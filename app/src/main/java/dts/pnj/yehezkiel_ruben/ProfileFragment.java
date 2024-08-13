package dts.pnj.yehezkiel_ruben;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dts.pnj.yehezkiel_ruben.LoginActivity;
import dts.pnj.yehezkiel_ruben.R;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {
    SharedPreferences sharedPreferences;
    EditText email, nim, nama, kelas;

    public ProfileFragment() {

    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_profil_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.email);
        nim = view.findViewById(R.id.nim);
        nama = view.findViewById(R.id.nama);
        kelas = view.findViewById(R.id.kelas);

        sharedPreferences = this.getActivity().getSharedPreferences("login", MODE_PRIVATE);

        email.setEnabled(false);
        nim.setEnabled(false);
        nama.setEnabled(false);
        kelas.setEnabled(false);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value1 = sharedPreferences.getString("email", "");
        String value2 = sharedPreferences.getString("nim", "");
        String value3 = sharedPreferences.getString("nama", "");
        String value4 = sharedPreferences.getString("kelas", "");

        email.setText(value1);
        nim.setText(value2);
        nama.setText(value3);
        kelas.setText(value4);

    }
}
