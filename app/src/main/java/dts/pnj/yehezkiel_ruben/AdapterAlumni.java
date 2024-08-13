package dts.pnj.yehezkiel_ruben;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dts.pnj.yehezkiel_ruben.R;
import dts.pnj.yehezkiel_ruben.AlumniData;

public class AdapterAlumni extends ArrayAdapter<AlumniData> {

    Context context;
    int resource;

    public AdapterAlumni(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Holder holder;

        if (convertView==null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.txtNim = convertView.findViewById(R.id.txtNim);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            holder.txtTempat = convertView.findViewById(R.id.txtTempat);
            holder.txtTanggal = convertView.findViewById(R.id.txtTanggal);
            holder.txtAlamat = convertView.findViewById(R.id.txtAlamat);
            holder.txtAgama = convertView.findViewById(R.id.txtAgama);
            holder.txtTlp = convertView.findViewById(R.id.txtTlp);
            holder.txtMasuk = convertView.findViewById(R.id.txtMasuk);
            holder.txtLulus = convertView.findViewById(R.id.txtLulus);
            holder.txtPekerjaan = convertView.findViewById(R.id.txtPekerjaan);
            holder.txtJabatan = convertView.findViewById(R.id.txtJabatan);
            convertView.setTag(holder);
        } else {
            holder = (AdapterAlumni.Holder) convertView.getTag();
        }

        holder.txtNim.setText(getItem(position).getNim());
        holder.txtNama.setText(getItem(position).getNama());
        holder.txtTempat.setText(getItem(position).getTempat());
        holder.txtTanggal.setText(getItem(position).getTanggal());
        holder.txtAlamat.setText(getItem(position).getAlamat());
        holder.txtAgama.setText(getItem(position).getAgama());
        holder.txtTlp.setText(getItem(position).getTlp());
        holder.txtMasuk.setText(getItem(position).getMasuk());
        holder.txtLulus.setText(getItem(position).getLulus());
        holder.txtPekerjaan.setText(getItem(position).getPekerjaan());
        holder.txtJabatan.setText(getItem(position).getJabatan());

        return convertView;
    }

    class Holder {
        TextView txtNim, txtNama, txtTempat, txtTanggal, txtAlamat, txtAgama, txtTlp, txtMasuk, txtLulus, txtPekerjaan, txtJabatan;
    }
}
