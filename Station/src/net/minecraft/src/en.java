/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.PrintStream;
import java.util.Random;

public class en {
    protected static Random b = new Random();
    public static en[] c = new en[32000];
    public static en d = new gd(0, 2).a(82);
    public static en e = new ah(1, 2).a(98);
    public static en f = new dl(2, 2).a(114);
    public static en g = new hj(3).a(5);
    public static en h = new ig(4, 4).a(10);
    public static en i = new bu(5).a(21);
    public static en j = new en(6).a(37);
    public static en k = new en(7).a(7);
    public static en l = new en(8).a(55);
    public static en m = new en(9).a(23);
    public static en n = new en(10).a(39);
    public static en o = new bd(11, 2).a(66);
    public static en p = new bd(12, 0).a(64);
    public static en q = new gd(13, 0).a(80);
    public static en r = new ah(14, 0).a(96);
    public static en s = new dl(15, 0).a(112);
    public static en t = new bd(16, 1).a(65);
    public static en u = new gd(17, 1).a(81);
    public static en v = new ah(18, 1).a(97);
    public static en w = new dl(19, 1).a(113);
    public static en x = new bd(20, 3).a(67);
    public static en y = new gd(21, 3).a(83);
    public static en z = new ah(22, 3).a(99);
    public static en A = new dl(23, 3).a(115);
    public static en B = new en(24).a(53).c();
    public static en C = new en(25).a(71);
    public static en D = new az(26, 10).a(72);
    public static en E = new bd(27, 0).a(68);
    public static en F = new gd(28, 0).a(84);
    public static en G = new ah(29, 0).a(100);
    public static en H = new dl(30, 0).a(116);
    public static en I = new en(31).a(8);
    public static en J = new en(32).a(24);
    public static en K = new en(33).a(40);
    public static en L = new hk(34, 0).a(128);
    public static en M = new hk(35, 1).a(129);
    public static en N = new hk(36, 2).a(130);
    public static en O = new hk(37, 3).a(131);
    public static en P = new hk(38, 4).a(132);
    public static en Q = new cc(39, Block.az.ba).a(9);
    public static en R = new en(40).a(25);
    public static en S = new ig(41, 5).a(41);
    public static en T = new ga(42, 0, 0, 0).a(0);
    public static en U = new ga(43, 0, 0, 1).a(16);
    public static en V = new ga(44, 0, 0, 2).a(32);
    public static en W = new ga(45, 0, 0, 3).a(48);
    public static en X = new ga(46, 1, 1, 0).a(1);
    public static en Y = new ga(47, 1, 1, 1).a(17);
    public static en Z = new ga(48, 1, 1, 2).a(33);
    public static en aa = new ga(49, 1, 1, 3).a(49);
    public static en ab = new ga(50, 2, 2, 0).a(2);
    public static en ac = new ga(51, 2, 2, 1).a(18);
    public static en ad = new ga(52, 2, 2, 2).a(34);
    public static en ae = new ga(53, 2, 2, 3).a(50);
    public static en af = new ga(54, 3, 3, 0).a(3);
    public static en ag = new ga(55, 3, 3, 1).a(19);
    public static en ah = new ga(56, 3, 3, 2).a(35);
    public static en ai = new ga(57, 3, 3, 3).a(51);
    public static en aj = new ga(58, 1, 4, 0).a(4);
    public static en ak = new ga(59, 1, 4, 1).a(20);
    public static en al = new ga(60, 1, 4, 2).a(36);
    public static en am = new ga(61, 1, 4, 3).a(52);
    public static en an = new en(62).a(6);
    public static en ao = new ig(63, 3).a(87);
    public static en ap = new ig(64, 8).a(88);
    public static en aq = new ht(65).a(26);
    public static en ar = new ig(66, 42).a(11);
    public static en as = new fd(67).a(42);
    public static en at = new fn(68, Material.Packet20NamedEntitySpawn).a(43);
    public static en au = new ak(69, 0).a(74);
    public static en av = new ak(70, Block.A.ba).a(75);
    public static en aw = new ak(71, Block.C.ba).a(76);
    public static en ax = new ce(72, 0).a(135);
    public static en ay = new cp(73).a(104);
    public static en az = new fn(74, Material.e).a(44);
    public static en aA = new fr(75).a(56);
    public static en aB = new cb(76).a(14);
    public static en aC = new ff(77).a(136);
    public static en aD = new en(78).a(103);
    public static en aE = new en(79).a(77);
    public static en aF = new en(80).a(22);
    public static en aG = new en(81).a(57);
    public static en aH = new ie(82, Block.aX).a(27);
    public static en aI = new en(83).a(58);
    public static en aJ = new en(84).a(59);
    public static en aK = new en(85).a(30);
    public static en aL = new ce(86, 1).a(151);
    public static en aM = new ce(87, 2).a(167);
    public static en aN = new en(88).a(12);
    public static en aO = new ef(2000, "13").a(240);
    public static en aP = new ef(2001, "cat").a(241);
    public final int aQ;
    protected int aR = 64;
    protected int aS = 32;
    protected int aT;
    protected boolean aU = false;

    protected en(int n2) {
        this.aQ = 256 + n2;
        if (c[256 + n2] != null) {
            System.out.println("CONFLICT @ " + n2);
        }
        en.c[256 + n2] = this;
    }

    public en a(int n2) {
        this.aT = n2;
        return this;
    }

    public boolean a(gc gc2, EntityPlayer entityplayer2, World dp2, int n2, int n3, int n4, int n5) {
        return false;
    }

    public float a(gc gc2, Block et2) {
        return 1.0f;
    }

    public int a() {
        return this.aR;
    }

    public int b() {
        return this.aS;
    }

    public void a(gc gc2, int n2, int n3, int n4, int n5) {
    }

    public boolean a(Block et2) {
        return false;
    }

    public en c() {
        this.aU = true;
        return this;
    }
}

