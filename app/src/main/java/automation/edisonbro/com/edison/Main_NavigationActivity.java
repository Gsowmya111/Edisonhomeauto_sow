package automation.edisonbro.com.edison;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.Drawable;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.NavigationView;
        import android.support.design.widget.Snackbar;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.ActionBarDrawerToggle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.PopupMenu;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.Menu;

        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

       /* import com.bumptech.glide.Glide;
        import com.bumptech.glide.load.engine.DiskCacheStrategy;*/

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

import automation.edisonbro.com.edison.SwitchBoardFragment;
      /*  import info.androidhive.navigationdrawer.R;
          import info.androidhive.navigationdrawer.fragment.MoviesFragment;
        import info.androidhive.navigationdrawer.fragment.NotificationsFragment;
        import info.androidhive.navigationdrawer.fragment.PhotosFragment;
        import info.androidhive.navigationdrawer.fragment.PrivacyFragment;
        import info.androidhive.navigationdrawer.fragment.SettingsFragment;
        import info.androidhive.navigationdrawer.other.CircleTransform;*/
        import android.widget.AdapterView.OnItemSelectedListener;

public class Main_NavigationActivity extends AppCompatActivity implements OnItemSelectedListener {

    TextView tv9;
    Button button_back,button_pop;
    MenuItem mt;
    PopupMenu popupMenu;
    private String TAG = Main_NavigationActivity.class.getSimpleName();
    private ListView lv;
    ArrayList<HashMap<String, String>> contactList;
    String[] myStringArray;

    int op2;

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private Button nav_back_btn;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    // urls to load navigation header background image
    // and profile image

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "effe";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main__navigation);

        // Spinner element
      /*  Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("select ");
        categories.add("Event 1");
        categories.add("Event 2");
        categories.add("Event 3");
        categories.add("Event 4");
        categories.add("Event 5");
        categories.add("Event 6");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories)
        {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);*/



        mt=(MenuItem) findViewById(R.id.nav_privacy_policy);

      /*  button_back = (Button) findViewById(R.id.button2);

        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //  PopupMenu popupMenu = new PopupMenu(MainActivity.this, button_back);
                //View menuItemView = getView().findViewById(R.id.menu_popup);
                //  popupMenu.inflate(R.menu.color_menu);
                //  popupMenu.show();

                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawers();
                    return;
                }

            }
        });*/

        button_pop = (Button) findViewById(R.id.button3);

        button_pop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                PopupMenu popupMenu = new PopupMenu(Main_NavigationActivity.this, button_back);
                //View menuItemView = getView().findViewById(R.id.menu_popup);
                popupMenu.inflate(R.menu.color_menu);
                popupMenu.show();



            }
        });



//tv9=(TextView) findViewById(R.id.textView2);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //  View menuItemView1 = getView().findViewById(R.id.menu_popup);

        //  popupMenu = new PopupMenu(MainActivity.this, findViewById(R.id.nav_privacy_policy));


        Menu menu = navigationView.getMenu();


         myStringArray = new String[]{"home 1", "Edison", "Hubli", "home 4", "home 5"};

        int sizearr=myStringArray.length,i,j=100,k=100,L=101,sizearr1;
        for(i=0;i<sizearr;i++)
        {

            menu.add(R.id.second_group, i, j+i, myStringArray[i]).setIcon(R.mipmap.home);
            menu.setGroupCheckable(R.id.second_group, true, true);
            menu.setGroupVisible(R.id.second_group, true);
        }


     /*   menu.add("new")
                .setIcon(R.drawable.icon_1)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
                .setId(R.id.newone);*/


    /*    Menu menu2 = navigationView.getMenu();

     String[] myStringArray1 ={"Others","About","Settings"};

        sizearr1=myStringArray1.length;
        for(j=0;j<sizearr1;j++)
        {

            menu2.add(R.id.second_group, L, L+k, myStringArray1[j]);
            menu2.setGroupCheckable(R.id.third_group, true, true);
            menu2.setGroupVisible(R.id.third_group, true);
            L++;
        }*/



      /*  // Add items to the second group, and set to visible
        menu.add(R.id.second_group, 1, 100, "Item 1");
        menu.add(R.id.second_group, 2, 200, "Item 2");
        menu.add(R.id.second_group, 3, 300, "Item 3");
        menu.setGroupCheckable(R.id.second_group, true, true);
        menu.setGroupVisible(R.id.second_group, true);*/



        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);
        nav_back_btn=(Button ) navHeader.findViewById(R.id.nav_back);


nav_back_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
    }
});
// load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();



        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }



    private void loadNavHeader() {
        // name, website
        //   txtName.setText("Ravi Tamada");
        //  txtWebsite.setText("www.androidhive.info");

        // loading header background image
        // imgNavHeaderBg.setBackgroundColor(Color.rgb(0,0,0));

        Drawable myDrawable = getResources().getDrawable(R.mipmap.eb_image);
        imgNavHeaderBg.setImageDrawable(myDrawable);
       // imgProfile.setVisibility(View.INVISIBLE);
        //imgNavHeaderBg.setBackground("");
     /*   Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);*/

        // Loading profile image
       /* Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);*/

        // showing dot next to notifications label
        //  navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }


    private void loadHomeFragment2() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment2() {

        switch (navItemIndex) {
            case 0:
                // home
                CombinedFragment homeFragment = new CombinedFragment();
                return homeFragment;


          /*  case 1:
                // photos
                PhotosFragment photosFragment = new PhotosFragment();
                return photosFragment;
            case 2:
                // movies fragment
                MoviesFragment moviesFragment = new MoviesFragment();
                return moviesFragment;
            case 3:
                // notifications fragment
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                return notificationsFragment;

            case 4:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            case 5:
                PrivacyFragment privacyFragment = new PrivacyFragment();
                return privacyFragment;*/

            default:
                return new SwitchBoardFragment();
        }
    }



    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {

        switch (navItemIndex) {
            case 0:
                // home
                CombinedFragment homeFragment = new CombinedFragment();
                return homeFragment;


          /*  case 1:
                // photos
                PhotosFragment photosFragment = new PhotosFragment();
                return photosFragment;
            case 2:
                // movies fragment
                MoviesFragment moviesFragment = new MoviesFragment();
                return moviesFragment;
            case 3:
                // notifications fragment
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                return notificationsFragment;

            case 4:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            case 5:
                PrivacyFragment privacyFragment = new PrivacyFragment();
                return privacyFragment;*/

            default:
                return new SwitchBoardFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(myStringArray[op2]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //tv9.setText(Integer.toString(menuItem.getItemId()));
                String opt=Integer.toString(menuItem.getItemId());

                //navItemIndex=menuItem.getItemId();
                //   CURRENT_TAG = TAG_HOME;

                //  tv9.setText("int== "+navItemIndex);


                if(menuItem.getItemId() == R.id.nav_privacy_policy)
                {

                    PopupMenu popupMenu = new PopupMenu(Main_NavigationActivity.this, button_pop);
                    //View menuItemView = getView().findViewById(R.id.menu_popup);
                    popupMenu.inflate(R.menu.color_menu);
                    popupMenu.show();
                    // final PopupMenu popupMenu = new PopupMenu(this,menu);
                    //   MenuItem  mt= (MenuItem) findViewById(R.id.nav_privacy_policy);
                    // View menuItemView = findViewById(R.id.nav_privacy_policy);
                    //PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuItemView);
                    //View menuItemView = getView().findViewById(R.id.menu_popup);
                    // popupMenu.inflate(R.menu.color_menu);
                    // popupMenu.show();
                    //   PopupMenu popupMenu = new PopupMenu(this,findViewById(R.id.nav_privacy_policy));
                    //   startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                    //  drawer.closeDrawers();
                    return true;
                }
                else {
                    int opt1 = menuItem.getItemId();
                      op2=opt1;
                    //navItemIndex = opt1;
                    navItemIndex = 0;
                    CURRENT_TAG = "fragment" + op2;
/*
                    // selecting appropriate nav menu item
                    selectNavMenu();

                    // set toolbar title
                    setToolbarTitle();

                    switch (0) {
                        //Replacing the main content with ContentFragment Which is our Inbox View;
                        case 0:
                            navItemIndex = 0;
                            //  CURRENT_TAG = TAG_HOME;
                            startActivity(new Intent(Main_NavigationActivity.this, Combined_Activity.class));
                            break;
                        default:
                            navItemIndex = 0;
                            CURRENT_TAG = "fragment" + op2;
                    }*/
                }

            /*    switch (opt1) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case 0:
                        navItemIndex = 0;
                      //  CURRENT_TAG = TAG_HOME;
                        break;
                    case 1:
                        navItemIndex = 1;
                        CURRENT_TAG = "gjjhg";
                        break;
                    case 2:
                        navItemIndex = menuItem.getItemId();
                       // CURRENT_TAG = TAG_MOVIES;
                        break;
                    case 3:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_NOTIFICATIONS;
                        break;
                    case 4:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case 5:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        drawer.closeDrawers();
                        return true;


                    default:
                        navItemIndex = opt1;
                        CURRENT_TAG = "frag"+opt1;
                } */














               /* //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_photos:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_PHOTOS;
                        break;
                    case R.id.nav_movies:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_MOVIES;
                        break;
                    case R.id.nav_notifications:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_NOTIFICATIONS;
                        break;
                    case R.id.nav_settings:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case R.id.second_group:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_privacy_policy:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                        drawer.closeDrawers();
                        return true;

                    default:
                        navItemIndex = 0;
                }*/

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                // navItemIndex=menuItem.getItemId();
                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_about_us, R.string.privacy_policy) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    // show or hide the fab
    private void toggleFab() {
        if (navItemIndex == 0)
            fab.show();
        else
            fab.hide();
    }




    //for spinner

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
