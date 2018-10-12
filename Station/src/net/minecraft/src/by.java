/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class by
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;

    public by() {
    }

    public by(Entity db2) {
        this.a = db2.c;
        this.b = fw.b(db2.k * 32.0);
        this.c = fw.b(db2.l * 32.0);
        this.d = fw.b(db2.m * 32.0);
        this.e = (byte)(db2.q * 256.0f / 360.0f);
        this.f = (byte)(db2.r * 256.0f / 360.0f);
    }

    public by(int n2, int n3, int n4, int n5, byte by2, byte by3) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
        this.e = by2;
        this.f = by3;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = (byte)dataInputStream.read();
        this.f = (byte)dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.write(this.e);
        dataOutputStream.write(this.f);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 34;
    }
}

