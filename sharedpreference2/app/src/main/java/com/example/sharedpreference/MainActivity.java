package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textUsername, textPassword;
    Button login;
    Intent intent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUsername = findViewById(R.id.username);
        textPassword = findViewById(R.id.password);

        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        sharedPreferences.contains("username");
        sharedPreferences.contains("password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = textUsername.getText().toString();
                String pw = textPassword.getText().toString();

                if (uname.equals("irfan") && pw.equals("irfan123")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", uname);
                    editor.putString("password", pw);
                    editor.apply();

                    intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Data not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}