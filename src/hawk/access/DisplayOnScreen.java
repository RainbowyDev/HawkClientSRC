package hawk.access;

import javax.swing.*;
import java.awt.event.*;
import hawk.*;
import java.io.*;
import java.awt.*;

public class DisplayOnScreen extends JFrame implements ActionListener
{
    /* synthetic */ JTextField text;
    public static /* synthetic */ String CorrectKey;
    public static /* synthetic */ String KeyTyped;
    /* synthetic */ JLabel information;
    /* synthetic */ JButton button;
    
    static {
        DisplayOnScreen.CorrectKey = "RFWU4OTRHUY49HUGNRE5HUOIU5JY048764UGTDH";
    }
    
    @Override
    public void actionPerformed(final ActionEvent lllllllllllllllIIIlllllllllllllI) {
        DisplayOnScreen.KeyTyped = this.text.getText();
        if (DisplayOnScreen.KeyTyped.equals(DisplayOnScreen.CorrectKey)) {
            new DisplayValid();
            Client.IsRegistered = true;
            try {
                final PrintWriter lllllllllllllllIIIllllllllllllIl = new PrintWriter(new FileOutputStream("gie5hg8u4toihu45.hawkclient"));
                lllllllllllllllIIIllllllllllllIl.print(DisplayOnScreen.CorrectKey);
                lllllllllllllllIIIllllllllllllIl.close();
            }
            catch (IOException lllllllllllllllIIIllllllllllllII) {
                lllllllllllllllIIIllllllllllllII.printStackTrace();
            }
        }
        else {
            new DisplayInvalid();
        }
    }
    
    public DisplayOnScreen() {
        super("Register key for premium modules (private)");
        this.button = new JButton("Register key");
        this.text = new JTextField("", 25);
        this.information = new JLabel("If you want to access to all settings and all modules, enter the key here");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(1);
        this.setVisible(true);
        final Container lllllllllllllllIIlIIIIIIIIIIIllI = this.getContentPane();
        final FlowLayout lllllllllllllllIIlIIIIIIIIIIIlIl = new FlowLayout();
        lllllllllllllllIIlIIIIIIIIIIIllI.setLayout(lllllllllllllllIIlIIIIIIIIIIIlIl);
        this.button.addActionListener(this);
        lllllllllllllllIIlIIIIIIIIIIIllI.add(this.information);
        lllllllllllllllIIlIIIIIIIIIIIllI.add(this.text);
        lllllllllllllllIIlIIIIIIIIIIIllI.add(this.button);
        this.setContentPane(lllllllllllllllIIlIIIIIIIIIIIllI);
    }
}
