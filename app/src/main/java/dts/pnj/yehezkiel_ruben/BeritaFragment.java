package dts.pnj.yehezkiel_ruben;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import dts.pnj.yehezkiel_ruben.DetailBerita;
import dts.pnj.yehezkiel_ruben.R;
import dts.pnj.yehezkiel_ruben.AdapterBerita;
import dts.pnj.yehezkiel_ruben.BeritaData;

public class BeritaFragment extends Fragment {
    ListView listView;
    AdapterBerita adapterBerita;

    public BeritaFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_berita_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listBerita);
        adapterBerita = new AdapterBerita(getActivity(), R.layout.item_berita);
        listView.setAdapter(adapterBerita);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeritaData data = (BeritaData) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBerita.class);
                intent.putExtra("gambar", data.getGambar());
                intent.putExtra("judul", data.getJudul());
                intent.putExtra("deskripsi", data.getBerita());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        buatData();
    }

    void buatData() {
        adapterBerita.clear();
        String judul[] = new String[]{"Lakukan Physical Distancing, Beli Ponsel Bisa Pakai Delivery",
                "Keras! Buruh Protes Jokowi yang 'Manjakan' Ojol",
                "Lagi-lagi karena Corona, 450 Karyawan KFC Dirumahkan",
                "Nggak Perlu Antre, Sembako dari Jokowi Bakal Diantar Gojek dan Grab",
                "Jelang PSBB Makassar, Gubernur Nurdin Cek Dapur Lapangan Brimob Polda Sulsel",
                "Naik 407, Jumlah Kasus Baru Positif Corona RI Catatkan Angka Tertinggi",
                "Ratusan Pasien Dinyatakan Sembuh dari Corona Saat Diberi Obat Remdesivir",
                "Sebaran Pasien Virus Corona di Indonesia, 607 Sembuh, 520 Meninggal",
                "China Akui Kematian di Wuhan 50 Persen Lebih Tinggi dari yang Dilaporkan",
                "Pekerja Kantoran WFH, Jasa Logistik Sektor Ini Lesu",
                "Digugat Pengelola Mal, Anies Baswedan Menang di MA"
        };
        String deskripsi[] = new String[]{"Di tengah pelaksanaan Pembatasan Sosial Berskala Besar (PSBB), layanan pesan antar (delivery) menjadi salah satu solusi yang digunakan masyarakat untuk memenuhi kebutuhan. Dengan mengandalkan jaringan komunikasi, bahan makanan, kebutuhan rumah, hingga alat elektronik bisa diantarkan langsung ke rumah.",
                "Kebijakan pemerintah yang memberikan bantuan kepada driver ojek online (ojol) mendapat protes keras dari serikat buruh. Presiden Joko Widodo (Jokowi) dinilai tidak adil membuat kebijakan dan dianggap ada unsur Korupsi, Kolusi, dan Nepotisme (KKN).",
                "Kentucky Fried Chicken (KFC) Indonesia mulai merumahkan karyawannya imbas virus Corona (COVID-19). Setidaknya sampai saat ini sudah ada 450 karyawan KFC yang dirumahkan.",
                "Presiden Joko Widodo (Jokowi) bakal menggelontorkan bantuan sosial (bansos) paket sembako kepada 1,9 juta keluarga di Jabodetabek yang terdampak virus Corona (COVID-19). Paket sembako yang diberikan berupa 10 bahan makanan senilai Rp 600.000 yang diberikan tiap bulannya selama 3 bulan.",
                "PSBB di Kota Makassar akan diberlakukan pada 24 April mendatang atau bertepatan dengan 1 Ramadhan 1441 Hijriah. Gubernur Sulawesi Selatan (Sulsel) Nurdin Abdullah, memantau fasilitas dapur lapangan di markas Brimob Polda Sulsel, Jalan KS Tubun Makassar.",
                "Indonesia kembali mencatatkan penambahan kasus baru virus Corona COVID-19. Total hingga Jumat (17/4/2020) pukul 12:00 WIB jumlahnya menjadi 5.923 kasus, 607 sembuh, dan 520 meninggal.",
                "Ratusan pasien virus Corona COVID-19 dinyatakan sembuh saat uji coba menggunakan antivirus Ebola, yaitu remdesivir. Hal ini diungkapkan oleh dokter di The University of Chicago Medicine.",
                "Pemerintah mengumumkan jumlah kasus positif virus Corona COVID-19 di Indonesia pada Jumat (17/4/2020) telah mencapai 5.923 kasus. Sebanyak 607 pasien dinyatakan sembuh, 520 pasien meninggal.",
                "Korban kematian virus Corona di Wuhan, China, dilaporkan lebih tinggi seribu orang dari yang terdata sebelumnya. Badan Pencegahan dan Pengendalian Penyakit Wuhan telah mengubah jumlah kematian dari 2.579 menjadi 3.689, terdapat peningkatan sekitar 50 persen.",
                "Pandemi virus Corona (COVID-19) membuat penyedia jasa logistik kebanjiran order, khususnya untuk mengantarkan produk pangan ke pelanggan karena dibatasinya kegiatan di luar rumah. Namun tidak semua pengusaha logistik diuntungkan imbas virus Corona.",
                "Pengelola mal yang tergabung dalam Asosiasi Pengelola Pusat Belanja Indonesia (APPBI) mengajukan permohonan uji materi (judicial review) ke Mahkamah Agung (MA) agar Peraturan Daerah (Perda) Nomor 2 Tahun 2018 tentang Perpasaran dicabut. Alasannya, perda itu dinilai memberatkan pusat perbelanjaan (mal). Apa daya, permohonan itu ditolak.\n"
        };

        String[] imageAvatar = new String[] {
                "https://akcdn.detik.net.id/community/media/visual/2020/04/16/339aee01-133d-46f6-ad82-b60a802dd1ef.png?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/04/13/5c7ee3d1-f0ec-4f1d-a7aa-e0f683e3c3ae_169.jpeg?w=700&q=80",
                "https://akcdn.detik.net.id/community/media/visual/2015/12/22/a1d84349-b1fd-437c-b4cd-b5d854184eed_169.jpg?w=700&q=80",
                "https://akcdn.detik.net.id/community/media/visual/2020/04/14/a9e05b7d-d3ef-4938-abe6-26248ac58ad0_169.jpeg?w=700&q=80",
                "https://akcdn.detik.net.id/community/media/visual/2020/04/17/33a86c75-e273-438c-849c-4151155a5622_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/03/30/4f567966-d6a9-4629-808f-70ac3f53fac8_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/03/06/66daae6c-3f33-43be-b6cb-73ab1da75fb9_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/04/10/adda3d2b-2de1-4dd9-8e3d-1b9a75dfe78e_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/02/09/0c9f0dad-e289-4bd3-92e1-013219d0b5d1_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2018/09/06/6d85b70b-e924-4e1d-88f6-1a27a804b515_169.jpeg?w=700&q=80",
                "https://akcdn.detik.net.id/community/media/visual/2019/06/22/69c8e8d7-cb6d-43c1-a0d1-1d9185093998_43.jpeg?w=700&q=90"

        };


        ArrayList<BeritaData> datas = new ArrayList<>();

        for (int i=0; i<judul.length; i++) {
            BeritaData data = new BeritaData();
            data.setJudul(judul[i]);
            data.setBerita(deskripsi[i]);
            data.setGambar(imageAvatar[i]);


            datas.add(data);

        }
        adapterBerita.addAll(datas);
        adapterBerita.notifyDataSetChanged();
    }
}
