package com.example.macexcel.telehealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    Button login;
    EditText Username, Password;

    String S_User = "admin";
    String S_Pass = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        login = (Button)findViewById(R.id.login_button);
        Username = (EditText)findViewById(R.id.Username);
        Password = (EditText)findViewById(R.id.Password);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().equals(S_User) && Password.getText().toString().equals(S_Pass)) {
                    Intent intent = new Intent(LoginScreen.this, UserDashboard.class);
                    startActivity(intent);
                }
            }
        });
    }
}
