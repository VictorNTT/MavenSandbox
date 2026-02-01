package org.example.sandbox;

public class Address implements IEntity {
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public IEntity cloneEntity() throws Exception {
        return (IEntity) super.clone();
    }
}
