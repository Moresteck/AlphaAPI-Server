/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.util.logging.Handler;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.minecraft.server.MinecraftServer;

public class ServerGUI
extends JComponent {
    public static Logger log = Logger.getLogger("Minecraft");
    private MinecraftServer mcServer;

    public static void initGui(MinecraftServer minecraftserver) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception) {
            // empty catch block
        }
        ServerGUI fb2 = new ServerGUI(minecraftserver);
        JFrame jFrame = new JFrame("Minecraft server");
        jFrame.add(fb2);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.addWindowListener(new q(minecraftserver));
    }

    public ServerGUI(MinecraftServer minecraftServer) {
        this.mcServer = minecraftServer;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());
        try {
            this.add((Component)this.getLogComponent(), "Center");
            this.add((Component)this.getStatsComponent(), "West");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private JComponent getStatsComponent() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)new hh(), "North");
        jPanel.add((Component)this.getPlayerListComponent(), "Center");
        jPanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return jPanel;
    }

    private JComponent getPlayerListComponent() {
        PlayerListBox g2 = new PlayerListBox(this.mcServer);
        JScrollPane jScrollPane = new JScrollPane(g2, 22, 30);
        jScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return jScrollPane;
    }

    private JComponent getLogComponent() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JTextArea jTextArea = new JTextArea();
        log.addHandler(new ch(jTextArea));
        JScrollPane jScrollPane = new JScrollPane(jTextArea, 22, 30);
        jTextArea.setEditable(false);
        JTextField jTextField = new JTextField();
        jTextField.addActionListener(new t(this, jTextField));
        jTextArea.addFocusListener(new u(this));
        jPanel.add((Component)jScrollPane, "Center");
        jPanel.add((Component)jTextField, "South");
        jPanel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        return jPanel;
    }

    static MinecraftServer getMinecraftServer(ServerGUI servergui) {
        return servergui.mcServer;
    }
}

