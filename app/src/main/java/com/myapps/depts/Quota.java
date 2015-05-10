package com.myapps.depts;

/**
 * Created by Adrian on 2015-05-07.
 */
public class Quota {

    public long id;
    public Person person;
    public float money;

    public Quota() {
        this.person = new Person();
        this.money = 0L;
    }

    public Quota(Person person) {
        this.person = person;
        this.money = 0L;
    }

    public Quota(Person person, float money) {
        this.person = person;
        this.money = money;
    }
}
