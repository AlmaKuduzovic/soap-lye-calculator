package com.example.rma_1_alma_kuduzovic;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface totalTableDao {
    @Insert
    void insertTotalTable(totalTable totalTable);

    @Query("SELECT * FROM totalTable")
    List<totalTable> getAllTotalTables();

    @Query("DELETE FROM totalTable")
    void deleteAllTotalTables();

   /* @Update
    void updateTotalTable(totalTable totalTable);*/

    @Query("UPDATE totalTable SET totalOfLiquid = :newTotalOfLiquid")
    void updateTotalOfLiquid(double newTotalOfLiquid);

    @Query("UPDATE totalTable SET gramsOfLye = :newGramsOfLye")
    void updateGramsOfLye(double newGramsOfLye);

    @Query("UPDATE totalTable SET finalTotal = :newFinalTotal")
    void updateFinalTotal(double newFinalTotal);

    @Query("UPDATE totalTable SET totalOil = :newTotalOil")
    void updateTotalOil(double newTotalOil);

    @Query("UPDATE totalTable SET totalSoup = :newTotalSoup")
    void updateTotalSoup(double newTotalSoup);

}