package com.example.hellow.Util;

import com.example.hellow.Models.ContactsModel;

import java.util.List;

public class Singleton {

    List<ContactsModel> list;

    public List<ContactsModel> getList() {
        return list;
    }

    public void setList(List<ContactsModel> list) {
        this.list = list;
    }
}
