package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gw
extends Thread {
    final /* synthetic */ NetworkManager a;

    gw(NetworkManager aw2) {
        this.a = aw2;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.e(this.a).isAlive()) {
                try {
                    NetworkManager.e(this.a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (NetworkManager.f(this.a).isAlive()) {
                try {
                    NetworkManager.f(this.a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

