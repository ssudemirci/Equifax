package com.equifax.utilities;

public enum EndPointResources {
    GetEndPoint("/employee/"),
    DeleteEndPoint("/delete/");
    private String endpoint;


    EndPointResources(String endpoint) {
        this.endpoint = endpoint;
    }


    public String getEndPoint() {
        return endpoint;
    }


}
