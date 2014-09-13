package com.hansonsoftware.minecraftify;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;


public class BuildThisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_build_this);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.bringToFront();

        String web[] = {
                "Bedrock",
                "Birch Wood Planks",
                "Black Wool",
                "Blue Wool",
                "Bricks",
                "Brown Wool",
                "Clay Block",
                "Cyan Wool",
                "Dark Gray Wool"
        };

        Integer imageId[] = {
                R.drawable.bedrock,
                R.drawable.birchwoodplanks,
                R.drawable.blackwool,
                R.drawable.bluewool,
                R.drawable.bricks,
                R.drawable.brownwool,
                R.drawable.clayblock,
                R.drawable.cyanwool,
                R.drawable.darkgraywool
        };

        CustomListAdapter adapter = new CustomListAdapter(BuildThisActivity.this, web, imageId);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.build_this, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
