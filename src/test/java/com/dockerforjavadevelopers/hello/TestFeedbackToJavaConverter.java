package com.dockerforjavadevelopers.hello;

import com.dockerforjavadevelopers.hello.model.FeedbackToObjectConverter;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestFeedbackToJavaConverter {

    private FeedbackToObjectConverter feedbackToObjectConverter = new FeedbackToObjectConverter();
    @Test
    public void setExchangeDefinitionTest(){
        String feedback = "exchangeId=77&parentId=46&name=Teads&abbr=tea&enable=false&ports=&adstxtExchgId=77&" +
                "adstxtPubIdField=ext.ads_txt.pub_id&adstxtSspDomainField=&adstxtSspDomainExchgIdMap=";
        ExchangeDefinition exchangeDefinition = feedbackToObjectConverter.convertFeedbackToObject(feedback);
        Assert.assertEquals(77,exchangeDefinition.getExchangeId());
        Assert.assertEquals(46, exchangeDefinition.getParentId());
        Assert.assertEquals("Teads", exchangeDefinition.getName());
        Assert.assertEquals("tea", exchangeDefinition.getAbbr());
        Assert.assertEquals(false, exchangeDefinition.isEnable());
        Assert.assertNull(exchangeDefinition.getPorts());
        Assert.assertEquals(77, exchangeDefinition.getAdstxtExchgId());
        Assert.assertEquals("ext.ads_txt.pub_id", exchangeDefinition.getAdstxtPubIdField());
        Assert.assertEquals(null, exchangeDefinition.getAdstxtSspDomainField());
        Assert.assertEquals(null, exchangeDefinition.getAdstxtSspDomainExchgIdMap());

    }

    @Test
    public void setExchangeDefinitionFullyFilled(){
        String feedback = "exchangeId=7&parentId=7&name=GenericInterface&abbr=gic&enable=true&" +
                "ports=+80%2C+9040%2C+9050%2C+9060%2C+9061%2C+9071%2C+9080%2C+9090%2C+9100%2C+9110%2C+9120%2C+9130%2C+9140%2C+9150%2C+9160%2C+9170%2C+9171&" +
                "adstxtExchgId=74&adstxtPubIdField=diwj&adstxtSspDomainField=qdwiqu&adstxtSspDomainExchgIdMap=dqdwq";

        ExchangeDefinition exchangeDefinition = feedbackToObjectConverter.convertFeedbackToObject(feedback);
        Assert.assertEquals(7,exchangeDefinition.getExchangeId());
        Assert.assertEquals(7, exchangeDefinition.getParentId());
        Assert.assertEquals("GenericInterface", exchangeDefinition.getName());
        Assert.assertEquals("gic", exchangeDefinition.getAbbr());
        Assert.assertEquals(true, exchangeDefinition.isEnable());
        List<Integer>ports = Arrays.asList(80, 9040, 9050, 9060, 9061, 9071, 9080, 9090, 9100, 9110, 9120, 9130, 9140, 9150, 9160, 9170, 9171);
        Assert.assertEquals(ports, exchangeDefinition.getPorts());
        Assert.assertEquals(74, exchangeDefinition.getAdstxtExchgId());
        Assert.assertEquals("diwj", exchangeDefinition.getAdstxtPubIdField());
        Assert.assertEquals("qdwiqu", exchangeDefinition.getAdstxtSspDomainField());
        Assert.assertEquals("dqdwq", exchangeDefinition.getAdstxtSspDomainExchgIdMap());

    }

    @Test
    public void setExchangeDefinitionEmptyValues(){
        String feedback= "exchangeId=&parentId=&name=&abbr=&enable=&ports=&adstxtExchgId=&adstxtPubIdField=&adstxtSspDomainField=&adstxtSspDomainExchgIdMap=";

        ExchangeDefinition exchangeDefinition = feedbackToObjectConverter.convertFeedbackToObject(feedback);
        Assert.assertEquals(0,exchangeDefinition.getExchangeId());
        Assert.assertEquals(0, exchangeDefinition.getParentId());
        Assert.assertNull(exchangeDefinition.getName());
        Assert.assertNull(exchangeDefinition.getAbbr());
        Assert.assertNull(exchangeDefinition.isEnable());
        Assert.assertNull(exchangeDefinition.getPorts());
        Assert.assertEquals(0, exchangeDefinition.getAdstxtExchgId());
        Assert.assertNull(exchangeDefinition.getAdstxtPubIdField());
        Assert.assertNull(exchangeDefinition.getAdstxtSspDomainField());
        Assert.assertNull( exchangeDefinition.getAdstxtSspDomainExchgIdMap());

    }@Test
    public void setExchangeDefinitionWhiteSignsValues(){
        String feedback= "exchangeId=++&parentId=++&name=++&abbr=++&enable=++&ports=++&adstxtExchgId=++&adstxtPubIdField=++&adstxtSspDomainField=++&adstxtSspDomainExchgIdMap=++";

        ExchangeDefinition exchangeDefinition = feedbackToObjectConverter.convertFeedbackToObject(feedback);
        Assert.assertEquals(0,exchangeDefinition.getExchangeId());
        Assert.assertEquals(0, exchangeDefinition.getParentId());
        Assert.assertNull(exchangeDefinition.getName());
        Assert.assertNull(exchangeDefinition.getAbbr());
        Assert.assertNull(exchangeDefinition.isEnable());
        Assert.assertNull(exchangeDefinition.getPorts());
        Assert.assertEquals(0, exchangeDefinition.getAdstxtExchgId());
        Assert.assertNull(exchangeDefinition.getAdstxtPubIdField());
        Assert.assertNull(exchangeDefinition.getAdstxtSspDomainField());
        Assert.assertNull( exchangeDefinition.getAdstxtSspDomainExchgIdMap());

    }

}
