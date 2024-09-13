package com.example.travel;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class yourplaces extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourplaces);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        // Load and set the saved values for EditTexts and CheckBoxes
        loadAndSetValues(R.id.editTextText, "editText1");
        loadAndSetValues(R.id.editTextText2, "editText2");
        loadAndSetValues(R.id.editTextText3, "editText3");

        loadAndSetCheckBoxState(R.id.checkBox, "checkBox1");
        loadAndSetCheckBoxState(R.id.checkBox2, "checkBox2");
        loadAndSetCheckBoxState(R.id.checkBox3, "checkBox3");
    }

    private void saveValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private void loadAndSetValues(int editTextId, final String key) {
        final EditText editText = findViewById(editTextId);
        String savedValue = sharedPreferences.getString(key, "");
        editText.setText(savedValue);
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                saveValue(key, editText.getText().toString());
            }
        });
    }

    private void saveCheckBoxState(String key, boolean isChecked) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, isChecked);
        editor.apply();
    }

    private void loadAndSetCheckBoxState(int checkBoxId, final String key) {
        final CheckBox checkBox = findViewById(checkBoxId);
        boolean savedCheckBoxState = sharedPreferences.getBoolean(key, false);
        checkBox.setChecked(savedCheckBoxState);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            saveCheckBoxState(key, isChecked);
        });
    }
}
