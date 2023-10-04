package br.com.alcoholorgasolineapp.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;

public class LoginActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private LoginEntity mLogin = new LoginEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mViewHolder.editEmail = findViewById(R.id.edit_email);
        mViewHolder.editPassword = findViewById(R.id.edit_password);
        mViewHolder.btnSignIn = findViewById(R.id.btn_signIn);

        mLogin.setEmail(String.valueOf(mViewHolder.editEmail.getText()));
        mLogin.setPassword(String.valueOf(mViewHolder.editPassword.getText()));

        if(mLogin.getEmail().isEmpty()){
            System.out.println("sou o email estou em branco");
        }

        if (mLogin.getEmail() == null){
            System.out.println("sou o email estou nulo");
        }

        if(mLogin.getPassword().isEmpty()){
            System.out.println("estou em branco");
        }

        if (mLogin.getPassword() == null){
            System.out.println("estou nulo");
        }



        mViewHolder.btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
        });

    }



    private static class ViewHolder {
        private EditText editEmail;
        private EditText editPassword;
        private Button btnSignIn;
    }
}

