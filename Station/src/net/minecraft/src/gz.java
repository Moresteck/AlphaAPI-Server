package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gz
extends Thread {
    final /* synthetic */ aw a;

    gz(aw aw2, String string) {
        this.a = aw2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = aw.a;
        synchronized (object) {
            ++aw.Packet20NamedEntitySpawn;
        }
        try {
            while (aw.a(this.a)) {
                aw.d(this.a);
            }
        }
        finally {
            object = aw.a;
            synchronized (object) {
                --aw.Packet20NamedEntitySpawn;
            }
        }
    }
}

