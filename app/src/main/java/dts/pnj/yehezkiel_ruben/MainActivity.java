package dts.pnj.yehezkiel_ruben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreferences.getBoolean("isLogin", false)) {
                    Intent splash = new Intent(MainActivity.this, MenuUtama.class);
                    startActivity(splash);
                    finish();
                } else {
                    Intent splash = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(splash);
                    finish();
                }
            }
        }, 5000);
    }
}
