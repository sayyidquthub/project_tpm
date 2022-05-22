package com.projek.rajaongkir.network;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface DataOngkirDAO {
    @Insert
    Long insertData(DataOngkir dataOngkir);

    @Query("Select * from ongkir_db")
    List<DataOngkir> getData();

    @Update
    int updateData(DataOngkir item);

    @Delete
    void deleteData(DataOngkir item);
}

