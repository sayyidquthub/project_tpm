package com.projek.rajaongkir.ui.home;

import android.view.View;

import com.projek.rajaongkir.network.AppDatabase;
import com.projek.rajaongkir.network.DataOngkir;
import java.util.List;

public interface MainContactProfile {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataOngkir> list);
        void editData(DataOngkir item);
        void deleteData(DataOngkir item);

        void insertData(String nama, String alamat, String telpon, String ongkir, AppDatabase database);

        void readData(AppDatabase database);

        void editData(String nama, String alamat, String telpon, String ongkir, int id, AppDatabase database);

        void deleteData(DataOngkir dataOngkir, AppDatabase appDatabase);
    }

    interface presenter{
        void insertData(String nama, String alamat, String telpon, String ongkir, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String alamat, String telpon, String ongkir, int id, AppDatabase database);
        void deleteData(DataOngkir dataOngkir, AppDatabase appDatabase);

    }
}

