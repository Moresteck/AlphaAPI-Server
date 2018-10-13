/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

class ab {
    private List b = new ArrayList();
    private int c;
    private int d;
    private ih e;
    private short[] f = new short[10];
    private int g = 0;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    final /* synthetic */ PlayerManager a;

    public ab(PlayerManager gr2, int n2, int n3) {
        this.a = gr2;
        this.c = n2;
        this.d = n3;
        this.e = new ih(n2, n3);
        PlayerManager.a((PlayerManager)gr2).e.u.d(n2, n3);
    }

    public void a(EntityPlayerMP dq2) {
        if (this.b.contains(dq2)) {
            throw new IllegalStateException("Failed to add player. " + dq2 + " already is in chunk " + this.c + ", " + this.d);
        }
        dq2.ag.add(this.e);
        dq2.a.b(new Packet50PreChunk(this.e.a, this.e.b, true));
        this.b.add(dq2);
        dq2.af.add(this.e);
    }

    public void b(EntityPlayerMP dq2) {
        if (!this.b.contains(dq2)) {
            new IllegalStateException("Failed to remove player. " + dq2 + " isn't in chunk " + this.c + ", " + this.d).printStackTrace();
            return;
        }
        this.b.remove(dq2);
        if (this.b.size() == 0) {
            long l2 = (long)this.c + Integer.MAX_VALUE | (long)this.d + Integer.MAX_VALUE << 32;
            PlayerManager.b(this.a).b(l2);
            if (this.g > 0) {
                PlayerManager.c(this.a).remove(this);
            }
            PlayerManager.a((PlayerManager)this.a).e.u.c(this.c, this.d);
        }
        dq2.af.remove(this.e);
        if (dq2.ag.contains(this.e)) {
            dq2.a.b(new Packet50PreChunk(this.c, this.d, false));
        }
    }

    public void a(int n2, int n3, int n4) {
        if (this.g == 0) {
            PlayerManager.c(this.a).add(this);
            this.h = this.i = n2;
            this.j = this.k = n3;
            this.l = this.m = n4;
        }
        if (this.h > n2) {
            this.h = n2;
        }
        if (this.i < n2) {
            this.i = n2;
        }
        if (this.j > n3) {
            this.j = n3;
        }
        if (this.k < n3) {
            this.k = n3;
        }
        if (this.l > n4) {
            this.l = n4;
        }
        if (this.m < n4) {
            this.m = n4;
        }
        if (this.g < 10) {
            short s2 = (short)(n2 << 12 | n4 << 8 | n3);
            for (int i2 = 0; i2 < this.g; ++i2) {
                if (this.f[i2] != s2) continue;
                return;
            }
            this.f[this.g++] = s2;
        }
    }

    public void a(Packet ha2) {
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            EntityPlayerMP dq2 = (EntityPlayerMP)this.b.get(i2);
            if (!dq2.ag.contains(this.e)) continue;
            dq2.a.b(ha2);
        }
    }

    public void a() {
        if (this.g == 0) {
            return;
        }
        Packet ha2 = null;
        if (this.g == 1) {
            ha2 = new Packet53BlockChange(this.c * 16 + this.h, this.j, this.d * 16 + this.l, PlayerManager.a((PlayerManager)this.a).e);
        } else if (this.g == 10) {
            this.j = this.j / 2 * 2;
            this.k = (this.k / 2 + 1) * 2;
            int n2 = this.h + this.c * 16;
            int n3 = this.j;
            int n4 = this.l + this.d * 16;
            int n5 = this.i - this.h + 1;
            int n6 = this.k - this.j + 2;
            int n7 = this.m - this.l + 1;
            ha2 = new Packet51MapChunk(n2, n3, n4, n5, n6, n7, PlayerManager.a((PlayerManager)this.a).e);
        } else {
            ha2 = new Packet52MultiBlockChange(this.c, this.d, this.f, this.g, PlayerManager.a((PlayerManager)this.a).e);
        }
        this.a(ha2);
        this.g = 0;
    }
}

