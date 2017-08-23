package de.piobyte.dressler.heimautomatisierung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.piobyte.dressler.heimautomatisierung.R;
import de.piobyte.dressler.heimautomatisierung.adapter.MainGridViewAdapter;
import de.piobyte.dressler.heimautomatisierung.model.hAGroup;

public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    TextView topFieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        topFieldView = (TextView)findViewById(R.id.topField);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view_groups);
        recyclerView.setHasFixedSize(true);

        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        List<hAGroup> entryList = getListItemData();

        MainGridViewAdapter rcAdapter = new MainGridViewAdapter(MainActivity.this, entryList);
        recyclerView.setAdapter(rcAdapter);
    }

    public void onClickTopField(View v) {
        Intent intent = new Intent(this, ModiActivity.class);
        startActivity(intent);

         topFieldView.setText("Modi");
        topFieldView.setBackgroundColor(256);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<hAGroup> getListItemData(){
        List<hAGroup> listViewItems = new ArrayList<hAGroup>();
        listViewItems.add(new hAGroup("4 aktive Geräte", R.drawable.one, "Wohnzimmer"));
        listViewItems.add(new hAGroup("3 aktive Geräte", R.drawable.two, "Schlafzimmer"));
        listViewItems.add(new hAGroup("12 aktive Geräte", R.drawable.three, "Keller"));
        listViewItems.add(new hAGroup("567 aktive Geräte", R.drawable.one, "Küche"));
        listViewItems.add(new hAGroup("0 aktive Geräte", R.drawable.one, "Dachboden"));
        listViewItems.add(new hAGroup("2 aktive Geräte", R.drawable.two, "Garage"));
        listViewItems.add(new hAGroup("4 aktive Geräte", R.drawable.one, "Wohnzimmer"));
        listViewItems.add(new hAGroup("3 aktive Geräte", R.drawable.two, "Schlafzimmer"));
        listViewItems.add(new hAGroup("12 aktive Geräte", R.drawable.three, "Keller"));
        listViewItems.add(new hAGroup("567 aktive Geräte", R.drawable.one, "Küche"));
        listViewItems.add(new hAGroup("0 aktive Geräte", R.drawable.one, "Dachboden"));
        listViewItems.add(new hAGroup("2 aktive Geräte", R.drawable.two, "Garage"));

        return listViewItems;
    }

}