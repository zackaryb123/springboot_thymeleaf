package com.example.springboot_template.model;

public class Emp {
    private String name;
    private  String address;

    public Emp () {
    }

    public Emp(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
