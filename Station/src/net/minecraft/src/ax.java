/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ax
extends Packet {
    public String a;

    public ax() {
    }

    public ax(String string) {
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

