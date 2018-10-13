package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class f
extends Block {
    public f(int n2, int n3) {
        super(n2, n3, Material.d);
    }

    public int a(int n2, Random random) {
        if (this.ba == Block.I.ba) {
            return en.k.aQ;
        }
        if (this.ba == Block.aw.ba) {
            return en.l.aQ;
        }
        return this.ba;
    }

    public int a(Random random) {
        return 1;
    }
}

