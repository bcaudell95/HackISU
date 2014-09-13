package com.hansonsoftware.minecraftify;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hansonsoftware.minecraftify.Blocks.Block;
import com.hansonsoftware.minecraftify.Blocks.BlockBitmap;
import com.hansonsoftware.minecraftify.Blocks.BlockBitmapNotBuiltException;
import com.hansonsoftware.minecraftify.PictureConverter.PicConverter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BlockBitmap blockBitmap = PicConverter.testConverter(getResources().openRawResource(R.raw.testphoto1));
        try {
            Bitmap gridOfTextures = blockBitmap.buildBlockGrid("res/drawable-mdpi/");
        } catch (BlockBitmapNotBuiltException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream out = new FileOutputStream("TEST_GRID.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void beginCameraActivity(View view) {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
    }
}
