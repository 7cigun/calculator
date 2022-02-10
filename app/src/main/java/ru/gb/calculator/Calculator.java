package ru.gb.calculator;

import java.io.Serializable;

public class Calculator implements Serializable {

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    private String userData;
}
