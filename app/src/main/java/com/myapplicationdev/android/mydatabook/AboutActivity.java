package com.myapplicationdev.android.mydatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class AboutActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        iv = findViewById(R.id.iv);

        String url = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";

        AnimationDrawable ph = (AnimationDrawable) ContextCompat.getDrawable(AboutActivity.this, R.drawable.ajax_loader);
        ph.start();


        Glide.with(AboutActivity.this)
                .load(url)
                .apply(new RequestOptions().placeholder(ph).error(R.drawable.error))
                .into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.rp.edu.sg/"));
                startActivity(intent);

            }
        });

    }}