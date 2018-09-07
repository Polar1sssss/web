package com.web.domain;

/**
 * @author hujtb
 * @create on 2018-08-17-11:16
 */
public class Employee {
    private String city;
    private double salary;
    private Address addr;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee{" + "city='" + city + '\'' + ", salary=" + salary + ", addr=" + addr + '}';
    }
}
