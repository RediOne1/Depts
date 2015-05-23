package com.myapps.depts;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * author: Adrian
 * date: 2015-05-07.
 */
public class Quota implements TextWatcher {

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

    public Quota setPersonName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public String toString() {
        return person.toString();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        person.name = s.toString();
    }
}
