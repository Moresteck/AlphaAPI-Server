package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class hr
implements bf {
    private Set a = new HashSet();
    private Chunk b;
    private bf c;
    private am d;
    private Map e = new HashMap();
    private List f = new ArrayList();
    private World g;

    public hr(World dp2, am am2, bf bf2) {
        this.b = new Chunk(dp2, new byte[32768], 0, 0);
        this.b.q = true;
        this.b.p = true;
        this.g = dp2;
        this.d = am2;
        this.c = bf2;
    }

    public boolean a(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        return this.e.containsKey(ia2);
    }

    public void c(int n2, int n3) {
        int n4 = n2 * 16 + 8 - this.g.l;
        int n5 = n3 * 16 + 8 - this.g.n;
        int n6 = 20;
        if (n4 < - n6 || n4 > n6 || n5 < - n6 || n5 > n6) {
            this.a.add(new ia(n2, n3));
        }
    }

    public Chunk d(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        this.a.remove(new ia(n2, n3));
        Chunk chunk2 = (Chunk)this.e.get(ia2);
        if (chunk2 == null) {
            chunk2 = this.e(n2, n3);
            if (chunk2 == null) {
                chunk2 = this.c == null ? this.b : this.c.b(n2, n3);
            }
            this.e.put(ia2, chunk2);
            this.f.add(chunk2);
            if (chunk2 != null) {
                chunk2.c();
            }
            if (!chunk2.n && this.a(n2 + 1, n3 + 1) && this.a(n2, n3 + 1) && this.a(n2 + 1, n3)) {
                this.a(this, n2, n3);
            }
            if (this.a(n2 - 1, n3) && !this.b((int)(n2 - 1), (int)n3).n && this.a(n2 - 1, n3 + 1) && this.a(n2, n3 + 1) && this.a(n2 - 1, n3)) {
                this.a(this, n2 - 1, n3);
            }
            if (this.a(n2, n3 - 1) && !this.b((int)n2, (int)(n3 - 1)).n && this.a(n2 + 1, n3 - 1) && this.a(n2, n3 - 1) && this.a(n2 + 1, n3)) {
                this.a(this, n2, n3 - 1);
            }
            if (this.a(n2 - 1, n3 - 1) && !this.b((int)(n2 - 1), (int)(n3 - 1)).n && this.a(n2 - 1, n3 - 1) && this.a(n2, n3 - 1) && this.a(n2 - 1, n3)) {
                this.a(this, n2 - 1, n3 - 1);
            }
        }
        return chunk2;
    }

    public Chunk b(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        Chunk chunk2 = (Chunk)this.e.get(ia2);
        if (chunk2 == null) {
            if (this.g.s) {
                return this.d(n2, n3);
            }
            return this.b;
        }
        return chunk2;
    }

    private Chunk e(int n2, int n3) {
        if (this.d == null) {
            return null;
        }
        try {
            Chunk chunk2 = this.d.a(this.g, n2, n3);
            if (chunk2 != null) {
                chunk2.lastSaveTime = this.g.b;
            }
            return chunk2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void a(Chunk chunk2) {
        if (this.d == null) {
            return;
        }
        try {
            this.d.b(this.g, chunk2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(Chunk chunk2) {
        if (this.d == null) {
            return;
        }
        try {
            chunk2.lastSaveTime = this.g.b;
            this.d.a(this.g, chunk2);
        }
        catch (Exception iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(bf bf2, int n2, int n3) {
        Chunk chunk2 = this.b(n2, n3);
        if (!chunk2.n) {
            chunk2.n = true;
            if (this.c != null) {
                this.c.a(bf2, n2, n3);
                chunk2.e();
            }
        }
    }

    public boolean a(boolean bl2, hg hg2) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            Chunk chunk2 = (Chunk)this.f.get(i2);
            if (bl2 && !chunk2.p) {
                this.a(chunk2);
            }
            if (!chunk2.a(bl2)) continue;
            this.b(chunk2);
            chunk2.isModified = false;
            if (++n2 != 2 || bl2) continue;
            return false;
        }
        if (bl2) {
            if (this.d == null) {
                return true;
            }
            this.d.b();
        }
        return true;
    }

    public boolean a() {
        for (int i2 = 0; i2 < 16; ++i2) {
            if (this.a.isEmpty()) continue;
            ia ia2 = (ia)this.a.iterator().next();
            Chunk chunk2 = this.b(ia2.a, ia2.b);
            chunk2.d();
            this.b(chunk2);
            this.a(chunk2);
            this.a.remove(ia2);
            this.e.remove(ia2);
            this.f.remove(chunk2);
        }
        if (this.d != null) {
            this.d.a();
        }
        return this.c.a();
    }

    public boolean b() {
        return true;
    }
}

