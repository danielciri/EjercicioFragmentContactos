package com.danielcirilo.contactosfragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoListado extends Fragment {
    private ListView lvFragmento;
    private IContactoListener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Parser parserJson = new Parser(getActivity());
        parserJson.parse();
        lvFragmento = getView().findViewById(R.id.lvFragment);
        lvFragmento.setAdapter(new AdaptadorContacto(this, parserJson.getContactos()));

        lvFragmento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener!=null) {
                    listener.onContactoSeleccionado((Contacto)lvFragmento.getAdapter().getItem(position));
                }
            }
        });

    }

    public void setContactoListener(IContactoListener listener) {
        this.listener = listener;
    }
}
