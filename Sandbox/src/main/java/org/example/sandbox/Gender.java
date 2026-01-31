package org.example.sandbox;

public class Gender extends AbstractCode {

    public Gender MALE = new Gender(1, "Male");
    public Gender FEMALE = new Gender(2, "Female");

    public Gender(int ordinal, String desc) {
        super(ordinal, desc);
    }
}
