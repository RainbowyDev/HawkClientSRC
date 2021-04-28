package hawk.access;

import javax.swing.*;
import java.awt.*;

public class DisplayInvalid extends JFrame
{
    /* synthetic */ JLabel information;
    
    public DisplayInvalid() {
        super("Invalid key");
        this.information = new JLabel("The key is invalid.");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(1);
        this.setVisible(true);
        final Container llllllllllllllllllIlIIllIIIlIIIl = this.getContentPane();
        final FlowLayout llllllllllllllllllIlIIllIIIlIIII = new FlowLayout();
        llllllllllllllllllIlIIllIIIlIIIl.setLayout(llllllllllllllllllIlIIllIIIlIIII);
        llllllllllllllllllIlIIllIIIlIIIl.add(this.information);
        this.setContentPane(llllllllllllllllllIlIIllIIIlIIIl);
    }
}
