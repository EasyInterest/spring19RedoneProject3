package com.example.abkire.project3;
// saves our color from the color picker
public class DataHolder {
    private String data;
    private String data2;
    public String getData() {return data;}
    public void setData(String data) {this.data = data;}



    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}
}