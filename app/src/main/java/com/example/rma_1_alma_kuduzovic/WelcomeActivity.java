package com.example.rma_1_alma_kuduzovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSpinners();

        Button nextButton = findViewById(R.id.button);
        nextButton.setVisibility(View.GONE);

        /*DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        OilInformationDao oilInformationDao = databaseHelper.oilInformationDao();
        oilInformationDao.insertOil(new OilInformation("Coconut Oil", "0.257", "0.183"));
        oilInformationDao.insertOil(new OilInformation("Jojoba Oil", "0.092", "0.066"));
        oilInformationDao.insertOil(new OilInformation("Palm Oil", "0.199", "0.142"));
        oilInformationDao.insertOil(new OilInformation("Olive Oil", "0.19", "0.35"));
        oilInformationDao.insertOil(new OilInformation("Avocado Oil", "0.186", "0.133"));*/


        nextButton.setOnClickListener(v -> {
            String spinner2Value = ((Spinner) findViewById(R.id.spinner2)).getSelectedItem().toString();
            String spinner3Value = ((Spinner) findViewById(R.id.spinner3)).getSelectedItem().toString();
            String spinner4Value = ((Spinner) findViewById(R.id.spinner4)).getSelectedItem().toString();


            Intent intent = new Intent(WelcomeActivity.this, OilPickerActivity.class);
            intent.putExtra("spinner2Value", spinner2Value);
            intent.putExtra("spinner4Value", spinner4Value);
            intent.putExtra("spinner3Value", spinner3Value);
            startActivity(intent);
            finish();
        });
    }

    private void setupSpinners() {
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);

        List<String> types = new ArrayList<>();
        types.add(0, "Select a type from the list");
        types.add(1, "Solid");
        types.add(2, "Liquid");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {
                    String selectedValue = parent.getItemAtPosition(position).toString();
                    Toast.makeText(WelcomeActivity.this, "Selected: " + selectedValue, Toast.LENGTH_SHORT).show();
                }


                checkButtonEnableState();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkButtonEnableState();
            }
        });

        List<String> units = new ArrayList<>();
        units.add(0, "Select a measurement units");
        units.add(1, "Grams");
        units.add(2, "Ounces");

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {
                    String selectedValue = parent.getItemAtPosition(position).toString();
                    Toast.makeText(WelcomeActivity.this, "Selected: " + selectedValue, Toast.LENGTH_SHORT).show();
                }


                checkButtonEnableState();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkButtonEnableState();
            }
        });

        List<String> superfatting = new ArrayList<>();
        superfatting.add(0, "Select a superfatting (%)");
        superfatting.add(1, "2");
        superfatting.add(2, "3");
        superfatting.add(3, "4");
        superfatting.add(4, "5");
        superfatting.add(5, "6");
        superfatting.add(6, "7");
        superfatting.add(7, "8");
        superfatting.add(8, "9");
        superfatting.add(9, "10");


        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, superfatting);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {
                    String selectedValue = parent.getItemAtPosition(position).toString();
                    Toast.makeText(WelcomeActivity.this, "Selected: " + selectedValue, Toast.LENGTH_SHORT).show();
                }


                checkButtonEnableState();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkButtonEnableState();
            }
        });
    }

    private void checkButtonEnableState() {
        Button nextButton = findViewById(R.id.button);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);


        if (spinner2.getSelectedItemPosition() != 0 && spinner3.getSelectedItemPosition() != 0 && spinner4.getSelectedItemPosition() != 0) {


            if (areOptionsValid()) {
                nextButton.setVisibility(View.VISIBLE);
            } else {
                nextButton.setVisibility(View.GONE);
            }
        } else {

            nextButton.setVisibility(View.GONE);
        }
    }


    private boolean areOptionsValid() {
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);


        return spinner2.getSelectedItemPosition() != 0 && spinner3.getSelectedItemPosition() != 0 && spinner4.getSelectedItemPosition() != 0;
    }
}
