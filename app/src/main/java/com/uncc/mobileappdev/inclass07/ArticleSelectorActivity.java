package com.uncc.mobileappdev.inclass07;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleSelectorActivity extends AppCompatActivity implements AsyncData.IData{

    ListView listView;
    public static final String INTENT_ARTICLE = "Articles";
    public static final String INTENT_BUNDLE = "Bundle";
    ArrayList<Articles> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);

        Intent intent = getIntent();
        String category = intent.getStringExtra(ListActivity.INTENT_KEY);

        setTitle(category);
        String queryParam = "&category=" + category;
        new AsyncData(ArticleSelectorActivity.this,ArticleSelectorActivity.this).execute("https://newsapi.org/v2/top-headlines?country=us&apiKey=ebb2dacd7f314b5fa3300c914e144121" + queryParam);


        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ArticleSelectorActivity.this, MainActivity.class);
                Articles article = result.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable(INTENT_ARTICLE, article);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                        && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            Toast toast = Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    @Override
    public void setupData(ArrayList<Articles> result) {
        ArticleListingArrayAdapter adapter = new ArticleListingArrayAdapter(this, R.layout.activity_article_selector, result);
        listView.setAdapter(adapter);

        this.result = result;
    }
}
