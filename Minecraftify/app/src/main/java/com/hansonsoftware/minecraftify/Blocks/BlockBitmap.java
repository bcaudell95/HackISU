package com.hansonsoftware.minecraftify.Blocks;

import com.hansonsoftware.minecraftify.Blocks.Block;

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
}
