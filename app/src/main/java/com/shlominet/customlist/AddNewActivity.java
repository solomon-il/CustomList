package com.shlominet.customlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.shlominet.customAdapter.ImageAdapter;

import java.util.ArrayList;

public class AddNewActivity extends AppCompatActivity {

    private EditText bookNameET, bookWriterET, bookPriceET;
    private Spinner bookImageSpinner;

    private ArrayList<Integer> arrayList;
    private ImageAdapter imageAdapter;

    private int[] imgID;
    private int selectedImgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        imgID = new int[10];
        for(int i=0; i<10; i++) {
            imgID[i] = getResources().getIdentifier("draw_"+i, "drawable", getPackageName());
        }
        arrayList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            arrayList.add(imgID[i]);
        }
        imageAdapter = new ImageAdapter(this, arrayList);
        bookImageSpinner = findViewById(R.id.book_image_spinner);
        bookImageSpinner.setAdapter(imageAdapter);

        bookNameET = findViewById(R.id.book_name_et);
        bookWriterET = findViewById(R.id.book_writer_et);
        bookPriceET = findViewById(R.id.book_price_et);

        bookImageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedImgID = (Integer)imageAdapter.getItem(i);
                //ImageView selectedImg = adapterView.getChildAt(i).findViewById(R.id.image_spinner_item);
                //selectedImgID = selectedImg.getId();
                Toast.makeText(AddNewActivity.this, ""+selectedImgID, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    public void addNewBookClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("bookName", bookNameET.getText().toString());
        intent.putExtra("bookWriter", bookWriterET.getText().toString());
        intent.putExtra("bookPrice", bookPriceET.getText().toString());
        intent.putExtra("bookImage", selectedImgID);
        setResult(RESULT_OK, intent);
        finish();
    }
}
