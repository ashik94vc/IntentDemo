package com.ashikvetrivelu.ashik4areceiving;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Uri> arrayList;
        TextView textView = (TextView) findViewById(R.id.text);
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type!=null){
                textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
                textView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.GONE);
        }
        else if(Intent.ACTION_SEND_MULTIPLE.equals(action) && type!=null){
            arrayList = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            ImageAdapter imageAdapter = new ImageAdapter(arrayList, this);
            gridView.setAdapter(imageAdapter);
            gridView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
    }

}
