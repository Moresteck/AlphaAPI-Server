/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.Random;

public class Block {
    public static final bl e = new bl("stone", 1.0f, 1.0f);
    public static final bl f = new bl("wood", 1.0f, 1.0f);
    public static final bl g = new bl("gravel", 1.0f, 1.0f);
    public static final bl h = new bl("grass", 1.0f, 1.0f);
    public static final bl i = new bl("stone", 1.0f, 1.0f);
    public static final bl j = new bl("stone", 1.0f, 1.5f);
    public static final bl k = new aa("stone", 1.0f, 1.0f);
    public static final bl l = new bl("cloth", 1.0f, 1.0f);
    public static final bl m = new z("sand", 1.0f, 1.0f);
    public static final Block[] n = new Block[256];
    public static final boolean[] o = new boolean[256];
    public static final boolean[] p = new boolean[256];
    public static final int[] q = new int[256];
    public static final boolean[] r = new boolean[256];
    public static final int[] s = new int[256];
    public static final Block t = new cw(1, 1).c(1.5f).b(10.0f).a(i);
    public static final gl u = (gl)new gl(2).c(0.6f).a(h);
    public static final Block v = new al(3, 2).c(0.5f).a(g);
    public static final Block w = new Block(4, 16, hz.d).c(2.0f).b(10.0f).a(i);
    public static final Block x = new Block(5, 4, hz.c).c(2.0f).b(5.0f).a(f);
    public static final Block y = new ex(6, 15).c(0.0f).a(h);
    public static final Block z = new Block(7, 17, hz.d).c(-1.0f).b(6000000.0f).a(i);
    public static final Block A = new ai(8, hz.f).c(100.0f).c(3);
    public static final Block B = new v(9, hz.f).c(100.0f).c(3);
    public static final Block C = new ai(10, hz.g).c(0.0f).a(1.0f).c(255);
    public static final Block D = new v(11, hz.g).c(100.0f).a(1.0f).c(255);
    public static final Block E = new em(12, 18).c(0.5f).a(m);
    public static final Block F = new i(13, 19).c(0.6f).a(g);
    public static final Block G = new f(14, 32).c(3.0f).b(5.0f).a(i);
    public static final Block H = new f(15, 33).c(3.0f).b(5.0f).a(i);
    public static final Block I = new f(16, 34).c(3.0f).b(5.0f).a(i);
    public static final Block J = new fh(17).c(2.0f).a(f);
    public static final bn K = (bn)new bn(18, 52).c(0.2f).c(1).a(h);
    public static final Block L = new gv(19).c(0.6f).a(h);
    public static final Block M = new dt(20, 49, hz.o, false).c(0.3f).a(k);
    public static final Block N = null;
    public static final Block O = null;
    public static final Block P = null;
    public static final Block Q = null;
    public static final Block R = null;
    public static final Block S = null;
    public static final Block T = null;
    public static final Block U = null;
    public static final Block V = null;
    public static final Block W = null;
    public static final Block X = null;
    public static final Block Y = null;
    public static final Block Z = null;
    public static final Block aa = null;
    public static final Block ab = new Block(35, 64, hz.k).c(0.8f).a(l);
    public static final Block ac = null;
    public static final gb ad = (gb)new gb(37, 13).c(0.0f).a(h);
    public static final gb ae = (gb)new gb(38, 12).c(0.0f).a(h);
    public static final gb af = (gb)new dx(39, 29).c(0.0f).a(h).a(0.125f);
    public static final gb ag = (gb)new dx(40, 28).c(0.0f).a(h);
    public static final Block ah = new h(41, 39).c(3.0f).b(10.0f).a(j);
    public static final Block ai = new h(42, 38).c(5.0f).b(10.0f).a(j);
    public static final Block aj = new hy(43, true).c(2.0f).b(10.0f).a(i);
    public static final Block ak = new hy(44, false).c(2.0f).b(10.0f).a(i);
    public static final Block al = new Block(45, 7, hz.d).c(2.0f).b(10.0f).a(i);
    public static final Block am = new y(46, 8).c(0.0f).a(h);
    public static final Block an = new ew(47, 35).c(1.5f).a(f);
    public static final Block ao = new Block(48, 36, hz.d).c(2.0f).b(10.0f).a(i);
    public static final Block ap = new BlockObsidian(49, 37).c(10.0f).b(2000.0f).a(i);
    public static final Block aq = new fp(50, 80).c(0.0f).a(0.9375f).a(f);
    public static final hu ar = (hu)new hu(51, 31).c(0.0f).a(1.0f).a(f);
    public static final Block as = new bv(52, 65).c(5.0f).a(j);
    public static final Block at = new df(53, x);
    public static final Block au = new b(54).c(2.5f).a(f);
    public static final Block av = new cz(55, 84).c(0.0f).a(e);
    public static final Block aw = new f(56, 50).c(3.0f).b(5.0f).a(i);
    public static final Block ax = new h(57, 40).c(5.0f).b(10.0f).a(j);
    public static final Block ay = new ds(58).c(2.5f).a(f);
    public static final Block az = new l(59, 88).c(0.0f).a(h);
    public static final Block aA = new fm(60).c(0.6f).a(g);
    public static final Block aB = new dm(61, false).c(3.5f).a(i);
    public static final Block aC = new dm(62, true).c(3.5f).a(i).a(0.875f);
    public static final Block aD = new eo(63, hp.class, true).c(1.0f).a(f);
    public static final Block aE = new hn(64, hz.c).c(3.0f).a(f);
    public static final Block aF = new cf(65, 83).c(0.4f).a(f);
    public static final Block aG = new ar(66, 128).c(0.7f).a(j);
    public static final Block aH = new df(67, w);
    public static final Block aI = new eo(68, hp.class, false).c(1.0f).a(f);
    public static final Block aJ = new hd(69, 96).c(0.5f).a(f);
    public static final Block aK = new at(70, Block.t.aZ, ck.b).c(0.5f).a(i);
    public static final Block aL = new hn(71, hz.e).c(5.0f).a(j);
    public static final Block aM = new at(72, Block.x.aZ, ck.a).c(0.5f).a(f);
    public static final Block aN = new aq(73, 51, false).c(3.0f).b(5.0f).a(i);
    public static final Block aO = new aq(74, 51, true).a(0.625f).c(3.0f).b(5.0f).a(i);
    public static final Block aP = new bt(75, 115, false).c(0.0f).a(f);
    public static final Block aQ = new bt(76, 99, true).c(0.0f).a(0.5f).a(f);
    public static final Block aR = new ag(77, Block.t.aZ).c(0.5f).a(i);
    public static final Block aS = new gm(78, 66).c(0.1f).a(l);
    public static final Block aT = new m(79, 67).c(0.5f).c(3).a(k);
    public static final Block aU = new s(80, 66).c(0.2f).a(l);
    public static final Block aV = new aj(81, 70).c(0.4f).a(l);
    public static final Block aW = new co(82, 72).c(0.6f).a(g);
    public static final Block aX = new ca(83, 73).c(0.0f).a(h);
    public static final Block aY = new dw(84, 74).c(2.0f).b(10.0f).a(i);
    public int aZ;
    public final int ba;
    protected float bb;
    protected float bc;
    public double bd;
    public double be;
    public double bf;
    public double bg;
    public double bh;
    public double bi;
    public bl bj = e;
    public float bk = 1.0f;
    public final hz bl;
    public float bm = 0.6f;

    protected Block(int n2, hz hz2) {
        if (n[n2] != null) {
            throw new IllegalArgumentException("Slot " + n2 + " is already occupied by " + n[n2] + " when adding " + this);
        }
        this.bl = hz2;
        Block.n[n2] = this;
        this.ba = n2;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        Block.p[n2] = this.b();
        Block.q[n2] = this.b() ? 255 : 0;
        Block.r[n2] = this.f();
    }

    protected Block(int n2, int n3, hz hz2) {
        this(n2, hz2);
        this.aZ = n3;
    }

    protected Block a(bl bl2) {
        this.bj = bl2;
        return this;
    }

    protected Block c(int n2) {
        Block.q[this.ba] = n2;
        return this;
    }

    protected Block a(float f2) {
        Block.s[this.ba] = (int)(15.0f * f2);
        return this;
    }

    protected Block b(float f2) {
        this.bc = f2 * 3.0f;
        return this;
    }

    private boolean f() {
        return false;
    }

    public int a() {
        return 0;
    }

    protected Block c(float f2) {
        this.bb = f2;
        if (this.bc < f2 * 5.0f) {
            this.bc = f2 * 5.0f;
        }
        return this;
    }

    protected void a(boolean bl2) {
        Block.o[this.ba] = bl2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.bd = f2;
        this.be = f3;
        this.bf = f4;
        this.bg = f5;
        this.bh = f6;
        this.bi = f7;
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        if (n5 == 0 && this.be > 0.0) {
            return true;
        }
        if (n5 == 1 && this.bh < 1.0) {
            return true;
        }
        if (n5 == 2 && this.bf > 0.0) {
            return true;
        }
        if (n5 == 3 && this.bi < 1.0) {
            return true;
        }
        if (n5 == 4 && this.bd > 0.0) {
            return true;
        }
        if (n5 == 5 && this.bg < 1.0) {
            return true;
        }
        return !hb2.d(n2, n3, n4);
    }

    public int a(int n2) {
        return this.aZ;
    }

    public void a(World world, int n2, int n3, int n4, AxisAlignedBB cy2, ArrayList arrayList) {
        AxisAlignedBB cy3 = this.d(world, n2, n3, n4);
        if (cy3 != null && cy2.a(cy3)) {
            arrayList.add(cy3);
        }
    }

    public AxisAlignedBB d(World world, int n2, int n3, int n4) {
        return AxisAlignedBB.b((double)n2 + this.bd, (double)n3 + this.be, (double)n4 + this.bf, (double)n2 + this.bg, (double)n3 + this.bh, (double)n4 + this.bi);
    }

    public boolean b() {
        return true;
    }

    public boolean a(int n2, boolean bl2) {
        return this.e();
    }

    public boolean e() {
        return true;
    }

    public void a(World world, int n2, int n3, int n4, Random random) {
    }

    public void a(World world, int n2, int n3, int n4, int n5) {
    }

    public void b(World world, int n2, int n3, int n4, int n5) {
    }

    public int c() {
        return 10;
    }

    public void e(World world, int n2, int n3, int n4) {
    }

    public void b(World world, int n2, int n3, int n4) {
    }

    public int a(Random random) {
        return 1;
    }

    public int a(int n2, Random random) {
        return this.ba;
    }

    public float a(EntityPlayer entityplayer) {
        if (this.bb < 0.0f) {
            return 0.0f;
        }
        if (!entityplayer.b(this)) {
            return 1.0f / this.bb / 100.0f;
        }
        return entityplayer.a(this) / this.bb / 30.0f;
    }

    public void a_(World world, int n2, int n3, int n4, int n5) {
        this.a(world, n2, n3, n4, n5, 1.0f);
    }

    public void a(World world, int n2, int n3, int n4, int n5, float f2) {
        if (world.t) {
            return;
        }
        int n6 = this.a(world.k);
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7;
            if (world.k.nextFloat() > f2 || (n7 = this.a(n5, world.k)) <= 0) continue;
            float f3 = 0.7f;
            double d2 = (double)(world.k.nextFloat() * f3) + (double)(1.0f - f3) * 0.5;
            double d3 = (double)(world.k.nextFloat() * f3) + (double)(1.0f - f3) * 0.5;
            double d4 = (double)(world.k.nextFloat() * f3) + (double)(1.0f - f3) * 0.5;
            fa fa2 = new fa(world, (double)n2 + d2, (double)n3 + d3, (double)n4 + d4, new gc(n7));
            fa2.ac = 10;
            world.a(fa2);
        }
    }

    public float a(Entity entity) {
        return this.bc / 5.0f;
    }

    public fe a(World world, int n2, int n3, int n4, Vec3D as2, Vec3D as3) {
        this.a((IBlockAccess)world, n2, n3, n4);
        as2 = as2.c(- n2, - n3, - n4);
        as3 = as3.c(- n2, - n3, - n4);
        Vec3D as4 = as2.a(as3, this.bd);
        Vec3D as5 = as2.a(as3, this.bg);
        Vec3D as6 = as2.b(as3, this.be);
        Vec3D as7 = as2.b(as3, this.bh);
        Vec3D as8 = as2.c(as3, this.bf);
        Vec3D as9 = as2.c(as3, this.bi);
        if (!this.a(as4)) {
            as4 = null;
        }
        if (!this.a(as5)) {
            as5 = null;
        }
        if (!this.b(as6)) {
            as6 = null;
        }
        if (!this.b(as7)) {
            as7 = null;
        }
        if (!this.c(as8)) {
            as8 = null;
        }
        if (!this.c(as9)) {
            as9 = null;
        }
        Vec3D as10 = null;
        if (as4 != null && (as10 == null || as2.a(as4) < as2.a(as10))) {
            as10 = as4;
        }
        if (as5 != null && (as10 == null || as2.a(as5) < as2.a(as10))) {
            as10 = as5;
        }
        if (as6 != null && (as10 == null || as2.a(as6) < as2.a(as10))) {
            as10 = as6;
        }
        if (as7 != null && (as10 == null || as2.a(as7) < as2.a(as10))) {
            as10 = as7;
        }
        if (as8 != null && (as10 == null || as2.a(as8) < as2.a(as10))) {
            as10 = as8;
        }
        if (as9 != null && (as10 == null || as2.a(as9) < as2.a(as10))) {
            as10 = as9;
        }
        if (as10 == null) {
            return null;
        }
        int n5 = -1;
        if (as10 == as4) {
            n5 = 4;
        }
        if (as10 == as5) {
            n5 = 5;
        }
        if (as10 == as6) {
            n5 = 0;
        }
        if (as10 == as7) {
            n5 = 1;
        }
        if (as10 == as8) {
            n5 = 2;
        }
        if (as10 == as9) {
            n5 = 3;
        }
        return new fe(n2, n3, n4, n5, as10.c(n2, n3, n4));
    }

    private boolean a(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.b >= this.be && vec3d.b <= this.bh && vec3d.c >= this.bf && vec3d.c <= this.bi;
    }

    private boolean b(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.a >= this.bd && vec3d.a <= this.bg && vec3d.c >= this.bf && vec3d.c <= this.bi;
    }

    private boolean c(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.a >= this.bd && vec3d.a <= this.bg && vec3d.b >= this.be && vec3d.b <= this.bh;
    }

    public void c(World world, int n2, int n3, int n4) {
    }

    public boolean a(World world, int n2, int n3, int n4) {
        int n5 = world.a(n2, n3, n4);
        return n5 == 0 || Block.n[n5].bl.d();
    }

    public boolean a(World world, int n2, int n3, int n4, EntityPlayer entityplayer) {
        return false;
    }

    public void b(World world, int n2, int n3, int n4, Entity entity) {
    }

    public void c(World world, int n2, int n3, int n4, int n5) {
    }

    public void b(World world, int n2, int n3, int n4, EntityPlayer entityplayer) {
    }

    public void a(World world, int n2, int n3, int n4, Entity entity, Vec3D vec3d) {
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
    }

    public boolean b(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(World world, int n2, int n3, int n4, Entity entity) {
    }

    public boolean d(World world, int n2, int n3, int n4, int n5) {
        return false;
    }

    public boolean f(World world, int n2, int n3, int n4) {
        return true;
    }

    static {
        for (int i2 = 0; i2 < 256; ++i2) {
            if (n[i2] == null) continue;
            en.c[i2] = new be(i2 - 256);
        }
    }
}

