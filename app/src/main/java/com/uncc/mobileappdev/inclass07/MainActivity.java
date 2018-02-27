package com.uncc.mobileappdev.inclass07;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String selectedCategory;
    private int currentIndex = 0;
    private ArrayList<Articles> articles = new ArrayList<>();
    EditText searchBar;
    TextView counter;
    TextView title;
    TextView date;
    TextView description;
    ImageView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Article");

        title = findViewById(R.id.article_title);
        date = findViewById(R.id.article_date);
        description = findViewById(R.id.desc_text);
        main = findViewById(R.id.article_image);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Articles article = (Articles) bundle.getSerializable(ArticleSelectorActivity.INTENT_ARTICLE);

        title.setText(article.getTitle());
        date.setText(article.getPublishedAtDate());
        description.setText(article.getDescription());
        Picasso.with(this).load(article.getUrlToImage()).into(main);

    }



}
