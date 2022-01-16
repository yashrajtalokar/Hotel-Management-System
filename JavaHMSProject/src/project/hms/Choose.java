package project.hms;

import project.room.RoomData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Choose extends JFrame
{
    JButton room,food;
    ImageIcon i = new ImageIcon("aaaa.jpg");
    JLabel hname;
    JLabel img = new JLabel("",i,JLabel.CENTER);
    ImageIcon icon = new ImageIcon("bank-2010880_640.png");
    public Choose()
    {
        super("ChoosePage");

        JLabel hname = new JLabel("HOTEL 11TH HEAVEN!");
        setIconImage(icon.getImage());

        add(img);

        room = new JButton("Room");
        room.setLayout(null);
        room.setBounds(420,200,150,35);
        room.setFont(new Font("Lucida Console",Font.BOLD,25));
        room.setBackground(Color.PINK);
        room.setForeground(Color.BLACK);
        room.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));

        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    new RoomData();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        food = new JButton("Food");
        food.setLayout(null);
        food.setBounds(420,270,150,35);
        food.setFont(new Font("Lucida Console",Font.BOLD,25));
        food.setBackground(Color.CYAN);
        food.setForeground(Color.BLACK);
        food.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));

        hname.setLayout(null);
        hname.setBounds(150,50,750,90);
        hname.setFont(new Font("Arial",Font.PLAIN,68));
        hname.setForeground(Color.BLACK);

        img.setLayout(null);
        img.setBounds(0,0,1000,650);
        img.add(hname);
        img.add(room);
        img.add(food);

        setLayout(null);
        setBounds(200,50,1000,650);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}


