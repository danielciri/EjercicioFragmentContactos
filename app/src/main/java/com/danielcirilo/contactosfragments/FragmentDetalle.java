package com.danielcirilo.contactosfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }
    public void mostrarDetalle(Contacto contacto) {
        TextView tvNombre = getView().findViewById(R.id.tvNombre);
        tvNombre.setText(contacto.getName());
        TextView tvApellido = getView().findViewById(R.id.tvApellido);
        tvApellido.setText(contacto.getSurname1()+" "+contacto.getSurname2());
        TextView tvDireccion = getView().findViewById(R.id.tvDireccion);
        tvDireccion.setText(contacto.getAddress());
        TextView tvEmpresa = getView().findViewById(R.id.tvEmpresa);
        tvEmpresa.setText(contacto.getCompany());
        TextView tvFecha = getView().findViewById(R.id.tvFechaNac);
        tvFecha.setText(contacto.getFecha());
        TextView tvTelefono1 = getView().findViewById(R.id.tvTelefono1);
        tvTelefono1.setText(contacto.getPhone1());
        TextView tvTelefono2 = getView().findViewById(R.id.tvTelefono2);
        tvTelefono2.setText(contacto.getPhone2());
        TextView tvEmail = getView().findViewById(R.id.tvEmail);
        tvEmail.setText(contacto.getEmail());
    }
}