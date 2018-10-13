package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public abstract class cl
extends Block {
    protected cl(int n2, Material hz2) {
        super(n2, hz2);
    }

    protected cl(int n2, int n3, Material hz2) {
        super(n2, n3, hz2);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        super.e(dp2, n2, n3, n4);
        dp2.a(n2, n3, n4, this.a_());
    }

    public void b(World dp2, int n2, int n3, int n4) {
        super.b(dp2, n2, n3, n4);
        dp2.l(n2, n3, n4);
    }

    protected abstract TileEntity a_();
}

