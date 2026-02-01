package org.example.sandbox;

public class Gender extends AbstractCode {

    public static final Gender MALE = new Gender(1, "Male");
    public static final Gender FEMALE = new Gender(2, "Female");

    protected Gender(int ordinal, String desc) {
        super(ordinal, desc);
    }
}
