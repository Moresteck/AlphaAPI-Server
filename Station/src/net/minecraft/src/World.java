package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World
implements IBlockAccess {
    private List u;
    private List v;
    private List w;
    private TreeSet x;
    private Set y;
    public List a;
    public long b;
    public boolean c;
    private long z;
    private long A;
    private long B;
    public int d;
    protected int e;
    protected int f;
    public boolean g;
    public static float[] h = new float[16];
    private final long C;
    public List i;
    public int j;
    public Random k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    private List D;
    private bf E;
    private File F;
    public long p;
    private r G;
    public long q;
    public final String r;
    public boolean s;
    private ArrayList H;
    private Set I;
    private int J;
    private List K;
    public boolean t;

    public World(File file, String string) {
        this(file, string, new Random().nextLong());
    }

    public World(String string) {
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new TreeSet();
        this.y = new HashSet();
        this.a = new ArrayList();
        this.b = 0L;
        this.c = false;
        this.z = 8961023L;
        this.A = 12638463L;
        this.B = 0xFFFFFFL;
        this.d = 0;
        this.e = new Random().nextInt();
        this.f = 1013904223;
        this.g = false;
        this.C = System.currentTimeMillis();
        this.i = new ArrayList();
        this.k = new Random();
        this.o = false;
        this.D = new ArrayList();
        this.p = 0L;
        this.q = 0L;
        this.H = new ArrayList();
        this.I = new HashSet();
        this.J = this.k.nextInt(12000);
        this.K = new ArrayList();
        this.t = false;
        this.r = string;
        this.E = this.a(this.F);
        this.d();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public World(File file, String string, long l2) {
        File file2;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new TreeSet();
        this.y = new HashSet();
        this.a = new ArrayList();
        this.b = 0L;
        this.c = false;
        this.z = 8961023L;
        this.A = 12638463L;
        this.B = 0xFFFFFFL;
        this.d = 0;
        this.e = new Random().nextInt();
        this.f = 1013904223;
        this.g = false;
        this.C = System.currentTimeMillis();
        this.i = new ArrayList();
        this.k = new Random();
        this.o = false;
        this.D = new ArrayList();
        this.p = 0L;
        this.q = 0L;
        this.H = new ArrayList();
        this.I = new HashSet();
        this.J = this.k.nextInt(12000);
        this.K = new ArrayList();
        this.t = false;
        this.r = string;
        file.mkdirs();
        this.F = new File(file, string);
        this.F.mkdirs();
        try {
            file2 = new File(this.F, "session.lock");
            DataOutputStream dataoutput = new DataOutputStream(new FileOutputStream(file2));
            try {
                dataoutput.writeLong(this.C);
            }
            finally {
                dataoutput.close();
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to check session lock, aborting");
        }
        file2 = new File(this.F, "level.dat");
        boolean bl2 = this.o = !file2.exists();
        if (file2.exists()) {
            try {
                r dataoutput = af.a(new FileInputStream(file2));
                r r2 = dataoutput.j("Data");
                this.p = r2.e("RandomSeed");
                this.l = r2.d("SpawnX");
                this.m = r2.d("SpawnY");
                this.n = r2.d("SpawnZ");
                this.b = r2.e("Time");
                this.q = r2.e("SizeOnDisk");
                this.c = r2.l("SnowCovered");
                if (r2.a("Player")) {
                    this.G = r2.j("Player");
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            this.c = this.k.nextInt(4) == 0;
        }
        boolean bl3 = false;
        if (this.p == 0L) {
            this.p = l2;
            bl3 = true;
        }
        this.E = this.a(this.F);
        if (bl3) {
            this.s = true;
            this.l = 0;
            this.m = 64;
            this.n = 0;
            while (!this.e(this.l, this.n)) {
                this.l += this.k.nextInt(64) - this.k.nextInt(64);
                this.n += this.k.nextInt(64) - this.k.nextInt(64);
            }
            this.s = false;
        }
        this.d();
    }

    protected bf a(File file) {
        return new hf(this, new ec(file, true), new hi(this, this.p));
    }

    private boolean e(int n2, int n3) {
        int n4 = this.f(n2, n3);
        if (n4 != Block.E.ba) {
            return false;
        }
        return true;
    }

    private int f(int n2, int n3) {
        int n4 = 63;
        while (this.a(n2, n4 + 1, n3) != 0) {
            ++n4;
        }
        return this.a(n2, n4, n3);
    }

    public void a(boolean bl2, hg hg2) {
        if (!this.E.b()) {
            return;
        }
        if (hg2 != null) {
            hg2.a("Saving level");
        }
        this.h();
        if (hg2 != null) {
            hg2.b("Saving chunks");
        }
        this.E.a(bl2, hg2);
    }

    private void h() {
        r r2;
        this.g();
        r r3 = new r();
        r3.a("RandomSeed", this.p);
        r3.a("SpawnX", this.l);
        r3.a("SpawnY", this.m);
        r3.a("SpawnZ", this.n);
        r3.a("Time", this.b);
        r3.a("SizeOnDisk", this.q);
        r3.a("SnowCovered", this.c);
        r3.a("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;
        if (this.i.size() > 0) {
            entityplayer = (EntityPlayer)this.i.get(0);
        }
        if (entityplayer != null) {
            r2 = new r();
            entityplayer.d(r2);
            r3.a("Player", r2);
        }
        r2 = new r();
        r2.a("Data", (ft)r3);
        try {
            File file = new File(this.F, "level.dat_new");
            File file2 = new File(this.F, "level.dat_old");
            File file3 = new File(this.F, "level.dat");
            af.a(r2, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int a(int n2, int n3, int n4) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return 0;
        }
        if (n3 < 0) {
            return 0;
        }
        if (n3 >= 128) {
            return 0;
        }
        return this.b(n2 >> 4, n4 >> 4).a(n2 & 15, n3, n4 & 15);
    }

    public boolean e(int n2, int n3, int n4) {
        if (n3 < 0 || n3 >= 128) {
            return false;
        }
        return this.g(n2 >> 4, n4 >> 4);
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n6 < 0 || n3 >= 128) {
            return false;
        }
        n3 >>= 4;
        n4 >>= 4;
        n6 >>= 4;
        n7 >>= 4;
        for (int i2 = n2 >>= 4; i2 <= (n5 >>= 4); ++i2) {
            for (int i3 = n4; i3 <= n7; ++i3) {
                if (this.g(i2, i3)) continue;
                return false;
            }
        }
        return true;
    }

    private boolean g(int n2, int n3) {
        return this.E.a(n2, n3);
    }

    public hv a(int n2, int n3) {
        return this.b(n2 >> 4, n3 >> 4);
    }

    public hv b(int n2, int n3) {
        return this.E.b(n2, n3);
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return false;
        }
        if (n3 < 0) {
            return false;
        }
        if (n3 >= 128) {
            return false;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        return hv2.a(n2 & 15, n3, n4 & 15, n5, n6);
    }

    public boolean a(int n2, int n3, int n4, int n5) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return false;
        }
        if (n3 < 0) {
            return false;
        }
        if (n3 >= 128) {
            return false;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        return hv2.a(n2 & 15, n3, n4 & 15, n5);
    }

    public hz c(int n2, int n3, int n4) {
        int n5 = this.a(n2, n3, n4);
        if (n5 == 0) {
            return hz.a;
        }
        return Block.n[n5].bl;
    }

    public int b(int n2, int n3, int n4) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return 0;
        }
        if (n3 < 0) {
            return 0;
        }
        if (n3 >= 128) {
            return 0;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        return hv2.b(n2 &= 15, n3, n4 &= 15);
    }

    public void b(int n2, int n3, int n4, int n5) {
        this.c(n2, n3, n4, n5);
    }

    public boolean c(int n2, int n3, int n4, int n5) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return false;
        }
        if (n3 < 0) {
            return false;
        }
        if (n3 >= 128) {
            return false;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        hv2.b(n2 &= 15, n3, n4 &= 15, n5);
        return true;
    }

    public boolean d(int n2, int n3, int n4, int n5) {
        if (this.a(n2, n3, n4, n5)) {
            this.e(n2, n3, n4, n5);
            return true;
        }
        return false;
    }

    public boolean b(int n2, int n3, int n4, int n5, int n6) {
        if (this.a(n2, n3, n4, n5, n6)) {
            this.e(n2, n3, n4, n5);
            return true;
        }
        return false;
    }

    public void f(int n2, int n3, int n4) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(n2, n3, n4);
        }
    }

    protected void e(int n2, int n3, int n4, int n5) {
        this.f(n2, n3, n4);
        this.g(n2, n3, n4, n5);
    }

    public void f(int n2, int n3, int n4, int n5) {
        if (n4 > n5) {
            int n6 = n5;
            n5 = n4;
            n4 = n6;
        }
        this.b(n2, n4, n3, n2, n5, n3);
    }

    public void b(int n2, int n3, int n4, int n5, int n6, int n7) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(n2, n3, n4, n5, n6, n7);
        }
    }

    public void g(int n2, int n3, int n4, int n5) {
        this.k(n2 - 1, n3, n4, n5);
        this.k(n2 + 1, n3, n4, n5);
        this.k(n2, n3 - 1, n4, n5);
        this.k(n2, n3 + 1, n4, n5);
        this.k(n2, n3, n4 - 1, n5);
        this.k(n2, n3, n4 + 1, n5);
    }

    private void k(int n2, int n3, int n4, int n5) {
        if (this.g || this.t) {
            return;
        }
        Block et2 = Block.n[this.a(n2, n3, n4)];
        if (et2 != null) {
            et2.b(this, n2, n3, n4, n5);
        }
    }

    public boolean g(int n2, int n3, int n4) {
        return this.b(n2 >> 4, n4 >> 4).c(n2 & 15, n3, n4 & 15);
    }

    public int h(int n2, int n3, int n4) {
        return this.a(n2, n3, n4, true);
    }

    public int a(int n2, int n3, int n4, boolean bl2) {
        int n5;
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return 15;
        }
        if (bl2 && ((n5 = this.a(n2, n3, n4)) == Block.ak.ba || n5 == Block.aA.ba)) {
            int n6 = this.a(n2, n3 + 1, n4, false);
            int n7 = this.a(n2 + 1, n3, n4, false);
            int n8 = this.a(n2 - 1, n3, n4, false);
            int n9 = this.a(n2, n3, n4 + 1, false);
            int n10 = this.a(n2, n3, n4 - 1, false);
            if (n7 > n6) {
                n6 = n7;
            }
            if (n8 > n6) {
                n6 = n8;
            }
            if (n9 > n6) {
                n6 = n9;
            }
            if (n10 > n6) {
                n6 = n10;
            }
            return n6;
        }
        if (n3 < 0) {
            return 0;
        }
        if (n3 >= 128) {
            n5 = 15 - this.d;
            if (n5 < 0) {
                n5 = 0;
            }
            return n5;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        return hv2.c(n2 &= 15, n3, n4 &= 15, this.d);
    }

    public boolean i(int n2, int n3, int n4) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return false;
        }
        if (n3 < 0) {
            return false;
        }
        if (n3 >= 128) {
            return true;
        }
        if (!this.g(n2 >> 4, n4 >> 4)) {
            return false;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        return hv2.c(n2 &= 15, n3, n4 &= 15);
    }

    public int c(int n2, int n3) {
        if (n2 < -32000000 || n3 < -32000000 || n2 >= 32000000 || n3 > 32000000) {
            return 0;
        }
        if (!this.g(n2 >> 4, n3 >> 4)) {
            return 0;
        }
        hv hv2 = this.b(n2 >> 4, n3 >> 4);
        return hv2.b(n2 & 15, n3 & 15);
    }

    public void a(cr cr2, int n2, int n3, int n4, int n5) {
        int n6;
        if (!this.e(n2, n3, n4)) {
            return;
        }
        if (cr2 == cr.a) {
            if (this.i(n2, n3, n4)) {
                n5 = 15;
            }
        } else if (cr2 == cr.b && Block.s[n6 = this.a(n2, n3, n4)] > n5) {
            n5 = Block.s[n6];
        }
        if (this.a(cr2, n2, n3, n4) != n5) {
            this.a(cr2, n2, n3, n4, n2, n3, n4);
        }
    }

    public int a(cr cr2, int n2, int n3, int n4) {
        if (n3 < 0 || n3 >= 128 || n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return cr2.c;
        }
        int n5 = n2 >> 4;
        int n6 = n4 >> 4;
        if (!this.g(n5, n6)) {
            return 0;
        }
        hv hv2 = this.b(n5, n6);
        return hv2.a(cr2, n2 & 15, n3, n4 & 15);
    }

    public void b(cr cr2, int n2, int n3, int n4, int n5) {
        if (n2 < -32000000 || n4 < -32000000 || n2 >= 32000000 || n4 > 32000000) {
            return;
        }
        if (n3 < 0) {
            return;
        }
        if (n3 >= 128) {
            return;
        }
        if (!this.g(n2 >> 4, n4 >> 4)) {
            return;
        }
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        hv2.a(cr2, n2 & 15, n3, n4 & 15, n5);
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(n2, n3, n4);
        }
    }

    public float j(int n2, int n3, int n4) {
        return h[this.h(n2, n3, n4)];
    }

    public boolean a() {
        return this.d < 4;
    }

    public fe a(Vec3D as2, Vec3D as3) {
        return this.a(as2, as3, false);
    }

    public fe a(Vec3D as2, Vec3D as3, boolean bl2) {
        if (Double.isNaN(as2.a) || Double.isNaN(as2.b) || Double.isNaN(as2.c)) {
            return null;
        }
        if (Double.isNaN(as3.a) || Double.isNaN(as3.b) || Double.isNaN(as3.c)) {
            return null;
        }
        int n2 = MathHelper.b(as3.a);
        int n3 = MathHelper.b(as3.b);
        int n4 = MathHelper.b(as3.c);
        int n5 = MathHelper.b(as2.a);
        int n6 = MathHelper.b(as2.b);
        int n7 = MathHelper.b(as2.c);
        int n8 = 20;
        while (n8-- >= 0) {
            fe fe2;
            if (Double.isNaN(as2.a) || Double.isNaN(as2.b) || Double.isNaN(as2.c)) {
                return null;
            }
            if (n5 == n2 && n6 == n3 && n7 == n4) {
                return null;
            }
            double d2 = 999.0;
            double d3 = 999.0;
            double d4 = 999.0;
            if (n2 > n5) {
                d2 = (double)n5 + 1.0;
            }
            if (n2 < n5) {
                d2 = (double)n5 + 0.0;
            }
            if (n3 > n6) {
                d3 = (double)n6 + 1.0;
            }
            if (n3 < n6) {
                d3 = (double)n6 + 0.0;
            }
            if (n4 > n7) {
                d4 = (double)n7 + 1.0;
            }
            if (n4 < n7) {
                d4 = (double)n7 + 0.0;
            }
            double d5 = 999.0;
            double d6 = 999.0;
            double d7 = 999.0;
            double d8 = as3.a - as2.a;
            double d9 = as3.b - as2.b;
            double d10 = as3.c - as2.c;
            if (d2 != 999.0) {
                d5 = (d2 - as2.a) / d8;
            }
            if (d3 != 999.0) {
                d6 = (d3 - as2.b) / d9;
            }
            if (d4 != 999.0) {
                d7 = (d4 - as2.c) / d10;
            }
            int n9 = 0;
            if (d5 < d6 && d5 < d7) {
                n9 = n2 > n5 ? 4 : 5;
                as2.a = d2;
                as2.b += d9 * d5;
                as2.c += d10 * d5;
            } else if (d6 < d7) {
                n9 = n3 > n6 ? 0 : 1;
                as2.a += d8 * d6;
                as2.b = d3;
                as2.c += d10 * d6;
            } else {
                n9 = n4 > n7 ? 2 : 3;
                as2.a += d8 * d7;
                as2.b += d9 * d7;
                as2.c = d4;
            }
            Vec3D as4 = Vec3D.b(as2.a, as2.b, as2.c);
            as4.a = MathHelper.b(as2.a);
            n5 = (int)as4.a;
            if (n9 == 5) {
                --n5;
                as4.a += 1.0;
            }
            as4.b = MathHelper.b(as2.b);
            n6 = (int)as4.b;
            if (n9 == 1) {
                --n6;
                as4.b += 1.0;
            }
            as4.c = MathHelper.b(as2.c);
            n7 = (int)as4.c;
            if (n9 == 3) {
                --n7;
                as4.c += 1.0;
            }
            int n10 = this.a(n5, n6, n7);
            int n11 = this.b(n5, n6, n7);
            Block et2 = Block.n[n10];
            if (n10 <= 0 || !et2.a(n11, bl2) || (fe2 = et2.a(this, n5, n6, n7, as2, as3)) == null) continue;
            return fe2;
        }
        return null;
    }

    public void a(Entity db2, String string, float f2, float f3) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(string, db2.k, db2.l - (double)db2.B, db2.m, f2, f3);
        }
    }

    public void a(double d2, double d3, double d4, String string, float f2, float f3) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(string, d2, d3, d4, f2, f3);
        }
    }

    public void a(String string, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(string, n2, n3, n4);
        }
    }

    public void a(String string, double d2, double d3, double d4, double d5, double d6, double d7) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(string, d2, d3, d4, d5, d6, d7);
        }
    }

    public boolean a(Entity entity) {
        int n2 = MathHelper.b(entity.k / 16.0);
        int n3 = MathHelper.b(entity.m / 16.0);
        boolean bl2 = false;
        if (entity instanceof EntityPlayer) {
            bl2 = true;
        }
        if (bl2 || this.g(n2, n3)) {
            if (entity instanceof EntityPlayer) {
                this.i.add((EntityPlayer)entity);
                System.out.println("Player count: " + this.i.size());
            }
            this.b(n2, n3).a(entity);
            this.v.add(entity);
            this.b(entity);
            return true;
        }
        return false;
    }

    protected void b(Entity db2) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).a(db2);
        }
    }

    protected void c(Entity db2) {
        for (int i2 = 0; i2 < this.D.size(); ++i2) {
            ((ba)this.D.get(i2)).b(db2);
        }
    }

    public void d(Entity entity) {
        entity.i();
        if (entity instanceof EntityPlayer) {
            this.i.remove((EntityPlayer)entity);
            System.out.println("Player count: " + this.i.size());
        }
    }

    public void a(ba ba2) {
        this.D.add(ba2);
    }

    public List a(Entity db2, AxisAlignedBB cy2) {
        this.H.clear();
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n6; i3 < n7; ++i3) {
                if (!this.e(i2, 64, i3)) continue;
                for (int i4 = n4 - 1; i4 < n5; ++i4) {
                    Block et2 = Block.n[this.a(i2, i4, i3)];
                    if (et2 == null) continue;
                    et2.a(this, i2, i4, i3, cy2, this.H);
                }
            }
        }
        double d2 = 0.25;
        List list = this.b(db2, cy2.b(d2, d2, d2));
        for (int i5 = 0; i5 < list.size(); ++i5) {
            AxisAlignedBB cy3 = ((Entity)list.get(i5)).l();
            if (cy3 != null && cy3.a(cy2)) {
                this.H.add(cy3);
            }
            if ((cy3 = db2.d((Entity)list.get(i5))) == null || !cy3.a(cy2)) continue;
            this.H.add(cy3);
        }
        return this.H;
    }

    public int a(float f2) {
        float f3 = this.b(f2);
        float f4 = 1.0f - (MathHelper.b(f3 * 3.1415927f * 2.0f) * 2.0f + 0.5f);
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        return (int)(f4 * 11.0f);
    }

    public float b(float f2) {
        int n2 = (int)(this.b % 24000L);
        float f3 = ((float)n2 + f2) / 24000.0f - 0.25f;
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        float f4 = f3;
        f3 = 1.0f - (float)((Math.cos((double)f3 * 3.141592653589793) + 1.0) / 2.0);
        f3 = f4 + (f3 - f4) / 3.0f;
        return f3;
    }

    public int d(int n2, int n3) {
        hv hv2 = this.a(n2, n3);
        n2 &= 15;
        n3 &= 15;
        for (int i2 = 127; i2 > 0; --i2) {
            int n4 = hv2.a(n2, i2, n3);
            if (n4 == 0 || !Block.n[n4].bl.c() && !Block.n[n4].bl.d()) {
                continue;
            }
            return i2 + 1;
        }
        return -1;
    }

    public void h(int n2, int n3, int n4, int n5) {
        bq bq2 = new bq(n2, n3, n4, n5);
        int n6 = 8;
        if (this.a(n2 - n6, n3 - n6, n4 - n6, n2 + n6, n3 + n6, n4 + n6)) {
            if (n5 > 0) {
                bq2.a((long)Block.n[n5].c() + this.b);
            }
            if (!this.y.contains(bq2)) {
                this.y.add(bq2);
                this.x.add(bq2);
            }
        }
    }

    public void b() {
    	Entity entity;
        int n2;
        int n3;
        int n4;
        this.v.removeAll(this.w);
        for (n3 = 0; n3 < this.w.size(); ++n3) {
            entity = (Entity)this.w.get(n3);
            n4 = entity.Z;
            n2 = entity.ab;
            if (!entity.Y || !this.g(n4, n2)) continue;
            this.b(n4, n2).b(entity);
        }
        for (n3 = 0; n3 < this.w.size(); ++n3) {
            this.c((Entity)this.w.get(n3));
        }
        this.w.clear();
        for (n3 = 0; n3 < this.v.size(); ++n3) {
            entity = (Entity)this.v.get(n3);
            if (entity.f != null) {
                if (!entity.f.A && entity.f.e == entity) continue;
                entity.f.e = null;
                entity.f = null;
            }
            if (!entity.A) {
                this.e(entity);
            }
            if (!entity.A) continue;
            n4 = entity.Z;
            n2 = entity.ab;
            if (entity.Y && this.g(n4, n2)) {
                this.b(n4, n2).b(entity);
            }
            this.v.remove(n3--);
            this.c(entity);
        }
        for (n3 = 0; n3 < this.a.size(); ++n3) {
            TileEntity tileentity = (TileEntity)this.a.get(n3);
            tileentity.b();
        }
    }

    protected void e(Entity db2) {
        int n2;
        int n3;
        int n4 = MathHelper.b(db2.k);
        if (!this.a(n4 - (n2 = 16), 0, (n3 = MathHelper.b(db2.m)) - n2, n4 + n2, 128, n3 + n2)) {
            return;
        }
        db2.I = db2.k;
        db2.J = db2.l;
        db2.K = db2.m;
        db2.s = db2.q;
        db2.t = db2.r;
        if (db2.f != null) {
            db2.t();
        } else {
            db2.b_();
        }
        int n5 = MathHelper.b(db2.k / 16.0);
        int n6 = MathHelper.b(db2.l / 16.0);
        int n7 = MathHelper.b(db2.m / 16.0);
        if (!db2.Y || db2.Z != n5 || db2.aa != n6 || db2.ab != n7) {
            if (db2.Y && this.g(db2.Z, db2.ab)) {
                this.b(db2.Z, db2.ab).a(db2, db2.aa);
            }
            if (this.g(n5, n7)) {
                this.b(n5, n7).a(db2);
            } else {
                db2.Y = false;
                System.out.println("Removing entity because it's not in a chunk!!");
                db2.i();
            }
        }
        if (db2.e != null) {
            if (db2.e.A || db2.e.f != db2) {
                db2.e.f = null;
                db2.e = null;
            } else {
                this.e(db2.e);
            }
        }
        if (Double.isNaN(db2.k) || Double.isInfinite(db2.k)) {
            db2.k = db2.I;
        }
        if (Double.isNaN(db2.l) || Double.isInfinite(db2.l)) {
            db2.l = db2.J;
        }
        if (Double.isNaN(db2.m) || Double.isInfinite(db2.m)) {
            db2.m = db2.K;
        }
        if (Double.isNaN(db2.r) || Double.isInfinite(db2.r)) {
            db2.r = db2.t;
        }
        if (Double.isNaN(db2.q) || Double.isInfinite(db2.q)) {
            db2.q = db2.s;
        }
    }

    public boolean a(AxisAlignedBB cy2) {
        List list = this.b(null, cy2);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Entity db2 = (Entity)list.get(i2);
            if (db2.A || !db2.d) continue;
            return false;
        }
        return true;
    }

    public boolean b(AxisAlignedBB cy2) {
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        if (cy2.a < 0.0) {
            --n2;
        }
        if (cy2.b < 0.0) {
            --n4;
        }
        if (cy2.c < 0.0) {
            --n6;
        }
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    Block et2 = Block.n[this.a(i2, i3, i4)];
                    if (et2 == null || !et2.bl.d()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean c(AxisAlignedBB cy2) {
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    int n8 = this.a(i2, i3, i4);
                    if (n8 != Block.ar.ba && n8 != Block.C.ba && n8 != Block.D.ba) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(AxisAlignedBB cy2, hz hz2, Entity db2) {
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        boolean bl2 = false;
        Vec3D as2 = Vec3D.b(0.0, 0.0, 0.0);
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    double d2;
                    Block et2 = Block.n[this.a(i2, i3, i4)];
                    if (et2 == null || et2.bl != hz2 || (double)n5 < (d2 = (double)((float)(i3 + 1) - cg.b(this.b(i2, i3, i4))))) continue;
                    bl2 = true;
                    et2.a(this, i2, i3, i4, db2, as2);
                }
            }
        }
        if (as2.c() > 0.0) {
            as2 = as2.b();
            double d3 = 0.004;
            db2.n += as2.a * d3;
            db2.o += as2.b * d3;
            db2.p += as2.c * d3;
        }
        return bl2;
    }

    public boolean a(AxisAlignedBB cy2, hz hz2) {
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    Block et2 = Block.n[this.a(i2, i3, i4)];
                    if (et2 == null || et2.bl != hz2) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(AxisAlignedBB cy2, hz hz2) {
        int n2 = MathHelper.b(cy2.a);
        int n3 = MathHelper.b(cy2.d + 1.0);
        int n4 = MathHelper.b(cy2.b);
        int n5 = MathHelper.b(cy2.e + 1.0);
        int n6 = MathHelper.b(cy2.c);
        int n7 = MathHelper.b(cy2.f + 1.0);
        for (int i2 = n2; i2 < n3; ++i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    Block et2 = Block.n[this.a(i2, i3, i4)];
                    if (et2 == null || et2.bl != hz2) continue;
                    int n8 = this.b(i2, i3, i4);
                    double d2 = i3 + 1;
                    if (n8 < 8) {
                        d2 = (double)(i3 + 1) - (double)n8 / 8.0;
                    }
                    if (d2 < cy2.b) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public void a(Entity db2, double d2, double d3, double d4, float f2) {
        new br().a(this, db2, d2, d3, d4, f2);
    }

    public float a(Vec3D as2, AxisAlignedBB cy2) {
        double d2 = 1.0 / ((cy2.d - cy2.a) * 2.0 + 1.0);
        double d3 = 1.0 / ((cy2.e - cy2.b) * 2.0 + 1.0);
        double d4 = 1.0 / ((cy2.f - cy2.c) * 2.0 + 1.0);
        int n2 = 0;
        int n3 = 0;
        float f2 = 0.0f;
        while (f2 <= 1.0f) {
            float f3 = 0.0f;
            while (f3 <= 1.0f) {
                float f4 = 0.0f;
                while (f4 <= 1.0f) {
                    double d5 = cy2.a + (cy2.d - cy2.a) * (double)f2;
                    double d6 = cy2.b + (cy2.e - cy2.b) * (double)f3;
                    double d7 = cy2.c + (cy2.f - cy2.c) * (double)f4;
                    if (this.a(Vec3D.b(d5, d6, d7), as2) == null) {
                        ++n2;
                    }
                    ++n3;
                    f4 = (float)((double)f4 + d4);
                }
                f3 = (float)((double)f3 + d3);
            }
            f2 = (float)((double)f2 + d2);
        }
        return (float)n2 / (float)n3;
    }

    public TileEntity k(int n2, int n3, int n4) {
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        if (hv2 != null) {
            return hv2.d(n2 & 15, n3, n4 & 15);
        }
        return null;
    }

    public void a(int n2, int n3, int n4, TileEntity ap2) {
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        if (hv2 != null) {
            hv2.a(n2 & 15, n3, n4 & 15, ap2);
        }
    }

    public void l(int n2, int n3, int n4) {
        hv hv2 = this.b(n2 >> 4, n4 >> 4);
        if (hv2 != null) {
            hv2.e(n2 & 15, n3, n4 & 15);
        }
    }

    public boolean d(int n2, int n3, int n4) {
        Block et2 = Block.n[this.a(n2, n3, n4)];
        if (et2 == null) {
            return false;
        }
        return et2.b();
    }

    public boolean c() {
        int n2 = 1000;
        while (this.u.size() > 0) {
            if (--n2 <= 0) {
                return true;
            }
            ((dg)this.u.remove(this.u.size() - 1)).a(this);
        }
        return false;
    }

    public void a(cr cr2, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.a(cr2, n2, n3, n4, n5, n6, n7, true);
    }

    public void a(cr cr2, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl2) {
        int n8 = (n5 + n2) / 2;
        int n9 = (n7 + n4) / 2;
        if (!this.e(n8, 64, n9)) {
            return;
        }
        int n10 = this.u.size();
        if (bl2) {
            int n11 = 4;
            if (n11 > n10) {
                n11 = n10;
            }
            for (int i2 = 0; i2 < n11; ++i2) {
                dg dg2 = (dg)this.u.get(this.u.size() - i2 - 1);
                if (dg2.a != cr2 || !dg2.a(n2, n3, n4, n5, n6, n7)) continue;
                return;
            }
        }
        this.u.add(new dg(cr2, n2, n3, n4, n5, n6, n7));
        if (this.u.size() > 100000) {
            while (this.u.size() > 50000) {
                this.c();
            }
        }
    }

    public void d() {
        int n2 = this.a(1.0f);
        if (n2 != this.d) {
            this.d = n2;
        }
    }

    public void e() {
        this.E.a();
        int n2 = this.a(1.0f);
        if (n2 != this.d) {
            this.d = n2;
            for (int i2 = 0; i2 < this.D.size(); ++i2) {
                ((ba)this.D.get(i2)).a();
            }
        }
        ++this.b;
        if (this.b % 20L == 0L) {
            this.a(false, null);
        }
        this.a(false);
        this.f();
    }

    protected void f() {
        int n2;
        int n3;
        int n4;
        int n5;
        this.I.clear();
        for (int i2 = 0; i2 < this.i.size(); ++i2) {
            EntityPlayer entityplayer = (EntityPlayer)this.i.get(i2);
            n2 = MathHelper.b(entityplayer.k / 16.0);
            n4 = MathHelper.b(entityplayer.m / 16.0);
            int n6 = 9;
            for (n5 = - n6; n5 <= n6; ++n5) {
                for (n3 = - n6; n3 <= n6; ++n3) {
                    this.I.add(new ih(n5 + n2, n3 + n4));
                }
            }
        }
        if (this.J > 0) {
            --this.J;
        }
        for (Object object : this.I) {
            int n7;
            int n8;
            int n9;
            n2 = ((ih)object).a * 16;
            n4 = ((ih)object).b * 16;
            hv hv2 = this.b(((ih)object).a, ((ih)object).b);
            if (this.J == 0) {
                EntityPlayer entityplayer;
                this.e = this.e * 3 + this.f;
                n5 = this.e >> 2;
                n3 = n5 & 15;
                n8 = n5 >> 8 & 15;
                n9 = n5 >> 16 & 127;
                n7 = hv2.a(n3, n9, n8);
                if (n7 == 0 && this.h(n3, n9, n8) <= this.k.nextInt(8) && this.a(cr.a, n3, n9, n8) <= 0 && (entityplayer = this.a((double)n3 + 0.5, (double)n9 + 0.5, (double)n8 + 0.5, 8.0)) != null && entityplayer.d((double)(n3 += n2) + 0.5, (double)n9 + 0.5, (double)(n8 += n4) + 0.5) > 4.0) {
                    this.a((double)n3 + 0.5, (double)n9 + 0.5, (double)n8 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.k.nextFloat() * 0.2f);
                    this.J = this.k.nextInt(12000) + 6000;
                }
            }
            if (this.c && this.k.nextInt(4) == 0) {
                this.e = this.e * 3 + this.f;
                n5 = this.e >> 2;
                n3 = n5 & 15;
                n8 = n5 >> 8 & 15;
                n9 = this.d(n3 + n2, n8 + n4);
                if (n9 >= 0 && n9 < 128 && hv2.a(cr.b, n3, n9, n8) < 10) {
                    n7 = hv2.a(n3, n9 - 1, n8);
                    if (hv2.a(n3, n9, n8) == 0 && n7 != 0 && n7 != Block.aT.ba && Block.n[n7].bl.c()) {
                        this.d(n3 + n2, n9, n8 + n4, Block.aS.ba);
                    }
                    if (n7 == Block.B.ba && hv2.b(n3, n9 - 1, n8) == 0) {
                        this.d(n3 + n2, n9 - 1, n8 + n4, Block.aT.ba);
                    }
                }
            }
            for (n5 = 0; n5 < 80; ++n5) {
                this.e = this.e * 3 + this.f;
                n3 = this.e >> 2;
                n8 = n3 & 15;
                n9 = n3 >> 8 & 15;
                n7 = n3 >> 16 & 127;
                byte by2 = hv2.b[n8 << 11 | n9 << 7 | n7];
                if (!Block.o[by2]) continue;
                Block.n[by2].a(this, n8 + n2, n7, n9 + n4, this.k);
            }
        }
    }

    public boolean a(boolean bl2) {
        int n2 = this.x.size();
        if (n2 != this.y.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (n2 > 1000) {
            n2 = 1000;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            bq bq2 = (bq)this.x.first();
            if (!bl2 && bq2.e > this.b) break;
            this.x.remove(bq2);
            this.y.remove(bq2);
            int n4 = 8;
            if (!this.a(bq2.a - n4, bq2.b - n4, bq2.c - n4, bq2.a + n4, bq2.b + n4, bq2.c + n4) || (n3 = this.a(bq2.a, bq2.b, bq2.c)) != bq2.d || n3 <= 0) continue;
            Block.n[n3].a(this, bq2.a, bq2.b, bq2.c, this.k);
        }
        return this.x.size() != 0;
    }

    public List b(Entity db2, AxisAlignedBB cy2) {
        this.K.clear();
        int n2 = MathHelper.b((cy2.a - 2.0) / 16.0);
        int n3 = MathHelper.b((cy2.d + 2.0) / 16.0);
        int n4 = MathHelper.b((cy2.c - 2.0) / 16.0);
        int n5 = MathHelper.b((cy2.f + 2.0) / 16.0);
        for (int i2 = n2; i2 <= n3; ++i2) {
            for (int i3 = n4; i3 <= n5; ++i3) {
                if (!this.g(i2, i3)) continue;
                this.b(i2, i3).a(db2, cy2, this.K);
            }
        }
        return this.K;
    }

    public List a(Class class_, AxisAlignedBB cy2) {
        int n2 = MathHelper.b((cy2.a - 2.0) / 16.0);
        int n3 = MathHelper.b((cy2.d + 2.0) / 16.0);
        int n4 = MathHelper.b((cy2.c - 2.0) / 16.0);
        int n5 = MathHelper.b((cy2.f + 2.0) / 16.0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = n2; i2 <= n3; ++i2) {
            for (int i3 = n4; i3 <= n5; ++i3) {
                if (!this.g(i2, i3)) continue;
                this.b(i2, i3).a(class_, cy2, arrayList);
            }
        }
        return arrayList;
    }

    public void m(int n2, int n3, int n4) {
        if (this.e(n2, n3, n4)) {
            this.a(n2, n4).e();
        }
    }

    public void a(List list) {
        this.v.addAll(list);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            this.b((Entity)list.get(i2));
        }
    }

    public void b(List list) {
        this.w.addAll(list);
    }

    public boolean a(int n2, int n3, int n4, int n5, boolean bl2) {
        int n6 = this.a(n3, n4, n5);
        Block et2 = Block.n[n6];
        Block et3 = Block.n[n2];
        AxisAlignedBB cy2 = et3.d(this, n3, n4, n5);
        if (bl2) {
            cy2 = null;
        }
        if (cy2 != null && !this.a(cy2)) {
            return false;
        }
        if (et2 == Block.A || et2 == Block.B || et2 == Block.C || et2 == Block.D || et2 == Block.ar || et2 == Block.aS) {
            return true;
        }
        if (n2 > 0 && et2 == null && et3.a(this, n3, n4, n5)) {
            return true;
        }
        return false;
    }

    public bx a(Entity db2, Entity db3, float f2) {
        int n2 = MathHelper.b(db2.k);
        int n3 = MathHelper.b(db2.l);
        int n4 = MathHelper.b(db2.m);
        int n5 = (int)(f2 + 16.0f);
        int n6 = n2 - n5;
        int n7 = n3 - n5;
        int n8 = n4 - n5;
        int n9 = n2 + n5;
        int n10 = n3 + n5;
        int n11 = n4 + n5;
        dj dj2 = new dj(this, n6, n7, n8, n9, n10, n11);
        return new ed(dj2).a(db2, db3, f2);
    }

    public bx a(Entity db2, int n2, int n3, int n4, float f2) {
        int n5 = MathHelper.b(db2.k);
        int n6 = MathHelper.b(db2.l);
        int n7 = MathHelper.b(db2.m);
        int n8 = (int)(f2 + 8.0f);
        int n9 = n5 - n8;
        int n10 = n6 - n8;
        int n11 = n7 - n8;
        int n12 = n5 + n8;
        int n13 = n6 + n8;
        int n14 = n7 + n8;
        dj dj2 = new dj(this, n9, n10, n11, n12, n13, n14);
        return new ed(dj2).a(db2, n2, n3, n4, f2);
    }

    public boolean i(int n2, int n3, int n4, int n5) {
        int n6 = this.a(n2, n3, n4);
        if (n6 == 0) {
            return false;
        }
        return Block.n[n6].d(this, n2, n3, n4, n5);
    }

    public boolean n(int n2, int n3, int n4) {
        if (this.i(n2, n3 - 1, n4, 0)) {
            return true;
        }
        if (this.i(n2, n3 + 1, n4, 1)) {
            return true;
        }
        if (this.i(n2, n3, n4 - 1, 2)) {
            return true;
        }
        if (this.i(n2, n3, n4 + 1, 3)) {
            return true;
        }
        if (this.i(n2 - 1, n3, n4, 4)) {
            return true;
        }
        if (this.i(n2 + 1, n3, n4, 5)) {
            return true;
        }
        return false;
    }

    public boolean j(int n2, int n3, int n4, int n5) {
        if (this.d(n2, n3, n4)) {
            return this.n(n2, n3, n4);
        }
        int n6 = this.a(n2, n3, n4);
        if (n6 == 0) {
            return false;
        }
        return Block.n[n6].b((IBlockAccess)this, n2, n3, n4, n5);
    }

    public boolean o(int n2, int n3, int n4) {
        if (this.j(n2, n3 - 1, n4, 0)) {
            return true;
        }
        if (this.j(n2, n3 + 1, n4, 1)) {
            return true;
        }
        if (this.j(n2, n3, n4 - 1, 2)) {
            return true;
        }
        if (this.j(n2, n3, n4 + 1, 3)) {
            return true;
        }
        if (this.j(n2 - 1, n3, n4, 4)) {
            return true;
        }
        if (this.j(n2 + 1, n3, n4, 5)) {
            return true;
        }
        return false;
    }

    public EntityPlayer a(Entity entity, double d2) {
        return this.a(entity.k, entity.l, entity.m, d2);
    }

    public EntityPlayer a(double d2, double d3, double d4, double d5) {
        double d6 = -1.0;
        EntityPlayer entityplayer = null;
        for (int i2 = 0; i2 < this.i.size(); ++i2) {
            EntityPlayer entityplayer2 = (EntityPlayer)this.i.get(i2);
            double d7 = entityplayer2.d(d2, d3, d4);
            if (d5 >= 0.0 && d7 >= d5 * d5 || d6 != -1.0 && d7 >= d6) continue;
            d6 = d7;
            entityplayer = entityplayer2;
        }
        return entityplayer;
    }

    public byte[] c(int n2, int n3, int n4, int n5, int n6, int n7) {
        byte[] arrby = new byte[n5 * n6 * n7 * 5 / 2];
        int n8 = n2 >> 4;
        int n9 = n4 >> 4;
        int n10 = n2 + n5 - 1 >> 4;
        int n11 = n4 + n7 - 1 >> 4;
        int n12 = 0;
        int n13 = n3;
        int n14 = n3 + n6;
        if (n13 < 0) {
            n13 = 0;
        }
        if (n14 > 128) {
            n14 = 128;
        }
        for (int i2 = n8; i2 <= n10; ++i2) {
            int n15 = n2 - i2 * 16;
            int n16 = n2 + n5 - i2 * 16;
            if (n15 < 0) {
                n15 = 0;
            }
            if (n16 > 16) {
                n16 = 16;
            }
            for (int i3 = n9; i3 <= n11; ++i3) {
                int n17 = n4 - i3 * 16;
                int n18 = n4 + n7 - i3 * 16;
                if (n17 < 0) {
                    n17 = 0;
                }
                if (n18 > 16) {
                    n18 = 16;
                }
                n12 = this.b(i2, i3).a(arrby, n15, n13, n17, n16, n14, n18, n12);
            }
        }
        return arrby;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void g() {
        try {
            File file = new File(this.F, "session.lock");
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                if (dataInputStream.readLong() != this.C) {
                    throw new er("The save is being accessed from another location, aborting");
                }
            }
            finally {
                dataInputStream.close();
            }
        }
        catch (IOException iOException) {
            throw new er("Failed to check session lock, aborting");
        }
    }

    static {
        float f2 = 0.05f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f3 = 1.0f - (float)i2 / 15.0f;
            World.h[i2] = (1.0f - f3) / (f3 * 3.0f + 1.0f) * (1.0f - f2) + f2;
        }
    }
}

