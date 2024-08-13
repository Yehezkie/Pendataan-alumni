package dts.pnj.yehezkiel_ruben;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperAlumni extends SQLiteOpenHelper {

    public DatabaseHelperAlumni(Context context) {
        super(context, "db_alumni", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_alumni (nim INTEGER PRIMARY KEY, nama TEXT, tempat TEXT, tanggal TEXT, alamat TEXT, agama TEXT, tlp TEXT, masuk TEXT, lulus TEXT, pekerjaan TEXT, jabatan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE tb_alumni");
            db.execSQL("CREATE TABLE tb_alumni (nim INTEGER PRIMARY KEY, nama TEXT, tempat TEXT, tanggal TEXT, alamat TEXT, agama TEXT, tlp TEXT, masuk TEXT, lulus TEXT, pekerjaan TEXT, jabatan TEXT)");
        }

    }
}
