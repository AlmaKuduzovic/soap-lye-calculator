package com.example.rma_1_alma_kuduzovic;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OilInformationDao {
    @Query("SELECT * FROM oilinformation")
    List<OilInformation> getAllOil();

    @Insert
    void insertOil(OilInformation oil);

    @Query("DELETE FROM oilinformation")
    void deleteAllOils();


    @Query("SELECT * FROM oilinformation WHERE KOH = :KOHValue")
    OilInformation getOilByKOH(double KOHValue);

}
