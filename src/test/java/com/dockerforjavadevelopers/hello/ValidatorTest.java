package com.dockerforjavadevelopers.hello;

import com.dockerforjavadevelopers.hello.model.InterfaceExchangeDefRepository;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
public class ValidatorTest {
    @Mock
    InterfaceExchangeDefRepository interfaceExchangeDefRepository;
    @InjectMocks
    private ExchangeDefinitionValidator exchangeDefinitionValidator = new ExchangeDefinitionValidator();
    private ExchangeDefinition exchangeDefinition= new ExchangeDefinition();

    @Test
    public void validateExchangeTest(){
        Mockito.doReturn(null).when(interfaceExchangeDefRepository).getExchangeDefinitionByAbbr(Mockito.anyString());
        Assert.assertFalse(exchangeDefinitionValidator.validateExchange(exchangeDefinition));

    }

}
