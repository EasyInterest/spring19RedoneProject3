package com.example.abkire.project3;
// saves our color from the color picker
public class DataHolder2 {
    private String data;
    public String getData() {return data;}
    public void setData(String data) {this.data = data;}



    private static final DataHolder2 holder = new DataHolder2();
    public static DataHolder2 getInstance() {return holder;}
}