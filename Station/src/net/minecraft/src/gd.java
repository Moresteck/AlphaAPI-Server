package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gd
extends ci {
    private static Block[] aV = new Block[]{Block.u, Block.v, Block.E, Block.F, Block.aS, Block.aU, Block.aW};

    public gd(int n2, int n3) {
        super(n2, 1, n3, aV);
    }

    public boolean a(Block et2) {
        if (et2 == Block.aS) {
            return true;
        }
        if (et2 == Block.aU) {
            return true;
        }
        return false;
    }
}

