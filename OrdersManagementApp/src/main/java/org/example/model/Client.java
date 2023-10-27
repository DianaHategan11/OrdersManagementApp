package org.example.model;

public class Client {
    private int idClient;
    private String name;
    private int age;
    private String address;
    private String emailAddress;
    private String telephoneNumber;

    public Client() {
    }

    public Client(int idClient, String name, int age, String address, String emailAddress, String telephoneNumber) {
        this.idClient = idClient;
        this.name = name;
        this.age = age;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public Client(String name, int age, String address, String emailAddress, String telephoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + idClient +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
