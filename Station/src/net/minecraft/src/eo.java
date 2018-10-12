/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class eo
extends cl {
    private Class a;
    private boolean b;

    protected eo(int n2, Class class_, boolean bl2) {
        super(n2, hz.Packet20NamedEntitySpawn);
        this.b = bl2;
        this.aZ = 4;
        this.a = class_;
        float f2 = 0.25f;
        float f3 = 1.0f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f3, 0.5f + f2);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
        if (this.b) {
            return;
        }
        int n5 = hb2.b(n2, n3, n4);
        float f2 = 0.28125f;
        float f3 = 0.78125f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 0.125f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (n5 == 2) {
            this.a(f4, f2, 1.0f - f6, f5, f3, 1.0f);
        }
        if (n5 == 3) {
            this.a(f4, f2, 0.0f, f5, f3, f6);
        }
        if (n5 == 4) {
            this.a(1.0f - f6, f2, f4, 1.0f, f3, f5);
        }
        if (n5 == 5) {
            this.a(0.0f, f2, f4, f6, f3, f5);
        }
    }

    public int a() {
        return -1;
    }

    public boolean b() {
        return false;
    }

    protected TileEntity a_() {
        try {
            return (TileEntity)this.a.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public int a(int n2, Random random) {
        return en.as.aQ;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        boolean bl2 = false;
        if (this.b) {
            if (!dp2.c(n2, n3 - 1, n4).a()) {
                bl2 = true;
            }
        } else {
            int n6 = dp2.b(n2, n3, n4);
            bl2 = true;
            if (n6 == 2 && dp2.c(n2, n3, n4 + 1).a()) {
                bl2 = false;
            }
            if (n6 == 3 && dp2.c(n2, n3, n4 - 1).a()) {
                bl2 = false;
            }
            if (n6 == 4 && dp2.c(n2 + 1, n3, n4).a()) {
                bl2 = false;
            }
            if (n6 == 5 && dp2.c(n2 - 1, n3, n4).a()) {
                bl2 = false;
            }
        }
        if (bl2) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
        super.b(dp2, n2, n3, n4, n5);
    }
}

