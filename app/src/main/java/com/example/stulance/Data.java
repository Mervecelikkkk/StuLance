package com.example.stulance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Data {
    SQLiteDatabase db;
    DatabaseHandler dbh;

    public Data(Context c){
        dbh = new DatabaseHandler(c);
    } //veritabanı initializer edilir
    public void Open(){
        db = dbh.getWritableDatabase();
    } //veritabanına daha sağlıklı veri yazılması için databaseHandler katmanı kullanılır
    public void Close(){
        dbh.close();
    }// veritabanı bağlantısı kapatılır

    public void CreateStudent(){
        Student student = new Student();
        //student.setName();
    }
}
