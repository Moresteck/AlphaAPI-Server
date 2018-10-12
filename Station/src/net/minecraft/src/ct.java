/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ct
extends Packet {
    public int a;
    public int b;
    public boolean c;

    public ct() {
    }

    public ct(int n2, int n3, boolean bl2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.c = bl2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.read() != 0;
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.write(this.c ? 1 : 0);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 9;
    }
}

