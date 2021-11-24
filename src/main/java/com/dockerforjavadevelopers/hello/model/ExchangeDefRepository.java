package com.dockerforjavadevelopers.hello.model;

import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinitionContainer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
public class ExchangeDefRepository implements InterfaceExchangeDefRepository {

    private ExchangeDefinitionContainer exchangeDefinitionContainer;

    public ExchangeDefinitionContainer getExchangeDefinitionContainer() {
        return exchangeDefinitionContainer;
    }

    public void setExchangeDefinitionContainer(ExchangeDefinitionContainer exchangeDefinitionContainer) {
        this.exchangeDefinitionContainer = exchangeDefinitionContainer;
    }

    public List<ExchangeDefinition> findAll() {
        return exchangeDefinitionContainer.getData();
    }

    public List<String> getAllNames() {
        return exchangeDefinitionContainer.getData().stream().map(e -> e.getName()).collect(Collectors.toList());
    }

    public ExchangeDefinition getExchangeDefinitionByAbbr(String abbr) {
        return exchangeDefinitionContainer.getData()
                .stream()
                .filter(w -> w.getAbbr().equals(abbr))
                .findAny()
                .orElse(null);
    }
}