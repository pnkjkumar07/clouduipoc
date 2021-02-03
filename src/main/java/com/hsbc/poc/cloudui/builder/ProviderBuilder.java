package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.Provider;

public class ProviderBuilder {

    private String project;
    private String region;

    public ProviderBuilder setProject(String project) {
        this.project = project;
        return this;
    }

    public ProviderBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public Provider createProvider(){
        return new Provider(project, region);
    }
}
