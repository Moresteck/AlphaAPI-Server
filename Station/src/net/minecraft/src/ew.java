package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ew
extends Block {
    public ew(int n2, int n3) {
        super(n2, n3, Material.Packet20NamedEntitySpawn);
    }

    public int a(int n2) {
        if (n2 <= 1) {
            return 4;
        }
        return this.aZ;
    }

    public int a(Random random) {
        return 0;
    }
}

