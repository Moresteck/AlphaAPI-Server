/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ex
extends gb {
    protected ex(int n2, int n3) {
        super(n2, n3);
        float f2 = 0.4f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 2.0f, 0.5f + f2);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        super.a(dp2, n2, n3, n4, random);
        if (dp2.h(n2, n3 + 1, n4) >= 9 && random.nextInt(5) == 0) {
            int n5 = dp2.b(n2, n3, n4);
            if (n5 < 15) {
                dp2.b(n2, n3, n4, n5 + 1);
            } else {
                dp2.a(n2, n3, n4, 0);
                ay ay2 = new hl();
                if (random.nextInt(10) == 0) {
                    ay2 = new fv();
                }
                if (!ay2.a(dp2, random, n2, n3, n4)) {
                    dp2.a(n2, n3, n4, this.ba);
                }
            }
        }
    }
}

