package com.example.rma_1_alma_kuduzovic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OilPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oilpicker);

        /*Log.d("OilPickerActivity", "onCreate method called");*/
       /* setContentView(R.layout.activity_oilpicker);*/

        ArrayList<OilInformation> oilList = getAllOilInformation();

        showOilInformation(oilList);
    }

    private ArrayList<OilInformation> getAllOilInformation() {
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        OilInformationDao oilInformationDao = databaseHelper.oilInformationDao();
        return (ArrayList<OilInformation>) oilInformationDao.getAllOil();
    }


    private void showOilInformation(ArrayList<OilInformation> oilList) {
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);

        if (oilList != null && oilList.size() >= 5) {

            textView1.setText(oilList.get(0).getTitle());
            textView2.setText(oilList.get(1).getTitle());
            textView3.setText(oilList.get(2).getTitle());
            textView4.setText(oilList.get(3).getTitle());
            textView5.setText(oilList.get(4).getTitle());
        }
        Button nextButton = findViewById(R.id.button2);
        nextButton.setOnClickListener(v -> {

            EditText editText1 = findViewById(R.id.editText1);
            EditText editText2 = findViewById(R.id.editText2);
            EditText editText3 = findViewById(R.id.editText3);
            EditText editText4 = findViewById(R.id.editText4);
            EditText editText5 = findViewById(R.id.editText5);


            String grams1Text = editText1.getText().toString();
            String grams2Text = editText2.getText().toString();
            String grams3Text = editText3.getText().toString();
            String grams4Text = editText4.getText().toString();
            String grams5Text = editText5.getText().toString();


            if (grams1Text.isEmpty() || grams2Text.isEmpty() || grams3Text.isEmpty() || grams4Text.isEmpty() || grams5Text.isEmpty()) {

                Toast.makeText(this, "Please enter values in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double totalGramsOfOil = 0;
            double grams1 = Double.parseDouble(editText1.getText().toString());
            double grams2 = Double.parseDouble(editText2.getText().toString());
            double grams3 = Double.parseDouble(editText3.getText().toString());
            double grams4 = Double.parseDouble(editText4.getText().toString());
            double grams5 = Double.parseDouble(editText5.getText().toString());

            totalGramsOfOil = grams1 + grams2 + grams3 + grams4 + grams5;

            double KOH1 = 0, KOH2 = 0, KOH3 = 0, KOH4 = 0, KOH5 = 0;
            double NaOH1 = 0, NaOH2 = 0, NaOH3 = 0, NaOH4 = 0, NaOH5 = 0;
            double lye1 = 0, lye2 = 0, lye3 = 0, lye4 = 0, lye5 = 0;

            Intent intent = getIntent();
            String spinner2Value = intent.getStringExtra("spinner2Value");
            String spinner4Value = intent.getStringExtra("spinner4Value");
            String spinner3Value = intent.getStringExtra("spinner3Value");

            double totalLye = 0;
            double totalLiquid = 0;
            double totalGrams = 0;
            double totalSoup = 0;
            if (Objects.equals(spinner2Value, "Solid")) {

                if (oilList != null && oilList.size() >= 5) {

                    KOH1 = Double.parseDouble(oilList.get(0).getKOH());
                    KOH2 = Double.parseDouble(oilList.get(1).getKOH());
                    KOH3 = Double.parseDouble(oilList.get(2).getKOH());
                    KOH4 = Double.parseDouble(oilList.get(3).getKOH());
                    KOH5 = Double.parseDouble(oilList.get(4).getKOH());


                    lye1 = (KOH1 * Double.parseDouble(editText1.getText().toString()));
                    lye2 = (KOH2 * Double.parseDouble(editText2.getText().toString()));
                    lye3 = (KOH3 * Double.parseDouble(editText3.getText().toString()));
                    lye4 = (KOH4 * Double.parseDouble(editText4.getText().toString()));
                    lye5 = (KOH5 * Double.parseDouble(editText5.getText().toString()));

                    double pomcnaVarijabla = (Double.parseDouble(spinner4Value) / 100);
                    double pomocnaVarijabla2 = 1 - pomcnaVarijabla;
                    double pomocnaVarijabla3 = (lye1 + lye2 + lye3 + lye4 + lye5);

                    totalLye = pomocnaVarijabla2 * pomocnaVarijabla3;
                    totalLiquid = totalLye * 1.2475;
                    totalGrams = totalLye + totalLiquid;
                    totalSoup = totalGrams + totalGramsOfOil;
                }
            } else {
                if (oilList != null && oilList.size() >= 5) {

                    NaOH1 = Double.parseDouble(oilList.get(0).getNaOH());
                    NaOH2 = Double.parseDouble(oilList.get(1).getNaOH());
                    NaOH3 = Double.parseDouble(oilList.get(2).getNaOH());
                    NaOH4 = Double.parseDouble(oilList.get(3).getNaOH());
                    NaOH5 = Double.parseDouble(oilList.get(4).getNaOH());


                    lye1 = (NaOH1 * Double.parseDouble(editText1.getText().toString()));
                    lye2 = (NaOH2 * Double.parseDouble(editText2.getText().toString()));
                    lye3 = (NaOH3 * Double.parseDouble(editText3.getText().toString()));
                    lye4 = (NaOH4 * Double.parseDouble(editText4.getText().toString()));
                    lye5 = (NaOH5 * Double.parseDouble(editText5.getText().toString()));

                    totalLye = (1 - (Double.parseDouble(spinner4Value) / 100)) * (lye1 + lye2 + lye3 + lye4 + lye5);
                    totalLiquid = totalLye * 1.6316;
                    totalGrams = totalLye + totalLiquid;
                    totalSoup = totalGrams + totalGramsOfOil;
                }
            }
            DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
            TemporaryDataDao temporaryDataDao = databaseHelper.temporaryDataDao();

            DatabaseHelper databaseHelper1 = DatabaseHelper.getDB(this);
            totalTableDao totalTableDao = databaseHelper1.totalTableDao();

            List<totalTable> existingTotalTables = totalTableDao.getAllTotalTables();
            if (existingTotalTables != null && !existingTotalTables.isEmpty()) {

                totalTableDao.deleteAllTotalTables();
            }

            totalTable total = new totalTable(totalLiquid, totalLye, totalGrams, totalGramsOfOil, totalSoup);
            totalTableDao.insertTotalTable(total);

            temporaryDataDao.deleteAll();

            if (lye1 != 0) {
                double percent1 = (Double.parseDouble(editText1.getText().toString()) / totalGramsOfOil) * 100;
                temporaryDataDao.add(new TemporaryData(oilList.get(0).getTitle(), Double.parseDouble(editText1.getText().toString()), roundToTwoDecimals(percent1)));
            }

            if (lye2 != 0) {
                double percent2 = (Double.parseDouble(editText2.getText().toString()) / totalGramsOfOil) * 100;
                temporaryDataDao.add(new TemporaryData(oilList.get(1).getTitle(), Double.parseDouble(editText2.getText().toString()), roundToTwoDecimals(percent2)));
            }

            if (lye3 != 0) {
                double percent3 = (Double.parseDouble(editText3.getText().toString()) / totalGramsOfOil) * 100;
                temporaryDataDao.add(new TemporaryData(oilList.get(2).getTitle(), Double.parseDouble(editText3.getText().toString()), roundToTwoDecimals(percent3)));
            }

            if (lye4 != 0) {
                double percent4 = (Double.parseDouble(editText4.getText().toString()) / totalGramsOfOil) * 100;
                temporaryDataDao.add(new TemporaryData(oilList.get(3).getTitle(), Double.parseDouble(editText4.getText().toString()), roundToTwoDecimals(percent4)));
            }

            if (lye5 != 0) {
                double percent5 = (Double.parseDouble(editText5.getText().toString()) / totalGramsOfOil) * 100;
                temporaryDataDao.add(new TemporaryData(oilList.get(4).getTitle(), Double.parseDouble(editText5.getText().toString()), roundToTwoDecimals(percent5)));
            }


            String Oil1 = oilList.get(0).getTitle();
            String Oil2 = oilList.get(1).getTitle();
            String Oil3 = oilList.get(2).getTitle();
            String Oil4 = oilList.get(3).getTitle();
            String Oil5 = oilList.get(4).getTitle();


            temporaryDataDao.add("Total", totalGramsOfOil, 100.00);
            Intent intent1 = new Intent(OilPickerActivity.this, FinalActivity.class);

            intent1.putExtra("spinner3Value", spinner3Value);

            intent1.putExtra("totalLiquid", String.valueOf(totalLiquid));
            intent1.putExtra("totalLye", String.valueOf(totalLye));
            intent1.putExtra("totalGrams", String.valueOf(totalGrams));
            intent1.putExtra("totalGramsOfOil", String.valueOf(totalGramsOfOil));
            intent1.putExtra("totalSoup", String.valueOf(totalSoup));

            intent1.putExtra("grams1", editText1.getText().toString());
            intent1.putExtra("grams2", editText2.getText().toString());
            intent1.putExtra("grams3", editText3.getText().toString());
            intent1.putExtra("grams4", editText4.getText().toString());
            intent1.putExtra("grams5", editText5.getText().toString());

            intent1.putExtra("Oil1", Oil1);
            intent1.putExtra("Oil2", Oil2);
            intent1.putExtra("Oil3", Oil3);
            intent1.putExtra("Oil4", Oil4);
            intent1.putExtra("Oil5", Oil5);


            startActivity(intent1);



        });
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }


}
