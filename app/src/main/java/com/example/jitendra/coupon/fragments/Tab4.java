package com.example.jitendra.coupon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jitendra.coupon.R;


public class Tab4 extends Fragment {
    public static final String EXTRA_MESSAGE = "This is Tab 4";

    View v;

    public Tab4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            //String message = getArguments().getString(EXTRA_MESSAGE);
            v = inflater.inflate(R.layout.tab1, container, false);
            TextView messageTextView = (TextView) v.findViewById(R.id.textView);
            messageTextView.setText(EXTRA_MESSAGE);

        return v;
    }

}