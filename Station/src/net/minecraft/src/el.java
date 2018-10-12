/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class el
extends Packet {
    public int a;
    public byte b;
    public byte c;
    public byte d;
    public byte e;
    public byte f;
    public boolean g = false;

    public el() {
    }

    public el(int n2) {
        this.a = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 4;
    }
}

