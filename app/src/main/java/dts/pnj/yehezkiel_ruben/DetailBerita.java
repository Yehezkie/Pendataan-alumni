package dts.pnj.yehezkiel_ruben;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailBerita extends AppCompatActivity {
    ImageView header;
    TextView heading, isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        header = findViewById(R.id.header);
        heading = findViewById(R.id.heading);
        isi = findViewById(R.id.isi);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Picasso.get().load(extras.getString("gambar", "")).into(header);
            heading.setText(extras.getString("judul", ""));
            isi.setText(extras.getString("deskripsi", ""));
        }
    }
}
