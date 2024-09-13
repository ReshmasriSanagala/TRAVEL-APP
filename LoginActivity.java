package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername=findViewById(R.id.editTextLoginUsername);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textViewNewUser);
        Database db=new Database(getApplicationContext(),"travel",null,1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                if(username.length()==0||password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    try{
                    if(1 == db.Login(username, password)){
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                        SharedPreferences sp=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edi=sp.edit();
                        edi.putString("username",username);
                        edi.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }}
                    catch (Exception e) {
                        e.printStackTrace();
                        // Log the exception details
                    }

                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}