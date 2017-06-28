package com.itheima.android50.activity;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.TextView;

import com.itheima.android50.R;


public class ScrollingActivity extends AppCompatActivity {

    Toolbar toolbar;
    private boolean show = true;
    FloatingActionButton fab;
    MAA aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setContentView(R.layout.activity_scrolling);
        Log.d("wang","nihaoaaa  aaaaa========================");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarLayout a = (AppBarLayout) findViewById(R.id.app_bar);
        aa = (MAA) findViewById(R.id.aa);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            aa.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.d("wang", "CoordinatorLayout");
                }
            });
        } else {

        }

        a.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("wang","onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("wang","onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("wang","onAnimationRepeat");
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                    Log.d("wang", "toolbar=========");
                }
            });
            a.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.d("wang", "appbar=========");
                    View v1 = toolbar.getMenu().findItem(R.id.action_settings1).setVisible(true).getActionView();
                    Animator animator = ViewAnimationUtils.createCircularReveal(
                            v1,
                            v1.getWidth() / 2,
                            v1.getHeight() / 2,
                            0,
                            v1.getWidth()
                    );
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.setDuration(2000);
                    animator.start();
                }
            });
        }
        Menu menu = toolbar.getMenu();
        NestedScrollView nest = (NestedScrollView) findViewById(R.id.scorr);

        nest.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if(show) {
                Log.d("wang","NestedScrollView=========");
                    show = false;

                }
//            }
        });

//        toolbar.setNavigationIcon();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            fab.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.d("wang", "fab onScrollChange");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        TextView a = new TextView(this);
        a.setBackgroundColor(Color.RED);
        a.setText("hahah");
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("wang","text click");
//                View v1 = toolbar.getMenu().findItem(R.id.action_settings1).getActionView();
//                Animator animator = ViewAnimationUtils.createCircularReveal(
//                        v1,
//                        v1.getWidth()/2,
//                        v1.getHeight()/2,
//                        0,
//                        v1.getWidth()
//                        );
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.setDuration(2000);
//                animator.start();
//                toolbar.getMenu().findItem(R.id.action_settings1).getActionView().animate();
            }
        });
        menu.findItem(R.id.action_settings1).setActionView(a);
        menu.findItem(R.id.action_settings1).setVisible(false);
        MenuItem m = menu.findItem(R.id.action_settings1);
        aa.setAniView(fab,m);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.findItem(R.id.action_settings1).collapseActionView();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("wang","nihaoaaa");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_settings1){
            Log.d("wang","nihao");
            item.setVisible(false);
        }
        return super.onOptionsItemSelected(item);
    }
}
