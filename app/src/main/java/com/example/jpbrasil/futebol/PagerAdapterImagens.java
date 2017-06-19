package com.example.jpbrasil.futebol;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by JpBrasil on 18/06/2017.
 */

class PagerAdapterImagens extends PagerAdapter{

    private Context context;
    private int[] imgs;

    public PagerAdapterImagens(Context context, int[] imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    //tamanho da nossa lista
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    /**
     *
     * @param container -> Esse container é o pagerview
     * @param position -> Posição do nosso elemento de imagem
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        //O elemento que vai aparecer no viewPager tem que ser adicionado no container
        container.addView(linearLayout);//colocando elemento que está sendo apresentado
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imgs[position]);
        linearLayout.addView(imageView);

        TextView textView = new TextView(context);
        textView.setText("SPORT CLUBE DO RECIFE" + position);
        linearLayout.addView(textView);

        return (linearLayout);
    }

    public void destroyItem(ViewGroup container, int position, Object view){
        container.removeView((View)view);
    }
}
