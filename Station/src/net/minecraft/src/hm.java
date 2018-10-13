/*
 * Decompiled with CFR 0_132.
 */
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class hm
extends NetHandler {
    public static Logger a = Logger.getLogger("Minecraft");
    public aw b;
    public boolean c = false;
    private MinecraftServer d;
    private EntityPlayerMP e;
    private int f = 0;
    private double g;
    private double h;
    private double i;
    private boolean j = true;

    public hm(MinecraftServer minecraftServer, aw aw2, EntityPlayerMP dq2) {
        this.d = minecraftServer;
        this.b = aw2;
        aw2.a(this);
        this.e = dq2;
        dq2.a = this;
    }

    public void a() {
        this.b.a();
        if (this.f++ % 20 == 0) {
            this.b.a(new Packet0KeepAlive());
        }
    }

    public void b(String string) {
        this.b.a(new Packet255KickDisconnect(string));
        this.b.c();
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet10Flying fs2) {
        double d2;
        if (!this.j) {
            d2 = fs2.b - this.h;
            if (fs2.a == this.g && d2 * d2 < 0.01 && fs2.c == this.i) {
                this.j = true;
            }
        }
        if (this.j) {
            boolean bl2;
            double d3;
            this.g = this.e.k;
            this.h = this.e.l;
            this.i = this.e.m;
            d2 = this.e.k;
            double d4 = this.e.l;
            double d5 = this.e.m;
            float f2 = this.e.q;
            float f3 = this.e.r;
            if (fs2.h) {
                d2 = fs2.a;
                d4 = fs2.b;
                d5 = fs2.c;
                d3 = fs2.d - fs2.b;
                if (d3 > 1.65 || d3 < 0.1) {
                    this.b("Illegal stance");
                    a.warning(this.e.ap + " had an illegal stance: " + d3);
                }
                this.e.ah = fs2.d;
            }
            if (fs2.i) {
                f2 = fs2.e;
                f3 = fs2.f;
            }
            this.e.h();
            this.e.L = 0.0f;
            this.e.b(this.g, this.h, this.i, f2, f3);
            d3 = d2 - this.e.k;
            double d6 = d4 - this.e.l;
            double d7 = d5 - this.e.m;
            float f4 = 0.0625f;
            boolean bl3 = this.d.e.a((Entity)this.e, this.e.u.b().e(f4, f4, f4)).size() == 0;
            this.e.c(d3, d6, d7);
            d3 = d2 - this.e.k;
            d6 = d4 - this.e.l;
            if (d6 > -0.5 || d6 < 0.5) {
                d6 = 0.0;
            }
            d7 = d5 - this.e.m;
            double d8 = d3 * d3 + d6 * d6 + d7 * d7;
            boolean bl4 = false;
            if (d8 > 0.0625) {
                bl4 = true;
                a.warning(this.e.ap + " moved wrongly!");
            }
            this.e.b(d2, d4, d5, f2, f3);
            boolean bl5 = bl2 = this.d.e.a((Entity)this.e, this.e.u.b().e(f4, f4, f4)).size() == 0;
            if (bl3 && (bl4 || !bl2)) {
                this.a(this.g, this.h, this.i, f2, f3);
                return;
            }
            this.e.v = fs2.g;
            this.d.f.b(this.e);
        }
    }

    public void a(double d2, double d3, double d4, float f2, float f3) {
        this.j = false;
        this.g = d2;
        this.h = d3;
        this.i = d4;
        this.e.b(d2, d3, d4, f2, f3);
        this.e.a.b(new Packet13PlayerLookMove(d2, d3 + 1.6200000047683716, d3, d4, f2, f3, false));
    }

    public void a(Packet14BlockDig gp2) {
        double d2;
        double d3;
        int n2;
        double d4;
        double d5;
        boolean bl2 = false;
        if (gp2.e == 0) {
            bl2 = true;
        }
        if (gp2.e == 1) {
            bl2 = true;
        }
        if (bl2) {
            double d6 = this.e.l;
            this.e.l = this.e.ah;
            fe fe2 = this.e.a(4.0, 1.0f);
            this.e.l = d6;
            if (fe2 == null) {
                System.out.println("MISMATCH: Got " + gp2.a + ", " + gp2.b + ", " + gp2.c + ", " + gp2.d + ", but expected <NO HIT>");
                return;
            }
            if (fe2.b != gp2.a || fe2.c != gp2.b || fe2.d != gp2.c || fe2.e != gp2.d) {
                System.out.println("MISMATCH: Got " + gp2.a + ", " + gp2.b + ", " + gp2.c + ", " + gp2.d + ", but expected " + fe2.b + ", " + fe2.c + ", " + fe2.d + ", " + fe2.e);
                return;
            }
        }
        int n3 = gp2.a;
        int n4 = gp2.b;
        int n5 = gp2.c;
        int n6 = gp2.d;
        int n7 = (int)MathHelper.e(n3 - this.d.e.WANDERER);
        if (n7 > (n2 = (int)MathHelper.e(n5 - this.d.e.BUST))) {
            n2 = n7;
        }
        if (gp2.e == 0) {
            if (n2 > 16) {
                this.e.ac.a(n3, n4, n5);
            }
        } else if (gp2.e == 2) {
            this.e.ac.a();
        } else if (gp2.e == 1) {
            if (n2 > 16) {
                this.e.ac.a(n3, n4, n5, n6);
            }
        } else if (gp2.e == 3 && (d3 = (d4 = this.e.k - ((double)n3 + 0.5)) * d4 + (d2 = this.e.l - ((double)n4 + 0.5)) * d2 + (d5 = this.e.m - ((double)n5 + 0.5)) * d5) < 256.0) {
            this.e.a.b(new Packet53BlockChange(n3, n4, n5, this.d.e));
        }
    }

    public void a(Packet15Place es2) {
        int n2;
        int n3 = es2.b;
        int n4 = es2.c;
        int n5 = es2.d;
        int n6 = es2.e;
        int n7 = (int)MathHelper.e(n3 - this.d.e.WANDERER);
        if (n7 > (n2 = (int)MathHelper.e(n5 - this.d.e.BUST))) {
            n2 = n7;
        }
        if (n2 > 16) {
            gc gc2 = new gc(es2.a);
            this.e.ac.a(this.e, this.d.e, gc2, n3, n4, n5, n6);
        }
        this.e.a.b(new Packet53BlockChange(n3, n4, n5, this.d.e));
    }

    public void a(String string) {
        a.info(this.e.ap + " lost connection: " + string);
        this.d.f.c(this.e);
        this.c = true;
    }

    public void a(Packet ha2) {
        a.warning(this.getClass() + " wasn't prepared to deal with a " + ha2.getClass());
        this.b("Protocol error, unexpected packet");
    }

    public void b(Packet ha2) {
        this.b.a(ha2);
    }

    public void a(Packet16BlockItemSwitch fi2) {
        int n2 = fi2.b;
        this.e.ai.a[this.e.ai.d] = n2 == 0 ? null : new gc(n2);
        this.d.k.a(this.e, new Packet16BlockItemSwitch(this.e.c, n2));
    }

    public void a(Packet21PickupSpawn j2) {
        double d2 = (double)j2.b / 32.0;
        double d3 = (double)j2.c / 32.0;
        double d4 = (double)j2.d / 32.0;
        fa fa2 = new fa(this.d.e, d2, d3, d4, new gc(j2.h, j2.i));
        fa2.n = (double)j2.e / 128.0;
        fa2.o = (double)j2.f / 128.0;
        fa2.p = (double)j2.g / 128.0;
        fa2.ac = 10;
        this.d.e.a(fa2);
    }

    public void a(Packet3Chat ax2) {
        String string = ax2.a;
        if (string.length() > 100) {
            this.b("Chat message too long");
            return;
        }
        string = string.trim();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(string.charAt(i2)) >= 0) continue;
            this.b("Illegal characters in chat");
            return;
        }
        if (string.startsWith("/")) {
            this.c(string);
        } else {
            string = "<" + this.e.ap + "> " + string;
            a.info(string);
            this.d.f.a(new Packet3Chat(string));
        }
    }

    private void c(String string) {
        if (string.toLowerCase().startsWith("/me ")) {
            string = "* " + this.e.ap + " " + string.substring(string.indexOf(" ")).trim();
            a.info(string);
            this.d.f.a(new Packet3Chat(string));
        } else if (string.toLowerCase().equalsIgnoreCase("/home")) {
            a.info(this.e.ap + " returned home");
            int n2 = this.d.e.d(this.d.e.WANDERER, this.d.e.BUST);
            this.a((double)this.d.e.WANDERER + 0.5, (double)n2 + 1.5, (double)this.d.e.BUST + 0.5, 0.0f, 0.0f);
        } else if (string.toLowerCase().equalsIgnoreCase("/away")) {
            Random random = new Random();
            a.info(this.e.ap + " went away");
            double d2 = Math.random() * 10000.0 - 5000.0;
            double d3 = Math.random() * 10000.0 - 5000.0;
            this.a(d2, 80.0, d3, random.nextFloat() * 360.0f, 0.0f);
        } else if (string.toLowerCase().equalsIgnoreCase("/iron")) {
            if (MinecraftServer.b.containsKey(this.e.ap)) {
                a.info(this.e.ap + " failed to iron!");
                this.b(new Packet3Chat("\u00a7cYou can't /iron again so soon!"));
            } else {
                MinecraftServer.b.put(this.e.ap, 6000);
                a.info(this.e.ap + " ironed!");
                for (int i2 = 0; i2 < 4; ++i2) {
                    this.e.a(new gc(en.m, 1));
                }
            }
        } else if (string.toLowerCase().equalsIgnoreCase("/wood")) {
            if (MinecraftServer.b.containsKey(this.e.ap)) {
                a.info(this.e.ap + " failed to wood!");
                this.b(new Packet3Chat("\u00a7cYou can't /wood again so soon!"));
            } else {
                MinecraftServer.b.put(this.e.ap, 6000);
                a.info(this.e.ap + " wooded!");
                for (int i3 = 0; i3 < 4; ++i3) {
                    this.e.a(new gc(Block.y, 1));
                }
            }
        } else {
            this.b(new Packet3Chat("\u00a79Unknown command"));
        }
    }

    public void a(Packet18ArmAnimation n2) {
        if (n2.b == 1) {
            this.e.y();
        }
    }

    public void a(Packet255KickDisconnect hx2) {
        this.b.a("Quitting");
    }

    public int b() {
        return this.b.d();
    }
}

