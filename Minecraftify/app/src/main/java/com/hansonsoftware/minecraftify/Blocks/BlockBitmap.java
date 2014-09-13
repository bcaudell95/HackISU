package com.hansonsoftware.minecraftify.Blocks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Color;
import android.graphics.Rect;

import com.hansonsoftware.minecraftify.Blocks.Block;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brandon Caudell on 9/13/2014.
 */
public class BlockBitmap {

    private Block[][] blocks;

    private int subdivisionWidth;
    private int imageWidth, imageHeight;
    private int columnCount, rowCount;
    private int lastColumnWidth, lastRowHeight;

    private Map<Block, Integer> blockCounter = new HashMap<Block, Integer>();

    private InputStream originalImageInputStream;

    public BlockBitmap(int imageWidth, int imageHeight, int subdivisionWidth) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.subdivisionWidth = subdivisionWidth;

        this.columnCount = (this.imageWidth / this.subdivisionWidth);
        this.rowCount = (this.imageHeight / this.subdivisionWidth);

        this.lastColumnWidth = this.imageWidth % this.subdivisionWidth;
        this.lastRowHeight = this.imageHeight % this.subdivisionWidth;

        if(lastColumnWidth!=0) this.columnCount++;
        if(lastRowHeight!=0) this.rowCount++;

        this.blocks = new Block[this.rowCount][this.columnCount];

        //initialize the counters for all blocks to zero
        for(Block b : Block.values()) {
            blockCounter.put(b, 0);
        }
    }

    public void setBlockAtIndices(int row, int col, Block b) throws IndexOutOfBoundsException {
        if(row<0 || row>=this.rowCount) throw new IndexOutOfBoundsException("Attempted to access invalid row: "+row);
        if(col<0 || col>=this.columnCount) throw new IndexOutOfBoundsException("Attempted to access invalid column: "+col);

        this.blocks[row][col] = b;

        this.blockCounter.put(b, blockCounter.get(b)+1); //increments the counter for that block type
    }

    public void buildBlocksFromImage(InputStream imageStream) {

        this.originalImageInputStream = imageStream;

        BitmapRegionDecoder brp = null;

        try {
            brp = BitmapRegionDecoder.newInstance(imageStream, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int row = 0;row<this.rowCount;row++) {
            for(int col=0;col<this.columnCount; col++) {
                int left = col*subdivisionWidth, top = row*subdivisionWidth;
                int right = left + subdivisionWidth, bottom = top  + subdivisionWidth;
                Bitmap region = brp.decodeRegion(new Rect(left, top, right, bottom), null);
                RgbColor averageColor = calculateAverageColor(region);
                Block bestBlock = Block.bestMatchedBlock(averageColor);
                this.setBlockAtIndices(row, col, bestBlock);
            }
        }

        return;
    }

    private RgbColor calculateAverageColor(Bitmap pixels) {
        long redBucket=0, greenBucket=0, blueBucket=0;
        long pixelCount = pixels.getWidth() * pixels.getHeight();

        for(int x=0;x<pixels.getWidth();x++) {
            for(int y=0;y<pixels.getHeight();y++) {
                int currPixel = pixels.getPixel(x,y);
                redBucket += Color.red(currPixel);
                greenBucket += Color.green(currPixel);
                blueBucket += Color.blue(currPixel);
            }
        }

        int redAverage = (int) (redBucket/pixelCount);
        int greenAverage = (int) (greenBucket/pixelCount);
        int blueAverage = (int) (blueBucket/pixelCount);

        return new RgbColor(redAverage, greenAverage, blueAverage);
    }

    public Bitmap buildBlockGrid(String texturesDirectory) throws BlockBitmapNotBuiltException {

        if(this.originalImageInputStream==null) throw new BlockBitmapNotBuiltException();

        Bitmap image = BitmapFactory.decodeStream(this.originalImageInputStream);

        for(int row=0;row<this.rowCount;row++) {
            for(int col=0;col<this.columnCount;col++) {
                int x = col*this.subdivisionWidth;
                int y = row*this.subdivisionWidth;

                Block b = this.blocks[row][col];
                String pathToTexture = texturesDirectory + b.toString()+".png";
                Bitmap blockTexture = BitmapFactory.decodeFile(pathToTexture);
                blockTexture = Bitmap.createScaledBitmap(blockTexture,subdivisionWidth, subdivisionWidth, true);
                int[] texturePixels = new int[subdivisionWidth*subdivisionWidth];
                blockTexture.getPixels(texturePixels,0,blockTexture.getWidth(), 0,0, subdivisionWidth, subdivisionWidth);

                image.setPixels(texturePixels,0,image.getWidth(),x,y,subdivisionWidth,subdivisionWidth);
            }
        }

        return image;
    }

    public int getBlockCount(Block b) {
        return this.blockCounter.get(b);
    }
}
