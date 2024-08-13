package dts.pnj.yehezkiel_ruben;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dts.pnj.yehezkiel_ruben.DatabaseHelperAlumni;

public class TambahData extends AppCompatActivity {
    EditText edtNim, edtNama, edtTempat, edtTanggal, edtAlamat, edtAgama, edtTlp, edtMasuk, edtLulus, edtPekerjaan, edtJabatan;
    Button actionSimpan;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        edtNim = findViewById(R.id.edtNim);
        edtNama = findViewById(R.id.edtNama);
        edtTempat = findViewById(R.id.edtTempat);
        edtTanggal = findViewById(R.id.edtTanggal);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);
        edtTlp = findViewById(R.id.edtTlp);
        edtMasuk = findViewById(R.id.edtMasuk);
        edtLulus = findViewById(R.id.edtLulus);
        edtPekerjaan = findViewById(R.id.edtPekerjaan);
        edtJabatan = findViewById(R.id.edtJabatan);
        actionSimpan = findViewById(R.id.actionSimpan);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            edtNim.setText(extras.getString("nim", ""));
            edtNim.setEnabled(false);
            edtNama.setText(extras.getString("nama", ""));
            edtTempat.setText(extras.getString("tempat", ""));
            edtTanggal.setText(extras.getString("tanggal", ""));
            edtAlamat.setText(extras.getString("alamat", ""));
            edtAgama.setText(extras.getString("agama", ""));
            edtTlp.setText(extras.getString("tlp", ""));
            edtMasuk.setText(extras.getString("masuk", ""));
            edtLulus.setText(extras.getString("lulus", ""));
            edtPekerjaan.setText(extras.getString("pekerjaan", ""));
            edtJabatan.setText(extras.getString("jabatan", ""));
            actionSimpan.setText("Update");
        }

        actionSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = edtNim.getText().toString();
                String nama = edtNama.getText().toString();
                String tempat = edtTempat.getText().toString();
                String tanggal = edtTanggal.getText().toString();
                String alamat = edtAlamat.getText().toString();
                String agama = edtAgama.getText().toString();
                String tlp = edtTlp.getText().toString();
                String masuk = edtMasuk.getText().toString();
                String lulus = edtLulus.getText().toString();
                String pekerjaan = edtPekerjaan.getText().toString();
                String jabatan = edtJabatan.getText().toString();

                simpan();
            }
        });

        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar tanggalSekarang = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar tanggalSelected = Calendar.getInstance();
                        tanggalSelected.set(Calendar.YEAR, year);
                        tanggalSelected.set(Calendar.MONTH, month);
                        tanggalSelected.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
                        edtTanggal.setText(sdf.format(tanggalSelected.getTime()));
                    }
                };
                new DatePickerDialog(TambahData.this, date, tanggalSekarang.get(Calendar.YEAR), tanggalSekarang.get(Calendar.MONTH), tanggalSekarang.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    void simpan(){
        if (!edtNim.getText().toString().isEmpty() && !edtNama.getText().toString().isEmpty() && !edtTempat.getText().toString().isEmpty() && !edtTanggal.getText().toString().isEmpty() && !edtAlamat.getText().toString().isEmpty() && !edtAgama.getText().toString().isEmpty() && !edtTlp.getText().toString().isEmpty() && !edtMasuk.getText().toString().isEmpty() && !edtLulus.getText().toString().isEmpty() && !edtPekerjaan.getText().toString().isEmpty() && !edtPekerjaan.getText().toString().isEmpty()) {
            database = new DatabaseHelperAlumni(this).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nim", edtNim.getText().toString());
            contentValues.put("nama", edtNama.getText().toString());
            contentValues.put("tempat", edtTempat.getText().toString());
            contentValues.put("tanggal", edtTanggal.getText().toString());
            contentValues.put("alamat", edtAlamat.getText().toString());
            contentValues.put("agama", edtAgama.getText().toString());
            contentValues.put("tlp", edtTlp.getText().toString());
            contentValues.put("masuk", edtMasuk.getText().toString());
            contentValues.put("lulus", edtLulus.getText().toString());
            contentValues.put("pekerjaan", edtPekerjaan.getText().toString());
            contentValues.put("jabatan", edtJabatan.getText().toString());

            Bundle extras = getIntent().getExtras();

            if(extras != null){
                long update = database.update("tb_alumni", contentValues, "nim=?", new String[]{extras.getString("nim", "")});

                if (update != -1) {
                    Toast.makeText(this, "Update Data Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Update Data Gagal", Toast.LENGTH_SHORT).show();
                }
            } else {
                contentValues.put("nim", Integer.parseInt(edtNim.getText().toString()));
                long insert = database.insert("tb_alumni", null, contentValues);

//            database.update("tb_mahasiswa", contentValues, "nim=? and nama=?", new String[]{"12345", "nama"});
//            database.delete("tb_mahasiswa", "nim=? and nama=?", new String[]{"12345", "nama"});

                if (insert != -1) {
                    Toast.makeText(this, "Penyimpanan Data Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Penyimpanan Data Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            database.close();

//            Intent kembali = new Intent(TambahData.this, MenuUtama.class);
//            startActivity(kembali);
//            finish();
        } else {
            Toast.makeText(this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
        }
    }
}
