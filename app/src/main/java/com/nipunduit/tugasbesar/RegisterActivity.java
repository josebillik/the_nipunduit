package com.nipunduit.tugasbesar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mConfPassword;
    private EditText mTelp;
    private Button mBatal;
    private Button mDaftar;
    ProgressDialog loading;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setAtribut();
        mDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAO = new UserDAO(mName.getText().toString(), mEmail.getText().toString(),
                 mTelp.getText().toString(), mPassword.getText().toString());
                onClickRegister();
            }
        });
        mBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setAtribut() {
        mName =  findViewById(R.id.mName);
        mEmail = findViewById(R.id.mEmail);
        mTelp = findViewById(R.id.mTelp);
        mPassword = findViewById(R.id.mPassword);
        mConfPassword = findViewById(R.id.mConfPassword);
        mBatal = findViewById(R.id.mBatal);
        mDaftar = findViewById(R.id.mDone);
    }

    public void startIntent(){
        Intent  intent =  new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void onClickRegister(){
        if(mName.getText().toString().isEmpty() ||  mEmail.getText().toString().isEmpty() || mTelp.getText().toString().isEmpty()
                || mPassword.getText().toString().isEmpty() || mConfPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Data tidak boleh ada  yang kosong", Toast.LENGTH_SHORT).show();
        }
        else{
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://nipunduit.000webhostapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit=builder.build();
            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<UserDAO> userDAOCall = apiClient.registerUser(mName.getText().toString(), mEmail.getText().toString(),
                    mTelp.getText().toString(),mPassword.getText().toString());
            userDAOCall.enqueue(new Callback<UserDAO>() {
                @Override
                public void onResponse(Call<UserDAO> call, Response<UserDAO> response) {
                    Toast.makeText(RegisterActivity.this, "Pendaftaran akun berhasil", Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<UserDAO> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this,"Pendaftaran akun gagal", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
