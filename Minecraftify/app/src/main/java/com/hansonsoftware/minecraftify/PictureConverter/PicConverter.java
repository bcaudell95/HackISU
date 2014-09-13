package com.hansonsoftware.minecraftify.PictureConverter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.hansonsoftware.minecraftify.Blocks.BlockBitmap;
import com.hansonsoftware.minecraftify.R;

import java.io.InputStream;

/**
 * Created by Brandon Caudell on 9/13/2014.
 */
public class PicConverter {

    public static BlockBitmap testConverter(InputStream stream) {
        BlockBitmap result = convertBitmapToBlocks(stream);
        return result;
    }

    public static BlockBitmap convertBitmapToBlocks(InputStream stream) {

        BlockBitmap blockBitmap = new BlockBitmap(1080, 1920, 20);

        blockBitmap.buildBlocksFromImage(stream);

        return  blockBitmap;
    }
}
