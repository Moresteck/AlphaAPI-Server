/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class es
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readShort();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.read();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.write(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.write(this.e);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 12;
    }
}

