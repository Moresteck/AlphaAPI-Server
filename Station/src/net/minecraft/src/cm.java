/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class cm
extends Packet {
    public int a;

    public cm() {
    }

    public cm(int n2) {
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

