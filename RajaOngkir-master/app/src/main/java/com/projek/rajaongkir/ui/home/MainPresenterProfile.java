package com.projek.rajaongkir.ui.home;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.projek.rajaongkir.network.AppDatabase;
import com.projek.rajaongkir.network.DataOngkir;

import java.util.List;

public class MainPresenterProfile implements MainContactProfile.view  {
    private MainContactProfile.view view;

    public MainPresenterProfile(MainContactProfile.view view){
        this.view = view;
    }

    @Override
    public void successAdd() {

    }

    @Override
    public void successDelete() {

    }

    @Override
    public void resetForm() {

    }

    @Override
    public void getData(List<DataOngkir> list) {

    }

    @Override
    public void editData(DataOngkir item) {

    }

    @Override
    public void deleteData(DataOngkir item) {

    }

    @Override
    public void onClick(View view) {

    }

    class InsertData extends AsyncTask<Void,Void,Long> {
        private AppDatabase appDatabase;
        private DataOngkir dataOngkir;
        public InsertData(AppDatabase appDatabase, DataOngkir dataOngkir) {
            this.appDatabase = appDatabase;
            this.dataOngkir = dataOngkir;
        }

        protected Long doInBackground(Void... voids){
            return appDatabase.dao().insertData(dataOngkir);
        }

        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String nama, String alamat, String telpon, String ongkir, AppDatabase database) {
        final DataOngkir dataOngkir =  new DataOngkir();
        dataOngkir.setNama(nama);
        dataOngkir.setAlamat(alamat);
        dataOngkir.setTelpon(telpon);
        dataOngkir.setOngkir(ongkir);
        new InsertData(database, dataOngkir).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataOngkir> list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataOngkir dataOngkir;

        public EditData(AppDatabase appDatabase, DataOngkir dataOngkir){
            this.appDatabase = appDatabase;
            this.dataOngkir = dataOngkir;
        }

        protected Integer doInBackground(Void... voids){
            return  appDatabase.dao().updateData(dataOngkir);
        }

        protected void  onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : "+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String nama, String alamat, String telpon, String ongkir, int id, AppDatabase database) {
        final DataOngkir dataOngkir = new DataOngkir();
        dataOngkir.setNama(nama);
        dataOngkir.setAlamat(alamat);
        dataOngkir.setTelpon(telpon);
        dataOngkir.setOngkir(ongkir);
        dataOngkir.setId(id);
        new EditData(database, dataOngkir).execute();
    }

    class  DeleteData extends  AsyncTask<Void,Void,Long>{
        private  AppDatabase appDatabase;
        private DataOngkir dataOngkir;

        public DeleteData(AppDatabase appDatabase, DataOngkir dataOngkir){
            this.appDatabase = appDatabase;
            this.dataOngkir = dataOngkir;
        }

        protected Long doInBackground(Void... voids){
            appDatabase.dao().deleteData(dataOngkir);
            return null;
        }

        protected void  onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataOngkir dataOngkir, AppDatabase appDatabase) {
        new DeleteData(appDatabase, dataOngkir).execute();
    }
}

