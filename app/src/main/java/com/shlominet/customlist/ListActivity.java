package com.shlominet.customlist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shlominet.customAdapter.CustomAdapter;
import com.shlominet.customAdapter.CustomObject;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private static final int REQ_CODE = 123;

    private ListView listView;
    private Button button;

    private ArrayList<CustomObject> arrayList;
    private CustomAdapter customAdapter;
    private int[] imgID;
    private int selectedImgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        imgID = new int[10];
        for(int i=0; i<10; i++) {
            imgID[i] = getResources().getIdentifier("draw_"+i, "drawable", getPackageName());
        }
        arrayList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            arrayList.add(new CustomObject(
                    imgID[i],
                    "book name "+i,
                    "book writer "+i,
                    new Random().nextInt(200)));
        }
        customAdapter = new CustomAdapter(this, arrayList);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int index = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Delete");
                builder.setMessage("delete this item??");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                remove(index);
                            }
                        });
                builder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // code to run when Cancel is pressed
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
//                CustomObject object = (CustomObject)customAdapter.getItem(i);
//                selectedImgID = object.getImgID();
//                Toast.makeText(ListActivity.this, ""+selectedImgID, Toast.LENGTH_SHORT).show();
            }
        });

        button = findViewById(R.id.go_to_activity_btn);
    }

    private void remove(int index) {
        arrayList.remove(index);
        customAdapter.notifyDataSetChanged();
    }

    public void goToNewActivityClick(View view) {
        Intent intent = new Intent(this, AddNewActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            // came back from AddNewActivity
            String bName = data.getStringExtra("bookName");
            String bWriter = data.getStringExtra("bookWriter");
            String bPrice = data.getStringExtra("bookPrice");
            int bImage = data.getIntExtra("bookImage", R.drawable.draw_0);

            arrayList.add(new CustomObject(bImage, bName, bWriter, Integer.parseInt(bPrice)));
            customAdapter.notifyDataSetChanged();
//            Toast.makeText(this, "Got back: " + bName+bWriter+bPrice+bImage,
//                    Toast.LENGTH_LONG).show();
        }
    }
}
