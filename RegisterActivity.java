package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername=findViewById(R.id.username);
        edEmail=findViewById(R.id.email);
        edPassword=findViewById(R.id.password);
        edConfirm=findViewById(R.id.conpassword);
        btn=findViewById(R.id.buttonreg);
        tv=findViewById(R.id.registernew);
        Database db=new Database(getApplicationContext(),"travel",null,1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String confirm=edConfirm.getText().toString();
                if(username.length()==0||password.length()==0||email.length()==0||confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password must contain a digit, atleast 8 charecters and symbol",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and confirm password must be same",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
    public static boolean isValid(String pass){
        int f1=0,f2=0,f3=0;
        if(pass.length()>8){
            return false;
        }
        else{
            for(int p=0;p<pass.length();p++){
                if(Character.isLetter(pass.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<pass.length();r++){
                if(Character.isLetter(pass.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<pass.length();s++){
                if(Character.isLetter(pass.charAt(s))){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
            return false;

        }
    }
}