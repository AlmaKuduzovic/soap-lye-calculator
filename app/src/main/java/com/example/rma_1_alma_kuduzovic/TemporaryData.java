package com.example.rma_1_alma_kuduzovic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "temporarydata")
public class TemporaryData {
    @ColumnInfo(name = "totalquantity")
    public double totalquantity;
    @ColumnInfo(name = "precent")
    public double precent;
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;


    public TemporaryData(String title, double totalquantity, double precent) {
        this.title = title;
        this.totalquantity = totalquantity;
        this.precent = precent;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(double totalquantity) {
        this.totalquantity = totalquantity;
    }

    public double getPrecent() {
        return precent;
    }

    public void setPrecent(double precent) {
        this.precent = precent;
    }
}
