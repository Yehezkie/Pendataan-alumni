package dts.pnj.yehezkiel_ruben;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;
    EditText email, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.buttonLogin);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String nama = "Muhammad Ridwan Ramadhan";
                String nim = "4617010036";
                String kelas = "TI-6A";

                if(!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    if (mail.equals("ridwanra_pop2@yahoo.com") && pass.equals("admin123")){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("isLogin", true);
                        editor.putString("email", email.getText().toString());
                        editor.putString("nama", nama);
                        editor.putString("nim", nim);
                        editor.putString("kelas", kelas);
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, MenuUtama.class);
                        startActivity(intent);
                        finish();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Username atau password salah").setNegativeButton("Retry", null).create().show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Mohon lengkapi email atau password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
