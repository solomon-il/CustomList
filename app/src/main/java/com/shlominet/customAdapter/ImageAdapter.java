package com.shlominet.customAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.shlominet.customlist.R;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Integer> arrayList;

    public ImageAdapter(Context context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.spinner_item, null);

        ImageView imageView = view.findViewById(R.id.image_spinner_item);
        imageView.setImageResource(arrayList.get(i));

        return view;
    }


}
