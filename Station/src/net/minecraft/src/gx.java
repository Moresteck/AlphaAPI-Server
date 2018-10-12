/*
 * Decompiled with CFR 0_132.
 */
class gx
extends Thread {
    final /* synthetic */ aw a;

    gx(aw aw2) {
        this.a = aw2;
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (aw.a(this.a)) {
                aw.f(this.a).interrupt();
                this.a.a("Connection closed");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

