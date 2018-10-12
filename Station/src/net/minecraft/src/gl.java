/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class gl
extends Block {
    protected gl(int n2) {
        super(n2, hz.b);
        this.aZ = 3;
        this.a(true);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5;
        int n6;
        int n7;
        if (dp2.h(n2, n3 + 1, n4) < 4 && dp2.c(n2, n3 + 1, n4).b()) {
            if (random.nextInt(4) != 0) {
                return;
            }
            dp2.d(n2, n3, n4, Block.v.ba);
        } else if (dp2.h(n2, n3 + 1, n4) >= 9 && dp2.a(n7 = n2 + random.nextInt(3) - 1, n6 = n3 + random.nextInt(5) - 3, n5 = n4 + random.nextInt(3) - 1) == Block.v.ba && dp2.h(n7, n6 + 1, n5) >= 4 && !dp2.c(n7, n6 + 1, n5).b()) {
            dp2.d(n7, n6, n5, Block.u.ba);
        }
    }

    public int a(int n2, Random random) {
        return Block.v.a(0, random);
    }
}

