package com.example.stulance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnCreate;
    EditText etName, etPassword;
    Connection connection;
    DatabaseHandler dbHandler;
    Student student;
    String userName,password, database, ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        ButtonLogin();
        ButtonCreate();

    }

    public void tanimla() {
        btnLogin = findViewById(R.id.btnStuLogin);
        btnCreate = findViewById(R.id.btnCreateAcc);
        etName = findViewById(R.id.etStuLoginName);
        etPassword = findViewById(R.id.etStuPassword);
        dbHandler=new DatabaseHandler(getApplicationContext());
        student=new Student();
    }

    public void ButtonLogin() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etName.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(etPassword.getWindowToken(), 0);
                String username = etName.getText().toString();
                String password = etPassword.getText().toString();
                if (username.length() > 0 && password.length() > 0) {
                    try {

                        if (dbHandler.checkUser(username)==true) {
                            Toast.makeText(MainActivity.this,
                                    "Successfully Logged In", Toast.LENGTH_LONG)
                                    .show();
                            Intent i = new Intent(MainActivity.this, drawer_menu.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Invalid username or password",
                                    Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Some problem occurred",
                                Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this,
                            "Username or Password is empty", Toast.LENGTH_LONG).show();
                }
            }


        }); }



            public void ButtonCreate() {

                btnCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, CreateAccountStu.class);
                        startActivity(i);
                    }
                });
            }

            }



