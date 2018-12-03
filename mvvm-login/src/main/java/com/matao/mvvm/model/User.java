package com.matao.mvvm.model;

/**
 * Created by matao on 2018/12/4
 */
public class User {
    private String id;
    private String name;
    private boolean isMale;
    private int age;

    public User(String id, String name, boolean isMale, int age) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " isMale: " + isMale + " age: " + age;
    }
}
