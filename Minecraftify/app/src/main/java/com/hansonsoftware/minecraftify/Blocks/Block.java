package com.hansonsoftware.minecraftify.Blocks;

import android.graphics.Color;

import com.hansonsoftware.minecraftify.R;

public enum Block {
    LapisLazuliBlock(R.drawable.lapislazuliblock, new RgbColor(29,71,166)),
    GoldBlock(R.drawable.goldblock, new RgbColor(249, 236, 79)),
    IronBlock(R.drawable.ironblock, new RgbColor(219, 219, 219)),
    RedstoneBlock(R.drawable.redstoneblock, new RgbColor(171, 28, 9)),
    DiamondBlock(R.drawable.diamondblock, new RgbColor(98, 219, 214)),
    EmeraldBlock(R.drawable.emeraldblock, new RgbColor(81, 217, 117)),
    WhiteWool(R.drawable.whitewool, new RgbColor(222, 222, 222)),
    OrangeWool(R.drawable.orangewool, new RgbColor(219,125,63)),
    PurpleWool(R.drawable.purplewool, new RgbColor(127, 62, 182)),
    BlueWool(R.drawable.bluewool, new RgbColor(46, 57, 142)),
    BrownWool(R.drawable.brownwool, new RgbColor(79, 51, 31)),
    GreenWool(R.drawable.greenwool, new RgbColor(53, 71, 27)),
    RedWool(R.drawable.redwool, new RgbColor(151, 52, 49)),
    BlackWool(R.drawable.blackwool, new RgbColor(26, 22, 22)),
    MagentaWool(R.drawable.magentawool, new RgbColor(180, 81, 189)),
    LightBlueWool(R.drawable.lightbluewool, new RgbColor(107, 138, 201)),
    YellowWool(R.drawable.yellowwool, new RgbColor(177, 166, 39)),
    LimeGreenWool(R.drawable.limegreenwool, new RgbColor(66, 174, 57)),
    PinkWool(R.drawable.pinkwool, new RgbColor(208, 132, 153)),
    DarkGrayWool(R.drawable.darkgraywool, new RgbColor(64, 64, 64)),
    LightGrayWool(R.drawable.lightgraywool, new RgbColor(255, 161, 161)),
    CyanWool(R.drawable.cyanwool, new RgbColor(47, 111, 137)),
    ClayBlock(R.drawable.clayblock, new RgbColor(159, 164, 177)),
    Bricks(R.drawable.bricks, new RgbColor(147, 100, 87)),
    Sandstone(R.drawable.sandstone, new RgbColor(218, 210, 159)),
    Mycelium(R.drawable.mycelium, new RgbColor(111, 100, 105)),
    NetherBrick(R.drawable.netherbrick, new RgbColor(45, 23, 27)),
    StoneBricks(R.drawable.stonebricks, new RgbColor(122,122,122)),
    OakWood(R.drawable.oakwood, new RgbColor(155, 125, 77)),
    Endstone(R.drawable.endstone, new RgbColor(221, 224, 165)),
    OakWoodPlanks(R.drawable.oakwoodplanks, new RgbColor(157, 128, 79)),
    BirchWoodPlanks(R.drawable.birchwoodplanks, new RgbColor(196, 179, 123)),
    JungleWoodPlanks(R.drawable.junglewoodplanks, new RgbColor(154, 110, 77)),
    SpruceWoodPlanks(R.drawable.sprucewoodplanks, new RgbColor(104, 78, 47)),
    Stone(R.drawable.stone, new RgbColor(125, 125, 125)),
    Pumpkin(R.drawable.pumpkin, new RgbColor(193, 118, 21)),
    Obsidian(R.drawable.obsidian, new RgbColor(20, 18, 30)),
    Dirt(R.drawable.dirt, new RgbColor(134, 96, 67)),
    Bedrock(R.drawable.bedrock, new RgbColor(84, 84, 84)),
    Gravel(R.drawable.gravel, new RgbColor(127, 124, 123)),
    Glowstone(R.drawable.glowstone, new RgbColor(144, 118, 70)),
    Netherrack(R.drawable.netherrack, new RgbColor(111, 54, 53)),
    SoulSand(R.drawable.soulsand, new RgbColor(85, 64, 52)),
    Melon(R.drawable.melon, new RgbColor(151, 154, 37)),
    Snow(R.drawable.snow, new RgbColor(240, 251, 251)),
    Lava(R.drawable.lava, new RgbColor(217, 105, 26))
    ;

    private int resourceCode;
	private RgbColor color;

    Block() {
        this(-1, new RgbColor(0,0,0));
    }

    Block(int resourceCode, RgbColor color) {
        this.resourceCode = resourceCode;
        this.color = color;
    }

    public static Block bestMatchedBlock(RgbColor color) {
        Block closestBlock = null;
        double shortestDistance = -1;
        for (Block b : Block.values()) {
            double distance = color.distance(b.getColor());
            if (distance < shortestDistance || shortestDistance==-1) {
                shortestDistance = distance;
                closestBlock = b;
            }
        }
        return closestBlock;
    }

    public RgbColor getColor() {
        return color;
    }
}