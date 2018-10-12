/*
 * Decompiled with CFR 0_132.
 */
class gw
extends Thread {
    final /* synthetic */ aw a;

    gw(aw aw2) {
        this.a = aw2;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (aw.e(this.a).isAlive()) {
                try {
                    aw.e(this.a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (aw.f(this.a).isAlive()) {
                try {
                    aw.f(this.a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

