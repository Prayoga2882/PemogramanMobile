package com.example.listviewpresiden;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Item List");

        title = new String[]{"Soekarno", "Soeharto", "Bachruddin Jusuf Habibie", "Abdurrahman Wahid", "Megawati Soekarnoputri", "Susilo Bambang Yudhoyono", "Joko Widodo"};
        description = new String[]{"Presiden Pertama", "Presiden Kedua", "Presiden Ketiga", "Presiden Keempat", "Presiden Kelima", "Presiden Keenam", "Presiden KeTujuh"};
        icon = new int[]{R.drawable.satu, R.drawable.dua, R.drawable.tiga, R.drawable.empat, R.drawable.lima, R.drawable.enam, R.drawable.tujuh};

        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i]);
            arrayList.add(model);
        }

        adapter = new ListViewAdapter(this, arrayList);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_setting){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
