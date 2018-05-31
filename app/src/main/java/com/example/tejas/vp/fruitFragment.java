package com.example.tejas.vp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fruitFragment extends Fragment {

    TextView mTV;
    public static fruitFragment newInstance(String fruit) {

        Bundle args = new Bundle();
        args.putSerializable("Name",fruit);
        fruitFragment fragment = new fruitFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fruitfragment, container, false);
        mTV = v.findViewById(R.id.nametv);
        String fruit = getArguments().getSerializable("Name").toString();
        mTV.setText(fruit);
        return v;
    }
    }
