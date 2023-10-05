package br.com.alcoholorgasolineapp.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.RegisterActivity;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;
import br.com.alcoholorgasolineapp.utils.ValidateLogin;

public class LoginActivity extends AppCompatActivity  implements ValidateLogin {


    private EditText editEmail;
    private EditText editPassword;
    private Button btnSignIn;
    private TextView btnRegister;
    private LoginEntity mLogin = new LoginEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        btnSignIn = findViewById(R.id.btn_create_account);
        btnRegister = findViewById(R.id.btn_register);


        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public LoginEntity getLoginEntityData() {
        LoginEntity entity = new LoginEntity();
        entity.setEmail(editEmail.getText().toString());
        entity.setPassword(editPassword.getText().toString());
        return entity;
    }

    @Override
    public boolean validateRegister() {
        LoginEntity loginEntity = getLoginEntityData();
        if(TextUtils.isEmpty(loginEntity.getEmail())){
            editEmail.setError("Campo Email Obrigatorio");
            return false;
        }
        if(TextUtils.isEmpty(loginEntity.getPassword())){
            editPassword.setError("Campo Senha Obrigatorio");
            return false;
        }

        //TODO: inserir metodo que busca os dados do usuario e verifica com os digitados

        return true;
    }


}

