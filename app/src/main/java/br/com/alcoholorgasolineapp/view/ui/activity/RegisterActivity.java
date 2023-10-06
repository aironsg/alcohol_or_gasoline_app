package br.com.alcoholorgasolineapp.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.controller.LoginController;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;
import br.com.alcoholorgasolineapp.model.repository.LoginRepository;
import br.com.alcoholorgasolineapp.utils.ValidateLogin;
import br.com.alcoholorgasolineapp.view.ui.activity.LoginActivity;
import br.com.alcoholorgasolineapp.view.ui.activity.MainActivity;
import br.com.alcoholorgasolineapp.view.ui.activity.SplashScreenActivity;

public class RegisterActivity extends AppCompatActivity implements ValidateLogin {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;
    private Button btnRegister;
    public static final int TIME_OUT_SPLASH_SCREEN = 3000;
    private LoginController controller = new LoginController();

    private Boolean isValidate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        editTextName = findViewById(R.id.edit_name);
        editTextEmail = findViewById(R.id.edit_email);
        editTextPassword = findViewById(R.id.edit_password);
        editTextRepeatPassword = findViewById(R.id.edit_password_repeat);
        btnRegister = findViewById(R.id.btn_create_account);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isValidate = validateRegister();
                if (isValidate) {
                    saveAccount();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.txt_error_fields, Toast.LENGTH_LONG).show();
                }
                    clearFields();
            }
        });

    }




    private void clearFields() {
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
        editTextRepeatPassword.setText("");
    }

    @Override
    public LoginEntity getLoginEntityData() {
        LoginEntity entity = new LoginEntity();
        entity.setName(editTextName.getText().toString());
        entity.setEmail(editTextEmail.getText().toString());
        entity.setPassword(editTextPassword.getText().toString());
        return entity;
    }

    @Override
    public boolean validateRegister() {
        LoginEntity loginEntity = getLoginEntityData();
        if (TextUtils.isEmpty(loginEntity.getName())) {
            editTextName.setError("Campo Nome Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(loginEntity.getEmail())) {
            editTextEmail.setError("Campo Email Obrigatorio");
            return false;
        }
        if (TextUtils.isEmpty(loginEntity.getPassword())) {
            editTextPassword.setError("Campo Senha Obrigatorio");
            return false;
        }

        if (TextUtils.isEmpty(editTextRepeatPassword.getText())) {
            editTextRepeatPassword.setError("Campo Senha Obrigatorio");
            return false;
        }
        if (!TextUtils.equals(editTextRepeatPassword.getText(), editTextPassword.getText())) {
            editTextRepeatPassword.setError("Senha Desigual, favor verifique!");
            return false;
        }
        return true;
    }

    private void saveAccount() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                controller.save(getLoginEntityData(), getApplicationContext());
                Toast.makeText(getApplicationContext(), R.string.txt_created_user_success,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, TIME_OUT_SPLASH_SCREEN);
    }


}