package com.hansonsoftware.minecraftify.Blocks;

/**
 * Created by Brandon Caudell on 9/13/2014.
 */
public class RgbColor {
    public int red, green, blue;
    public RgbColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public double distance(RgbColor c2) {
        int redDiff = this.red - c2.red;
        int greenDiff = this.green - c2.green;
        int blueDiff = this.blue - c2.blue;
        long sum = redDiff*redDiff + blueDiff*blueDiff + greenDiff*greenDiff;
        return Math.sqrt(sum);
    }
    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
