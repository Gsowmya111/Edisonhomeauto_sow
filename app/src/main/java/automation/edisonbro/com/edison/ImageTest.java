package automation.edisonbro.com.edison;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by vidya on 27-06-2017.
 */

public class ImageTest extends BaseAdapter {
    private Context context;
   // static Integer[] images;

    static Integer[] numbers={R.drawable.currenttabicon,R.drawable.currenttabicon,R.drawable.currenttabicon,R.drawable.currenttabicon,};

  /*  public Integer[] images2={ R.drawable.sprinkler,R.drawable.switch_board,};
    public Integer[] images3={ R.drawable.sprinkler,};

    public Integer[] images4={R.drawable.switch_board,R.drawable.dimmer,R.drawable.rgb,R.drawable.curtain,R.drawable.dog,R.drawable.door_lock,
            R.drawable.fm,R.drawable.geyser, R.drawable.pir,R.drawable.rgb, R.drawable.sprinkler,R.drawable.switch_board,};

    public Integer[] images5={R.drawable.curtain,R.drawable.dog,R.drawable.door_lock,
            R.drawable.fm,R.drawable.geyser, R.drawable.pir,R.drawable.rgb, R.drawable.sprinkler,R.drawable.switch_board,};*/

    public ImageTest(Context c, int index)
    {
        context=c;

        if(index==0){
            this.numbers=numbers;
        }  /* else if(index==1){
            this.images=images2;
        }
        else if(index==2){
            this.images=images3;
        }
        else if(index==3){
            this.images=images4;
        }
        else if(index==4){
            this.images=images5;
        }*/

    }

    @Override
    public int getCount() {

        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return numbers[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(numbers[position]);
       /* imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));*/
        return imageView;
    }
}

