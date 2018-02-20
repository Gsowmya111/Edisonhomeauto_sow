package automation.edisonbro.com.edison;

/**
 * Created by vidya on 16-07-2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import automation.edisonbro.com.edison.model.QQ;

import static automation.edisonbro.com.edison.R.id.imageView;

/**
 * Created by vidya on 16-07-2017.
 */

class   Listviewadapter extends BaseAdapter {
    private final List<QQ> mQQList;
    Context context;
    public Integer[] images5={R.drawable.tentrance02,R.drawable.tbedroom02,R.drawable.tconference02,R.drawable.treception02,R.drawable.tdiningroom02};
    private ImageView selectedView = null;
    Integer []old = new Integer[1];
    static  String a;

    static  CustomViewHolder cvh = null;
    public Listviewadapter(Context applicationContext, List<QQ> mQQList) {
        context = applicationContext;
        this.mQQList=mQQList;
    }

    @Override
    public int getCount() {
        return mQQList.size();
    }

    @Override
    public Object getItem(int position) {
        return mQQList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mQQList.get(position).hashCode();
    }

    @Override
    public int getItemViewType(int position) {
        if (mQQList.get(position).isQun()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            cvh = new CustomViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_qq, null);
            cvh.imgLogo = (ImageView) convertView.findViewById(R.id.img_item_qq);
            // cvh.txtName = (TextView) convertView.findViewById(R.id.txt_item_qq_title);
            cvh.txtContent = (TextView) convertView.findViewById(R.id.txt_item_qq_title);


            convertView.setTag(cvh);
        }
         else {
            cvh = (CustomViewHolder) convertView.getTag();
        }
        QQ item = (QQ) this.getItem(position);
        cvh.imgLogo.setImageResource(item.getDrawableRes());
        cvh.txtContent.setText(item.getContent());
        if (getItemViewType(position) == 0) {
            // cvh.txtName.setText(item.getName());
        } else {
            // cvh.txtName.setText("(QQ群) " + item.getName() + "(" + item.getQunNumber() + ")");
        }


        final ImageView imgLogo1 = (ImageView) convertView.findViewById(R.id.img_item_qq);

        final View finalConvertView = convertView;
        imgLogo1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final TextView txt = (TextView) finalConvertView.findViewById(R.id.txt_item_qq_title);
                a = txt.getText().toString();
                if(old[0]!=null)
                {
                    selectedView.setImageResource(old[0]);
                    //Toast.makeText(Second.this,""+old[0],Toast.LENGTH_LONG).show();
                }

                if(a.equals("ENTRANCE"))
                {
                    // ImageView imageView = (ImageView) v;
                    imgLogo1.setImageResource(images5[0]);
                    old[0]=R.drawable.tentrance01;
                    selectedView= imgLogo1;



                }else  if(a.equals("CONFERENCE")){
                    // ImageView imageView = (ImageView) v;
                    imgLogo1.setImageResource(images5[2]);
                    old[0] = R.drawable.tconference01;
                    selectedView =imgLogo1;
                }
                else if(a.equals("RECEPTION"))
                {
                    // ImageView imageView = (ImageView) v;
                    imgLogo1.setImageResource(images5[3]);
                    old[0]=R.drawable.treception01;
                    selectedView= imgLogo1;



                }else if(a.equals("BEDROOM")) {
                    // ImageView imageView = (ImageView) v;
                    imgLogo1.setImageResource(images5[1]);
                    old[0] = R.drawable.tbedroom01;
                    selectedView =imgLogo1;
                }
               else if(a.equals("DININGROOM")) {
                // ImageView imageView = (ImageView) v;
                imgLogo1.setImageResource(images5[4]);
                old[0] = R.drawable.tdiningroom01;
                selectedView =imgLogo1;
            }



                return false;
            }
        });




        return convertView;
    }

    class CustomViewHolder {
        public ImageView imgLogo;
        //public TextView txtName;
        public TextView txtContent;
    }

};