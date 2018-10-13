package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gy
extends Thread {
    final /* synthetic */ aw a;

    gy(aw aw2, String string) {
        this.a = aw2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = aw.a;
        synchronized (object) {
            ++aw.b;
        }
        try {
            while (aw.a(this.a) && !aw.b(this.a)) {
                aw.c(this.a);
            }
        }
        finally {
            object = aw.a;
            synchronized (object) {
                --aw.b;
            }
        }
    }
}

