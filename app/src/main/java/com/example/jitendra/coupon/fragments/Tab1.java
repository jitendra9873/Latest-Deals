package com.example.jitendra.coupon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.jitendra.coupon.R;

import java.util.HashMap;


public class Tab1 extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    View v;
    private SliderLayout mDemoSlider;

    public Tab1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.tab1, container, false);
        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        /*url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");*/


        url_maps.put("Flipkart", "https://scontent.fnag1-1.fna.fbcdn.net/v/t1.0-0/s480x480/13615070_590532061107022_2893251283063195212_n.jpg?oh=00387e68b544ae9cad9077e4b36f3414&oe=59828EC8");
        url_maps.put("Paytm", "http://i1.wp.com/www.dealnloot.com/wp-content/uploads/2017/03/paytm-get-mobile-recharge-of-Rs-1200-in-just-Rs-300-loot.png?resize=300%2C176");
        url_maps.put("CouponBaazar", "https://scontent.fnag1-1.fna.fbcdn.net/v/t1.0-9/17991968_729976363829257_5570040467870322591_n.png?oh=69208857f16ff265cdd22514d7e3559a&oe=5988E0C1");
        url_maps.put("Beauty products", "http://i2.wp.com/www.dealnloot.com/wp-content/uploads/2017/04/beauty-products.jpg?resize=300%2C278");


/*        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);*/

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        ListView l = (ListView) v.findViewById(R.id.transformers);
        l.setAdapter(new com.example.jitendra.coupon.TransformerAdapter(this.getContext()));
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
                //Toast.makeText(Tab1.this), ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this.getContext(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

/*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_custom_indicator:
                mDemoSlider.setCustomIndicator((PagerIndicator) v.findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                mDemoSlider.setCustomAnimation(new com.example.jitendra.coupon.ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;
            case R.id.action_github:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


}


