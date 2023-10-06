package br.com.alcoholorgasolineapp.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.controller.LoginController;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private LoginController controller = new LoginController();;
    private Boolean isLoggedIn = false;
    private Intent intent;
    public static final int TIME_OUT_SPLASH_SCREEN = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        loadApp();
    }

    private void loadApp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                authenticateLogin();
            }
        }, TIME_OUT_SPLASH_SCREEN);
    }

    private void authenticateLogin(){
        isLoggedIn =  controller.authenticationLogin(getApplicationContext());
        if(isLoggedIn){
            intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }


}