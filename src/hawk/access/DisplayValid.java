package hawk.access;

import javax.swing.*;
import java.awt.*;

public class DisplayValid extends JFrame
{
    /* synthetic */ JLabel information;
    
    public DisplayValid() {
        super("Valid key");
        this.information = new JLabel("The key is valid ! You can now use private modules.");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(1);
        this.setVisible(true);
        final Container lllllllllllllllIlIlIllllIIllIIII = this.getContentPane();
        final FlowLayout lllllllllllllllIlIlIllllIIlIllll = new FlowLayout();
        lllllllllllllllIlIlIllllIIllIIII.setLayout(lllllllllllllllIlIlIllllIIlIllll);
        lllllllllllllllIlIlIllllIIllIIII.add(this.information);
        this.setContentPane(lllllllllllllllIlIlIllllIIllIIII);
    }
}
