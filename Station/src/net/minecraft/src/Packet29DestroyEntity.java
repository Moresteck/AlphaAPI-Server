package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet29DestroyEntity
extends Packet {
    public int a;

    public Packet29DestroyEntity() {
    }

    public Packet29DestroyEntity(int n2) {
        this.a = n2;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 4;
    }
}

