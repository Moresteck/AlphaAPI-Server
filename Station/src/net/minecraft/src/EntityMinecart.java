/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.List;
import java.util.Random;

public class EntityMinecart
extends Entity
implements IInventory {
    private gc[] ah = new gc[36];
    public int a = 0;
    public int b = 0;
    public int ac = 1;
    private boolean ai = false;
    public int ad;
    public int ae;
    public double af;
    public double ag;
    private static final int[][][] aj = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
    private int ak;
    private double al;
    private double am;
    private double an;
    private double ao;
    private double ap;

    public EntityMinecart(World world) {
        super(world);
        this.d = true;
        this.a(0.98f, 0.7f);
        this.B = this.D / 2.0f;
        this.G = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.u;
    }

    public AxisAlignedBB l() {
        return this.u;
    }

    public boolean p() {
        return true;
    }

    public EntityMinecart(World world, double d2, double d3, double d4, int n2) {
        this(world);
        this.a(d2, d3 + (double)this.B, d4);
        this.n = 0.0;
        this.o = 0.0;
        this.p = 0.0;
        this.h = d2;
        this.i = d3;
        this.j = d4;
        this.ad = n2;
    }

    public double w() {
        return (double)this.D * 0.0 - 0.30000001192092896;
    }

    public boolean a(World world, int n2) {
        this.ac = - this.ac;
        this.b = 10;
        this.a += n2 * 10;
        if (this.a > 40) {
            this.a(en.ax.aQ, 1, 0.0f);
            if (this.ad == 1) {
                this.a(Block.au.ba, 1, 0.0f);
            } else if (this.ad == 2) {
                this.a(Block.aB.ba, 1, 0.0f);
            }
            this.i();
        }
        return true;
    }

    public boolean c_() {
        return !this.A;
    }

    public void i() {
        for (int i2 = 0; i2 < this.a(); ++i2) {
            gc gc2 = this.a(i2);
            if (gc2 == null) continue;
            float f2 = this.Q.nextFloat() * 0.8f + 0.1f;
            float f3 = this.Q.nextFloat() * 0.8f + 0.1f;
            float f4 = this.Q.nextFloat() * 0.8f + 0.1f;
            while (gc2.a > 0) {
                int n2 = this.Q.nextInt(21) + 10;
                if (n2 > gc2.a) {
                    n2 = gc2.a;
                }
                gc2.a -= n2;
                fa fa2 = new fa(this.g, this.k + (double)f2, this.l + (double)f3, this.m + (double)f4, new gc(gc2.c, n2, gc2.d));
                float f5 = 0.05f;
                fa2.n = (float)this.Q.nextGaussian() * f5;
                fa2.o = (float)this.Q.nextGaussian() * f5 + 0.2f;
                fa2.p = (float)this.Q.nextGaussian() * f5;
                this.g.a(fa2);
            }
        }
        super.i();
    }

    public void b_() {
        int n2;
        double d2;
        int n3;
        if (this.g.t) {
            if (this.ak > 0) {
                double d3;
                double d4 = this.k + (this.al - this.k) / (double)this.ak;
                double d5 = this.l + (this.am - this.l) / (double)this.ak;
                double d6 = this.m + (this.an - this.m) / (double)this.ak;
                for (d3 = this.ao - (double)this.q; d3 < -180.0; d3 += 360.0) {
                }
                while (d3 >= 180.0) {
                    d3 -= 360.0;
                }
                this.q = (float)((double)this.q + d3 / (double)this.ak);
                this.r = (float)((double)this.r + (this.ap - (double)this.r) / (double)this.ak);
                --this.ak;
                this.a(d4, d5, d6);
                this.b(this.q, this.r);
            } else {
                this.a(this.k, this.l, this.m);
                this.b(this.q, this.r);
            }
            return;
        }
        if (this.b > 0) {
            --this.b;
        }
        if (this.a > 0) {
            --this.a;
        }
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        this.o -= 0.03999999910593033;
        int n4 = fw.b(this.k);
        if (this.g.a(n4, (n3 = fw.b(this.l)) - 1, n2 = fw.b(this.m)) == Block.aG.ba) {
            --n3;
        }
        double d7 = 0.4;
        boolean bl2 = false;
        double d8 = 0.0078125;
        if (this.g.a(n4, n3, n2) == Block.aG.ba) {
            double d9;
            double d10;
            double d11;
            double d12;
            Vec3D vec3d = this.g(this.k, this.l, this.m);
            int n5 = this.g.b(n4, n3, n2);
            this.l = n3;
            if (n5 >= 2 && n5 <= 5) {
                this.l = n3 + 1;
            }
            if (n5 == 2) {
                this.n -= d8;
            }
            if (n5 == 3) {
                this.n += d8;
            }
            if (n5 == 4) {
                this.p += d8;
            }
            if (n5 == 5) {
                this.p -= d8;
            }
            int[][] arrn = aj[n5];
            double d13 = arrn[1][0] - arrn[0][0];
            double d14 = arrn[1][2] - arrn[0][2];
            double d15 = Math.sqrt(d13 * d13 + d14 * d14);
            double d16 = this.n * d13 + this.p * d14;
            if (d16 < 0.0) {
                d13 = - d13;
                d14 = - d14;
            }
            double d17 = Math.sqrt(this.n * this.n + this.p * this.p);
            this.n = d17 * d13 / d15;
            this.p = d17 * d14 / d15;
            double d18 = 0.0;
            double d19 = (double)n4 + 0.5 + (double)arrn[0][0] * 0.5;
            double d20 = (double)n2 + 0.5 + (double)arrn[0][2] * 0.5;
            double d21 = (double)n4 + 0.5 + (double)arrn[1][0] * 0.5;
            double d22 = (double)n2 + 0.5 + (double)arrn[1][2] * 0.5;
            d13 = d21 - d19;
            d14 = d22 - d20;
            if (d13 == 0.0) {
                this.k = (double)n4 + 0.5;
                d18 = this.m - (double)n2;
            } else if (d14 == 0.0) {
                this.m = (double)n2 + 0.5;
                d18 = this.k - (double)n4;
            } else {
                d10 = this.k - d19;
                d12 = this.m - d20;
                d18 = d9 = (d10 * d13 + d12 * d14) * 2.0;
            }
            this.k = d19 + d13 * d18;
            this.m = d20 + d14 * d18;
            this.a(this.k, this.l + (double)this.B, this.m);
            d10 = this.n;
            d12 = this.p;
            if (this.e != null) {
                d10 *= 0.75;
                d12 *= 0.75;
            }
            if (d10 < - d7) {
                d10 = - d7;
            }
            if (d10 > d7) {
                d10 = d7;
            }
            if (d12 < - d7) {
                d12 = - d7;
            }
            if (d12 > d7) {
                d12 = d7;
            }
            this.c(d10, 0.0, d12);
            if (arrn[0][1] != 0 && fw.b(this.k) - n4 == arrn[0][0] && fw.b(this.m) - n2 == arrn[0][2]) {
                this.a(this.k, this.l + (double)arrn[0][1], this.m);
            } else if (arrn[1][1] != 0 && fw.b(this.k) - n4 == arrn[1][0] && fw.b(this.m) - n2 == arrn[1][2]) {
                this.a(this.k, this.l + (double)arrn[1][1], this.m);
            }
            if (this.e != null) {
                this.n *= 0.996999979019165;
                this.o *= 0.0;
                this.p *= 0.996999979019165;
            } else {
                if (this.ad == 2) {
                    d9 = fw.a(this.af * this.af + this.ag * this.ag);
                    if (d9 > 0.01) {
                        bl2 = true;
                        this.af /= d9;
                        this.ag /= d9;
                        double d23 = 0.04;
                        this.n *= 0.800000011920929;
                        this.o *= 0.0;
                        this.p *= 0.800000011920929;
                        this.n += this.af * d23;
                        this.p += this.ag * d23;
                    } else {
                        this.n *= 0.8999999761581421;
                        this.o *= 0.0;
                        this.p *= 0.8999999761581421;
                    }
                }
                this.n *= 0.9599999785423279;
                this.o *= 0.0;
                this.p *= 0.9599999785423279;
            }
            Vec3D vec3d2 = this.g(this.k, this.l, this.m);
            if (vec3d2 != null && vec3d != null) {
                double d24 = (vec3d.b - vec3d2.b) * 0.05;
                d17 = Math.sqrt(this.n * this.n + this.p * this.p);
                if (d17 > 0.0) {
                    this.n = this.n / d17 * (d17 + d24);
                    this.p = this.p / d17 * (d17 + d24);
                }
                this.a(this.k, vec3d2.b, this.m);
            }
            int n6 = fw.b(this.k);
            int n7 = fw.b(this.m);
            if (n6 != n4 || n7 != n2) {
                d17 = Math.sqrt(this.n * this.n + this.p * this.p);
                this.n = d17 * (double)(n6 - n4);
                this.p = d17 * (double)(n7 - n2);
            }
            if (this.ad == 2 && (d11 = (double)fw.a(this.af * this.af + this.ag * this.ag)) > 0.01 && this.n * this.n + this.p * this.p > 0.001) {
                this.af /= d11;
                this.ag /= d11;
                if (this.af * this.n + this.ag * this.p < 0.0) {
                    this.af = 0.0;
                    this.ag = 0.0;
                } else {
                    this.af = this.n;
                    this.ag = this.p;
                }
            }
        } else {
            if (this.n < - d7) {
                this.n = - d7;
            }
            if (this.n > d7) {
                this.n = d7;
            }
            if (this.p < - d7) {
                this.p = - d7;
            }
            if (this.p > d7) {
                this.p = d7;
            }
            if (this.v) {
                this.n *= 0.5;
                this.o *= 0.5;
                this.p *= 0.5;
            }
            this.c(this.n, this.o, this.p);
            if (!this.v) {
                this.n *= 0.949999988079071;
                this.o *= 0.949999988079071;
                this.p *= 0.949999988079071;
            }
        }
        this.r = 0.0f;
        double d25 = this.h - this.k;
        double d26 = this.j - this.m;
        if (d25 * d25 + d26 * d26 > 0.001) {
            this.q = (float)(Math.atan2(d26, d25) * 180.0 / 3.141592653589793);
            if (this.ai) {
                this.q += 180.0f;
            }
        }
        for (d2 = (double)(this.q - this.s); d2 >= 180.0; d2 -= 360.0) {
        }
        while (d2 < -180.0) {
            d2 += 360.0;
        }
        if (d2 < -170.0 || d2 >= 170.0) {
            this.q += 180.0f;
            this.ai = !this.ai;
        }
        this.b(this.q, this.r);
        List list = this.g.b(this, this.u.b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Entity entity = (Entity)list.get(i2);
                if (entity == this.e || !entity.p() || !(entity instanceof EntityMinecart)) continue;
                entity.c(this);
            }
        }
        if (this.e != null && this.e.A) {
            this.e = null;
        }
        if (bl2 && this.Q.nextInt(4) == 0) {
            --this.ae;
            if (this.ae < 0) {
                this.ag = 0.0;
                this.af = 0.0;
            }
            this.g.a("largesmoke", this.k, this.l + 0.8, this.m, 0.0, 0.0, 0.0);
        }
    }

    public Vec3D g(double d2, double d3, double d4) {
        int n2;
        int n3;
        int n4 = fw.b(d2);
        if (this.g.a(n4, (n3 = fw.b(d3)) - 1, n2 = fw.b(d4)) == Block.aG.ba) {
            --n3;
        }
        if (this.g.a(n4, n3, n2) == Block.aG.ba) {
            int n5 = this.g.b(n4, n3, n2);
            d3 = n3;
            if (n5 >= 2 && n5 <= 5) {
                d3 = n3 + 1;
            }
            int[][] arrn = aj[n5];
            double d5 = 0.0;
            double d6 = (double)n4 + 0.5 + (double)arrn[0][0] * 0.5;
            double d7 = (double)n3 + 0.5 + (double)arrn[0][1] * 0.5;
            double d8 = (double)n2 + 0.5 + (double)arrn[0][2] * 0.5;
            double d9 = (double)n4 + 0.5 + (double)arrn[1][0] * 0.5;
            double d10 = (double)n3 + 0.5 + (double)arrn[1][1] * 0.5;
            double d11 = (double)n2 + 0.5 + (double)arrn[1][2] * 0.5;
            double d12 = d9 - d6;
            double d13 = (d10 - d7) * 2.0;
            double d14 = d11 - d8;
            if (d12 == 0.0) {
                d2 = (double)n4 + 0.5;
                d5 = d4 - (double)n2;
            } else if (d14 == 0.0) {
                d4 = (double)n2 + 0.5;
                d5 = d2 - (double)n4;
            } else {
                double d15;
                double d16 = d2 - d6;
                double d17 = d4 - d8;
                d5 = d15 = (d16 * d12 + d17 * d14) * 2.0;
            }
            d2 = d6 + d12 * d5;
            d3 = d7 + d13 * d5;
            d4 = d8 + d14 * d5;
            if (d13 < 0.0) {
                d3 += 1.0;
            }
            if (d13 > 0.0) {
                d3 += 0.5;
            }
            return Vec3D.b(d2, d3, d4);
        }
        return null;
    }

    protected void a(r r2) {
        r2.a("Type", this.ad);
        if (this.ad == 2) {
            r2.a("PushX", this.af);
            r2.a("PushZ", this.ag);
            r2.a("Fuel", (short)this.ae);
        } else if (this.ad == 1) {
            de de2 = new de();
            for (int i2 = 0; i2 < this.ah.length; ++i2) {
                if (this.ah[i2] == null) continue;
                r r3 = new r();
                r3.a("Slot", (byte)i2);
                this.ah[i2].a(r3);
                de2.a(r3);
            }
            r2.a("Items", de2);
        }
    }

    protected void b(r r2) {
        this.ad = r2.d("Type");
        if (this.ad == 2) {
            this.af = r2.g("PushX");
            this.ag = r2.g("PushZ");
            this.ae = r2.c("Fuel");
        } else if (this.ad == 1) {
            de de2 = r2.k("Items");
            this.ah = new gc[this.a()];
            for (int i2 = 0; i2 < de2.b(); ++i2) {
                r r3 = (r)de2.a(i2);
                int n2 = r3.b("Slot") & 255;
                if (n2 < 0 || n2 >= this.ah.length) continue;
                this.ah[n2] = new gc(r3);
            }
        }
    }

    public void c(Entity entity) {
        double d2;
        double d3;
        double d4;
        if (entity == this.e) {
            return;
        }
        if (entity instanceof EntityLiving && !(entity instanceof EntityPlayer) && this.ad == 0 && this.n * this.n + this.p * this.p > 0.01 && this.e == null && entity.f == null) {
            entity.e(this);
        }
        if ((d2 = (d4 = entity.k - this.k) * d4 + (d3 = entity.m - this.m) * d3) >= 9.999999747378752E-5) {
            d2 = fw.a(d2);
            d4 /= d2;
            d3 /= d2;
            double d5 = 1.0 / d2;
            if (d5 > 1.0) {
                d5 = 1.0;
            }
            d4 *= d5;
            d3 *= d5;
            d4 *= 0.10000000149011612;
            d3 *= 0.10000000149011612;
            d4 *= (double)(1.0f - this.O);
            d3 *= (double)(1.0f - this.O);
            d4 *= 0.5;
            d3 *= 0.5;
            if (entity instanceof EntityMinecart) {
                double d6 = entity.n + this.n;
                double d7 = entity.p + this.p;
                if (((EntityMinecart)entity).ad == 2 && this.ad != 2) {
                    this.n *= 0.20000000298023224;
                    this.p *= 0.20000000298023224;
                    this.f(entity.n - d4, 0.0, entity.p - d3);
                    entity.n *= 0.699999988079071;
                    entity.p *= 0.699999988079071;
                } else if (((EntityMinecart)entity).ad != 2 && this.ad == 2) {
                    entity.n *= 0.20000000298023224;
                    entity.p *= 0.20000000298023224;
                    entity.f(this.n + d4, 0.0, this.p + d3);
                    this.n *= 0.699999988079071;
                    this.p *= 0.699999988079071;
                } else {
                    this.n *= 0.20000000298023224;
                    this.p *= 0.20000000298023224;
                    this.f((d6 /= 2.0) - d4, 0.0, (d7 /= 2.0) - d3);
                    entity.n *= 0.20000000298023224;
                    entity.p *= 0.20000000298023224;
                    entity.f(d6 + d4, 0.0, d7 + d3);
                }
            } else {
                this.f(- d4, 0.0, - d3);
                entity.f(d4 / 4.0, 0.0, d3 / 4.0);
            }
        }
    }

    public int a() {
        return 27;
    }

    public gc a(int n2) {
        return this.ah[n2];
    }
}

