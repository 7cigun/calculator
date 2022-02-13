package ru.gb.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.view.View;


public class ThemeChoser extends AppCompatActivity implements View.OnClickListener {

    private static final String PREF_NAME = "key_pref";
    private static final String PREF_THEME_KEY = "key_pref_theme";
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_theme_choser);
        ((RadioButton) findViewById(R.id.radioButtonMaterialBlue)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialRed)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialGreen)).setOnClickListener(this);
        buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radioButtonMaterialBlue: {
                setAppTheme(R.style.BlueCalculator);
                break;
            }
            case R.id.radioButtonMaterialRed: {
                setAppTheme(R.style.RedCalculator);
                break;
            }
            case R.id.radioButtonMaterialGreen: {
                setAppTheme(R.style.GreenCalculator);
                break;
            }
            case R.id.buttonOk: {
                Intent intentResult = new Intent();
                /*intentResult.putExtra(MainActivity.KEY_INTENT_FROM_SECOND_TO_MAIN, getAppTheme());
                ThemeChoser.this.setResult(RESULT_OK,intentResult);*/
                Intent intent = new Intent(ThemeChoser.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
        recreate();
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_THEME_KEY, codeStyle);
        editor.apply();
    }

    protected int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY, MODE_PRIVATE);
    }
}