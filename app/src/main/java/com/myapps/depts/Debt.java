package com.myapps.depts;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Adrian
 * date: 2015-05-07.
 */
public class Debt {

    public long id;
    public String name;
    public long payerId;
    private List<Quota> quotaList;

    public Debt() {
        quotaList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        quotaList.add(new Quota(person));
    }

    public void addPerson(Person person, float money) {
        quotaList.add(new Quota(person, money));
    }

    public List<Quota> getQuotaList() {
        return quotaList;
    }

    public String getQuotaListToString() {
        StringBuilder stringBuilder = new StringBuilder();
        int quotaSize = quotaList.size();
        for (int i = 0; i < quotaSize; i++) {
            stringBuilder.append(quotaList.get(i));
            if (i != quotaSize - 1)
                stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public void setQuotaListFromString(String s) {
        String temp[] = s.split(",");
        for (String quotaId : temp) {

        }
    }
}
