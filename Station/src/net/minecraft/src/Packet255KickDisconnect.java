package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet255KickDisconnect
extends Packet {
    public String a;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String string) {
        this.a = string;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readUTF();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.a);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return this.a.length();
    }
}

