package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class dj
implements IBlockAccess {
    private int a;
    private int b;
    private hv[][] c;
    private World d;

    public dj(World dp2, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.d = dp2;
        this.a = n2 >> 4;
        this.b = n4 >> 4;
        int n8 = n5 >> 4;
        int n9 = n7 >> 4;
        this.c = new hv[n8 - this.a + 1][n9 - this.b + 1];
        for (int i2 = this.a; i2 <= n8; ++i2) {
            for (int i3 = this.b; i3 <= n9; ++i3) {
                this.c[i2 - this.a][i3 - this.b] = dp2.b(i2, i3);
            }
        }
    }

    public int a(int n2, int n3, int n4) {
        if (n3 < 0) {
            return 0;
        }
        if (n3 >= 128) {
            return 0;
        }
        int n5 = (n2 >> 4) - this.a;
        int n6 = (n4 >> 4) - this.b;
        return this.c[n5][n6].a(n2 & 15, n3, n4 & 15);
    }

    public int b(int n2, int n3, int n4) {
        if (n3 < 0) {
            return 0;
        }
        if (n3 >= 128) {
            return 0;
        }
        int n5 = (n2 >> 4) - this.a;
        int n6 = (n4 >> 4) - this.b;
        return this.c[n5][n6].b(n2 & 15, n3, n4 & 15);
    }

    public hz c(int n2, int n3, int n4) {
        int n5 = this.a(n2, n3, n4);
        if (n5 == 0) {
            return hz.a;
        }
        return Block.n[n5].bl;
    }

    public boolean d(int n2, int n3, int n4) {
        Block et2 = Block.n[this.a(n2, n3, n4)];
        if (et2 == null) {
            return false;
        }
        return et2.b();
    }
}

