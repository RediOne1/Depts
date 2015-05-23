package com.myapps.depts;

import android.widget.EditText;

/**
 * author: Adrian
 * date: 2015-05-07.
 */
public class Quota {

    public long id;
    public Person person;
    public float money;
    public EditText nameEditText;

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

    public Quota setPersonName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public String toString() {
        if (nameEditText != null)
            person.name = nameEditText.getText().toString();
        return person.toString();
    }
}
