/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class d
extends ft {
    public long a;

    public d() {
    }

    public d(long l2) {
        this.a = l2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeLong(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readLong();
    }

    public byte a() {
        return 4;
    }

    public String toString() {
        return "" + this.a;
    }
}
