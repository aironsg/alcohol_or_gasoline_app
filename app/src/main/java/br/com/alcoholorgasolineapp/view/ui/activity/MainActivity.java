package br.com.alcoholorgasolineapp.view.ui.activity;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.alcoholorgasolineapp.R;

public class MainActivity extends AppCompatActivity {
    private EditText editPriceAlcohol;
    private EditText editPricegasoline;
    private TextView txtResult;
    private Button btnCalculate;
    private Button btnClear;
    private Button btnSave;
    private Button btnFinished;

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
    }


}