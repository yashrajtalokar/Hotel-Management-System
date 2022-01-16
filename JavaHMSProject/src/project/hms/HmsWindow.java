package project.hms;

import java.io.*;
import javax.swing.*;
import java.awt.*;

public class HmsWindow extends JFrame {
    // Below Label Declaration is very-very Important
    File f;
    JLabel image = new JLabel(new ImageIcon("hms62.jpg"));

    JProgressBar pbar;

    public HmsWindow() throws Exception
    {
        super("11 HEAVEN");

        createHMS();
        addImageHMS();
        addProgressBar();
        runProgressBar();
    }

    public void createHMS()
    {
        setLayout(null);
        setUndecorated(true);
        setSize(700,500);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void addImageHMS()
    {
        image.setBounds(0,0,700,480);
        getContentPane().add(image);
    }

    public void addProgressBar()
    {
        pbar = new JProgressBar();

        pbar.setBounds(0,480,700,20);
        JLabel zero = new JLabel("0");
        zero.setFont(new Font("algerian",Font.BOLD,20));
        zero.setForeground(Color.BLACK);
        pbar.setValue(Integer.parseInt(zero.getText()));
        pbar.setStringPainted(true);
        pbar.setBorderPainted(true);
        pbar.setBackground(Color.WHITE);
        pbar.setForeground(Color.DARK_GRAY);
        add(pbar);
    }

    public void runProgressBar() throws Exception
    {
        int i=0;
        //     showmsg = new JLabel("");
        //   showmsg.setBounds(440,700,80,20);
        // add(showmsg);

        while(i <= 100)
        {
            Thread.sleep(30);
            pbar.setValue(i);
            pbar.setForeground(Color.DARK_GRAY);

            //showmsg.setText("LOADING " +Integer.toString(i)+ "%");
            i++;
            if(i == 100)
            {
                setVisible(false);
                new HmsLoginPanel();
            }
        }
    }
}
