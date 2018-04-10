package com.shlominet.customAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shlominet.customlist.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<CustomObject> arrayList;

    public CustomAdapter(Context context, ArrayList<CustomObject> arrayList) {
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
        view = inflater.inflate(R.layout.list_item, null);

        ImageView bookImage = view.findViewById(R.id.image_list_item);
        TextView bookName = view.findViewById(R.id.book_name_list_item);
        TextView bookWriter = view.findViewById(R.id.book_writer_list_item);
        TextView bookPrice = view.findViewById(R.id.book_price_list_item);

        bookImage.setImageResource(arrayList.get(i).getImgID());
        bookName.setText(arrayList.get(i).getBookName());
        bookWriter.setText(arrayList.get(i).getBookWriter());
        bookPrice.setText("price: " + arrayList.get(i).getPrice() + '$');

        return view;
    }
}
