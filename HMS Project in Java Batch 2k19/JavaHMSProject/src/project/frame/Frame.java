package project.frame;

import javax.swing.*;
import project.hms.*;

public class Frame extends JFrame
{
    public static void set(JFrame f)
    {
        ImageIcon i = new ImageIcon("project/hms/bank-2010880_640.png");


        f.setLayout(null);
        f.setBounds(0,0,1920,1080);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setIconImage(i.getImage());
        f.setVisible(true);

    }
}
