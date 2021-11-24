package com.dockerforjavadevelopers.hello.model;

import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;

import java.util.List;

public interface InterfaceExchangeDefRepository {

    List<ExchangeDefinition> findAll();
    List<String> getAllNames();
    ExchangeDefinition getExchangeDefinitionByAbbr(String abbr);
}
