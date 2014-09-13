package com.hansonsoftware.minecraftify.Blocks;

import android.graphics.Color;

public enum Block {

    LapisLazuliBlock("lapislazuliblock.png", new RgbColor(29,71,166)),
    GoldBlock("goldblock.png", new RgbColor(249, 236, 79)),
    IronBlock("ironblock.png", new RgbColor(219, 219, 219)),
    RedstoneBlock("redstoneblock.png", new RgbColor(171, 28, 9)),
    DiamondBlock("DiamondBlock.png", new RgbColor(98, 219, 214)),
    EmeraldBlock("emeraldblock.png", new RgbColor(81, 217, 117)),
    WhiteWool("whitewool.png", new RgbColor(222, 222, 222)),
    OrangeWool("orangewool.png", new RgbColor(219,125,63)),
    PurpleWool("purplewool.png", new RgbColor(127, 62, 182)),
    BlueWool("bluewool.png", new RgbColor(46, 57, 142)),
    BrownWool("brownwool.png", new RgbColor(79, 51, 31)),
    GreenWool("greenwool.png", new RgbColor(53, 71, 27)),
    RedWool("redwool.png", new RgbColor(151, 52, 49)),
    BlackWool("blackwool.png", new RgbColor(26, 22, 22)),
    MagentaWool("magentawool.png", new RgbColor(180, 81, 189)),
    LightBlueWool("lightbluewool.png", new RgbColor(107, 138, 201)),
    YellowWool("yellowwool.png", new RgbColor(177, 166, 39)),
    LimeGreenWool("limegreenwool.png", new RgbColor(66, 174, 57)),
    PinkWool("pinkwool.png", new RgbColor(208, 132, 153)),
    DarkGrayWool("darkgraywool.png", new RgbColor(64, 64, 64)),
    LightGrayWool("lightgraywool.png", new RgbColor(255, 161, 161)),
    CyanWool("cyanwool.png", new RgbColor(47, 111, 137)),
    ClayBlock("clayblock.png", new RgbColor(159, 164, 177)),
    Bricks("bricks.png", new RgbColor(147, 100, 87)),
    Sandstone("sandstone.png", new RgbColor(218, 210, 159)),
    Mycelium("mycelium.png", new RgbColor(111, 100, 105)),
    NetherBrick("netherbrick.png", new RgbColor(45, 23, 27)),
    StoneBricks("stonebricks.png", new RgbColor(122,122,122)),
    OakWood("oakwood.png", new RgbColor(155, 125, 77)),
    Endstone("endstone.png", new RgbColor(221, 224, 165)),
    OakWoodPlanks("oakwoodplanks.png", new RgbColor(157, 128, 79)),
    BirchWoodPlanks("birchwoodplanks.png", new RgbColor(196, 179, 123)),
    JungleWoodPlanks("junglewoodplanks.png", new RgbColor(154, 110, 77)),
    SpruceWoodPlanks("sprucewoodplanks.png", new RgbColor(104, 78, 47)),
    Stone("stone.png", new RgbColor(125, 125, 125)),
    Pumpkin("pumpkin.png", new RgbColor(193, 118, 21)),
    Obsidian("obsidian.png", new RgbColor(20, 18, 30)),
    Dirt("dirt.png", new RgbColor(134, 96, 67)),
    Bedrock("bedrock.png", new RgbColor(84, 84, 84)),
    Gravel("gravel.png", new RgbColor(127, 124, 123)),
    Glowstone("glowstone.png", new RgbColor(144, 118, 70)),
    Netherrack("netherrack.png", new RgbColor(111, 54, 53)),
    SoulSand("soulsand.png", new RgbColor(85, 64, 52)),
    Melon("melon.png", new RgbColor(151, 154, 37)),
    Snow("snow.png", new RgbColor(240, 251, 251)),
    Lava("lava.png", new RgbColor(217, 105, 26))
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