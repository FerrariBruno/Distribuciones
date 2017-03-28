package com.bruno.distribuciones.android;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Bruno on 30/12/2015.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    CharSequence titulos[];
    int numeroDeTabs;

    public ViewPagerAdapter(FragmentManager fragmentManager, CharSequence titulos[], int cantidadDeTabs) {
        super(fragmentManager);

        this.titulos = titulos;
        this.numeroDeTabs = cantidadDeTabs;

    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0)
        {
            PorAbscisa primeraTab = new PorAbscisa();
            return primeraTab;

        }
        else if(position == 1)
        {
            PorProbabilidad segundaTab = new PorProbabilidad();
            return segundaTab;
        }else{
            Tablas terceraTab = new Tablas();
            return terceraTab;
        }
    }

    @Override
    public CharSequence getPageTitle(int posicion) {
        return titulos[posicion];
    }

    @Override
    public int getCount() {
        return numeroDeTabs;
    }
}

