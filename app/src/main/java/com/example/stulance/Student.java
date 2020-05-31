package com.example.stulance;

public class Student {
    int _Id;
    String _email;
    String _username;
    String _password;

    public Student() {
    }

    public Student(int Id, String username, String password,String email) {
        this._Id = Id;
        this._username = username;
        this._password = password;
        this._email= email;
    }



    public Student(String username, String password , String email) {
        this._username = username;
        this._password = password;
        this._email=email;
    }

    public int getId(){
        return this._Id;
    }
    public void setId( int Id){
        this._Id = Id;
    }
    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
    public String getName(){
        return this._username;
    }
    public void setName(String username){
        this._username = username;
    }
    public String getPassword(){
        return this._password;
    }
    public void setPassword(String password){
        this._password = password;
    }
}
