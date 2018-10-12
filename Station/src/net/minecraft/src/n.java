/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class n
extends Packet {
    public int a;
    public int b;

    public n() {
    }

    public n(Entity db2, int n2) {
        this.a = db2.c;
        this.b = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.b);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 5;
    }
}

