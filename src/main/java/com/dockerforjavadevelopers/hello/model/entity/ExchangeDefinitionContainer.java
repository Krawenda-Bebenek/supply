package com.dockerforjavadevelopers.hello.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExchangeDefinitionContainer {
    @JsonProperty("ExchangesDef")
    private List<ExchangeDefinition> data = new ArrayList<>();

    public ExchangeDefinitionContainer(List<ExchangeDefinition> data) {
        this.data = data;
    }
    public ExchangeDefinitionContainer(){}


    public List<ExchangeDefinition> getData() {
        return data;
    }

    public void setData(List<ExchangeDefinition> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeDefinitionContainer that = (ExchangeDefinitionContainer) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "DataContainer{" +
                "data=" + data +
                '}';
    }
}
