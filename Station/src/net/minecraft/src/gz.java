package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gz
extends Thread {
    final /* synthetic */ NetworkManager a;

    gz(NetworkManager aw2, String string) {
    	super(string);
        this.a = aw2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = NetworkManager.a;
        synchronized (object) {
            ++NetworkManager.Packet20NamedEntitySpawn;
        }
        try {
            while (NetworkManager.a(this.a)) {
                NetworkManager.d(this.a);
            }
        }
        finally {
            object = NetworkManager.a;
            synchronized (object) {
                --NetworkManager.Packet20NamedEntitySpawn;
            }
        }
    }
}

