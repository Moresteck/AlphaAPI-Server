/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTrackerEntry {
    public Entity a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i = 0;
    private double l;
    private double m;
    private double n;
    private boolean o = false;
    public boolean j = false;
    public Set k = new HashSet();

    public EntityTrackerEntry(Entity db2, int n2, int n3) {
        this.a = db2;
        this.b = n2;
        this.c = n3;
        this.d = MathHelper.b(db2.k * 32.0);
        this.e = MathHelper.b(db2.l * 32.0);
        this.f = MathHelper.b(db2.m * 32.0);
        this.g = MathHelper.d(db2.q * 256.0f / 360.0f);
        this.h = MathHelper.d(db2.r * 256.0f / 360.0f);
    }

    public boolean equals(Object object) {
        if (object instanceof EntityTrackerEntry) {
            return ((EntityTrackerEntry)object).a.c == this.a.c;
        }
        return false;
    }

    public int hashCode() {
        return this.a.c;
    }

    public void a(List list) {
        this.j = false;
        if (!this.o || this.a.d(this.l, this.m, this.n) > 16.0) {
            this.b(list);
            this.l = this.a.k;
            this.m = this.a.l;
            this.n = this.a.m;
            this.o = true;
            this.j = true;
        }
        if (this.i++ % this.c == 0) {
            int n2 = MathHelper.b(this.a.k * 32.0);
            int n3 = MathHelper.b(this.a.l * 32.0);
            int n4 = MathHelper.b(this.a.m * 32.0);
            int n5 = MathHelper.d(this.a.q * 256.0f / 360.0f);
            int n6 = MathHelper.d(this.a.r * 256.0f / 360.0f);
            boolean bl2 = n2 != this.d || n3 != this.e || n4 != this.f;
            boolean bl3 = n5 != this.g || n6 != this.h;
            int n7 = n2 - this.d;
            int n8 = n3 - this.e;
            int n9 = n4 - this.f;
            Packet ha2 = null;
            ha2 = n7 < -128 || n7 >= 128 || n8 < -128 || n8 >= 128 || n9 < -128 || n9 >= 128 ? new Packet34EntityTeleport(this.a.c, n2, n3, n4, (byte)n5, (byte)n6) : (bl2 && bl3 ? new Packet33RelEntityMoveLook(this.a.c, (byte)n7, (byte)n8, (byte)n9, (byte)n5, (byte)n6) : (bl2 ? new Packet31RelEntityMove(this.a.c, (byte)n7, (byte)n8, (byte)n9) : (bl3 ? new Packet32EntityLook(this.a.c, (byte)n5, (byte)n6) : new Packet30Entity(this.a.c))));
            if (ha2 != null) {
                this.a(ha2);
            }
            this.d = n2;
            this.e = n3;
            this.f = n4;
            this.g = n5;
            this.h = n6;
        }
    }

    public void a(Packet ha2) {
        for (Iterator iterator = k.iterator();iterator.hasNext();) {
        	EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            entityplayermp.a.b(ha2);
        }
    }

    public void a() {
        this.a(new Packet29DestroyEntity(this.a.c));
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (entityplayermp == this.a) {
            return;
        }
        double d2 = entityplayermp.k - (double)(this.d / 32);
        double d3 = entityplayermp.m - (double)(this.f / 32);
        if (d2 >= (double)(- this.b) && d2 <= (double)this.b && d3 >= (double)(- this.b) && d3 <= (double)this.b) {
            if (!this.k.contains(entityplayermp)) {
                this.k.add(entityplayermp);
                entityplayermp.a.b(this.b());
            }
        } else if (this.k.contains(entityplayermp)) {
            this.k.remove(entityplayermp);
            entityplayermp.a.b(new Packet29DestroyEntity(this.a.c));
        }
    }

    public void b(List list) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            this.a((EntityPlayerMP)list.get(i2));
        }
    }

    private Packet b() {
        if (this.a instanceof fa) {
            fa fa2 = (fa)this.a;
            Packet21PickupSpawn j2 = new Packet21PickupSpawn(fa2);
            fa2.k = (double)j2.b / 32.0;
            fa2.l = (double)j2.c / 32.0;
            fa2.m = (double)j2.d / 32.0;
            fa2.n = (double)j2.e / 128.0;
            fa2.o = (double)j2.f / 128.0;
            fa2.p = (double)j2.g / 128.0;
            return j2;
        }
        if (this.a instanceof EntityPlayerMP) {
            return new Packet20NamedEntitySpawn((EntityPlayer)this.a);
        }
        if (this.a instanceof EntityMinecart) {
            EntityMinecart hs2 = (EntityMinecart)this.a;
            if (hs2.ad == 0) {
                return new Packet23VehicleSpawn(this.a, 10);
            }
            if (hs2.ad == 1) {
                return new Packet23VehicleSpawn(this.a, 11);
            }
            if (hs2.ad == 2) {
                return new Packet23VehicleSpawn(this.a, 12);
            }
        }
        if (this.a instanceof eg) {
            return new Packet23VehicleSpawn(this.a, 1);
        }
        throw new IllegalArgumentException("Don't know how to add " + this.a.getClass() + "!");
    }
}

