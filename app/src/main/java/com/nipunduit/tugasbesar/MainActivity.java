package com.nipunduit.tugasbesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mRegister;
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername=(EditText)findViewById(R.id.mUsername);
        mPassword=(EditText)findViewById(R.id.mPassword);
        mLogin=(Button) findViewById(R.id.mLogin);
        mRegister=(Button) findViewById(R.id.mDaftar);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        

    }
}