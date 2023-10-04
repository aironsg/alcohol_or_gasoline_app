package br.com.alcoholorgasolineapp.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.alcoholorgasolineapp.R;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adionei estas já após o erro
//        mViewHolder.editPriceAlcohol = findViewById(R.id.edit_price_alcohol);
//        mViewHolder.editPricegasoline = findViewById(R.id.edit_price_gasoline);
//        mViewHolder.btnCalculate = findViewById(R.id.btn_calc_price);
//        mViewHolder.btnClear = findViewById(R.id.btn_clear);
//        mViewHolder.btnSave = findViewById(R.id.btn_save);
//        mViewHolder.btnFinished = findViewById(R.id.btn_finish);
    }

    //classe criada já depois do erro
    private static class ViewHolder{
        private EditText editPriceAlcohol;
        private EditText editPricegasoline;
        private Button btnCalculate;
        private Button btnClear;
        private Button btnSave;
        private Button btnFinished;

    }
}