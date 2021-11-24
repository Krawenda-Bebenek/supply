package com.dockerforjavadevelopers.hello;

import com.dockerforjavadevelopers.hello.model.InterfaceExchangeDefRepository;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeDefinitionValidator {
    @Autowired
    private InterfaceExchangeDefRepository iexdefrepository;

    public boolean validateExchange(ExchangeDefinition ex){
        if(iexdefrepository.getExchangeDefinitionByAbbr(ex.getAbbr())==null){
            return false;
        }
        return true;
    }
}
