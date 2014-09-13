package com.hansonsoftware.minecraftify.Camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Adam on 9/13/2014.
 */
public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback {
    private Camera theCamera;

    public ShowCamera(Context context) {
        super(context);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            theCamera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        theCamera.startPreview();
    }
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3){
    }
    public void surfaceDestroyed(SurfaceHolder arg0) {
    }
}
