package com.usama.mockito_demo;

public class MyService {
    private MyDependency dependency;

    public MyService(MyDependency dependency) {
        this.dependency = dependency;
    }

    public String processRequest(String request) {
        if (request == null) {
            return "Error: request is null";
        } else {
            return dependency.doSomething(request);
        }
    }
}