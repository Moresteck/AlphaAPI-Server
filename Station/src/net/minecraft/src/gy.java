package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gy
extends Thread {
    final /* synthetic */ NetworkManager a;

    gy(NetworkManager aw2, String string) {
    	super(string);
        this.a = aw2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = NetworkManager.a;
        synchronized (object) {
            ++NetworkManager.b;
        }
        try {
            while (NetworkManager.a(this.a) && !NetworkManager.b(this.a)) {
                NetworkManager.c(this.a);
            }
        }
        finally {
            object = NetworkManager.a;
            synchronized (object) {
                --NetworkManager.b;
            }
        }
    }
}

