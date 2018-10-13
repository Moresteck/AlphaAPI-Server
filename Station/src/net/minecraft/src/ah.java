package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ah
extends ci {
    private static Block[] aV = new Block[]{Block.w, Block.aj, Block.ak, Block.t, Block.ao, Block.H, Block.ai, Block.I, Block.ah, Block.G, Block.aw, Block.ax, Block.aT};
    private int aW;

    public ah(int n2, int n3) {
        super(n2, 2, n3, aV);
        this.aW = n3;
    }

    public boolean a(Block et2) {
        if (et2 == Block.ap) {
            return this.aW == 3;
        }
        if (et2 == Block.ax || et2 == Block.aw) {
            return this.aW >= 2;
        }
        if (et2 == Block.ah || et2 == Block.G) {
            return this.aW >= 2;
        }
        if (et2 == Block.ai || et2 == Block.H) {
            return this.aW >= 1;
        }
        if (et2 == Block.aN || et2 == Block.aO) {
            return this.aW >= 2;
        }
        if (et2.bl == Material.d) {
            return true;
        }
        if (et2.bl == Material.e) {
            return true;
        }
        return false;
    }
}

