package br.com.rcurvo.domain;

import java.util.Objects;

public class Customer {


    private String name;
    private Long cpf;
    private Long phone;
    private String address;
    private Integer houseNumber;
    private String city;
    private String state;

    public Customer(String name, String cpf, String phone, String address, String houseNumber, String city, String state){
        this.name = name;
        this.cpf = Long.valueOf(cpf.trim());
        this.phone = Long.valueOf(phone.trim());
        this.address = address;
        this.houseNumber = Integer.valueOf(houseNumber.trim());
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cpf, customer.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente: {" +
                "nome='" + name + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
