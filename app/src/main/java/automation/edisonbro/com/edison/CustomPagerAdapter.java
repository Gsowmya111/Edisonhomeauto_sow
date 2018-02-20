package automation.edisonbro.com.edison;

/**
 * Created by sowmyaram on 6/19/2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomPagerAdapter extends PagerAdapter {
    private Context mContext;
    LayoutInflater mLayoutInflater;
   // private int[] mResources;

       int layoutes[]={R.layout.rgb,R.layout.aquarium};


    public CustomPagerAdapter(Context context, int[] resources) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      layoutes=resources;
        //  mResources = resources;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       /* View itemView = mLayoutInflater.inflate(R.layout.pager_item,container,false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(layoutes[position]);
           *//* LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(950, 950);
            imageView.setLayoutParams(layoutParams);*//*
        container.addView(itemView);
        return itemView;*/


     //   Context context = null;
        mLayoutInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View one=mLayoutInflater.inflate(R.layout.rgb,container,false);
        View two=mLayoutInflater.inflate(R.layout.aquarium,container,false);
       // View three=mLayoutInflater.inflate(R.layout.three,container,false);
        View viewarr[]={one,two};
        container.addView(viewarr[position]);
        return viewarr[position];





    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return layoutes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}