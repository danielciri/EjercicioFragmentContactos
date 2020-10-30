package com.danielcirilo.contactosfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdaptadorContacto extends ArrayAdapter<Contacto> {
    private Context context;
    private Contacto[] contactos;

    public AdaptadorContacto(Fragment context, Contacto[]contactos) {
        super(context.getActivity(), R.layout.listitem_contactos, contactos);
        this.contactos = contactos;
        this.context = context.getActivity();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listitem_contactos, null);
        TextView tvNombreLis =item.findViewById(R.id.tvNombreLis);
        tvNombreLis.setText(contactos[position].getName()+" "+contactos[position].getSurname1());
        TextView tvTelefonoLis = item.findViewById(R.id.tvTelefonoLis);
        tvTelefonoLis.setText(contactos[position].getPhone1());
        return item;
    }
}