package com.example.atomscan;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private String enrolTxt;
    private String passTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText enrol = findViewById(R.id.enrol);
        EditText pass = findViewById(R.id.pass);
        Button loginBtn = findViewById(R.id.loginBtn);





        loginBtn.setOnClickListener(v -> {
            enrolTxt = enrol.getText().toString().trim();
            passTxt = pass.getText().toString().trim();

            DatabaseCon databaseCon = new DatabaseCon(LoginActivity.this);
            databaseCon.execute("http://192.168.0.7:10080/login.php",enrolTxt,passTxt);
        });


    }


}
