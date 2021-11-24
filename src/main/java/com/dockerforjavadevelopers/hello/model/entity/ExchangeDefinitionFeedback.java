package com.dockerforjavadevelopers.hello.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ExchangeDefinitionFeedback {

        private String exchangeId;
        private String parentId;
        private String name;
        private String abbr;
        private String enable;
        private String ports;
        private String adstxtExchgId;
        private String adstxtPubIdField;
        private String adstxtSspDomainField;
        private String adstxtSspDomainExchgIdMap;

    public ExchangeDefinitionFeedback(String exchangeId, String parentId, String name, String abbr, String enable, String ports, String adstxtExchgId, String adstxtPubIdField, String adstxtSspDomainField, String adstxtSspDomainExchgIdMap) {
        this.exchangeId = exchangeId;
        this.parentId = parentId;
        this.name = name;
        this.abbr = abbr;
        this.enable = enable;
        this.ports = ports;
        this.adstxtExchgId = adstxtExchgId;
        this.adstxtPubIdField = adstxtPubIdField;
        this.adstxtSspDomainField = adstxtSspDomainField;
        this.adstxtSspDomainExchgIdMap = adstxtSspDomainExchgIdMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeDefinitionFeedback that = (ExchangeDefinitionFeedback) o;
        return Objects.equals(exchangeId, that.exchangeId) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(abbr, that.abbr) &&
                Objects.equals(enable, that.enable) &&
                Objects.equals(ports, that.ports) &&
                Objects.equals(adstxtExchgId, that.adstxtExchgId) &&
                Objects.equals(adstxtPubIdField, that.adstxtPubIdField) &&
                Objects.equals(adstxtSspDomainField, that.adstxtSspDomainField) &&
                Objects.equals(adstxtSspDomainExchgIdMap, that.adstxtSspDomainExchgIdMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeId, parentId, name, abbr, enable, ports, adstxtExchgId, adstxtPubIdField, adstxtSspDomainField, adstxtSspDomainExchgIdMap);
    }

    @Override
    public String toString() {
        return "ExchangeDefinitionFeedback{" +
                "exchangeId='" + exchangeId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", enable='" + enable + '\'' +
                ", ports='" + ports + '\'' +
                ", adstxtExchgId='" + adstxtExchgId + '\'' +
                ", adstxtPubIdField='" + adstxtPubIdField + '\'' +
                ", adstxtSspDomainField='" + adstxtSspDomainField + '\'' +
                ", adstxtSspDomainExchgIdMap='" + adstxtSspDomainExchgIdMap + '\'' +
                '}';
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getAdstxtExchgId() {
        return adstxtExchgId;
    }

    public void setAdstxtExchgId(String adstxtExchgId) {
        this.adstxtExchgId = adstxtExchgId;
    }

    public String getAdstxtPubIdField() {
        return adstxtPubIdField;
    }

    public void setAdstxtPubIdField(String adstxtPubIdField) {
        this.adstxtPubIdField = adstxtPubIdField;
    }

    public String getAdstxtSspDomainField() {
        return adstxtSspDomainField;
    }

    public void setAdstxtSspDomainField(String adstxtSspDomainField) {
        this.adstxtSspDomainField = adstxtSspDomainField;
    }

    public String getAdstxtSspDomainExchgIdMap() {
        return adstxtSspDomainExchgIdMap;
    }

    public void setAdstxtSspDomainExchgIdMap(String adstxtSspDomainExchgIdMap) {
        this.adstxtSspDomainExchgIdMap = adstxtSspDomainExchgIdMap;
    }
}