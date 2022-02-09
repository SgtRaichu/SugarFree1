package com.example.myapplication1;

public class Products {

    String name, amount, eatable;

    public Products(String name, String amount, String eatable) {
        this.name = name;
        this.amount = amount;
        this.eatable = eatable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEatable() {
        return eatable;
    }

    public void setEatable(String eatable) {
        this.eatable = eatable;
    }
}
