/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hi
implements bf {
    private Random j;
    private ej k;
    private ej l;
    private ej m;
    private ej n;
    private ej o;
    public ej a;
    public ej b;
    public ej c;
    private World p;
    private double[] q;
    private double[] r = new double[256];
    private double[] s = new double[256];
    private double[] t = new double[256];
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;
    int[][] i = new int[32][32];

    public hi(World dp2, long l2) {
        this.p = dp2;
        this.j = new Random(l2);
        this.k = new ej(this.j, 16);
        this.l = new ej(this.j, 16);
        this.m = new ej(this.j, 8);
        this.n = new ej(this.j, 4);
        this.o = new ej(this.j, 4);
        this.a = new ej(this.j, 10);
        this.b = new ej(this.j, 16);
        this.c = new ej(this.j, 8);
    }

    public void a(int n2, int n3, byte[] arrby) {
        int n4 = 4;
        int n5 = 64;
        int n6 = n4 + 1;
        int n7 = 17;
        int n8 = n4 + 1;
        this.q = this.a(this.q, n2 * n4, 0, n3 * n4, n6, n7, n8);
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n4; ++i3) {
                for (int i4 = 0; i4 < 16; ++i4) {
                    double d2 = 0.125;
                    double d3 = this.q[((i2 + 0) * n8 + (i3 + 0)) * n7 + (i4 + 0)];
                    double d4 = this.q[((i2 + 0) * n8 + (i3 + 1)) * n7 + (i4 + 0)];
                    double d5 = this.q[((i2 + 1) * n8 + (i3 + 0)) * n7 + (i4 + 0)];
                    double d6 = this.q[((i2 + 1) * n8 + (i3 + 1)) * n7 + (i4 + 0)];
                    double d7 = (this.q[((i2 + 0) * n8 + (i3 + 0)) * n7 + (i4 + 1)] - d3) * d2;
                    double d8 = (this.q[((i2 + 0) * n8 + (i3 + 1)) * n7 + (i4 + 1)] - d4) * d2;
                    double d9 = (this.q[((i2 + 1) * n8 + (i3 + 0)) * n7 + (i4 + 1)] - d5) * d2;
                    double d10 = (this.q[((i2 + 1) * n8 + (i3 + 1)) * n7 + (i4 + 1)] - d6) * d2;
                    for (int i5 = 0; i5 < 8; ++i5) {
                        double d11 = 0.25;
                        double d12 = d3;
                        double d13 = d4;
                        double d14 = (d5 - d3) * d11;
                        double d15 = (d6 - d4) * d11;
                        for (int i6 = 0; i6 < 4; ++i6) {
                            int n9 = i6 + i2 * 4 << 11 | 0 + i3 * 4 << 7 | i4 * 8 + i5;
                            int n10 = 128;
                            double d16 = 0.25;
                            double d17 = d12;
                            double d18 = (d13 - d12) * d16;
                            for (int i7 = 0; i7 < 4; ++i7) {
                                int n11 = 0;
                                if (i4 * 8 + i5 < n5) {
                                    n11 = this.p.c && i4 * 8 + i5 >= n5 - 1 ? Block.aT.ba : Block.B.ba;
                                }
                                if (d17 > 0.0) {
                                    n11 = Block.t.ba;
                                }
                                arrby[n9] = (byte)n11;
                                n9 += n10;
                                d17 += d18;
                            }
                            d12 += d14;
                            d13 += d15;
                        }
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                        d6 += d10;
                    }
                }
            }
        }
    }

    public void b(int n2, int n3, byte[] arrby) {
        int n4 = 64;
        double d2 = 0.03125;
        this.r = this.n.a(this.r, n2 * 16, n3 * 16, 0.0, 16, 16, 1, d2, d2, 1.0);
        this.s = this.n.a(this.s, n3 * 16, 109.0134, n2 * 16, 16, 1, 16, d2, 1.0, d2);
        this.t = this.o.a(this.t, n2 * 16, n3 * 16, 0.0, 16, 16, 1, d2 * 2.0, d2 * 2.0, d2 * 2.0);
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int i3 = 0; i3 < 16; ++i3) {
                boolean bl2 = this.r[i2 + i3 * 16] + this.j.nextDouble() * 0.2 > 0.0;
                boolean bl3 = this.s[i2 + i3 * 16] + this.j.nextDouble() * 0.2 > 3.0;
                int n5 = (int)(this.t[i2 + i3 * 16] / 3.0 + 3.0 + this.j.nextDouble() * 0.25);
                int n6 = -1;
                byte by2 = (byte)Block.u.ba;
                byte by3 = (byte)Block.v.ba;
                for (int i4 = 127; i4 >= 0; --i4) {
                    int n7 = (i2 * 16 + i3) * 128 + i4;
                    if (i4 <= 0 + this.j.nextInt(6) - 1) {
                        arrby[n7] = (byte)Block.z.ba;
                        continue;
                    }
                    byte by4 = arrby[n7];
                    if (by4 == 0) {
                        n6 = -1;
                        continue;
                    }
                    if (by4 != Block.t.ba) continue;
                    if (n6 == -1) {
                        if (n5 <= 0) {
                            by2 = 0;
                            by3 = (byte)Block.t.ba;
                        } else if (i4 >= n4 - 4 && i4 <= n4 + 1) {
                            by2 = (byte)Block.u.ba;
                            by3 = (byte)Block.v.ba;
                            if (bl3) {
                                by2 = 0;
                            }
                            if (bl3) {
                                by3 = (byte)Block.F.ba;
                            }
                            if (bl2) {
                                by2 = (byte)Block.E.ba;
                            }
                            if (bl2) {
                                by3 = (byte)Block.E.ba;
                            }
                        }
                        if (i4 < n4 && by2 == 0) {
                            by2 = (byte)Block.B.ba;
                        }
                        n6 = n5;
                        if (i4 >= n4 - 1) {
                            arrby[n7] = by2;
                            continue;
                        }
                        arrby[n7] = by3;
                        continue;
                    }
                    if (n6 <= 0) continue;
                    --n6;
                    arrby[n7] = by3;
                }
            }
        }
    }

    public hv b(int n2, int n3) {
        this.j.setSeed((long)n2 * 341873128712L + (long)n3 * 132897987541L);
        byte[] arrby = new byte[32768];
        hv hv2 = new hv(this.p, arrby, n2, n3);
        this.a(n2, n3, arrby);
        this.b(n2, n3, arrby);
        this.c(n2, n3, arrby);
        hv2.b();
        return hv2;
    }

    protected void a(int n2, int n3, byte[] arrby, double d2, double d3, double d4) {
        this.a(n2, n3, arrby, d2, d3, d4, 1.0f + this.j.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }

    protected void a(int n2, int n3, byte[] arrby, double d2, double d3, double d4, float f2, float f3, float f4, int n4, int n5, double d5) {
        boolean bl2;
        int n6;
        double d6 = n2 * 16 + 8;
        double d7 = n3 * 16 + 8;
        float f5 = 0.0f;
        float f6 = 0.0f;
        Random random = new Random(this.j.nextLong());
        if (n5 <= 0) {
            n6 = 112;
            n5 = n6 - random.nextInt(n6 / 4);
        }
        n6 = 0;
        if (n4 == -1) {
            n4 = n5 / 2;
            n6 = 1;
        }
        int n7 = random.nextInt(n5 / 2) + n5 / 4;
        boolean bl3 = bl2 = random.nextInt(6) == 0;
        while (n4 < n5) {
            double d8 = 1.5 + (double)(MathHelper.a((float)n4 * 3.1415927f / (float)n5) * f2 * 1.0f);
            double d9 = d8 * d5;
            float f7 = MathHelper.b(f4);
            float f8 = MathHelper.a(f4);
            d2 += (double)(MathHelper.b(f3) * f7);
            d3 += (double)f8;
            d4 += (double)(MathHelper.a(f3) * f7);
            f4 = bl2 ? (f4 *= 0.92f) : (f4 *= 0.7f);
            f4 += f6 * 0.1f;
            f3 += f5 * 0.1f;
            f6 *= 0.9f;
            f5 *= 0.75f;
            f6 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f5 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (n6 == 0 && n4 == n7 && f2 > 1.0f) {
                this.a(n2, n3, arrby, d2, d3, d4, random.nextFloat() * 0.5f + 0.5f, f3 - 1.5707964f, f4 / 3.0f, n4, n5, 1.0);
                this.a(n2, n3, arrby, d2, d3, d4, random.nextFloat() * 0.5f + 0.5f, f3 + 1.5707964f, f4 / 3.0f, n4, n5, 1.0);
                return;
            }
            if (n6 != 0 || random.nextInt(4) != 0) {
                double d10 = d2 - d6;
                double d11 = d4 - d7;
                double d12 = n5 - n4;
                double d13 = f2 + 2.0f + 16.0f;
                if (d10 * d10 + d11 * d11 - d12 * d12 > d13 * d13) {
                    return;
                }
                if (d2 >= d6 - 16.0 - d8 * 2.0 && d4 >= d7 - 16.0 - d8 * 2.0 && d2 <= d6 + 16.0 + d8 * 2.0 && d4 <= d7 + 16.0 + d8 * 2.0) {
                    int n8;
                    int n9;
                    int n10 = MathHelper.b(d2 - d8) - n2 * 16 - 1;
                    int n11 = MathHelper.b(d2 + d8) - n2 * 16 + 1;
                    int n12 = MathHelper.b(d3 - d9) - 1;
                    int n13 = MathHelper.b(d3 + d9) + 1;
                    int n14 = MathHelper.b(d4 - d8) - n3 * 16 - 1;
                    int n15 = MathHelper.b(d4 + d8) - n3 * 16 + 1;
                    if (n10 < 0) {
                        n10 = 0;
                    }
                    if (n11 > 16) {
                        n11 = 16;
                    }
                    if (n12 < 1) {
                        n12 = 1;
                    }
                    if (n13 > 120) {
                        n13 = 120;
                    }
                    if (n14 < 0) {
                        n14 = 0;
                    }
                    if (n15 > 16) {
                        n15 = 16;
                    }
                    boolean bl4 = false;
                    for (n8 = n10; !bl4 && n8 < n11; ++n8) {
                        for (int i2 = n14; !bl4 && i2 < n15; ++i2) {
                            for (int i3 = n13 + 1; !bl4 && i3 >= n12 - 1; --i3) {
                                n9 = (n8 * 16 + i2) * 128 + i3;
                                if (i3 < 0 || i3 >= 128) continue;
                                if (arrby[n9] == Block.A.ba || arrby[n9] == Block.B.ba) {
                                    bl4 = true;
                                }
                                if (i3 == n12 - 1 || n8 == n10 || n8 == n11 - 1 || i2 == n14 || i2 == n15 - 1) continue;
                                i3 = n12;
                            }
                        }
                    }
                    if (!bl4) {
                        for (n8 = n10; n8 < n11; ++n8) {
                            double d14 = ((double)(n8 + n2 * 16) + 0.5 - d2) / d8;
                            for (n9 = n14; n9 < n15; ++n9) {
                                double d15 = ((double)(n9 + n3 * 16) + 0.5 - d4) / d8;
                                int n16 = (n8 * 16 + n9) * 128 + n13;
                                boolean bl5 = false;
                                for (int i4 = n13 - 1; i4 >= n12; --i4) {
                                    double d16 = ((double)i4 + 0.5 - d3) / d9;
                                    if (d16 > -0.7 && d14 * d14 + d16 * d16 + d15 * d15 < 1.0) {
                                        byte by2 = arrby[n16];
                                        if (by2 == Block.u.ba) {
                                            bl5 = true;
                                        }
                                        if (by2 == Block.t.ba || by2 == Block.v.ba || by2 == Block.u.ba) {
                                            if (i4 < 10) {
                                                arrby[n16] = (byte)Block.C.ba;
                                            } else {
                                                arrby[n16] = 0;
                                                if (bl5 && arrby[n16 - 1] == Block.v.ba) {
                                                    arrby[n16 - 1] = (byte)Block.u.ba;
                                                }
                                            }
                                        }
                                    }
                                    --n16;
                                }
                            }
                        }
                        if (n6 != 0) break;
                    }
                }
            }
            ++n4;
        }
    }

    private void c(int n2, int n3, byte[] arrby) {
        int n4 = 8;
        this.j.setSeed(this.p.p);
        long l2 = this.j.nextLong() / 2L * 2L + 1L;
        long l3 = this.j.nextLong() / 2L * 2L + 1L;
        for (int i2 = n2 - n4; i2 <= n2 + n4; ++i2) {
            for (int i3 = n3 - n4; i3 <= n3 + n4; ++i3) {
                this.j.setSeed((long)i2 * l2 + (long)i3 * l3 ^ this.p.p);
                int n5 = this.j.nextInt(this.j.nextInt(this.j.nextInt(40) + 1) + 1);
                if (this.j.nextInt(15) != 0) {
                    n5 = 0;
                }
                for (int i4 = 0; i4 < n5; ++i4) {
                    double d2 = i2 * 16 + this.j.nextInt(16);
                    double d3 = this.j.nextInt(this.j.nextInt(120) + 8);
                    double d4 = i3 * 16 + this.j.nextInt(16);
                    int n6 = 1;
                    if (this.j.nextInt(4) == 0) {
                        this.a(n2, n3, arrby, d2, d3, d4);
                        n6 += this.j.nextInt(4);
                    }
                    for (int i5 = 0; i5 < n6; ++i5) {
                        float f2 = this.j.nextFloat() * 3.1415927f * 2.0f;
                        float f3 = (this.j.nextFloat() - 0.5f) * 2.0f / 8.0f;
                        float f4 = this.j.nextFloat() * 2.0f + this.j.nextFloat();
                        this.a(n2, n3, arrby, d2, d3, d4, f4, f2, f3, 0, 0, 1.0);
                    }
                }
            }
        }
    }

    private double[] a(double[] arrd, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (arrd == null) {
            arrd = new double[n5 * n6 * n7];
        }
        double d2 = 684.412;
        double d3 = 684.412;
        this.g = this.a.a(this.g, n2, n3, n4, n5, 1, n7, 1.0, 0.0, 1.0);
        this.h = this.b.a(this.h, n2, n3, n4, n5, 1, n7, 100.0, 0.0, 100.0);
        this.d = this.m.a(this.d, n2, n3, n4, n5, n6, n7, d2 / 80.0, d3 / 160.0, d2 / 80.0);
        this.e = this.k.a(this.e, n2, n3, n4, n5, n6, n7, d2, d3, d2);
        this.f = this.l.a(this.f, n2, n3, n4, n5, n6, n7, d2, d3, d2);
        int n8 = 0;
        int n9 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            for (int i3 = 0; i3 < n7; ++i3) {
                double d4 = (this.g[n9] + 256.0) / 512.0;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                double d5 = 0.0;
                double d6 = this.h[n9] / 8000.0;
                if (d6 < 0.0) {
                    d6 = - d6;
                }
                if ((d6 = d6 * 3.0 - 3.0) < 0.0) {
                    if ((d6 /= 2.0) < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                    d4 = 0.0;
                } else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 6.0;
                }
                d4 += 0.5;
                d6 = d6 * (double)n6 / 16.0;
                double d7 = (double)n6 / 2.0 + d6 * 4.0;
                ++n9;
                for (int i4 = 0; i4 < n6; ++i4) {
                    double d8;
                    double d9 = 0.0;
                    double d10 = ((double)i4 - d7) * 12.0 / d4;
                    if (d10 < 0.0) {
                        d10 *= 4.0;
                    }
                    double d11 = this.e[n8] / 512.0;
                    double d12 = this.f[n8] / 512.0;
                    double d13 = (this.d[n8] / 10.0 + 1.0) / 2.0;
                    d9 = d13 < 0.0 ? d11 : (d13 > 1.0 ? d12 : d11 + (d12 - d11) * d13);
                    d9 -= d10;
                    if (i4 > n6 - 4) {
                        d8 = (float)(i4 - (n6 - 4)) / 3.0f;
                        d9 = d9 * (1.0 - d8) + -10.0 * d8;
                    }
                    if ((double)i4 < d5) {
                        d8 = (d5 - (double)i4) / 4.0;
                        if (d8 < 0.0) {
                            d8 = 0.0;
                        }
                        if (d8 > 1.0) {
                            d8 = 1.0;
                        }
                        d9 = d9 * (1.0 - d8) + -10.0 * d8;
                    }
                    arrd[n8] = d9;
                    ++n8;
                }
            }
        }
        return arrd;
    }

    public boolean a(int n2, int n3) {
        return true;
    }

    public void a(bf bf2, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        em.a = true;
        int n10 = n2 * 16;
        int n11 = n3 * 16;
        this.j.setSeed(this.p.p);
        long l2 = this.j.nextLong() / 2L * 2L + 1L;
        long l3 = this.j.nextLong() / 2L * 2L + 1L;
        this.j.setSeed((long)n2 * l2 + (long)n3 * l3 ^ this.p.p);
        double d2 = 0.25;
        for (n6 = 0; n6 < 8; ++n6) {
            n8 = n10 + this.j.nextInt(16) + 8;
            n5 = this.j.nextInt(128);
            n9 = n11 + this.j.nextInt(16) + 8;
            new dc().a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 10; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(128);
            n9 = n11 + this.j.nextInt(16);
            new e(32).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 20; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(128);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.v.ba, 32).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 10; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(128);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.F.ba, 32).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 20; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(128);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.I.ba, 16).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 20; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(64);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.H.ba, 8).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 2; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(32);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.G.ba, 8).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 8; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(16);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.aN.ba, 7).a(this.p, this.j, n8, n5, n9);
        }
        for (n6 = 0; n6 < 1; ++n6) {
            n8 = n10 + this.j.nextInt(16);
            n5 = this.j.nextInt(16);
            n9 = n11 + this.j.nextInt(16);
            new dv(Block.aw.ba, 7).a(this.p, this.j, n8, n5, n9);
        }
        d2 = 0.5;
        n6 = (int)((this.c.a((double)n10 * d2, (double)n11 * d2) / 8.0 + this.j.nextDouble() * 4.0 + 4.0) / 3.0);
        if (n6 < 0) {
            n6 = 0;
        }
        if (this.j.nextInt(10) == 0) {
            ++n6;
        }
        ay ay2 = new hl();
        if (this.j.nextInt(10) == 0) {
            ay2 = new fv();
        }
        for (n5 = 0; n5 < n6; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = n11 + this.j.nextInt(16) + 8;
            ay2.a(1.0, 1.0, 1.0);
            ay2.a(this.p, this.j, n9, this.p.c(n9, n4), n4);
        }
        for (n5 = 0; n5 < 2; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = this.j.nextInt(128);
            n7 = n11 + this.j.nextInt(16) + 8;
            new an(Block.ad.ba).a(this.p, this.j, n9, n4, n7);
        }
        if (this.j.nextInt(2) == 0) {
            n5 = n10 + this.j.nextInt(16) + 8;
            n9 = this.j.nextInt(128);
            n4 = n11 + this.j.nextInt(16) + 8;
            new an(Block.ae.ba).a(this.p, this.j, n5, n9, n4);
        }
        if (this.j.nextInt(4) == 0) {
            n5 = n10 + this.j.nextInt(16) + 8;
            n9 = this.j.nextInt(128);
            n4 = n11 + this.j.nextInt(16) + 8;
            new an(Block.af.ba).a(this.p, this.j, n5, n9, n4);
        }
        if (this.j.nextInt(8) == 0) {
            n5 = n10 + this.j.nextInt(16) + 8;
            n9 = this.j.nextInt(128);
            n4 = n11 + this.j.nextInt(16) + 8;
            new an(Block.ag.ba).a(this.p, this.j, n5, n9, n4);
        }
        for (n5 = 0; n5 < 10; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = this.j.nextInt(128);
            n7 = n11 + this.j.nextInt(16) + 8;
            new fy().a(this.p, this.j, n9, n4, n7);
        }
        for (n5 = 0; n5 < 1; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = this.j.nextInt(128);
            n7 = n11 + this.j.nextInt(16) + 8;
            new ee().a(this.p, this.j, n9, n4, n7);
        }
        for (n5 = 0; n5 < 50; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = this.j.nextInt(this.j.nextInt(120) + 8);
            n7 = n11 + this.j.nextInt(16) + 8;
            new hc(Block.A.ba).a(this.p, this.j, n9, n4, n7);
        }
        for (n5 = 0; n5 < 20; ++n5) {
            n9 = n10 + this.j.nextInt(16) + 8;
            n4 = this.j.nextInt(this.j.nextInt(this.j.nextInt(112) + 8) + 8);
            n7 = n11 + this.j.nextInt(16) + 8;
            new hc(Block.C.ba).a(this.p, this.j, n9, n4, n7);
        }
        if (this.p.c) {
            for (n5 = n10 + 8 + 0; n5 < n10 + 8 + 16; ++n5) {
                for (n9 = n11 + 8 + 0; n9 < n11 + 8 + 16; ++n9) {
                    n4 = this.p.d(n5, n9);
                    if (n4 <= 0 || n4 >= 128 || this.p.a(n5, n4, n9) != 0 || !this.p.c(n5, n4 - 1, n9).c() || this.p.c(n5, n4 - 1, n9) == hz.r) continue;
                    this.p.d(n5, n4, n9, Block.aS.ba);
                }
            }
        }
        em.a = false;
    }

    public boolean a(boolean bl2, hg hg2) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }
}

