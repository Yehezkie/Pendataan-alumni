package dts.pnj.yehezkiel_ruben;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailAlumni extends AppCompatActivity {
    TextView detailNim, detailNama, detailTempat, detailTanggal, detailAlamat, detailAgama, detailTlp, detailMasuk, detailLulus, detailPekerjaan, detailJabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alumni);

        detailNim = findViewById(R.id.detailnim);
        detailNama = findViewById(R.id.detailnama);
        detailTempat = findViewById(R.id.detailtempat);
        detailTanggal = findViewById(R.id.detailtanggal);
        detailAlamat = findViewById(R.id.detailalamat);
        detailAgama = findViewById(R.id.detailagama);
        detailTlp = findViewById(R.id.detailtlp);
        detailMasuk = findViewById(R.id.detailmasuk);
        detailLulus = findViewById(R.id.detaillulus);
        detailPekerjaan = findViewById(R.id.detailpekerjaan);
        detailJabatan = findViewById(R.id.detailjabatan);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            detailNim.setText("NIM : "+extras.getString("nim", ""));
            detailNama.setText("Nama : "+extras.getString("nama", ""));
            detailTempat.setText("Tempat Lahir : "+extras.getString("tempat", ""));
            detailTanggal.setText("Tanggal Lahir : "+extras.getString("tanggal", ""));
            detailAlamat.setText("Alamat : "+extras.getString("alamat", ""));
            detailAgama.setText("Agama : "+extras.getString("agama", ""));
            detailTlp.setText("Nomor Telepon : "+extras.getString("tlp", ""));
            detailMasuk.setText("Tahun Masuk : "+extras.getString("masuk", ""));
            detailLulus.setText("Tahun Lulus : "+extras.getString("lulus", ""));
            detailPekerjaan.setText("Pekerjaan : "+extras.getString("pekerjaan", ""));
            detailJabatan.setText("Jabatan : "+extras.getString("jabatan", ""));
        }
    }
}
