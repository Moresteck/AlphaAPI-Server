/*
 * Decompiled with CFR 0_132.
 */
public class gn
extends ap
implements if {
    private gc[] e = new gc[36];

    public int a() {
        return 27;
    }

    public gc a(int n2) {
        return this.e[n2];
    }

    public void a(int n2, gc gc2) {
        this.e[n2] = gc2;
        if (gc2 != null && gc2.a > this.c()) {
            gc2.a = this.c();
        }
    }

    public void a(r r2) {
        super.a(r2);
        de de2 = r2.k("Items");
        this.e = new gc[this.a()];
        for (int i2 = 0; i2 < de2.b(); ++i2) {
            r r3 = (r)de2.a(i2);
            int n2 = r3.b("Slot") & 255;
            if (n2 < 0 || n2 >= this.e.length) continue;
            this.e[n2] = new gc(r3);
        }
    }

    public void b(r r2) {
        super.b(r2);
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
}

