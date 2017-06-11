package com.example.jpbrasil.futebol;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.jpbrasil.futebol.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JpBrasil on 02/06/2017.
 */

public class PagerAdapterFragments extends FragmentPagerAdapter {

    int[] imagens = {R.drawable.sport_estadio, R.drawable.atletico_mg_estadio, R.drawable.atletico_pr_estadio};
    String[] titulos;
    List<PageFragment> pagers = new ArrayList<PageFragment>();


    public PagerAdapterFragments(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
        this.pagers.add(new PageFragment());
        this.pagers.add(new PageFragment());
        this.pagers.add(new PageFragment());
    }

    //Vai retornar um fragment
    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }
}
