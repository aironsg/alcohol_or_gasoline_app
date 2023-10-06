package br.com.alcoholorgasolineapp.view.ui.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.model.entity.FuelEntity;
import br.com.alcoholorgasolineapp.utils.FuelUtil;

public class MainActivity extends AppCompatActivity {

    public static final int TIMEOUT_EXIT_APPLICATION = 2000;
    private AppCompatEditText editPriceAlcohol;
    private AppCompatEditText editPricegasoline;
    private AppCompatTextView txtResult;
    private AppCompatButton btnCalculate;
    private AppCompatButton btnClear;
    private AppCompatButton btnSave;
    private AppCompatButton btnFinished;
    private AppCompatImageView btnLogout;
    private Boolean isValidate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPriceAlcohol = findViewById(R.id.edit_price_alcohol);
        editPricegasoline = findViewById(R.id.edit_price_gasoline);
        txtResult = findViewById(R.id.txt_result_price);
        btnCalculate = findViewById(R.id.btn_calc_price);
        btnClear = findViewById(R.id.btn_clear);
        btnSave = findViewById(R.id.btn_save);
        btnFinished = findViewById(R.id.btn_finish);
        btnLogout = findViewById(R.id.btn_logout);

        btnFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outPutAppMessage();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearField();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            double gasoline;
            double alcohol;

            @Override
            public void onClick(View v) {
                isValidate = validateFields();
                if (isValidate) {
                    gasoline = Double.valueOf(editPricegasoline.getText().toString());
                    alcohol = Double.valueOf(editPriceAlcohol.getText().toString());
                    String result = FuelUtil.comparePrice(gasoline, alcohol);
                    txtResult.setText(result);

                } else {
                    Toast.makeText(getApplicationContext(), R.string.txt_error_validate_fields_main_activity, Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }



    private void logout(){
        finish();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    private void clearField() {
        editPriceAlcohol.setText("");
        editPricegasoline.setText("");
    }

    private void outPutAppMessage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), R.string.txt_exit_app_message, Toast.LENGTH_SHORT).show();
            }
        }, TIMEOUT_EXIT_APPLICATION);

        finishAffinity();

    }

    private boolean validateFields() {
        if (TextUtils.isEmpty(editPricegasoline.getText())) {
            editPricegasoline.setError("Campo Obrigátorio");
            return false;
        }

        if (TextUtils.isEmpty(editPriceAlcohol.getText())) {
            editPriceAlcohol.setError("Campo Obrigátorio");
            return false;
        }

        return true;


    }


}