package com.example.jitendra.coupon.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jitendra.coupon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitendra on 19/4/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    private List<contents> contentslist = new ArrayList<>();
    private String description[] = {
            "Get flat 25% off on all purchases and 10% additional cashback when u pay via Amazon pay balance.This offer is valid for all users.",
            "Get 15% off on all electronic items purchased during the offer period.Best offers on laptops and smartphones.",
            "10 % off on all lifestyle products.Use freecharge as payment option for additional 5% cashback",
            "Get flat 25% on any medium sized pizza.Also get 50% off for new users. ",
            "Get 100% cashback upto Rs 75 on any purchase made through freecharge.Choose freecharge as payment option while checkout.",
            "Get Rs 50 cashback on recharge of Rs 100 or more.Valid for only new users.",
            "Get Rs 30 cashback on your first transaction on paytm.Use coupon when checkout",
            "Get Rs 50 off on your first ride on Ola.Use coupon when checkout",
            "Get Rs 25 cashback on your next ride on paytm.Valid for all users.Use coupon when checkout",
            "Get flat Rs 100 cashback on your first movie ticket on bookmyshow.Use code at checkout."

    };
    private String codes[] = {"NEWUSER", "BUMPER", "FLASH", "LAST10", "FIRST100", "MAY100", "OFFER", "FULL50", "LUCK", "WIN100"};
    private String urls[] = {
            "http://www.amazon.in/",
            "https://www.flipkart.com",
            "https://www.snapdeal.com/",
            "https://pizzaonline.dominos.co.in/",
            "http://www.mcdonaldsindia.com/", "https://www.freecharge.in/",
            "https://paytm.com/",
            "https://www.olacabs.com/",
            "https://www.uber.com/en-IN/",
            "https://in.bookmyshow.com/"

    };


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        getting_data();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + "% discount");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contents c=contentslist.get(position);
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("data", c);
                i.putExtras(b);
                i.setClass(mContext, details.class);
                mContext.startActivity(i);

                /*Intent i = new Intent(mContext, details.class);
                i.putExtra("data",contentslist.get(position));
                mContext.startActivity(i);*/
            }
        });

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public void getting_data() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
        };

        contents a = new contents("Amazon", description[0], codes[0], covers[5], urls[0]);
        contentslist.add(a);

        a = new contents("Flipkart", description[1], codes[1], covers[6], urls[1]);
        contentslist.add(a);

        a = new contents("Snapdeal", description[2], codes[2], covers[7], urls[2]);
        contentslist.add(a);

        a = new contents("Dominous", description[3], codes[3], covers[8], urls[3]);
        contentslist.add(a);

        a = new contents("McDonald's", description[4], codes[4], covers[9], urls[4]);
        contentslist.add(a);

        a = new contents("Freecharge", description[5], codes[5], covers[0], urls[5]);
        contentslist.add(a);

        a = new contents("Paytm", description[6], codes[6], covers[1], urls[6]);
        contentslist.add(a);

        a = new contents("Ola", description[7], codes[7], covers[2], urls[7]);
        contentslist.add(a);

        a = new contents("Uber", description[8], codes[8], covers[3], urls[8]);
        contentslist.add(a);

        a = new contents("BookMyShow", description[9], codes[9], covers[4], urls[9]);
        contentslist.add(a);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
/*            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, details.class );
                    i.putParcelableArrayListExtra("data", contentslist);
                    mContext.startActivity(i);
                }
            });*/

        }
    }


    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Open", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Save Coupon", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
