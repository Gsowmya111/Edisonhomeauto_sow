package automation.edisonbro.com.edison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter_fish extends BaseAdapter {
    private Context context;

    public Integer[] images={R.drawable.fsh1,R.drawable.fsh2,R.drawable.fsh3,R.drawable.fsh4,R.drawable.fsh5,R.drawable.fsh6,R.drawable.fsh7,
            R.drawable.fsh8,R.drawable.fsh9, R.drawable.fsh10,R.drawable.fsh11, R.drawable.fsh12,R.drawable.fsh13,
            R.drawable.fsh14,R.drawable.fsh15, R.drawable.fsh16,R.drawable.fsh17, R.drawable.fsh18,R.drawable.fsh19,
            R.drawable.fsh20,R.drawable.fsh21, R.drawable.fsh22,R.drawable.fsh23, R.drawable.fsh24,R.drawable.fsh25,R.drawable.fsh26, R.drawable.fsh27,

    };

    public ImageAdapter_fish(Context c)
    {
        context=c;
    }

    @Override
    public int getCount() {

        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ImageView imageView = new ImageView(context);
        // imageView.setImageResource(images[position]);
        //  imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //    imageView.setLayoutParams(new GridView.LayoutParams(100,100));


        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ImageView imageView = new ImageView(context);
        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.single_grid_item_aquarium, null);
            final ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            imageView.setImageResource(images[position]);
        } else {
            grid = (View) convertView;
        }

            return grid;
        }
    }

