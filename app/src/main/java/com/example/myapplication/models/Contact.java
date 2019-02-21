package com.example.myapplication.models;

import java.util.ArrayList;

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String mName, boolean nOnline) {
        this.mName = mName;
        this.mOnline = nOnline;
    }

    public String getmName() {
        return mName;
    }

    public boolean isnOnline() {
        return mOnline;
    }

    private static int lastContacId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for(int i = 1; i <= numContacts; i++){
            contacts.add(new Contact("Person " + ++lastContacId, i <= numContacts / 2));
        }

        return contacts;
    }
}
