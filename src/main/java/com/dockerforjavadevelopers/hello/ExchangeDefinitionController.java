package com.dockerforjavadevelopers.hello;


import com.dockerforjavadevelopers.hello.model.FeedbackToObjectConverter;
import com.dockerforjavadevelopers.hello.model.InterfaceExchangeDefRepository;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinition;
import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinitionFeedback;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class ExchangeDefinitionController {

    @Autowired
    FeedbackToObjectConverter feedbackToObjectConverter;
    @Autowired
    ExchangeDefinitionUpdater exchangeDefinitionUpdater;
    @Autowired
   private InterfaceExchangeDefRepository repository;
    @RequestMapping(
            method=RequestMethod.POST,
            path = "/abbr/update")

    public String handleBrowserSubmissions(@RequestBody String feedback) throws Exception {
        String response = feedback;
        System.out.println(feedback);

        ExchangeDefinition exchangeDefinition = feedbackToObjectConverter.convertFeedbackToObject(response);
        if(!exchangeDefinitionUpdater.updateExchangeDefinition(exchangeDefinition)) return "Error during updating exchange definition"+ "<br>" + "<a href=\"/names\"> Go back to list. </a>" ;;
        return "update successfully completed."+ "<br>" + "<a href=\"/names\"> Go back to list. </a>" ;
    }
    @GetMapping("/abbr/{abbr}")
    public String getExchangeFormByAbbr(@PathVariable String abbr){
        ExchangeDefinition exchangeDefinition= repository.getExchangeDefinitionByAbbr(abbr);
        String ports="";
        if(exchangeDefinition.getPorts().size()>0){
        ports = StringUtils.join(exchangeDefinition.getPorts().stream().map(w->" "+ w.toString()).collect(Collectors.toList()), ',');}

        String exchangeDefinitionForm="<form action=\"update\" method=\"post\" target=\"_blank\">" + "\n" +
                "<label>ExchangeId</label>"  +  "<input type=\"text\" name=\"exchangeId\" value=\""+ exchangeDefinition.getExchangeId()+ "\""+ "/>" +"<br><br>"+ "\n" +
                "<label>ParentId</label>"  +  "<input type=\"text\" name=\"parentId\" value=\""+ exchangeDefinition.getParentId()+ "\""+ "/>" +"<br><br>" +"\n" +
                "<label>Name</label>"  +  "<input type=\"text\" name=\"name\" value=\""+ exchangeDefinition.getName()+ "\""+ "/>"  +"<br><br>"+ "\n" +
                "<label>Abbr</label>"  +  "<input type=\"text\" name=\"abbr\" value=\""+ exchangeDefinition.getAbbr()+ "\""+ "/>"  +"<br><br>"+ "\n" +
                "<label>Enable</label>"  +  "<input type=\"text\" name=\"enable\" value=\""+ exchangeDefinition.isEnable()+ "\""+ "/>" +"<br><br>" + "\n";
                if(exchangeDefinition.getPorts().size()==0){
                    exchangeDefinitionForm +=  "<label>Ports</label>" + "<input type=\"text\" name=\"ports\" value=\"" + "\"" + "/>" + "<br><br>" + "\n";
                } else {
                    exchangeDefinitionForm +=  "<label>Ports</label>" + "<input type=\"text\" name=\"ports\" value=\"" + ports + "\"" + "/>" + "<br><br>" + "\n";
                }
                if(exchangeDefinition.getAdstxtExchgId()==0){ exchangeDefinitionForm +=
                "<label>AdstxtExchgId</label>"  +  "<input type=\"text\" name=\"adstxtExchgId\" value=\""+ "\""+ "/>" +"<br><br>" + "\n"; }
                else {
                    exchangeDefinitionForm +=
                            "<label>AdstxtExchgId</label>"  +  "<input type=\"text\" name=\"adstxtExchgId\" value=\""+exchangeDefinition.getAdstxtExchgId()+ "\""+ "/>" +"<br><br>" + "\n";
                }
                if(exchangeDefinition.getAdstxtPubIdField()!=null){ exchangeDefinitionForm +=
                "<label>AdstxtPubIdField</label>"  +  "<input type=\"text\" name=\"adstxtPubIdField\" value=\""+ exchangeDefinition.getAdstxtPubIdField()+ "\""+ "/>" +"<br><br>" + "\n";}
                else {
                    exchangeDefinitionForm +=
                            "<label>AdstxtPubIdField</label>"  +  "<input type=\"text\" name=\"adstxtPubIdField\" value=\""+ "\""+ "/>" +"<br><br>" + "\n";
                }
                if(exchangeDefinition.getAdstxtSspDomainField()!=null){ exchangeDefinitionForm +=
                "<label>AdstxtSspDomainField</label>"  +  "<input type=\"text\" name=\"adstxtSspDomainField\" value=\""+ exchangeDefinition.getAdstxtSspDomainField()+ "\""+ "/>" +"<br><br>" + "\n"; }
                else{
                    exchangeDefinitionForm += "<label>AdstxtSspDomainField</label>"  +  "<input type=\"text\" name=\"adstxtSspDomainField\" value=\""+ "\""+ "/>" +"<br><br>" + "\n";
                }
                if(exchangeDefinition.getAdstxtSspDomainExchgIdMap()!=null){ exchangeDefinitionForm +=
                "<label>AdstxtSspDomainExchgIdMap</label>"  +  "<input type=\"text\" name=\"adstxtSspDomainExchgIdMap\" value=\""+ exchangeDefinition.getAdstxtSspDomainExchgIdMap()+ "\""+ "/>" +"<br><br>" + "\n";}
                else {
                    exchangeDefinitionForm +=
                            "<label>AdstxtSspDomainExchgIdMap</label>"  +  "<input type=\"text\" name=\"adstxtSspDomainExchgIdMap\" value=\""+  "\""+ "/>" +"<br><br>" + "\n";
                }
               exchangeDefinitionForm += "<input type=\"submit\" value=\"submit\" />"+
                "</form>";
        return exchangeDefinitionForm;
    }
    @RequestMapping("/")
    public String index() {
        return "Helllo Worldssj\n";
    }

    @RequestMapping("/names")
    public String listNames() {
        String names="";
        for (ExchangeDefinition exchangeDefinition : repository.findAll()) {
          names+= "<a href=\"abbr/" + exchangeDefinition.getAbbr() + "\">" + exchangeDefinition.getName()+ "</a><br>"+"\n";
        }
        return names;
    }
}