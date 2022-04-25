package com.hunter.mid_yohanes_tjhaiyadi_191103567;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button buttonLogin,buttonReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonReg = (Button) findViewById(R.id.buttonReg);

        buttonReg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"selamat datang di form register", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if(usernameKey.equals("yohanes") && passwordKey.equals("12345")){
                    //Jika Login Berhasil
                    Toast.makeText(getApplication(), "Login Sukses",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else {
                    //Jika Login Gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Anda Salah")
                            .setNegativeButton("Retry",null).create().show();
                }
            }
        });
    }
}