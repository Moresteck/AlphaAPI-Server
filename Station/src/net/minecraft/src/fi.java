/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class fi
extends Packet {
    public int a;
    public int b;

    public fi() {
    }

    public fi(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 6;
    }
}

