package dts.pnj.yehezkiel_ruben;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dts.pnj.yehezkiel_ruben.AdapterAlumni;
import dts.pnj.yehezkiel_ruben.DatabaseHelperAlumni;
import dts.pnj.yehezkiel_ruben.AlumniData;

public class ListAlumni extends AppCompatActivity {
    ListView listView;
    AdapterAlumni adapterAlumni;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alumni);

        listView = findViewById(R.id.listAlumni);
        adapterAlumni = new AdapterAlumni(this, R.layout.item_alumni);
        listView.setAdapter(adapterAlumni);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlumniData data = (AlumniData) parent.getAdapter().getItem(position);

                Intent intent = new Intent(ListAlumni.this, DetailAlumni.class);
                intent.putExtra("nim", data.getNim());
                intent.putExtra("nama", data.getNama());
                intent.putExtra("tempat", data.getTempat());
                intent.putExtra("tanggal", data.getTanggal());
                intent.putExtra("alamat", data.getAlamat());
                intent.putExtra("agama", data.getAgama());
                intent.putExtra("tlp", data.getTlp());
                intent.putExtra("masuk", data.getMasuk());
                intent.putExtra("lulus", data.getLulus());
                intent.putExtra("pekerjaan", data.getPekerjaan());
                intent.putExtra("jabatan", data.getJabatan());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListAlumni.this);

                builder.setItems(new String[]{"Edit", "Hapus"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlumniData data = (AlumniData) parent.getAdapter().getItem(position);
                        if (which==0){
                            Intent intent = new Intent(ListAlumni.this, TambahData.class);
                            intent.putExtra("nim", data.getNim());
                            intent.putExtra("nama", data.getNama());
                            intent.putExtra("tempat", data.getTempat());
                            intent.putExtra("tanggal", data.getTanggal());
                            intent.putExtra("alamat", data.getAlamat());
                            intent.putExtra("agama", data.getAgama());
                            intent.putExtra("tlp", data.getTlp());
                            intent.putExtra("masuk", data.getMasuk());
                            intent.putExtra("lulus", data.getLulus());
                            intent.putExtra("pekerjaan", data.getPekerjaan());
                            intent.putExtra("jabatan", data.getJabatan());
                            startActivity(intent);
                        } else {
                            database = new DatabaseHelperAlumni(ListAlumni.this).getWritableDatabase();
                            long hapus = database.delete("tb_alumni", "nim=?", new String[]{data.getNim()});

                            if(hapus != -1) {
                                buatData();
                            } else {
                                Toast.makeText(ListAlumni.this, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
                            }

                            database.close();
                        }
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        buatData();
    }

    void buatData(){
        adapterAlumni.clear();
        database = new DatabaseHelperAlumni(this).getReadableDatabase();
        ArrayList<AlumniData> datas = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);

        if (cursor.moveToFirst()) {

            do {
                AlumniData data = new AlumniData();
                data.setNim(cursor.getString(0));
                data.setNama(cursor.getString(1));
                data.setTempat(cursor.getString(2));
                data.setTanggal(cursor.getString(3));
                data.setAlamat(cursor.getString(4));
                data.setAgama(cursor.getString(5));
                data.setTlp(cursor.getString(6));
                data.setMasuk(cursor.getString(7));
                data.setLulus(cursor.getString(8));
                data.setPekerjaan(cursor.getString(9));
                data.setJabatan(cursor.getString(10));
                datas.add(data);
            } while (cursor.moveToNext());

        }
        cursor.close();
        database.close();

        adapterAlumni.addAll(datas);
        adapterAlumni.notifyDataSetChanged();
    }
}
