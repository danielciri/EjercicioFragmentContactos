package com.danielcirilo.contactosfragments;



import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class Parser {

    private Contacto[] contactos;
    private InputStream contactoFile;

    public Parser(Context c) {
        contactoFile= c.getResources().openRawResource(R.raw.contacts);
    }

    public void parse() {
        contactos = null;
        int bytesArchivo;
        byte[] bytes = null;
        String json;
        try {
            bytesArchivo = contactoFile.available();
            bytes = new byte[bytesArchivo];
            contactoFile.read(bytes);
            json=new String(bytes, "UTF-8");

            JSONTokener tokener = new JSONTokener(json);
            JSONArray archivo = new JSONArray(tokener);
            contactos = new Contacto[archivo.length()];

            for(int i=0; i<archivo.length();i++) {

                JSONObject jsonObject=archivo.getJSONObject(i);
                int id=jsonObject.getInt("id");
                String name=jsonObject.getString("name");
                String firstSurname=jsonObject.getString("firstSurname");
                String secondSurname=jsonObject.getString("secondSurname");
                String birth=jsonObject.getString("birth");
                String company=jsonObject.getString("company");
                String email=jsonObject.getString("email");
                String phone1=jsonObject.getString("phone1");
                String phone2=jsonObject.getString("phone2");
                String adress=jsonObject.getString("address");
                contactos[i]=new Contacto(id,name,firstSurname,secondSurname,
                        birth,company,email,phone1,phone2,adress);            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (JSONException jsonError) {
            jsonError.printStackTrace();
        }
    }

    public Contacto[] getContactos() {
        return this.contactos;
    }
}