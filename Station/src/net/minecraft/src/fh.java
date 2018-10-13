package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class fh
extends Block {
    protected fh(int n2) {
        super(n2, Material.Packet20NamedEntitySpawn);
        this.aZ = 20;
    }

    public int a(Random random) {
        return 1;
    }

    public int a(int n2, Random random) {
        return Block.J.ba;
    }

    public int a(int n2) {
        if (n2 == 1) {
            return 21;
        }
        if (n2 == 0) {
            return 21;
        }
        return 20;
    }
}

