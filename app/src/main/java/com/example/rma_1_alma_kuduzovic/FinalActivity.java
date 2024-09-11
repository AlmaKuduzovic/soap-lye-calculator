package com.example.rma_1_alma_kuduzovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FinalActivity extends AppCompatActivity {

    private RecyclerView firstTableRecyclerView;
    private RecyclerView secondTableRecyclerView;
    private RecyclerView thirdTableRecyclerView;
    private FirstTableAdapter firstTableAdapter;
    private SecondTableAdapter secondTableAdapter;
    private ThirdTableAdapter thirdTableAdapter;
    private DatabaseHelper databaseHelper;
    private totalTableDao totalTableDao;
    private TemporaryDataDao temporaryDataDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);

        Intent intent = getIntent();
        String spinner3Value;
        spinner3Value = intent.getStringExtra("spinner3Value");
        boolean useOunces = spinner3Value.equals("Ounces");

        String totalLye;
        String totalLiquid;
        String totalGrams;
        String totalGramsOfOil;
        String totalSoup;

        totalLye = intent.getStringExtra("totalLye");
        totalLiquid = intent.getStringExtra("totalLiquid");
        totalGrams = intent.getStringExtra("totalGrams");
        totalGramsOfOil = intent.getStringExtra("totalGramsOfOil");
        totalSoup = intent.getStringExtra("totalSoup");


        String grams1 = intent.getStringExtra("grams1");
        String grams2 = intent.getStringExtra("grams2");
        String grams3 = intent.getStringExtra("grams3");
        String grams4 = intent.getStringExtra("grams4");
        String grams5 = intent.getStringExtra("grams5");

        String Oil1 = intent.getStringExtra("Oil1");
        String Oil2 = intent.getStringExtra("Oil2");
        String Oil3 = intent.getStringExtra("Oil3");
        String Oil4 = intent.getStringExtra("Oil4");
        String Oil5 = intent.getStringExtra("Oil5");


        databaseHelper = DatabaseHelper.getDB(this);
        totalTableDao = databaseHelper.totalTableDao();
        temporaryDataDao = databaseHelper.temporaryDataDao();


        firstTableRecyclerView = findViewById(R.id.firstTableRecyclerView);
        secondTableRecyclerView = findViewById(R.id.secondTableRecyclerView);
        thirdTableRecyclerView = findViewById(R.id.thirdTableRecyclerView);


        firstTableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        secondTableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        thirdTableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<totalTable> totalTables = totalTableDao.getAllTotalTables();
        List<String> firstTableData1 = new ArrayList<>();
        List<String> firstTableData2 = new ArrayList<>();

        if (totalTables != null && !totalTables.isEmpty()) {

            totalTable firstRow = totalTables.get(0);

            firstTableData1.add("LYE: ");
            firstTableData1.add("LIQUID: ");
            firstTableData1.add("Total");
            if (Objects.equals(spinner3Value, "Grams")) {

                firstTableData2.add(String.format("%.2f", firstRow.getGramsOfLye()) + "g");
                firstTableData2.add(String.format("%.2f", firstRow.getTotalOfLiquid()) + "g");
                firstTableData2.add(String.format("%.2f", firstRow.getFinalTotal()) + "g");
            } else {
                firstTableData2.add(String.format("%.2f", firstRow.getGramsOfLye()) + "oz");
                firstTableData2.add(String.format("%.2f", firstRow.getTotalOfLiquid()) + "oz");
                firstTableData2.add(String.format("%.2f", firstRow.getFinalTotal()) + "oz");
            }

        }

        List<TemporaryData> temporaryDataList = databaseHelper.temporaryDataDao().getAllTemporaryData();


        secondTableAdapter = new SecondTableAdapter(temporaryDataList, useOunces);


        secondTableRecyclerView.setAdapter(secondTableAdapter);

        List<String> thirdTableData1 = new ArrayList<>();
        List<String> thirdTableData2 = new ArrayList<>();

        if (totalTables != null && !totalTables.isEmpty()) {

            totalTable firstRow = totalTables.get(0);

            thirdTableData1.add("LYE & LIQUID: ");
            thirdTableData1.add("OIL & FATS: ");
            thirdTableData1.add("Total Batch Yield");
            if (Objects.equals(spinner3Value, "Grams")) {

                thirdTableData2.add(String.format("%.2f", firstRow.getFinalTotal()) + "g");
                thirdTableData2.add(String.format("%.2f", firstRow.getTotalOil()) + "g");
                thirdTableData2.add(String.format("%.2f", firstRow.getTotalSoup()) + "g");
            } else {

                thirdTableData2.add(String.format("%.2f", firstRow.getFinalTotal()) + "oz");
                thirdTableData2.add(String.format("%.2f", firstRow.getTotalOil()) + "oz");
                thirdTableData2.add(String.format("%.2f", firstRow.getTotalSoup()) + "oz");
            }
        } else {

            firstTableData1.add("LYE");
            firstTableData1.add("LIQUID");
            firstTableData1.add("Total");

            firstTableData2.add("0");
            firstTableData2.add("0");
            firstTableData2.add("0");
        }


        firstTableAdapter = new FirstTableAdapter(firstTableData1, firstTableData2);

        thirdTableAdapter = new ThirdTableAdapter(thirdTableData1, thirdTableData2);


        firstTableRecyclerView.setAdapter(firstTableAdapter);
        secondTableRecyclerView.setAdapter(secondTableAdapter);
        thirdTableRecyclerView.setAdapter(thirdTableAdapter);

        Button ouncesGramsButton = findViewById(R.id.ouncesGramsButton);


        ouncesGramsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double grams1Value;
                double grams2Value;
                double grams3Value;
                double grams4Value;
                double grams5Value;
                double totalLiquid1;
                double totalLye1;
                double totalGrams1;
                double totalGramsOfOil1;
                double totalSoup1;

                if (spinner3Value.equals("Grams")) {

                    totalLiquid1 = Double.parseDouble(totalLiquid) * 0.03527396195;
                    totalLye1 = Double.parseDouble(totalLye) * 0.03527396195;
                    totalGrams1 = Double.parseDouble(totalGrams) * 0.03527396195;
                    totalGramsOfOil1 = Double.parseDouble(totalGramsOfOil) * 0.03527396195;
                    totalSoup1 = Double.parseDouble(totalSoup) * 0.03527396195;

                    totalTableDao.updateTotalOfLiquid(totalLiquid1);
                    totalTableDao.updateGramsOfLye(totalLye1);
                    totalTableDao.updateFinalTotal(totalGrams1);
                    totalTableDao.updateTotalOil(totalGramsOfOil1);
                    temporaryDataDao.updateTotalQuantity("Total", roundToTwoDecimals(totalGramsOfOil1));
                    totalTableDao.updateTotalSoup(totalSoup1);

                    double grams1Value1 = Double.parseDouble(grams1) * 0.03527396195;
                    double grams2Value2 = Double.parseDouble(grams2) * 0.03527396195;
                    double grams3Value3 = Double.parseDouble(grams3) * 0.03527396195;
                    double grams4Value4 = Double.parseDouble(grams4) * 0.03527396195;
                    double grams5Value5 = Double.parseDouble(grams5) * 0.03527396195;

                    grams1Value = grams1Value1;
                    grams2Value = grams2Value2;
                    grams3Value = grams3Value3;
                    grams4Value = grams4Value4;
                    grams5Value = grams5Value5;

                    if (grams1Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil1, roundToTwoDecimals(grams1Value));
                    }
                    if (grams2Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil2, roundToTwoDecimals(grams2Value));
                    }
                    if (grams3Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil3, roundToTwoDecimals(grams3Value));
                    }
                    if (grams4Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil4, roundToTwoDecimals(grams4Value));
                    }
                    if (grams5Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil5, roundToTwoDecimals(grams5Value));
                    }


                } else {

                    totalLiquid1 = Double.parseDouble(totalLiquid) * 28.349523125;
                    totalLye1 = Double.parseDouble(totalLye) * 28.349523125;
                    totalGrams1 = Double.parseDouble(totalGrams) * 28.349523125;
                    totalGramsOfOil1 = Double.parseDouble(totalGramsOfOil) * 28.349523125;
                    totalSoup1 = Double.parseDouble(totalSoup) * 28.349523125;

                    totalTableDao.updateTotalOfLiquid(totalLiquid1);
                    totalTableDao.updateGramsOfLye(totalLye1);
                    totalTableDao.updateFinalTotal(totalGrams1);
                    totalTableDao.updateTotalOil(totalGramsOfOil1);
                    temporaryDataDao.updateTotalQuantity("Total", roundToTwoDecimals(totalGramsOfOil1));
                    totalTableDao.updateTotalSoup(totalSoup1);

                    double grams1Value1 = Double.parseDouble(grams1) * 28.349523125;
                    double grams2Value2 = Double.parseDouble(grams2) * 28.349523125;
                    double grams3Value3 = Double.parseDouble(grams3) * 28.349523125;
                    double grams4Value4 = Double.parseDouble(grams4) * 28.349523125;
                    double grams5Value5 = Double.parseDouble(grams5) * 28.349523125;

                    grams1Value = grams1Value1;
                    grams2Value = grams2Value2;
                    grams3Value = grams3Value3;
                    grams4Value = grams4Value4;
                    grams5Value = grams5Value5;

                    if (grams1Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil1, roundToTwoDecimals(grams1Value));
                    }
                    if (grams2Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil2, roundToTwoDecimals(grams2Value));
                    }
                    if (grams3Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil3, roundToTwoDecimals(grams3Value));
                    }
                    if (grams4Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil4, roundToTwoDecimals(grams4Value));
                    }
                    if (grams5Value != 0) {
                        temporaryDataDao.updateTotalQuantity(Oil5, roundToTwoDecimals(grams5Value));
                    }

                }

                String spinner3value = spinner3Value.equals("Ounces") ? "Grams" : "Ounces";
                Intent intent = new Intent(FinalActivity.this, FinalActivity.class);
                intent.putExtra("spinner3Value", spinner3value);
                intent.putExtra("totalLiquid", String.valueOf(totalLiquid1));
                intent.putExtra("totalLye", String.valueOf(totalLye1));
                intent.putExtra("totalGrams", String.valueOf(totalGrams1));
                intent.putExtra("totalGramsOfOil", String.valueOf(totalGramsOfOil1));
                intent.putExtra("totalSoup", String.valueOf(totalSoup1));
                intent.putExtra("grams1", String.valueOf(grams1Value));
                intent.putExtra("grams2", String.valueOf(grams2Value));
                intent.putExtra("grams3", String.valueOf(grams3Value));
                intent.putExtra("grams4", String.valueOf(grams4Value));
                intent.putExtra("grams5", String.valueOf(grams5Value));
                intent.putExtra("Oil1", Oil1);
                intent.putExtra("Oil2", Oil2);
                intent.putExtra("Oil3", Oil3);
                intent.putExtra("Oil4", Oil4);
                intent.putExtra("Oil5", Oil5);


                startActivity(intent);

                finish();


            }

            private double roundToTwoDecimals(double value) {
                return Math.round(value * 100.0) / 100.0;

            }


        });

        Button resizeBatchButton = findViewById(R.id.resizeBatchButton);

        resizeBatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });

    }


}