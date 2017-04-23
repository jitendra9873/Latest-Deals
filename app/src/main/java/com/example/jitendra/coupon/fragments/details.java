package com.example.jitendra.coupon.fragments;

/**
 * Created by jitendra on 20/4/17.
 */

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.coupon.R;


public class details extends AppCompatActivity {



    contents mcontents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getActionBar();
        try {
            actionBar.setDisplayHomeAsUpEnabled(true);

        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        initCollapsingToolbar();
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            mcontents = b.getParcelable("data");
        ImageView mimage=(ImageView)findViewById(R.id.imageofsite);
        TextView mdesc=(TextView)findViewById(R.id.descofsite);
        TextView mname=(TextView)findViewById(R.id.nameofsite);
        TextView mcode=(TextView)findViewById(R.id.codeofsite);

        Button mlink=(Button) findViewById(R.id.linkofsite);
        mimage.setImageResource(mcontents.getThumbnail());
        mdesc.setText(mcontents.getDesc());
        mname.setText(mcontents.getName());
        mcode.setText("COUPONCODE: "+mcontents.getCode());
        mlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mcontents.getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



/*        Intent intent = getIntent();
        mcontents =intent.getParcelableArrayListExtra("data");
        TextView my=(TextView)findViewById(R.id.desc);
        my.setText(mcontents.);*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar1);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar1);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}



