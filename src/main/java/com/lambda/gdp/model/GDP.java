package com.lambda.gdp.model;

import java.util.concurrent.atomic.AtomicLong;

public class GDP
{
    private static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int GDP;

    public GDP(String name, int GDP) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.GDP = GDP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GDP{" + "id=" + id + ", name='" + name + '\'' + ", GDP=" + GDP + '}';
    }
}
