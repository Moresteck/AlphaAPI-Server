/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
public class BlockFurnace
extends TileEntity
implements IInventory {
    private gc[] e = new gc[3];
    private int f = 0;
    private int g = 0;
    private int h = 0;

    public int a() {
        return this.e.length;
    }

    public gc a(int n2) {
        return this.e[n2];
    }

    public void a(r r2) {
        super.a(r2);
        de de2 = r2.k("Items");
        this.e = new gc[this.a()];
        for (int i2 = 0; i2 < de2.b(); ++i2) {
            r r3 = (r)de2.a(i2);
            byte by2 = r3.b("Slot");
            if (by2 < 0 || by2 >= this.e.length) continue;
            this.e[by2] = new gc(r3);
        }
        this.f = r2.c("BurnTime");
        this.h = r2.c("CookTime");
        this.g = this.a(this.e[1]);
    }

    public void b(r r2) {
        super.b(r2);
        r2.a("BurnTime", (short)this.f);
        r2.a("CookTime", (short)this.h);
        de de2 = new de();
        for (int i2 = 0; i2 < this.e.length; ++i2) {
            if (this.e[i2] == null) continue;
            r r3 = new r();
            r3.a("Slot", (byte)i2);
            this.e[i2].a(r3);
            de2.a(r3);
        }
        r2.a("Items", de2);
    }

    public int c() {
        return 64;
    }

    public boolean d() {
        return this.f > 0;
    }

    public void b() {
        boolean bl2 = this.f > 0;
        boolean bl3 = false;
        if (this.f > 0) {
            --this.f;
            bl3 = true;
        }
        if (this.f == 0 && this.f()) {
            this.g = this.f = this.a(this.e[1]);
            if (this.f > 0) {
                bl3 = true;
                if (this.e[1] != null) {
                    --this.e[1].a;
                    if (this.e[1].a == 0) {
                        this.e[1] = null;
                    }
                }
            }
        }
        if (this.d() && this.f()) {
            ++this.h;
            if (this.h == 200) {
                this.h = 0;
                this.e();
                bl3 = true;
            }
        } else {
            this.h = 0;
        }
        if (bl2 != this.f > 0) {
            bl3 = true;
            dm.a(this.f > 0, this.a, this.b, this.c, this.d);
        }
        if (bl3) {
            this.a.m(this.b, this.c, this.d);
        }
    }

    private boolean f() {
        if (this.e[0] == null) {
            return false;
        }
        int n2 = this.b(this.e[0].a().aQ);
        if (n2 < 0) {
            return false;
        }
        if (this.e[2] == null) {
            return true;
        }
        if (this.e[2].c != n2) {
            return false;
        }
        if (this.e[2].a < this.c() && this.e[2].a < this.e[2].b()) {
            return true;
        }
        if (this.e[2].a < en.c[n2].a()) {
            return true;
        }
        return false;
    }

    public void e() {
        if (!this.f()) {
            return;
        }
        int n2 = this.b(this.e[0].a().aQ);
        if (this.e[2] == null) {
            this.e[2] = new gc(n2, 1);
        } else if (this.e[2].c == n2) {
            ++this.e[2].a;
        }
        --this.e[0].a;
        if (this.e[0].a <= 0) {
            this.e[0] = null;
        }
    }

    private int b(int n2) {
        if (n2 == Block.H.ba) {
            return en.m.aQ;
        }
        if (n2 == Block.G.ba) {
            return en.n.aQ;
        }
        if (n2 == Block.aw.ba) {
            return en.l.aQ;
        }
        if (n2 == Block.E.ba) {
            return Block.M.ba;
        }
        if (n2 == en.ao.aQ) {
            return en.ap.aQ;
        }
        if (n2 == Block.w.ba) {
            return Block.t.ba;
        }
        if (n2 == en.aG.aQ) {
            return en.aF.aQ;
        }
        return -1;
    }

    private int a(gc gc2) {
        if (gc2 == null) {
            return 0;
        }
        int n2 = gc2.a().aQ;
        if (n2 < 256 && Block.n[n2].bl == Material.c) {
            return 300;
        }
        if (n2 == en.B.aQ) {
            return 100;
        }
        if (n2 == en.k.aQ) {
            return 1600;
        }
        return 0;
    }
}

