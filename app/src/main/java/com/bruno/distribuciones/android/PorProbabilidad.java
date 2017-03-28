package com.bruno.distribuciones.android;

/**
 * Created by Bruno on 30/12/2015.
 */
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bruno.distribuciones.R;
import com.bruno.distribuciones.dominio.ChiCuadrada;
import com.bruno.distribuciones.dominio.Normal;
import com.bruno.distribuciones.dominio.TStudent;

import org.w3c.dom.Text;

import static com.bruno.distribuciones.R.id.txtGrados;

public class PorProbabilidad extends Fragment {
    RadioGroup grupo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.por_probabilidad, container, false);
        setearComienzo(v);
        final EditText gradosLibertad = (EditText) v.findViewById(txtGrados);
        final TextView labelGrados = (TextView) v.findViewById(R.id.lblGrados);
        final TextView resultado = (TextView) v.findViewById(R.id.txtResultado);
        setearVistaInicial(gradosLibertad, labelGrados);
        setearSegunRadioButton(v, gradosLibertad, labelGrados, resultado);
        clickCalcular(v);
        return v;
    }

    void setearComienzo(View v) {
        RadioButton normal = (RadioButton) v.findViewById(R.id.rbtnNormal);
        normal.setChecked(true);
    }

    void setearVistaInicial(EditText gradosLibertad, TextView labelGrados) {
        gradosLibertad.setEnabled(true);
        gradosLibertad.setEnabled(false);
        labelGrados.setTextColor(0XFFA8A8A8);
    }

    void setearSegunRadioButton(View v, final EditText gradosLibertad, final TextView labelGrados, final TextView resultado) {
        grupo = (RadioGroup) v.findViewById(R.id.rbtnGroup);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resultado.setText("");
                if (checkedId == R.id.rbtnNormal) {
                    setearNormal(gradosLibertad, labelGrados);
                } else if (checkedId == R.id.rbtnChi || checkedId == R.id.rbtnStudent) {
                    setearChiOTStudent(gradosLibertad, labelGrados);
                }
            }
        });
    }

    void setearNormal(EditText gradosLibertad, TextView labelGrados) {
        gradosLibertad.setText("");
        gradosLibertad.setEnabled(false);
        labelGrados.setTextColor(0XFFA8A8A8);
    }

    void setearChiOTStudent(EditText gradosLibertad, TextView labelGrados) {
        gradosLibertad.setEnabled(true);
        labelGrados.setTextColor(0XFF000000);
        gradosLibertad.getBackground().setColorFilter(ContextCompat.getColor(getContext(),
                R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        labelGrados.setTextColor(0XFF000000);
    }


    void clickCalcular(View v) {
        Button btn = (Button) v.findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logicaCalcular(v);
            }
        });
    }

    public boolean esValidoGrados(String dato){
        try{
            int aux = Integer.parseInt(dato);
            if(aux > 0) return true;
            else return false;
        }catch(Exception e){
            return false;
        }
    }

    public void mostrarErrorGrados() {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor de los grados de libertad debe ser un entero mayor a cero");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }



    public void logicaCalcular(View v) {
        View vista = (View) v.getParent();
        final RadioButton radioNormal = (RadioButton) vista.findViewById(R.id.rbtnNormal);
        final RadioButton radioChi = (RadioButton) vista.findViewById(R.id.rbtnChi);
        final TextView txtAbs = (TextView) vista.findViewById(R.id.txtAbscisa);
        final TextView txtGrad = (TextView) vista.findViewById(txtGrados);
        final TextView txtRes = (TextView) vista.findViewById(R.id.txtResultado);
        if (radioNormal.isChecked()) {
            calcularNormal(txtAbs, txtRes);
        } else if (radioChi.isChecked()) {
            calcularChiCuadrada(txtAbs, txtGrad, txtRes);
        } else {
            calcularTStudent(txtAbs, txtGrad, txtRes);
        }
    }

    void calcularNormal(TextView txtAbs, TextView txtRes){
        String dato = txtAbs.getText().toString();
        if(esValidoProbabilidadNormal(dato)){
            double dat = Double.parseDouble(dato);
            Normal n = new Normal();
            txtRes.setText(n.porProbabilidadNormal(dat));
        }else{
            mostrarErrorProbabilidadNormal();
        }
    }

    void calcularChiCuadrada(TextView txtAbs, TextView txtGrad, TextView txtRes) {
        String datoAbs = txtAbs.getText().toString();
        String datoGrad = txtGrad.getText().toString();
        if(esValidoEntre0y1(datoAbs) && esValidoGrados(datoGrad)){
            double abs = Double.parseDouble(datoAbs);
            int grad = Integer.parseInt(datoGrad);
            ChiCuadrada c = new ChiCuadrada();
            txtRes.setText(c.porAbscisaChiCuadrada(abs, grad));
        }else{
            if(!esValidoEntre0y1(datoAbs)){
                mostrarError0y1();
            }else{
                mostrarErrorGrados();
            }
        }
    }


    void calcularTStudent(TextView txtAbs, TextView txtGrad, TextView txtRes) {
        String datoAbs = txtAbs.getText().toString();
        String datoGrad = txtGrad.getText().toString();
        if (esValidoEntre0y1(datoAbs) && esValidoGrados(datoGrad)) {
            double abs = Double.parseDouble(datoAbs);
            int grad = Integer.parseInt(datoGrad);
            TStudent t = new TStudent();
            txtRes.setText(t.porAbscisaTStudent(abs, grad));
        } else {
            if (!esValidoEntre0y1(datoAbs)) {
                mostrarError0y1();
            } else {
                mostrarErrorGrados();
            }
        }
    }

    void mostrarErrorProbabilidadNormal(){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor de la probabilidad debe estar entre 0 y 1");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    boolean esValidoProbabilidadNormal(String dato){
        try{
            double aux = Double.parseDouble(dato);
            if(aux <= 1 && aux >= 0) return true;
            else return false;
        }catch(Exception e){
            return false;
        }
    }

    boolean esValidoEntre0y1(String dato){
        try{
            double aux = Double.parseDouble(dato);
            if(aux <= 1 && aux >= 0) return true;
            else return false;
        }catch(Exception e){
            return false;
        }
    }

    void mostrarError0y1(){
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage("El valor de la probabilidad debe estar entre 0 y 1");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

