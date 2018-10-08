package com.example.lzw.zhoukao1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lzw.zhoukao1.R;
import com.example.lzw.zhoukao1.WaterView;

public class ThreeFragment extends Fragment {

    private ImageView img;
    private WaterView water;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_three, container, false);
        img=(ImageView)view.findViewById(R.id.img);
        water=(WaterView)view.findViewById(R.id.water);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) img.getLayoutParams();
        water.result(new WaterView.AnimationListener() {
            @Override
            public void animation(float y) {
                params.setMargins(0,0,0, (int) y);
                img.setLayoutParams(params);
            }

        });

    }
}
