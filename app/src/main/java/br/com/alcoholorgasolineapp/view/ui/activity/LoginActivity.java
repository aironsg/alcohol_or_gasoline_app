package br.com.alcoholorgasolineapp.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alcoholorgasolineapp.R;

public class LoginActivity extends AppCompatActivity {

    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mViewHolder.editEmail = findViewById(R.id.edit_email);
        mViewHolder.editPassword = findViewById(R.id.edit_password);
        mViewHolder.btnSignIn = findViewById(R.id.btn_signIn);



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

