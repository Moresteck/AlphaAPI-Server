package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
public enum Painting {
    KEBAB("Kebab", 16, 16, 0, 0),
    AZTEC("Aztec", 16, 16, 16, 0),
    ALBAN("Alban", 16, 16, 32, 0),
    AZTEC2("Aztec2", 16, 16, 48, 0),
    BOMB("Bomb", 16, 16, 64, 0),
    PLANT("Plant", 16, 16, 80, 0),
    WASTELAND("Wasteland", 16, 16, 96, 0),
    POOL("Pool", 32, 16, 0, 32),
    COURBET("Courbet", 32, 16, 32, 32),
    SEA("Sea", 32, 16, 64, 32),
    SUNSET("Sunset", 32, 16, 96, 32),
    WANDERER("Wanderer", 16, 32, 0, 64),
    MATCH("Match", 32, 32, 0, 128),
    BUST("Bust", 32, 32, 32, 128),
    STAGE("Stage", 32, 32, 64, 128),
    VOID("Void", 32, 32, 96, 128),
    SKULL_AND_ROSES("SkullAndRoses", 32, 32, 128, 128),
    FIGHTERS("Fighters", 64, 32, 0, 96),
    POINTER("Pointer", 64, 64, 0, 192);
    
    public final String name;
    public final int u;
    public final int v;
    public final int w;
    public final int x;

    private Painting(String string2, int n3, int n4, int n5, int n6) {
        this.name = string2;
        this.u = n3;
        this.v = n4;
        this.w = n5;
        this.x = n6;
    }
}

