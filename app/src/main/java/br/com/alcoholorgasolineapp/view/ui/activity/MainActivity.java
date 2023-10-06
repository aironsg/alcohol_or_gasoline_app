package br.com.alcoholorgasolineapp.view.ui.activity;


import androidx.appcompat.app.AppCompatActivity;


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
    private EditText editPriceAlcohol;
    private EditText editPricegasoline;
    private TextView txtResult;
    private Button btnCalculate;
    private Button btnClear;
    private Button btnSave;
    private Button btnFinished;
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