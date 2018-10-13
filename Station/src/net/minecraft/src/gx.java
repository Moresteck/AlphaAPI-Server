package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gx
extends Thread {
    final /* synthetic */ NetworkManager a;

    gx(NetworkManager aw2) {
        this.a = aw2;
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (NetworkManager.a(this.a)) {
                NetworkManager.f(this.a).interrupt();
                this.a.a("Connection closed");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

