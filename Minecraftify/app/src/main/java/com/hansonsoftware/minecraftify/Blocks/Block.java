package com.hansonsoftware.minecraftify.Blocks;

import android.graphics.Color;

public enum Block {

    LapisLazuliBlock("LapisLazuliBlock.png", new RgbColor(29,71,166)),
    GoldBlock("GoldBlock.png", new RgbColor(249, 236, 79)),
    IronBlock("IronBlock.png", new RgbColor(219, 219, 219)),
    RedstoneBlock("RedstoneBlock.png", new RgbColor(171, 28, 9)),
    DiamondBlock("DiamondBlock.png", new RgbColor(98, 219, 214)),
    EmeraldBlock("EmeraldBlock.png", new RgbColor(81, 217, 117)),
    WhiteWool("WhiteWool.png", new RgbColor(222, 222, 222)),
    OrangeWool("OrangeWool.png", new RgbColor(219,125,63)),
    PurpleWool("PurpleWool.png", new RgbColor(127, 62, 182)),
    BlueWool("BlueWool.png", new RgbColor(46, 57, 142)),
    BrownWool("BrownWool.png", new RgbColor(79, 51, 31)),
    GreenWool("GreenWool.png", new RgbColor(53, 71, 27)),
    RedWool("RedWool.png", new RgbColor(151, 52, 49)),
    BlackWool("BlackWool.png", new RgbColor(26, 22, 22)),
    MagentaWool("MagentaWool.png", new RgbColor(180, 81, 189)),
    LightBlueWool("LightBlueWool.png", new RgbColor(107, 138, 201)),
    YellowWool("YellowWool.png", new RgbColor(177, 166, 39)),
    LimeGreenWool("LimeGreenWool.png", new RgbColor(66, 174, 57)),
    PinkWool("PinkWool.png", new RgbColor(208, 132, 153)),
    DarkGrayWool("DarkGrayWool.png", new RgbColor(64, 64, 64)),
    LightGrayWool("LightGrayWool.png", new RgbColor(255, 161, 161)),
    CyanWool("CyanWool.png", new RgbColor(47, 111, 137)),
    ClayBlock("ClayBlock.png", new RgbColor(159, 164, 177)),
    Bricks("Bricks.png", new RgbColor(147, 100, 87)),
    Sandstone("Sandstone.png", new RgbColor(218, 210, 159)),
    Mycelium("Mycelium.png", new RgbColor(111, 100, 105)),
    NetherBrick("NetherBrick.png", new RgbColor(45, 23, 27)),
    StoneBricks("StoneBricks.png", new RgbColor(122,122,122)),
    OakWood("OakWood.png", new RgbColor(155, 125, 77)),
    Endstone("Endstone.png", new RgbColor(221, 224, 165)),
    OakWoodPlanks("OakWoodPlanks.png", new RgbColor(157, 128, 79)),
    BirchWoodPlanks("BirchWoodPlanks.png", new RgbColor(196, 179, 123)),
    JungleWoodPlanks("JungleWoodPlanks.png", new RgbColor(154, 110, 77)),
    SpruceWoodPlanks("SpruceWoodPlanks.png", new RgbColor(104, 78, 47)),
    Stone("Stone.png", new RgbColor(125, 125, 125)),
    Pumpkin("Pumpkin.png", new RgbColor(193, 118, 21)),
    Obsidian("Obsidian.png", new RgbColor(20, 18, 30)),
    Dirt("Dirt.png", new RgbColor(134, 96, 67)),
    Bedrock("Bedrock.png", new RgbColor(84, 84, 84)),
    Gravel("Gravel.png", new RgbColor(127, 124, 123)),
    Glowstone("Glowstone.png", new RgbColor(144, 118, 70)),
    Netherrack("Netherrack.png", new RgbColor(111, 54, 53)),
    SoulSand("SoulSand.png", new RgbColor(85, 64, 52)),
    Melon("Melon.png", new RgbColor(151, 154, 37)),
    Snow("Snow.png", new RgbColor(240, 251, 251)),
    Lava("Lava.png", new RgbColor(217, 105, 26))
    ;

    private String fileName;
	private RgbColor color;

    Block() {
        fileName = "";
        color = new RgbColor(0,0,0);
    }

    Block(String fileName, RgbColor color) {
        this.fileName = fileName;
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