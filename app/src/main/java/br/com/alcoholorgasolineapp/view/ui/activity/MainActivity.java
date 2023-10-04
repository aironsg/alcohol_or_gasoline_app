package br.com.alcoholorgasolineapp.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.alcoholorgasolineapp.R;

public class MainActivity extends AppCompatActivity {

     private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewHolder.editPriceAlcohol = findViewById(R.id.edit_price_alcohol);
        mViewHolder.editPricegasoline = findViewById(R.id.edit_price_gasoline);
        mViewHolder.btnCalculate = findViewById(R.id.btn_calc_price);
        mViewHolder.btnClear = findViewById(R.id.btn_clear);
        mViewHolder.btnSave = findViewById(R.id.btn_save);
        mViewHolder.btnFinished = findViewById(R.id.btn_finish);
    }

    //classe criada já depois do erro
    private  class ViewHolder{
         AppCompatEditText editPriceAlcohol;
         AppCompatEditText editPricegasoline;
         AppCompatButton btnCalculate;
         AppCompatButton btnClear;
         AppCompatButton btnSave;
         AppCompatButton btnFinished;

    }
}