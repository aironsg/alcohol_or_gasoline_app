package br.com.alcoholorgasolineapp.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.controller.LoginController;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;
import br.com.alcoholorgasolineapp.utils.ValidateLogin;

public class LoginActivity extends AppCompatActivity implements ValidateLogin {


    private AppCompatEditText editEmail;
    private AppCompatEditText editPassword;
    private AppCompatButton btnSignIn;
    private AppCompatTextView btnRegister;
    private LoginController controller = new LoginController();
    private Intent intent;

    private Boolean isValidadeFiels = false;
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
            String email;
            String password;

            @Override
            public void onClick(View v) {
                isValidadeFiels = validateRegister();

                if (isValidadeFiels) {
                    email = editEmail.getText().toString();
                    password = editPassword.getText().toString();
                    authenticateLogin(email, password, getApplicationContext());
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void authenticateLogin(String email, String password, Context context) {
        boolean isValidateLogin = controller.findLogin(email, password, context);
        if (isValidateLogin) {
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(context, R.string.txt_authorizationSuccess, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, R.string.txt_error_authentication, Toast.LENGTH_SHORT).show();
        }
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
        if (TextUtils.isEmpty(loginEntity.getEmail())) {
            editEmail.setError("Campo Email Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(loginEntity.getPassword())) {
            editPassword.setError("Campo Senha Obrigatorio");
            return false;
        }

        //TODO: inserir metodo que busca os dados do usuario e verifica com os digitados

        return true;
    }


}

