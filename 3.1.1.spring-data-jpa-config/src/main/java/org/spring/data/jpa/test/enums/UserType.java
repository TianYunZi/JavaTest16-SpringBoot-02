package org.spring.data.jpa.test.enums;

public enum UserType {

    WORKER("worker"),
    TEACHER("teacher"),
    STUDENT("student");

    private String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
