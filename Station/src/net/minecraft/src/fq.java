/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.List;

class fq {
    private World b;
    private int c;
    private int d;
    private int e;
    private int f;
    private List g = new ArrayList();
    final /* synthetic */ ar a;

    public fq(ar ar2, World dp2, int n2, int n3, int n4) {
        this.a = ar2;
        this.b = dp2;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = dp2.b(n2, n3, n4);
        this.a();
    }

    private void a() {
        this.g.clear();
        if (this.f == 0) {
            this.g.add(new gf(this.c, this.d, this.e - 1));
            this.g.add(new gf(this.c, this.d, this.e + 1));
        } else if (this.f == 1) {
            this.g.add(new gf(this.c - 1, this.d, this.e));
            this.g.add(new gf(this.c + 1, this.d, this.e));
        } else if (this.f == 2) {
            this.g.add(new gf(this.c - 1, this.d, this.e));
            this.g.add(new gf(this.c + 1, this.d + 1, this.e));
        } else if (this.f == 3) {
            this.g.add(new gf(this.c - 1, this.d + 1, this.e));
            this.g.add(new gf(this.c + 1, this.d, this.e));
        } else if (this.f == 4) {
            this.g.add(new gf(this.c, this.d + 1, this.e - 1));
            this.g.add(new gf(this.c, this.d, this.e + 1));
        } else if (this.f == 5) {
            this.g.add(new gf(this.c, this.d, this.e - 1));
            this.g.add(new gf(this.c, this.d + 1, this.e + 1));
        } else if (this.f == 6) {
            this.g.add(new gf(this.c + 1, this.d, this.e));
            this.g.add(new gf(this.c, this.d, this.e + 1));
        } else if (this.f == 7) {
            this.g.add(new gf(this.c - 1, this.d, this.e));
            this.g.add(new gf(this.c, this.d, this.e + 1));
        } else if (this.f == 8) {
            this.g.add(new gf(this.c - 1, this.d, this.e));
            this.g.add(new gf(this.c, this.d, this.e - 1));
        } else if (this.f == 9) {
            this.g.add(new gf(this.c + 1, this.d, this.e));
            this.g.add(new gf(this.c, this.d, this.e - 1));
        }
    }

    private void b() {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            fq fq2 = this.a((gf)this.g.get(i2));
            if (fq2 == null || !fq2.b(this)) {
                this.g.remove(i2--);
                continue;
            }
            this.g.set(i2, new gf(fq2.c, fq2.d, fq2.e));
        }
    }

    private boolean a(int n2, int n3, int n4) {
        if (this.b.a(n2, n3, n4) == this.a.ba) {
            return true;
        }
        if (this.b.a(n2, n3 + 1, n4) == this.a.ba) {
            return true;
        }
        if (this.b.a(n2, n3 - 1, n4) == this.a.ba) {
            return true;
        }
        return false;
    }

    private fq a(gf gf2) {
        if (this.b.a(gf2.a, gf2.b, gf2.c) == this.a.ba) {
            return new fq(this.a, this.b, gf2.a, gf2.b, gf2.c);
        }
        if (this.b.a(gf2.a, gf2.b + 1, gf2.c) == this.a.ba) {
            return new fq(this.a, this.b, gf2.a, gf2.b + 1, gf2.c);
        }
        if (this.b.a(gf2.a, gf2.b - 1, gf2.c) == this.a.ba) {
            return new fq(this.a, this.b, gf2.a, gf2.b - 1, gf2.c);
        }
        return null;
    }

    private boolean b(fq fq2) {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            gf gf2 = (gf)this.g.get(i2);
            if (gf2.a != fq2.c || gf2.c != fq2.e) continue;
            return true;
        }
        return false;
    }

    private boolean b(int n2, int n3, int n4) {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            gf gf2 = (gf)this.g.get(i2);
            if (gf2.a != n2 || gf2.c != n4) continue;
            return true;
        }
        return false;
    }

    private int c() {
        int n2 = 0;
        if (this.a(this.c, this.d, this.e - 1)) {
            ++n2;
        }
        if (this.a(this.c, this.d, this.e + 1)) {
            ++n2;
        }
        if (this.a(this.c - 1, this.d, this.e)) {
            ++n2;
        }
        if (this.a(this.c + 1, this.d, this.e)) {
            ++n2;
        }
        return n2;
    }

    private boolean c(fq fq2) {
        if (this.b(fq2)) {
            return true;
        }
        if (this.g.size() == 2) {
            return false;
        }
        if (this.g.size() == 0) {
            return true;
        }
        gf gf2 = (gf)this.g.get(0);
        if (fq2.d == this.d && gf2.b == this.d) {
            return true;
        }
        return true;
    }

    private void d(fq fq2) {
        this.g.add(new gf(fq2.c, fq2.d, fq2.e));
        boolean bl2 = this.b(this.c, this.d, this.e - 1);
        boolean bl3 = this.b(this.c, this.d, this.e + 1);
        boolean bl4 = this.b(this.c - 1, this.d, this.e);
        boolean bl5 = this.b(this.c + 1, this.d, this.e);
        int n2 = -1;
        if (bl2 || bl3) {
            n2 = 0;
        }
        if (bl4 || bl5) {
            n2 = 1;
        }
        if (bl3 && bl5 && !bl2 && !bl4) {
            n2 = 6;
        }
        if (bl3 && bl4 && !bl2 && !bl5) {
            n2 = 7;
        }
        if (bl2 && bl4 && !bl3 && !bl5) {
            n2 = 8;
        }
        if (bl2 && bl5 && !bl3 && !bl4) {
            n2 = 9;
        }
        if (n2 == 0) {
            if (this.b.a(this.c, this.d + 1, this.e - 1) == this.a.ba) {
                n2 = 4;
            }
            if (this.b.a(this.c, this.d + 1, this.e + 1) == this.a.ba) {
                n2 = 5;
            }
        }
        if (n2 == 1) {
            if (this.b.a(this.c + 1, this.d + 1, this.e) == this.a.ba) {
                n2 = 2;
            }
            if (this.b.a(this.c - 1, this.d + 1, this.e) == this.a.ba) {
                n2 = 3;
            }
        }
        if (n2 < 0) {
            n2 = 0;
        }
        this.b.b(this.c, this.d, this.e, n2);
    }

    private boolean c(int n2, int n3, int n4) {
        fq fq2 = this.a(new gf(n2, n3, n4));
        if (fq2 == null) {
            return false;
        }
        fq2.b();
        return fq2.c(this);
    }

    public void a(boolean bl2) {
        boolean bl3 = this.c(this.c, this.d, this.e - 1);
        boolean bl4 = this.c(this.c, this.d, this.e + 1);
        boolean bl5 = this.c(this.c - 1, this.d, this.e);
        boolean bl6 = this.c(this.c + 1, this.d, this.e);
        int n2 = -1;
        if ((bl3 || bl4) && !bl5 && !bl6) {
            n2 = 0;
        }
        if ((bl5 || bl6) && !bl3 && !bl4) {
            n2 = 1;
        }
        if (bl4 && bl6 && !bl3 && !bl5) {
            n2 = 6;
        }
        if (bl4 && bl5 && !bl3 && !bl6) {
            n2 = 7;
        }
        if (bl3 && bl5 && !bl4 && !bl6) {
            n2 = 8;
        }
        if (bl3 && bl6 && !bl4 && !bl5) {
            n2 = 9;
        }
        if (n2 == -1) {
            if (bl3 || bl4) {
                n2 = 0;
            }
            if (bl5 || bl6) {
                n2 = 1;
            }
            if (bl2) {
                if (bl4 && bl6) {
                    n2 = 6;
                }
                if (bl5 && bl4) {
                    n2 = 7;
                }
                if (bl6 && bl3) {
                    n2 = 9;
                }
                if (bl3 && bl5) {
                    n2 = 8;
                }
            } else {
                if (bl3 && bl5) {
                    n2 = 8;
                }
                if (bl6 && bl3) {
                    n2 = 9;
                }
                if (bl5 && bl4) {
                    n2 = 7;
                }
                if (bl4 && bl6) {
                    n2 = 6;
                }
            }
        }
        if (n2 == 0) {
            if (this.b.a(this.c, this.d + 1, this.e - 1) == this.a.ba) {
                n2 = 4;
            }
            if (this.b.a(this.c, this.d + 1, this.e + 1) == this.a.ba) {
                n2 = 5;
            }
        }
        if (n2 == 1) {
            if (this.b.a(this.c + 1, this.d + 1, this.e) == this.a.ba) {
                n2 = 2;
            }
            if (this.b.a(this.c - 1, this.d + 1, this.e) == this.a.ba) {
                n2 = 3;
            }
        }
        if (n2 < 0) {
            n2 = 0;
        }
        this.f = n2;
        this.a();
        this.b.b(this.c, this.d, this.e, n2);
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            fq fq2 = this.a((gf)this.g.get(i2));
            if (fq2 == null) continue;
            fq2.b();
            if (!fq2.c(this)) continue;
            fq2.d(this);
        }
    }

    static /* synthetic */ int a(fq fq2) {
        return fq2.c();
    }
}

