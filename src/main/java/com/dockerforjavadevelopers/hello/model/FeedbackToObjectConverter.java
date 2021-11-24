package com.dockerforjavadevelopers.hello.model;


import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackToObjectConverter {

    Logger logger = LoggerFactory.getLogger(FeedbackToObjectConverter.class);

    public ExchangeDefinition convertFeedbackToObject(String feedback) {
        String[] feedbackValues = feedback.split("&");
        ExchangeDefinition updatedExchangeDefinition = new ExchangeDefinition();
        updatedExchangeDefinition.setExchangeId(extractLongValueFromFeedback(feedbackValues[0]));
        updatedExchangeDefinition.setParentId(extractLongValueFromFeedback(feedbackValues[1]));
        updatedExchangeDefinition.setName(extractStringValueFromFeedback(feedbackValues[2]));
        updatedExchangeDefinition.setAbbr(extractStringValueFromFeedback(feedbackValues[3]));
        updatedExchangeDefinition.setEnable(extractBooleanValueFromFeedback(feedbackValues[4]));
        updatedExchangeDefinition.setPorts(extractListFromFeedback(feedbackValues[5]));
        updatedExchangeDefinition.setAdstxtExchgId(extractLongValueFromFeedback(feedbackValues[6]));
        updatedExchangeDefinition.setAdstxtPubIdField(extractStringValueFromFeedback(feedbackValues[7]));
        updatedExchangeDefinition.setAdstxtSspDomainField(extractStringValueFromFeedback(feedbackValues[8]));
        updatedExchangeDefinition.setAdstxtSspDomainExchgIdMap(extractStringValueFromFeedback(feedbackValues[9]));

        return updatedExchangeDefinition;
    }
    private long extractLongValueFromFeedback(String feedbackValue){
        Optional<String> value = extractDecodedAndTrimmedFeedbackValue(feedbackValue);
        if(value.isPresent()) return Long.parseLong(value.get());
        return 0;
    }
    private Boolean extractBooleanValueFromFeedback(String feedbackValue){
        Optional<String> value = extractDecodedAndTrimmedFeedbackValue(feedbackValue);
        if(value.isPresent()) return Boolean.valueOf(value.get());
       return null;
    }
    private String extractStringValueFromFeedback(String feedbackValue){
        Optional<String> value = extractDecodedAndTrimmedFeedbackValue(feedbackValue);
        if(value.isPresent()) return value.get();
        return null;
    }
    private List<Integer> extractListFromFeedback(String feedbackValue){
        Optional<String> value = extractDecodedAndTrimmedFeedbackValue(feedbackValue);
        if(!value.isPresent()) return null;
        String portsString[] = value.get().split(",");
        return Arrays.stream(portsString).map(w -> Integer.valueOf(w.trim())).collect(Collectors.toList());
    }
    private Optional<String> extractDecodedAndTrimmedFeedbackValue(String feedbackValue) {
        String[] splitedFeedbackValue = feedbackValue.split("=");
        if (splitedFeedbackValue.length < 2) return Optional.empty();
        String decodedStringValue = decode(splitedFeedbackValue[1]).trim();
        if (decodedStringValue.isEmpty()) return Optional.empty();
        return Optional.of(decodedStringValue);
    }

    private String decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {

            logger.info("Unsupported encoding exception.");
        }
        return "";
    }
}