/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class hx
extends Packet {
    public String a;

    public hx() {
    }

    public hx(String string) {
        this.a = string;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readUTF();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeUTF(this.a);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return this.a.length();
    }
}

