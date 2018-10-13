/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
public class InventoryPlayer
implements IInventory {
    public gc[] a = new gc[36];
    public gc[] b = new gc[4];
    public gc[] c = new gc[4];
    public int d = 0;
    private EntityPlayer e;

    public InventoryPlayer(EntityPlayer entityplayer) {
        this.e = entityplayer;
    }

    public gc b() {
        return this.a[this.d];
    }

    private int c(int n2) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null || this.a[i2].c != n2 || this.a[i2].a >= this.a[i2].b() || this.a[i2].a >= this.d()) continue;
            return i2;
        }
        return -1;
    }

    private int g() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] != null) continue;
            return i2;
        }
        return -1;
    }

    private int a(int n2, int n3) {
        int n4;
        int n5 = this.c(n2);
        if (n5 < 0) {
            n5 = this.g();
        }
        if (n5 < 0) {
            return n3;
        }
        if (this.a[n5] == null) {
            this.a[n5] = new gc(n2, 0);
        }
        if ((n4 = n3) > this.a[n5].b() - this.a[n5].a) {
            n4 = this.a[n5].b() - this.a[n5].a;
        }
        if (n4 > this.d() - this.a[n5].a) {
            n4 = this.d() - this.a[n5].a;
        }
        if (n4 == 0) {
            return n3;
        }
        this.a[n5].a += n4;
        this.a[n5].b = 5;
        return n3 -= n4;
    }

    public void c() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null || this.a[i2].b <= 0) continue;
            --this.a[i2].b;
        }
    }

    public boolean a(gc gc2) {
        int n2;
        if (gc2.d == 0) {
            gc2.a = this.a(gc2.c, gc2.a);
            if (gc2.a == 0) {
                return true;
            }
        }
        if ((n2 = this.g()) >= 0) {
            this.a[n2] = gc2;
            this.a[n2].b = 5;
            return true;
        }
        return false;
    }

    public void a(int n2, gc gc2) {
        gc[] arrgc = this.a;
        if (n2 >= arrgc.length) {
            n2 -= arrgc.length;
            arrgc = this.b;
        }
        if (n2 >= arrgc.length) {
            n2 -= arrgc.length;
            arrgc = this.c;
        }
        arrgc[n2] = gc2;
    }

    public float a(Block et2) {
        float f2 = 1.0f;
        if (this.a[this.d] != null) {
            f2 *= this.a[this.d].a(et2);
        }
        return f2;
    }

    public int a() {
        return this.a.length + 4;
    }

    public gc a(int n2) {
        gc[] arrgc = this.a;
        if (n2 >= arrgc.length) {
            n2 -= arrgc.length;
            arrgc = this.b;
        }
        if (n2 >= arrgc.length) {
            n2 -= arrgc.length;
            arrgc = this.c;
        }
        return arrgc[n2];
    }

    public int d() {
        return 64;
    }

    public boolean b(Block et2) {
        if (et2.bl != Material.d && et2.bl != Material.e && et2.bl != Material.t && et2.bl != Material.s) {
            return true;
        }
        gc gc2 = this.a(this.d);
        if (gc2 != null) {
            return gc2.b(et2);
        }
        return false;
    }

    public int e() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] == null || !(this.b[i2].a() instanceof ga)) continue;
            int n5 = this.b[i2].c();
            int n6 = this.b[i2].d;
            int n7 = n5 - n6;
            n3 += n7;
            n4 += n5;
            int n8 = ((ga)this.b[i2].a()).aW;
            n2 += n8;
        }
        if (n4 == 0) {
            return 0;
        }
        return (n2 - 1) * n3 / n4 + 1;
    }

    public void b(int n2) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] == null || !(this.b[i2].a() instanceof ga)) continue;
            this.b[i2].a(n2);
            if (this.b[i2].a != 0) continue;
            this.b[i2].a(this.e);
            this.b[i2] = null;
        }
    }

    public void f() {
        int n2;
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if (this.a[n2] == null) continue;
            this.e.a(this.a[n2], true);
            this.a[n2] = null;
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            if (this.b[n2] == null) continue;
            this.e.a(this.b[n2], true);
            this.b[n2] = null;
        }
    }
}

