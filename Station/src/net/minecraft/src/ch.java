package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JTextArea;
import javax.swing.text.Document;

public class ch
extends Handler {
    private int[] b = new int[1024];
    private int c = 0;
    Formatter a = new fo(this);
    private JTextArea d;

    public ch(JTextArea jTextArea) {
        this.setFormatter(this.a);
        this.d = jTextArea;
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        int n2 = this.d.getDocument().getLength();
        this.d.append(this.a.format(logRecord));
        this.d.setCaretPosition(this.d.getDocument().getLength());
        int n3 = this.d.getDocument().getLength() - n2;
        if (this.b[this.c] != 0) {
            this.d.replaceRange("", 0, this.b[this.c]);
        }
        this.b[this.c] = n3;
        this.c = (this.c + 1) % 1024;
    }
}

