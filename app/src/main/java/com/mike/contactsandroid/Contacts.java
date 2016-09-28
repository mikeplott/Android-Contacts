package com.mike.contactsandroid;

/**
 * Created by michaelplott on 9/28/16.
 */

public class Contacts {
    String name;
    String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "  " + number;
    }
}
