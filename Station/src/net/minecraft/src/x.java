/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class x
extends Packet {
    public int a;
    public String b;
    public String c;

    public x() {
    }

    public x(String string, String string2, int n2) {
        this.b = string;
        this.c = string2;
        this.a = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readUTF();
        this.c = dataInputStream.readUTF();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        dataOutputStream.writeUTF(this.c);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 4 + this.b.length() + this.c.length() + 4;
    }
}

