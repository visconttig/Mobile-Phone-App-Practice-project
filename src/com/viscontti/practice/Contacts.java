package com.viscontti.practice;

import java.util.ArrayList;

public class Contacts {
    private String name;
    private int number;


    //Contructor
    public Contacts(String name, int number){
        this.name = name;
        this.number = number;
    }

    public Contacts(){
        super();
    }


    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.number = number;
    }
}
