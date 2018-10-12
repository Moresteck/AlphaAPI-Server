/*
 * Decompiled with CFR 0_132.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class t
implements ActionListener {
    final /* synthetic */ JTextField a;
    final /* synthetic */ ServerGUI b;

    t(ServerGUI fb2, JTextField jTextField) {
        this.b = fb2;
        this.a = jTextField;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String string = this.a.getText().trim();
        if (string.length() > 0) {
            ServerGUI.a(this.b).a(string);
        }
        this.a.setText("");
    }
}

