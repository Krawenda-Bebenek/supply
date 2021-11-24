package com.dockerforjavadevelopers.hello.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeDefRepositoryInitializer {

    @Bean
    InterfaceExchangeDefRepository initRepository(){
        ReadFileService readFileService = new ReadFileService();
        String json= readFileService.readJasonFile("supply_source.json");
        ExchangeDefRepository exchangeDefRepository = new ExchangeDefRepository();
        exchangeDefRepository.setExchangeDefinitionContainer(JasonToJavaConverter.convertingJsonsToObject(json));
        return exchangeDefRepository;
    }
}
