package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet23VehicleSpawn() {
    }

    public Packet23VehicleSpawn(Entity db2, int n2) {
        this.a = db2.c;
        this.b = MathHelper.b(db2.k * 32.0);
        this.c = MathHelper.b(db2.l * 32.0);
        this.d = MathHelper.b(db2.m * 32.0);
        this.e = n2;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.e = dataInputStream.readByte();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 17;
    }
}

