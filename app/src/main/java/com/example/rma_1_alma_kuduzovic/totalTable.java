package com.example.rma_1_alma_kuduzovic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "totalTable")
public class totalTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "totalOfLiquid")
    private double totalOfLiquid;
    @ColumnInfo(name = "gramsOfLye")
    private double gramsOfLye;

    @ColumnInfo(name = "finalTotal")
    private double finalTotal;

    @ColumnInfo(name = "totalOil")
    private double totalOil;

    @ColumnInfo(name = "totalSoup")
    private double totalSoup;


    public totalTable(double totalOfLiquid, double gramsOfLye, double finalTotal, double totalOil, double totalSoup) {
        this.totalOfLiquid = totalOfLiquid;
        this.gramsOfLye = gramsOfLye;
        this.finalTotal = finalTotal;
        this.totalOil = totalOil;
        this.totalSoup = totalSoup;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalOfLiquid() {
        return totalOfLiquid;
    }

    public void setTotalOfLiquid(double totalOfLiquid) {
        this.totalOfLiquid = totalOfLiquid;
    }

    public double getTotalWeight() {
        return totalOil;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalOil = totalWeight;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public double getGramsOfLye() {
        return gramsOfLye;
    }

    public void setGramsOfLye(double gramsOfLye) {
        this.gramsOfLye = gramsOfLye;
    }

    public double getTotalOil() {
        return totalOil;
    }

    public void setTotalOil(double totalOil) {
        this.totalOil = totalOil;
    }

    public double getTotalSoup() {
        return totalSoup;
    }

    public void setTotalSoup(double totalSoup) {
        this.totalSoup = totalSoup;
    }
}
