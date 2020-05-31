package com.example.stulance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.regex.Pattern;

public class CreateAccountStu extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                   // "(?=.*[a-zA-Z])" +      //any letter
                  //  "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    //"(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    public static final Pattern EMAIL_ADDRESS
            = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    EditText etUsername ,etPassword,etEmail;
    DatabaseHandler dbHandler;
    Connection connection;
    String userName, password, database,ip;
    Student student;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_stu);
        tanimla();
        tikla();

    }
    public void tanimla(){
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        confirmBtn=findViewById(R.id.button);
        dbHandler=new DatabaseHandler(getApplicationContext());
        student=new Student();
    }
    public void tikla(){
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Create createStudent = new Create();
               createStudent.execute("");
            }
        });
    }


    private boolean validateEmail() {
        String emailInput = etEmail.getText().toString().trim();
        if (isValidEmail(emailInput)==false) {
            etEmail.setError("Please enter a valid email address");
            return false;
        } else {
            etEmail.setError(null);
            return true;
        }
    }

    public boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private boolean validateUsername() {
        String usernameInput = etUsername.getText().toString().trim();
        if (usernameInput.isEmpty()) {
            etUsername.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            etUsername.setError("Username too long");
            return false;
        } else {
            etUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = etPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            etPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            etPassword.setError("Password too weak");
            return false;
        } else {
            etPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }
        String input = "Email: " + etEmail.getText().toString();
        input += "\n";
        input += "Username: " + etUsername.getText().toString();
        input += "\n";
        input += "Password: " + etPassword.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
    public class Create extends AsyncTask<String, String, String> {
        String message = " ";
        Boolean isSuccess = false;
        @Override
        protected void onPostExecute(String r)
        {

            Toast.makeText(CreateAccountStu.this, r, Toast.LENGTH_SHORT).show();
            if(isSuccess==true&&validateEmail()==true&&validatePassword()==true&&validateUsername()==true)
            {
                Toast.makeText(CreateAccountStu.this , message , Toast.LENGTH_LONG).show();
                Intent i = new Intent(CreateAccountStu.this, MainActivity.class);
                startActivity(i);
                //finish();
            }
            else{
                Toast.makeText(CreateAccountStu.this , message , Toast.LENGTH_LONG).show();
            }
        }

        protected String doInBackground(String... params) {
            String uName = etUsername.getText().toString();
            String uPassword = etPassword.getText().toString();
            String eMail=etEmail.getText().toString().trim();
            student._email=eMail;
            student._password=uPassword;
            student._username=uName;
            if (uName.trim().equals("") || uPassword.trim().equals("")||eMail.trim().equals("")) {
                message = "Please enter username password and email!";
            }
            else{

                    connection = connectionclass(userName, password, database, ip);        // Connect to database
                    if (dbHandler.addStudent(student)== true) {
                        isSuccess=true;
                        message="Student Create is Successfull";

                    } else {
                        isSuccess=false;
                        message="Student Create is Failed";

                    }



                }


            return message;
        }
    @SuppressLint("NewApi")
    public Connection connectionclass(String user, String password, String database, String server)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqliteserver://" + server + database + ";user=" + user+ ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLiteException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}}

