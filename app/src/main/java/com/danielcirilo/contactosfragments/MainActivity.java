package com.danielcirilo.contactosfragments;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IContactoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentoListado listado = (FragmentoListado)getSupportFragmentManager().findFragmentById(R.id.frgLista);
        listado.setContactoListener(this);
    }

    @Override
    public void onContactoSeleccionado(Contacto c) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!=null);
        if(hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(c);
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c);
            startActivity(i);
        }
    }
}