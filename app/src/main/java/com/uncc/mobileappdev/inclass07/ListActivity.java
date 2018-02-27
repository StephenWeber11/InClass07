package com.uncc.mobileappdev.inclass07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    protected static final String INTENT_KEY = "INTENT";
    private static final ArrayList<String> CATEGORIES = new ArrayList<>();

    static{
        CATEGORIES.add("Business");
        CATEGORIES.add("Entertainment");
        CATEGORIES.add("General");
        CATEGORIES.add("Health");
        CATEGORIES.add("Science");
        CATEGORIES.add("Sports");
        CATEGORIES.add("Technology");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);
        setTitle("Categories");

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        android.R.id.text1, CATEGORIES);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, ArticleSelectorActivity.class);
                intent.putExtra(INTENT_KEY, CATEGORIES.get(position));
                ListActivity.this.startActivity(intent);
            }
        });

    }
}
