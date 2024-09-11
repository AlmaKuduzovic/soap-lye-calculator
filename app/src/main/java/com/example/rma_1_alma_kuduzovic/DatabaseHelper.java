package com.example.rma_1_alma_kuduzovic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {OilInformation.class, TemporaryData.class, totalTable.class}, exportSchema = false, version = 7)
public abstract class DatabaseHelper extends RoomDatabase {

    private static final String DB_NAME = "oilinformationdb";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getDB(Context context) {
        if (instance == null)   {
            instance = Room.databaseBuilder(context, DatabaseHelper.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract OilInformationDao oilInformationDao();

    public abstract totalTableDao totalTableDao();

    public abstract TemporaryDataDao temporaryDataDao();
}
