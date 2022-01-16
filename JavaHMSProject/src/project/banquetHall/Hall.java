package project.banquetHall;

import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class Hall extends JFrame
{
    JLabel img = new JLabel(new ImageIcon("C:\\Users\\KRISHNA VERMA\\Desktop\\HMS Project in Java Batch 2k19\\JavaHMSProject\\src\\project\\hms\\pic2.jpg"));
    JPanel pan;
    JMenuBar bar;
    JMenu manage;
    JMenuItem room,food,hall;
    Toolkit tk = Toolkit.getDefaultToolkit();

    public Hall()
    {
        super("11 Heaven MANAGEMENT SECTION");
        setLayout(null);
        setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight());

        createComponent();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createComponent()
    {
        pan = new JPanel();
        img.setBounds(0,0,1920,1180);

        bar = new JMenuBar();
        bar.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        setJMenuBar(bar);

        manage = new JMenu("MANAGE ->");
        manage.setFont(new Font("arialblack",Font.BOLD,20));
        bar.add(manage);

        room = new JMenuItem("ROOM ->");
        food = new JMenuItem("FOOD ->");
        hall = new JMenuItem("HALL ->");

        room.setFont(new Font("arialblack",Font.BOLD,18));
        food.setFont(new Font("arialblack",Font.BOLD,18));
        hall.setFont(new Font("arialblack",Font.BOLD,18));

        room.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        food.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        hall.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));

        add(img);

       /* manage.add(room);
        manage.add(food);
        manage.add(hall);

        */
    }
}
