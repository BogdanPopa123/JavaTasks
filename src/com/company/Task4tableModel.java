package com.company;

import java.text.MessageFormat;

public class Task4tableModel {

    private int id;
    private int sum;
    private String fileName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString(){
        return MessageFormat.format("row : id={0} -----> sum = {1}   filename = {2}", id, sum, fileName);
    }

}
