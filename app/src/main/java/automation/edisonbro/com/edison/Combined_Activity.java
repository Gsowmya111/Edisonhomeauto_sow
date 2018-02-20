package automation.edisonbro.com.edison;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import automation.edisonbro.com.edison.model.QQ;
import automation.edisonbro.com.edison.sdlv.src.main.java.com.yydcdut.sdlv.Menu;
import automation.edisonbro.com.edison.sdlv.src.main.java.com.yydcdut.sdlv.MenuItem;
import automation.edisonbro.com.edison.sdlv.src.main.java.com.yydcdut.sdlv.SlideAndDragListView;

import automation.edisonbro.com.edison.Rgb;
import automation.edisonbro.com.edison.Aquarium;

public class Combined_Activity extends AppCompatActivity

  /*
}*/
 implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener,
        SlideAndDragListView.OnDragListener, SlideAndDragListView.OnSlideListener,
        SlideAndDragListView.OnMenuItemClickListener, SlideAndDragListView.OnItemDeleteListener{

private static final String TAG = CombinedFragment.class.getSimpleName();
        DataBaseHandler1 db= null;
private List<Menu> mMenuList;
private List<QQ> mQQList;
private SlideAndDragListView<QQ> mListView;
private Toast mToast;
        FrameLayout frameLayout;
        String roomnamesdb[];
        String imgnamesdb[];
        int startpos,endos;
        GridView gridView;
        LinearLayout linear;
        View view;


/*
public CombinedFragment() {
        // Required empty public constructor
        }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fragment_combined);
           // getLayoutInflater().inflate(R.layout.fragment_combined, frameLayout);
            view = getLayoutInflater().inflate(R.layout.curtain, frameLayout);
        //linear = (LinearLayout) view.findViewById(R.id.linear);
            linear = (LinearLayout) view.findViewById(R.id.linear);
        //startZoomOutAnimation(linear);

        startZoominAnimation(linear);
        gridView = (GridView) view.findViewById(R.id.gridView);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             /*   Fragment fr = null;
                switch(position) {
                    case 0:

                        Toast.makeText(getActivity().getApplicationContext(), "Position" + position, Toast.LENGTH_SHORT).show();

                       *//**//* fr = new Aquarium();
                        android.support.v4.app.FragmentManager fm = getFragmentManager();

                        android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();

                        fragmentTransaction.replace(R.id.fragment_place,  fr);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();*//**//*
                        break;


                    case 1:

                        Toast.makeText(getActivity().getApplicationContext(), "Position"+position, Toast.LENGTH_SHORT).show();
                       *//**//* fr = new Rgb();
                        android.support.v4.app.FragmentManager fm1 = getFragmentManager();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = fm1.beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_place, fr);
                        fragmentTransaction1.addToBackStack(null);
                        fragmentTransaction1.commit();*//**//*


*/

                // }
            }
        });




        db=new DataBaseHandler1(this);
        //  db.opendb();
        db.getWritableDatabase();
        int rowcount=db.numberOfRows();
        if(rowcount<=0) {
            db.insertData("Entrance","1","2","icentrance");
            db.insertData("Conference", "2", "4","icconference");
            db.insertData("Reception", "3", "3","icreception");
            db.insertData("Bedroom", "4", "0","icbedroom");
            db.insertData("Bathroom", "5", "1","icbathroom");

        }

        initData();
        initMenu();
        initUiAndListener();
        //    pullout();





        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }
/*@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_combined,container, false);
        // return inflater.inflate(R.layout.fragment_combined, container, false);
//return view;



        return view;
        }*/



public void fetchposi(int size){
        int newpositionslist[]=db.getposvalues(size);

        for(int j=0;j<newpositionslist.length;j++){

        Log.d("newpositionslist" , ""+newpositionslist[j]);

        }

        }

public void fetchrooms(){
        List<String> roomlist=db.getData1();
        roomnamesdb=roomlist.toArray(new String[roomlist.size()]);
        }

public void fetchimgnames(){
        List<String> imglist=db.getimagenames();
        imgnamesdb=imglist.toArray(new String[imglist.size()]);
        }

public void initData() {

        fetchrooms();
        fetchimgnames();

        fetchposi(roomnamesdb.length);

        for(int j=0;j<roomnamesdb.length;j++){

        Log.d("test","room"+j+"  "+roomnamesdb[j]);


        }


        for(int j=0;j<imgnamesdb.length;j++){

        Log.d("test","imgname"+j+"  "+imgnamesdb[j]);


        }


        // int imgname[] = new int[imgnamesdb.length];
        mQQList = new ArrayList<>();

        for(int k=0;k<imgnamesdb.length;k++){

        String mDrawableName = imgnamesdb[k];
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        //  imgname[k] = Integer.parseInt("R.drawable."+imgnamesdb[k]);
        mQQList.add(new QQ("", roomnamesdb[k],"",resID));


          /*  int id = getResources()
                    .getIdentifier("yourpackagename:drawable/" + imgname, null, null);*/

        }




        }

public void initMenu() {
        mMenuList = new ArrayList<>(2);
        Menu menu0 = new Menu(true, 0);
        menu0.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
        .setBackground(new ColorDrawable(Color.RED))
        .setText("DELETE")
        .setDirection(MenuItem.DIRECTION_RIGHT)
        .setTextColor(Color.WHITE)
        .setTextSize(10)
        .build());

        mMenuList.add(menu0);
        // mMenuList.add(menu1);
        }

public void initUiAndListener() {
        mListView = (SlideAndDragListView) view.findViewById(R.id.lv_edit);
        mListView.setMenu(mMenuList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemLongClickListener(this);
        mListView.setOnDragListener(this, mQQList);
        mListView.setOnItemClickListener(this);
        //   mListView.setOnSlideListener(this);
        //   mListView.setOnMenuItemClickListener(this);
        mListView.setOnItemDeleteListener(this);
        // mListView.setDivider(new ColorDrawable(Color.GRAY));
        //  mListView.setDividerHeight(1);
        }

private BaseAdapter mAdapter = new BaseAdapter() {
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
public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder cvh = null;
        if (convertView == null) {
        cvh = new CustomViewHolder();
        convertView = LayoutInflater.from(Combined_Activity.this).inflate(R.layout.item_qq, null);
        cvh.imgLogo = (ImageView) convertView.findViewById(R.id.img_item_qq);
       //  cvh.txtName = (TextView) convertView.findViewById(R.id.txt_item_qq_title);
         cvh.txtContent = (TextView) convertView.findViewById(R.id.txt_item_qq_title);
        convertView.setTag(cvh);
        } else {
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
        return convertView;
        }

class CustomViewHolder {
    public ImageView imgLogo;
   // public TextView txtName;
    public TextView txtContent;

}

    };

@Override
public void onDragViewStart(int position) {
        mToast.setText("onDragViewStart   position--->" + position);
        mToast.show();
        Log.i(TAG, "onDragViewStart   " + position);
        startpos=position;
        }


public void onDragViewMoving(int position) {
//        Toast.makeText(DifferentActivity.this, "onDragViewMoving   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDragViewMoving   " + position);
        }


public void onDragViewDown(int position) {
        mToast.setText("onDragViewDown   position--->" + position);
        mToast.show();
        Log.i(TAG, "onDragViewDown   " + position);
        endos=position;

        //  Log.i(TAG, "startpos   " + startpos +"end pos"+endos);

        mToast.setText("startpos   " + startpos +"end pos"+endos);
        mToast.show();
        int listsize=mQQList.size();
        if(startpos>endos){
        for(int l=endos;l<startpos;l++) {
        // boolean insfg= db.updateroompos_whr_nameis(roomnamesdb[endos],""+(endos+1));
        boolean insfg= db.updateroompos_whr_nameis(roomnamesdb[l],""+(l+1));
        // new_pos_array[y]=
        }
        db.updateroompos_whr_nameis(roomnamesdb[startpos],""+(endos));
        }else{

        for(int l=startpos+1;l<=endos;l++) {
        boolean insfg= db.updateroompos_whr_nameis(roomnamesdb[l],""+(l-1));
        // new_pos_array[y]=
        }
        db.updateroompos_whr_nameis(roomnamesdb[startpos],""+(endos));
        }


        }


public void onSlideOpen(View view, View parentView, int position, int direction) {
        mToast.setText("onSlideOpen   position--->" + position + "  direction--->" + direction);
        mToast.show();
        Log.i(TAG, "onSlideOpen   " + position);
        }


public void onSlideClose(View view, View parentView, int position, int direction) {
        mToast.setText("onSlideClose   position--->" + position + "  direction--->" + direction);
        mToast.show();
        Log.i(TAG, "onSlideClose   " + position);
        }


public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        Log.i(TAG, "onMenuItemClick   " + itemPosition + "   " + buttonPosition + "   " + direction);
        int viewType = mAdapter.getItemViewType(itemPosition);
        switch (viewType) {
        case 0:
        return clickMenuBtn0(buttonPosition, direction);
        case 1:
        return clickMenuBtn1(buttonPosition, direction);
default:
        return Menu.ITEM_NOTHING;
        }
        }

private int clickMenuBtn0(int buttonPosition, int direction) {
        switch (direction) {
        case MenuItem.DIRECTION_LEFT:
        switch (buttonPosition) {
        case 0:
        return Menu.ITEM_SCROLL_BACK;
        }
        break;
        case MenuItem.DIRECTION_RIGHT:
        switch (buttonPosition) {
        case 0:
        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
        case 1:
        return Menu.ITEM_NOTHING;
        case 2:
        return Menu.ITEM_SCROLL_BACK;
        }
        }
        return Menu.ITEM_NOTHING;
        }

private int clickMenuBtn1(int buttonPosition, int direction) {
        switch (direction) {
        case MenuItem.DIRECTION_LEFT:
        switch (buttonPosition) {
        case 0:
        return Menu.ITEM_SCROLL_BACK;
        }
        break;
        case MenuItem.DIRECTION_RIGHT:
        switch (buttonPosition) {
        case 0:
        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
        case 1:
        return Menu.ITEM_SCROLL_BACK;
        }
        }
        return Menu.ITEM_NOTHING;
        }


public void onItemDeleteAnimationFinished(View view, int position) {
        mQQList.remove(position - mListView.getHeaderViewsCount());
        mAdapter.notifyDataSetChanged();
        }


public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //mListView.getId()
        mToast.setText("onItemClick   position--->" + position);
        mToast.show();
        Log.i(TAG, "onItemClick   " + position);

      /*  if(ListviewAdapter.txt.getText().toString()=="Entrance")
        {
                String index="Entrance";
                gridView.setAdapter(new ImageAdapter(Combined_Activity.this,index));
        }
        else   if(ListviewAdapter.txt.getText().toString()=="Conference")
        {
                String index="Conference";
                gridView.setAdapter(new ImageAdapter(Combined_Activity.this,index));
        }
        else   if(ListviewAdapter.txt.getText().toString()=="Reception")
        {
                String index="Reception";
                gridView.setAdapter(new ImageAdapter(Combined_Activity.this,index));
        }
        else   if(ListviewAdapter.txt.getText().toString()=="Bedroom")
        {
                String index="Bedroom";
                gridView.setAdapter(new ImageAdapter(Combined_Activity.this,index));
        }
        else   if(ListviewAdapter.txt.getText().toString()=="Diningroom")
        {
                String index="Diningroom";
                gridView.setAdapter(new ImageAdapter(Combined_Activity.this,index));
        }

*/




        }


public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mToast.setText("onItemLongClick   position--->" + position);
        mToast.show();
        Log.i(TAG, "onItemLongClick   " + position);


        return false;
        }





     /* public void pullout() {

      //  db.open();

        File f = new File("/data/data/" + this.getPackageName() + "/databases/" + "sample" + ".db");
       FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(f);
            fout = new FileOutputStream(Environment.getExternalStorageDirectory() + "/" + "sowmya.db");
            int i = 0;
            while ((i = fin.read()) != -1) {
                fout.write(i);
            }

           fout.flush();
            Toast.makeText(this.getApplicationContext(), "dump created!!", Toast.LENGTH_LONG).show();
             db.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.getApplicationContext(), "exception occurs in creating dump!!", Toast.LENGTH_LONG)
                    .show();}

    }
*/

///////////////////////////////////////////////////////////////////
public void startZoomOutAnimation(LinearLayout linear) {
        Animation zoomOutAnimation = AnimationUtils.loadAnimation(Combined_Activity.this, R.anim.zoom_out_animation);
        linear.startAnimation(zoomOutAnimation);
        }


public void startZoominAnimation(LinearLayout linear) {

        Animation zoomOutAnimation = AnimationUtils.loadAnimation(Combined_Activity.this, R.anim.zoom_in_animation);
        linear.startAnimation(zoomOutAnimation);

        }
//////////////////////////////////////////////////
}
