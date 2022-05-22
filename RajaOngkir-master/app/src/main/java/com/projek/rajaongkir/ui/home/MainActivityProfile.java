package com.projek.rajaongkir.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projek.rajaongkir.R;
import com.projek.rajaongkir.network.AppDatabase;
import com.projek.rajaongkir.network.DataOngkir;

import java.util.List;

public class MainActivityProfile extends AppCompatActivity implements MainContactProfile.view{
    private AppDatabase appDatabase;
    private MainPresenterProfile mainPresenterProfile;
    private MainAdapterProfile mainAdapterProfile;
    public static Context context;

    private Button submit;
    private RecyclerView recyclerView;
    private EditText etNama, etAlamat, etTelpon, etOngkir;

    private int id = 0;
    boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        submit = findViewById(R.id.submit);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etTelpon = findViewById(R.id.etTelpon);
        etOngkir = findViewById(R.id.etOngkir);
        recyclerView = findViewById(R.id.rc_main);

        appDatabase = AppDatabase.inidb(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainPresenterProfile = new MainPresenterProfile(this);
        mainPresenterProfile.readData(appDatabase);
        submit.setOnClickListener(this);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
        mainPresenterProfile.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show();
        mainPresenterProfile.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etNama.setText("");
        etAlamat.setText("");
        etTelpon.setText("");
        etOngkir.setText("");
        submit.setText("Submit");
    }

    public void getData(List<DataOngkir> list) {
        mainAdapterProfile = new MainAdapterProfile(this, list, this);
        recyclerView.setAdapter(mainAdapterProfile);
    }

    public void editData(DataOngkir item) {
        etNama.setText(item.getNama());
        etAlamat.setText(item.getAlamat());
        etTelpon.setText(item.getTelpon());
        etOngkir.setText(item.getOngkir());
        id = item.getId();
        edit = true;
        submit.setText("EDIT DATA");
    }

    @Override
    public void deleteData(DataOngkir item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        mainPresenterProfile.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .show();
    }

    @Override
    public void insertData(String nama, String alamat, String telpon, String ongkir, AppDatabase database) {

    }

    @Override
    public void readData(AppDatabase database) {

    }

    @Override
    public void editData(String nama, String alamat, String telpon, String ongkir, int id, AppDatabase database) {

    }

    @Override
    public void deleteData(DataOngkir dataOngkir, AppDatabase appDatabase) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            if (etNama.getText().toString().equals("") || etAlamat.getText().toString().equals("") ||
                    etTelpon.getText().toString().equals("") || etOngkir.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Harap isi Semua data", Toast.LENGTH_SHORT).show();
            } else {
                if (!edit) {
                    mainPresenterProfile.insertData(etNama.getText().toString(), etAlamat.getText().toString(), etTelpon.getText().toString(),
                            etOngkir.getText().toString(), appDatabase);
                } else {
                    mainPresenterProfile.editData(etNama.getText().toString(), etAlamat.getText().toString(), etTelpon.getText().toString(),
                            etOngkir.getText().toString(), id, appDatabase);
                    edit = false;
                }
                resetForm();
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case android.R.id.home:
            finish();
            break;

        }
        return super.onOptionsItemSelected(item);

    }
}