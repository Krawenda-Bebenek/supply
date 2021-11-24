package com.dockerforjavadevelopers.hello.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;
import java.util.Objects;

public class ExchangeDefinition {
    @JsonProperty("ExchangeId")
    private long exchangeId;
    @JsonProperty("ParentId")
    private long parentId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Abbr")
    private String abbr;
    @JsonProperty("Enable")
    private Boolean enable;
    @JsonProperty("Ports")
    private List<Integer> ports;
    @JsonProperty("AdstxtExchgId")
    private long adstxtExchgId;
    @JsonProperty("AdstxtPubIdField")
    private String adstxtPubIdField;
    @JsonProperty("AdstxtSspDomainField")
    private String adstxtSspDomainField;
    @JsonProperty("AdstxtSspDomainExchgIdMap")
    private String adstxtSspDomainExchgIdMap;

    public ExchangeDefinition(long exchangeId, long parentId, String name, String abbr, Boolean enable, List<Integer> ports, long adstxtExchgId, String adstxtPubIdField, String adstxtSspDomainField, String adstxtSspDomainExchgIdMap) {
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

    public String getAdstxtSspDomainExchgIdMap() {
        return adstxtSspDomainExchgIdMap;
    }

    public void setAdstxtSspDomainExchgIdMap(String adstxtSspDomainExchgIdMap) {
        this.adstxtSspDomainExchgIdMap = adstxtSspDomainExchgIdMap;
    }

    public String getAdstxtSspDomainField() {
        return adstxtSspDomainField;
    }

    public void setAdstxtSspDomainField(String adstxtSspDomainField) {
       this.adstxtSspDomainField = adstxtSspDomainField;
    }

    public String getAdstxtPubIdField() {
        return adstxtPubIdField;
    }

    public void setAdstxtPubIdField(String adstxtPubIdField) {
        this.adstxtPubIdField = adstxtPubIdField;
    }

    public long getAdstxtExchgId() {
        return adstxtExchgId;
    }

    public void setAdstxtExchgId(long adstxtExchgId) {
        this.adstxtExchgId = adstxtExchgId;
    }

    public ExchangeDefinition() { };

    public long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
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

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<Integer> getPorts() {
        return ports;
    }

    public void setPorts(List<Integer> ports) {
        this.ports = ports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeDefinition that = (ExchangeDefinition) o;
        return exchangeId == that.exchangeId &&
                parentId == that.parentId &&
                enable == that.enable &&
                adstxtExchgId == that.adstxtExchgId &&
                Objects.equals(name, that.name) &&
                Objects.equals(abbr, that.abbr) &&
                Objects.equals(ports, that.ports) &&
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
        return "ExchangeDefinition{" +
                "exchangeId=" + exchangeId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", enable=" + enable +
                ", ports=" + ports +
                ", AdstxtExchgId=" + adstxtExchgId +
                ", AdstxtPubIdField='" + adstxtPubIdField + '\'' +
                ", AdstxtSspDomainField='" + adstxtSspDomainField + '\'' +
                ", AdstxtSspDomainExchgIdMap='" + adstxtSspDomainExchgIdMap + '\'' +
                '}';
    }
}
