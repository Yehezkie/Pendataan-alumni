package dts.pnj.yehezkiel_ruben;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import dts.pnj.yehezkiel_ruben.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_home_fragment, container, false);
    }
}
