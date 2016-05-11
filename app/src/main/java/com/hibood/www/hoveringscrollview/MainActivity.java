package com.hibood.www.hoveringscrollview;

/**
 * Created by WangCan on 2016/5/11.
 * Email：306217025@qq.com
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements
        HoveringScrollview.OnScrollListener {

    private HoveringScrollview hoveringScrollview;
    private int searchLayoutTop;

    LinearLayout hoveringLayout;
    LinearLayout search01, search02;
    RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        hoveringLayout = (LinearLayout) findViewById(R.id.hoveringLayout);
        hoveringScrollview = (HoveringScrollview) findViewById(R.id.hoveringScrollview);
        search01 = (LinearLayout) findViewById(R.id.search01);
        search02 = (LinearLayout) findViewById(R.id.search02);
        rlayout = (RelativeLayout) findViewById(R.id.rlayout);
        hoveringScrollview.setOnScrollListener(this);// set Listener

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub


        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = rlayout.getBottom();// 获取searchLayout的顶部位置

        }
    }

    @Override
    public void onScroll(int scrollY) {
        // TODO Auto-generated method stub


        if (scrollY >= searchLayoutTop) {
            if (hoveringLayout.getParent() != search01) {
                search02.removeView(hoveringLayout);
                search01.addView(hoveringLayout);
            }
        } else {
            if (hoveringLayout.getParent() != search02) {
                search01.removeView(hoveringLayout);
                search02.addView(hoveringLayout);
            }
        }
    }

    public void clickListenerMe(View view) {
        if (view.getId() == R.id.btnQiaBuy) {
            Toast.makeText(this, "抢购成功", Toast.LENGTH_SHORT).show();
        }
    }

}
