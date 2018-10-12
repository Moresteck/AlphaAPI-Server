/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class bz
extends Packet {
    public int a;
    public int b;

    public bz() {
    }

    public bz(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 8;
    }
}

