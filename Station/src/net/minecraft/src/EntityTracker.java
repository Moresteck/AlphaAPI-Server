/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class EntityTracker {
    private Set trackedEntitySet = new HashSet();
    private gq b = new gq();
    private MinecraftServer mcServer;
    private int d;

    public EntityTracker(MinecraftServer minecraftserver) {
        this.mcServer = minecraftserver;
        this.d = minecraftserver.configManager.a();
    }

    public void a(Entity entity) {
        if (entity instanceof EntityPlayerMP) {
            this.a(entity, 256, 2);
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entity;
            for (Iterator iterator = trackedEntitySet.iterator();iterator.hasNext();) {
            	EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
                if (entitytrackerentry.a != entityplayermp)
                	entitytrackerentry.a(entityplayermp);
            }
        }
        if (entity instanceof fa) {
            this.a(entity, 64, 20);
        }
        if (entity instanceof EntityMinecart) {
            this.a(entity, 160, 4);
        }
    }

    public void a(Entity db2, int n2, int n3) {
        if (n2 > this.d) {
            n2 = this.d;
        }
        if (this.b.b(db2.c)) {
            throw new IllegalStateException("Entity is already tracked!");
        }
        EntityTrackerEntry fl2 = new EntityTrackerEntry(db2, n2, n3);
        this.trackedEntitySet.add(fl2);
        this.b.a(db2.c, fl2);
        fl2.b(this.mcServer.world.i);
    }

    public void b(Entity db2) {
        EntityTrackerEntry fl2 = (EntityTrackerEntry)this.b.d(db2.c);
        if (fl2 != null) {
            this.trackedEntitySet.remove(fl2);
            fl2.a();
        }
    }

    public void a() {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (Iterator iterator = this.trackedEntitySet.iterator(); iterator.hasNext();) {
        	EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
            entitytrackerentry.a(this.mcServer.world.i);
            if (entitytrackerentry.j && (entitytrackerentry.a instanceof EntityPlayerMP))
            	arrayList.add((EntityPlayerMP)entitytrackerentry.a);
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)arrayList.get(i2);
            for (Iterator iterator = this.trackedEntitySet.iterator(); iterator.hasNext();) {
            	EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
                if (entitytrackerentry.a != entityplayermp)
                	entitytrackerentry.a(entityplayermp);
            }
        }
    }

    public void a(Entity db2, Packet ha2) {
        EntityTrackerEntry fl2 = (EntityTrackerEntry)this.b.a(db2.c);
        if (fl2 != null) {
            fl2.a(ha2);
        }
    }
}

