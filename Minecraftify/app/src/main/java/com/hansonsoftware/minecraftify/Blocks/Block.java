package com.hansonsoftware.minecraftify.Blocks;

public enum Block {

    LapisLazuliBlock("LapisLazuliBlock.png", new Color(29,71,166)),
    GoldBlock("GoldBlock.png", new Color(249, 236, 79)),
    IronBlock("IronBlock.png", new Color(219, 219, 219)),
    RedstoneBlock("RedstoneBlock.png", new Color(171, 28, 9)),
    DiamondBlock("DiamondBlock.png", new Color(98, 219, 214)),
    EmeraldBlock("EmeraldBlock.png", new Color(81, 217, 117)),
    WhiteWool("WhiteWool.png", new Color(222, 222, 222)),
    OrangeWool("OrangeWool.png", new Color(219,125,63)),
    PurpleWool("PurpleWool.png", new Color(127, 62, 182)),
    BlueWool("BlueWool.png", new Color(46, 57, 142)),
    BrownWool("BrownWool.png", new Color(79, 51, 31)),
    GreenWool("GreenWool.png", new Color(53, 71, 27)),
    RedWool("RedWool.png", new Color(151, 52, 49)),
    BlackWool("BlackWool.png", new Color(26, 22, 22)),
    MagentaWool("MagentaWool.png", new Color(180, 81, 189)),
    LightBlueWool("LightBlueWool.png", new Color(107, 138, 201)),
    YellowWool("YellowWool.png", new Color(177, 166, 39)),
    LimeGreenWool("LimeGreenWool.png", new Color(66, 174, 57)),
    PinkWool("PinkWool.png", new Color(208, 132, 153)),
    DarkGrayWool("DarkGrayWool.png", new Color(64, 64, 64)),
    LightGrayWool("LightGrayWool.png", new Color(255, 161, 161)),
    CyanWool("CyanWool.png", new Color(47, 111, 137)),
    ClayBlock("ClayBlock.png", new Color(159, 164, 177)),
    Bricks("Bricks.png", new Color(147, 100, 87)),
    Sandstone("Sandstone.png", new Color(218, 210, 159)),
    Mycelium("Mycelium.png", new Color(111, 100, 105)),
    NetherBrick("NetherBrick.png", new Color(45, 23, 27)),
    StoneBricks("StoneBricks.png", new Color(122,122,122)),
    OakWood("OakWood.png", new Color(155, 125, 77)),
    Endstone("Endstone.png", new Color(221, 224, 165)),
    OakWoodPlanks("OakWoodPlanks.png", new Color(157, 128, 79)),
    BirchWoodPlanks("BirchWoodPlanks.png", new Color(196, 179, 123)),
    JungleWoodPlanks("JungleWoodPlanks.png", new Color(154, 110, 77)),
    SpruceWoodPlanks("SpruceWoodPlanks.png", new Color(104, 78, 47)),
    Stone("Stone.png", new Color(125, 125, 125)),
    Pumpkin("Pumpkin.png", new Color(193, 118, 21)),
    Obsidian("Obsidian.png", new Color(20, 18, 30)),
    Dirt("Dirt.png", new Color(134, 96, 67)),
    Bedrock("Bedrock.png", new Color(84, 84, 84)),
    Gravel("Gravel.png", new Color(127, 124, 123)),
    Glowstone("Glowstone.png", new Color(144, 118, 70)),
    Netherrack("Netherrack.png", new Color(111, 54, 53)),
    SoulSand("SoulSand.png", new Color(85, 64, 52)),
    Melon("Melon.png", new Color(151, 154, 37)),
    Snow("Snow.png", new Color(240, 251, 251)),
    Lava("Lava.png", new Color(217, 105, 26))
    ;

    private String fileName;
	private Color color;

    Block() {
        fileName = "";
        color = new Color(0,0,0);
    }

    Block(String fileName, Color color) {
        this.fileName = fileName;
        this.color = color;
    }

    public static Block bestMatchedBlock(Color color) {
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

    public Color getColor() {
        return color;
    }
}