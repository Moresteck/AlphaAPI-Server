package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;

public abstract class ft {
    private String a = null;

    abstract void a(DataOutput var1);

    abstract void a(DataInput var1);

    public abstract byte a();

    public String c() {
        if (this.a == null) {
            return "";
        }
        return this.a;
    }

    public ft m(String string) {
        this.a = string;
        return this;
    }

    public static ft b(DataInput dataInput) {
        byte by2 = dataInput.readByte();
        if (by2 == 0) {
            return new hq();
        }
        ft ft2 = ft.a(by2);
        ft2.a = dataInput.readUTF();
        ft2.a(dataInput);
        return ft2;
    }

    public static void a(ft ft2, DataOutput dataOutput) {
        dataOutput.writeByte(ft2.a());
        if (ft2.a() == 0) {
            return;
        }
        dataOutput.writeUTF(ft2.c());
        ft2.a(dataOutput);
    }

    public static ft a(byte by2) {
        switch (by2) {
            case 0: {
                return new hq();
            }
            case 1: {
                return new bj();
            }
            case 2: {
                return new ep();
            }
            case 3: {
                return new bb();
            }
            case 4: {
                return new d();
            }
            case 5: {
                return new k();
            }
            case 6: {
                return new dk();
            }
            case 7: {
                return new fc();
            }
            case 8: {
                return new gu();
            }
            case 9: {
                return new de();
            }
            case 10: {
                return new r();
            }
        }
        return null;
    }

    public static String b(byte by2) {
        switch (by2) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
        }
        return "UNKNOWN";
    }
}

