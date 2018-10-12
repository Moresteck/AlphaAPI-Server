/*
 * Decompiled with CFR 0_132.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

public class hh
extends JComponent {
    private int[] a = new int[256];
    private int b = 0;
    private String[] c = new String[10];

    public hh() {
        this.setPreferredSize(new Dimension(256, 196));
        this.setMinimumSize(new Dimension(256, 196));
        this.setMaximumSize(new Dimension(256, 196));
        new Timer(500, new ib(this)).start();
        this.setBackground(Color.BLACK);
    }

    private void a() {
        long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.c[0] = "Memory use: " + l2 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.c[1] = "Threads: " + aw.b + " + " + aw.Packet20NamedEntitySpawn;
        this.a[this.b++ & 255] = (int)(l2 * 100L / Runtime.getRuntime().maxMemory());
        this.repaint();
    }

    public void paint(Graphics graphics) {
        int n2;
        graphics.setColor(new Color(16777215));
        graphics.fillRect(0, 0, 256, 192);
        for (n2 = 0; n2 < 256; ++n2) {
            int n3 = this.a[n2 + this.b & 255];
            graphics.setColor(new Color(n3 + 28 << 16));
            graphics.fillRect(n2, 100 - n3, 1, n3);
        }
        graphics.setColor(Color.BLACK);
        for (n2 = 0; n2 < this.c.length; ++n2) {
            String string = this.c[n2];
            if (string == null) continue;
            graphics.drawString(string, 32, 116 + n2 * 16);
        }
    }

    static /* synthetic */ void a(hh hh2) {
        hh2.a();
    }
}

