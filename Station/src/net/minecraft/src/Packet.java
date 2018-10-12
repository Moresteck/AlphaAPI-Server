/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public abstract class Packet {
    private static Map a = new HashMap();
    private static Map b = new HashMap();
    public boolean j = false;

    static void a(int n2, Class class_) {
        if (a.containsKey(n2)) {
            throw new IllegalArgumentException("Duplicate packet id:" + n2);
        }
        if (b.containsKey(class_)) {
            throw new IllegalArgumentException("Duplicate packet class:" + class_);
        }
        a.put(n2, class_);
        b.put(class_, n2);
    }

    public static Packet a(int n2) {
        try {
            Class class_ = (Class)a.get(n2);
            if (class_ == null) {
                return null;
            }
            return (Packet)class_.newInstance();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Skipping packet with id " + n2);
            return null;
        }
    }

    public final int b() {
        return (Integer)b.get(this.getClass());
    }

    public static Packet b(DataInputStream dataInputStream) throws IOException {
        int n2 = dataInputStream.read();
        if (n2 == -1) {
            return null;
        }
        Packet ha2 = Packet.a(n2);
        if (ha2 == null) {
            throw new IOException("Bad packet id " + n2);
        }
        ha2.a(dataInputStream);
        return ha2;
    }

    public static void a(Packet ha2, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(ha2.b());
        ha2.a(dataOutputStream);
    }

    public abstract void a(DataInputStream var1) throws IOException;

    public abstract void a(DataOutputStream var1) throws IOException;

    public abstract void a(NetHandler var1);

    public abstract int a();

    static {
        Packet.a(0, ii.class);
        Packet.a(1, x.class);
        Packet.a(3, ax.class);
        Packet.a(10, fs.class);
        Packet.a(11, w.class);
        Packet.a(12, fk.class);
        Packet.a(13, dh.class);
        Packet.a(14, gp.class);
        Packet.a(15, es.class);
        Packet.a(16, fi.class);
        Packet.a(17, eb.class);
        Packet.a(18, n.class);
        Packet.a(20, Packet20NamedEntitySpawn.class);
        Packet.a(21, j.class);
        Packet.a(22, bz.class);
        Packet.a(23, dd.class);
        Packet.a(29, cm.class);
        Packet.a(30, el.class);
        Packet.a(31, di.class);
        Packet.a(32, cq.class);
        Packet.a(33, bc.class);
        Packet.a(34, by.class);
        Packet.a(50, ct.class);
        Packet.a(51, cs.class);
        Packet.a(52, gs.class);
        Packet.a(53, eh.class);
        Packet.a(255, hx.class);
    }
}

