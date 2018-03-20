package com.ericharm.to_goandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText emailInput = (EditText) findViewById(R.id.email_input);
        String email = emailInput.getText().toString();
        EditText passwordInput = (EditText) findViewById(R.id.password_input);
        String password = passwordInput.getText().toString();

        LoginController loginController = new LoginController();
        loginController.setCredentials(email, password);
        loginController.start();
    }

}
