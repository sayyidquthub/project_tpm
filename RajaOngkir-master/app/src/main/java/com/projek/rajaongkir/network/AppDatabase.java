package com.projek.rajaongkir.network;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DataOngkir.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataOngkirDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context){
        if (appDatabase==null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbOngkir").allowMainThreadQueries().build();
        return appDatabase;
    }
}
