/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class dd
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public dd() {
    }

    public dd(Entity db2, int n2) {
        this.a = db2.c;
        this.b = fw.b(db2.k * 32.0);
        this.c = fw.b(db2.l * 32.0);
        this.d = fw.b(db2.m * 32.0);
        this.e = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.e = dataInputStream.readByte();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 17;
    }
}

