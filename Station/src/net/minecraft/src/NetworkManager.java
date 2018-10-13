package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NetworkManager {
    public static final Object a = new Object();
    public static int b;
    public static int c;
    private Object d = new Object();
    private Socket e;
    private DataInputStream f;
    private DataOutputStream g;
    private boolean h = true;
    private List i = Collections.synchronizedList(new LinkedList());
    private List j = Collections.synchronizedList(new LinkedList());
    private List k = Collections.synchronizedList(new LinkedList());
    private NetHandler l;
    private boolean m = false;
    private Thread n;
    private Thread o;
    private boolean p = false;
    private String q = "";
    private int r = 0;
    private int s = 0;
    private int t = 0;

    public NetworkManager(Socket socket, String string, NetHandler dy2) throws IOException {
        this.e = socket;
        this.l = dy2;
        socket.setTrafficClass(24);
        this.f = new DataInputStream(socket.getInputStream());
        this.g = new DataOutputStream(socket.getOutputStream());
        this.o = new gy(this, string + " read thread");
        this.n = new gz(this, string + " write thread");
        this.o.start();
        this.n.start();
    }

    public void a(NetHandler dy2) {
        this.l = dy2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Packet ha2) {
        if (this.m) {
            return;
        }
        Object object = this.d;
        synchronized (object) {
            this.s += ha2.a() + 1;
            if (ha2.j) {
                this.k.add(ha2);
            } else {
                this.j.add(ha2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void e() {
        block12 : {
            try {
                Packet ha2;
                Object object;
                boolean bl2 = true;
                if (!this.j.isEmpty()) {
                    bl2 = false;
                    object = this.d;
                    synchronized (object) {
                        ha2 = (Packet)this.j.remove(0);
                        this.s -= ha2.a() + 1;
                    }
                    Packet.a(ha2, this.g);
                }
                if ((bl2 || this.t-- <= 0) && !this.k.isEmpty()) {
                    bl2 = false;
                    object = this.d;
                    synchronized (object) {
                        ha2 = (Packet)this.k.remove(0);
                        this.s -= ha2.a() + 1;
                    }
                    Packet.a(ha2, this.g);
                    this.t = 50;
                }
                if (bl2) {
                    Thread.sleep(10L);
                }
            }
            catch (InterruptedException interruptedException) {
            }
            catch (Exception exception) {
                if (this.p) break block12;
                this.a(exception);
            }
        }
    }

    private void f() {
        block4 : {
            try {
                Packet ha2 = Packet.b(this.f);
                if (ha2 != null) {
                    this.i.add(ha2);
                } else {
                    this.a("End of stream");
                }
            }
            catch (Exception exception) {
                if (this.p) break block4;
                this.a(exception);
            }
        }
    }

    private void a(Exception exception) {
        exception.printStackTrace();
        this.a("Internal exception: " + exception.toString());
    }

    public void a(String string) {
        if (!this.h) {
            return;
        }
        this.p = true;
        this.q = string;
        new gw(this).start();
        this.h = false;
        try {
            this.f.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            this.g.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            this.e.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void a() {
        if (this.s > 1048576) {
            this.a("Send buffer overflow");
        }
        if (this.i.isEmpty()) {
            if (this.r++ == 1200) {
                this.a("Timed out");
            }
        } else {
            this.r = 0;
        }
        int n2 = 100;
        while (!this.i.isEmpty() && n2-- >= 0) {
            Packet ha2 = (Packet)this.i.remove(0);
            ha2.a(this.l);
        }
        if (this.p && this.i.isEmpty()) {
            this.l.a(this.q);
        }
    }

    public SocketAddress b() {
        return this.e.getRemoteSocketAddress();
    }

    public void c() {
        this.m = true;
        this.o.interrupt();
        new gx(this).start();
    }

    public int d() {
        return this.k.size();
    }

    static /* synthetic */ boolean a(NetworkManager aw2) {
        return aw2.h;
    }

    static /* synthetic */ boolean b(NetworkManager aw2) {
        return aw2.m;
    }

    static /* synthetic */ void c(NetworkManager aw2) {
        aw2.f();
    }

    static /* synthetic */ void d(NetworkManager aw2) {
        aw2.e();
    }

    static /* synthetic */ Thread e(NetworkManager aw2) {
        return aw2.o;
    }

    static /* synthetic */ Thread f(NetworkManager aw2) {
        return aw2.n;
    }
}

