package com.bruno.distribuciones.android;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bruno.distribuciones.R;

/**
 * Created by Bruno on 11/1/2016.
 */
public class Tablas extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tablas, container, false);
        Button btnNormal = (Button) v.findViewById(R.id.btnNormal);
        Button btnChi = (Button)v.findViewById(R.id.btnChi);
        Button btnStudent = (Button)v.findViewById(R.id.btnStudent);
        setearNormal(btnNormal);
        setearChiCuadrada(btnChi);
        setearTStudent(btnStudent);

        return v;
    }

    private void setearNormal(Button btnNormal) {
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://i.imgur.com/WOkrM2N.jpg"));
                startActivity(i);
            }
        });
    }

    void setearChiCuadrada(Button btnChi) {
        btnChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://i.imgur.com/baSBxjv.jpg"));
                startActivity(i);
            }
        });
    }

    void setearTStudent(Button btnStudent) {
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://i.imgur.com/On9oK7d.jpg"));
                startActivity(i);
            }
        });
    }


}
