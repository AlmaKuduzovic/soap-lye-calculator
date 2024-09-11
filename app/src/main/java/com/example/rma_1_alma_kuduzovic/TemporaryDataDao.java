package com.example.rma_1_alma_kuduzovic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TemporaryDataDao {

    @Query("SELECT * FROM temporarydata")
    List<TemporaryData> getAllTemporaryData();

    @Insert
    void add(TemporaryData temporaryData);

    @Query("INSERT INTO temporarydata (title, totalquantity, precent) VALUES (:nameParam, :valueParam, :percentParam)")
    void add(String nameParam, double valueParam, double percentParam);

   /* @Update
    void update(TemporaryData temporaryData);

    @Delete
    void delete(TemporaryData temporaryData);*/

    @Query("DELETE FROM temporarydata")
    void deleteAll();

    @Query("UPDATE temporarydata SET totalquantity = :newTotalQuantity WHERE title = :title")
    void updateTotalQuantity(String title, double newTotalQuantity);
}
