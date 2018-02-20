package automation.edisonbro.com.edison;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    static Integer[] images;
    private ImageView selectedView = null;
    Integer []old = new Integer[1];


    public Integer[] images1={R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,R.mipmap.dl,};
    public Integer[] images11={ R.drawable.ac01,R.mipmap.dimmer_grid,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01,R.drawable.ac01};

    public Integer[] images2={ R.mipmap.ac_grid,R.mipmap.dimmer_grid,R.mipmap.ac_grid,R.mipmap.switchboard_grid,};
    public Integer[] images3={ R.mipmap.ac_grid,};

    public Integer[] images4={R.mipmap.bell_grid,R.mipmap.ac_grid,R.mipmap.dimmer_grid,R.mipmap.ac_grid,R.mipmap.switchboard_grid,};

    public Integer[] images5={R.mipmap.ac_grid,R.mipmap.switchboard_grid,};

    public ImageAdapter(Context c, String index)
    {
        context=c;

      if(index=="Entrance"){
            this.images=images1;
        }   else if(index=="Conference"){
            this.images=images2;
        }
        else if(index=="Reception"){
            this.images=images3;
        }
        else if(index=="Bedroom"){
            this.images=images4;
        }
        else if(index=="Diningroom"){
            this.images=images5;
        }

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ImageView imageView = new ImageView(context);
        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.single_grid_item, null);
            final ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);

            imageView.setImageResource(images[position]);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(old[0]!=null)
                    {
                        selectedView.setImageResource(old[0]);
                        //Toast.makeText(Second.this,""+old[0],Toast.LENGTH_LONG).show();
                    }

                    if(position==0)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[0]);
                        old[0]=images[0];
                        selectedView=imageView;



                    }else if(position==1)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[1]);
                        old[0]=images[1];
                        selectedView=imageView;
                    }
                    else if(position==2)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[2]);
                        old[0]=images[2];
                        selectedView=imageView;

                    }
                    else if(position==3)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[3]);
                        old[0]=images1[3];
                        selectedView=imageView;
                    }
                    else if(position==4)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[4]);
                        old[0]=images[4];
                        selectedView=imageView;
                    }
                   else if(position==5)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[5]);
                        old[0]=images[5];
                        selectedView=imageView;



                    }else if(position==6)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[6]);
                        old[0]=images[6];
                        selectedView=imageView;
                    }
                    else if(position==7)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[7]);
                        old[0]=images[7];
                        selectedView=imageView;

                    }
                    else if(position==8)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[8]);
                        old[0]=images[8];
                        selectedView=imageView;
                    }
                    else if(position==9)
                    {
                        // ImageView imageView = (ImageView) v;
                        imageView.setImageResource(images11[9]);
                        old[0]=images[9];
                        selectedView=imageView;
                    }

                }
            });
            imageView.setImageResource(images[position]);





        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}