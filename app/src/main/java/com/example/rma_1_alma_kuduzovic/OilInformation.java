package com.example.rma_1_alma_kuduzovic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "oilinformation")
public class OilInformation {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "KOH")
    private String KOH;

    @ColumnInfo(name = "NaOH")
    private String NaOH;

    OilInformation(int id, String title, String KOH, String NaOH) {
        this.id = id;
        this.title = title;
        this.KOH = KOH;
        this.NaOH = NaOH;

    }

    @Ignore
    OilInformation(String title, String KOH, String NaOH) {
        this.title = title;
        this.KOH = KOH;
        this.NaOH = NaOH;

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

    public String getKOH() {
        return KOH;
    }

    public void setKOH(String KOH) {
        this.KOH = KOH;
    }

    public String getNaOH() {
        return NaOH;
    }

    public void setNaOH(String naOH) {
        NaOH = naOH;
    }
}