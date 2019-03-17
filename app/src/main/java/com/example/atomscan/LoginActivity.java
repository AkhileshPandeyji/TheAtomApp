package com.example.atomscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText enrol;
    private  EditText pass;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        enrol = (EditText) findViewById(R.id.enrol);
        pass = (EditText) findViewById(R.id.pass);
        loginBtn = (Button) findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enrolTxt = enrol.getText().toString().trim();
                String passTxt = pass.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("enrol",enrolTxt);
                intent.putExtra("pass",passTxt);
                startActivity(intent);
            }
        });



    }
}
