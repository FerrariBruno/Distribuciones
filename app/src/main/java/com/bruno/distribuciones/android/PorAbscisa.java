package com.bruno.distribuciones.android;

/**
 * Created by Bruno on 30/12/2015.
 */
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bruno.distribuciones.R;
import com.bruno.distribuciones.dominio.ChiCuadrada;
import com.bruno.distribuciones.dominio.Normal;
import com.bruno.distribuciones.dominio.TStudent;

public class PorAbscisa extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.por_abscisa, container, false);
        RadioButton normal = (RadioButton) v.findViewById(R.id.rbtnNormalProb);
        normal.setChecked(true);
        Button btn = (Button) v.findViewById(R.id.btnCalcularProb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logicaCalcular(v);
            }
        });
        return v;
    }

    public void logicaCalcular(View v){
        View vista = (View) v.getParent();
        final RadioButton radioNormal = (RadioButton) vista.findViewById(R.id.rbtnNormalProb);
        final RadioButton radioChi = (RadioButton) vista.findViewById(R.id.rbtnChiProb);
        final TextView txtAbs = (TextView) vista.findViewById(R.id.txtAbscisaProb);
        final TextView txtRes = (TextView) vista.findViewById(R.id.txtResultadoProb);
        if(radioNormal.isChecked()){
            calcularNormal(txtAbs, txtRes);
        }else if(radioChi.isChecked()){
            calcularChi(txtAbs, txtRes);
        }else{
            calcularTStudent(txtAbs, txtRes);
        }
    }

    void calcularNormal(TextView abs, TextView res){
        String dato = abs.getText().toString();
        if(esValidoAbscisa(dato)){
            double dat = Double.parseDouble(dato);
            Normal n = new Normal();
            res.setText(n.porAbscisaNormal(dat));
        }else{
            mostrarErrorAbscisa();
        }
    }

    void calcularChi(TextView txtAbs, TextView txtRes){
        String dato = txtAbs.getText().toString();
        if(esValidoProbabilidadChi(dato)){
            double abs = Double.parseDouble(dato);
            ChiCuadrada c = new ChiCuadrada();
            txtRes.setText(c.porProbabilidadChiCuadrada(abs));
        }else{
            mostrarErrorProbabilidadChi();
        }
    }

    void calcularTStudent(TextView txtAbs, TextView txtRes){
        String dato = txtAbs.getText().toString();
        if(esValidoProbabilidadStudent(dato)){
            double abs = Double.parseDouble(dato);
            TStudent t = new TStudent();
            txtRes.setText(t.porProbabilidadTStudent(abs));
        }else{
            mostrarErrorProbabilidadStudent();
        }
    }

    void mostrarErrorAbscisa(){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor de la abscisa debe ser un número válido");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    boolean esValidoAbscisa(String dato){
        try{
            Double.parseDouble(dato);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    void mostrarErrorProbabilidadChi(){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor de la abscisa debe ser mayor a cero");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    boolean esValidoProbabilidadChi(String dato){
        try{
            double aux = Double.parseDouble(dato);
            if(aux >= 0) return true;
            else return false;
        }catch(Exception e){
            return false;
        }
    }

    boolean esValidoProbabilidadStudent(String dato){
        try{
            Double.parseDouble(dato);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    void mostrarErrorProbabilidadStudent(){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor ingresado es incorrecto");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
