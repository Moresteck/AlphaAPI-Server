/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class EntityPlayerMP
extends EntityPlayer {
    public hm a;
    public MinecraftServer mcServer;
    public hw ac;
    public double ad;
    public double ae;
    public List af = new LinkedList();
    public Set ag = new HashSet();
    public double ah;

    public EntityPlayerMP(MinecraftServer minecraftserver, World dp2, String string, hw hw2) {
        super(dp2);
        int n2 = dp2.l + this.Q.nextInt(20) - 10;
        int n3 = dp2.n + this.Q.nextInt(20) - 10;
        int n4 = dp2.d(n2, n3);
        this.c((double)n2 + 0.5, n4, (double)n3 + 0.5, 0.0f, 0.0f);
        this.mcServer = minecraftserver;
        this.M = 0.0f;
        hw2.a = this;
        this.ap = string;
        this.ac = hw2;
        this.B = 0.0f;
    }

    public void b_() {
    }

    public void f(Entity db2) {
    }

    public boolean a(Entity db2, int n2) {
        return false;
    }

    public void a(int n2) {
    }

    public void h() {
        int n2;
        super.b_();
        ih ih2 = null;
        double d2 = 0.0;
        for (n2 = 0; n2 < this.af.size(); ++n2) {
            ih ih3 = (ih)this.af.get(n2);
            double d3 = ih3.a(this);
            if (n2 != 0 && d3 >= d2) continue;
            ih2 = ih3;
            d2 = ih3.a(this);
        }
        if (ih2 != null) {
            n2 = 0;
            if (d2 < 1024.0) {
                n2 = 1;
            }
            if (this.a.b() < 2) {
                n2 = 1;
            }
            if (n2 != 0) {
                this.af.remove(ih2);
                this.a.b(new Packet51MapChunk(ih2.a * 16, 0, ih2.b * 16, 16, 128, 16, this.mcServer.world));
            }
        }
    }

    public void x() {
        this.p = 0.0;
        this.o = 0.0;
        this.n = 0.0;
        this.bd = false;
        super.x();
    }

    public void c(Entity db2, int n2) {
        if (!db2.A && db2 instanceof fa) {
            this.a.b(new Packet17AddToInventory(((fa)db2).a, n2));
            this.mcServer.entityTracker.a(db2, new Packet22Collect(db2.c, this.c));
        }
        super.c(db2, n2);
    }

    public void y() {
        if (!this.an) {
            this.ao = -1;
            this.an = true;
            this.mcServer.entityTracker.a(this, new Packet18ArmAnimation(this, 1));
        }
    }

    protected float n() {
        return 1.62f;
    }
}

