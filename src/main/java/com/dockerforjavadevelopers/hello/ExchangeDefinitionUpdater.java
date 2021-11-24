package com.dockerforjavadevelopers.hello;

import com.dockerforjavadevelopers.hello.model.FeedbackToObjectConverter;
import com.dockerforjavadevelopers.hello.model.InterfaceExchangeDefRepository;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeDefinitionUpdater {

    @Autowired
    InterfaceExchangeDefRepository interfaceExchangeDefRepository;

    public boolean updateExchangeDefinition(ExchangeDefinition newExchangeDefinition){
      ExchangeDefinition  oldExchangeDefinition = interfaceExchangeDefRepository.getExchangeDefinitionByAbbr(newExchangeDefinition.getAbbr());
      if(oldExchangeDefinition==null) return false;
      oldExchangeDefinition.setName(newExchangeDefinition.getName());
      oldExchangeDefinition.setPorts(newExchangeDefinition.getPorts());
      oldExchangeDefinition.setAdstxtPubIdField(newExchangeDefinition.getAdstxtPubIdField());
      oldExchangeDefinition.setAdstxtSspDomainExchgIdMap(newExchangeDefinition.getAdstxtSspDomainExchgIdMap());
      oldExchangeDefinition.setAbbr(newExchangeDefinition.getAbbr());
      oldExchangeDefinition.setAdstxtExchgId(newExchangeDefinition.getAdstxtExchgId());
      oldExchangeDefinition.setParentId(newExchangeDefinition.getParentId());
      oldExchangeDefinition.setExchangeId(newExchangeDefinition.getExchangeId());
      oldExchangeDefinition.setEnable(newExchangeDefinition.isEnable());
      oldExchangeDefinition.setAdstxtSspDomainField(newExchangeDefinition.getAdstxtSspDomainField());
      return true;
    }
}
