package project.hms;

import javafx.scene.image.Image;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class HmsLoginPanel extends JFrame implements ActionListener
{
    JPanel pan;
    JLabel luser,lpass;
    JLabel img = new JLabel(new ImageIcon("hms2.jpg"));
    JTextField tuser,usercheat = new JTextField("root"),passcheat = new JTextField("pass@123");
    JPasswordField tpass;
    JButton login,reset;
    String user,pass;
    ImageIcon icon = new ImageIcon("bank-2010880_640.png");

    public HmsLoginPanel()
    {
        super("11 HEAVEN ADMINISTRATOR LOGIN PANEL");
        setIconImage(icon.getImage());
        createHms();

        addLoginComponent();

    }

    void addImg()
    {
        pan = new JPanel();
        getContentPane().add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.lightGray);
        pan.setBackground(new Color(0,0,0,5));
        add(img);

        pan.setBounds(150,130,460,360);
    }

    void addLoginComponent()
    {
        luser = new JLabel("USERNAME");
        luser.setFont(new Font("arial",Font.BOLD,18));
        luser.setForeground(Color.black);
        lpass = new JLabel("PASSWORD");
        lpass.setFont(new Font("arial",Font.BOLD,18));
        lpass.setForeground(Color.BLACK);
        tuser = new JTextField();
        tuser.setFont(new Font("arial;",Font.BOLD,16));
        tuser.resetKeyboardActions();
        tpass = new JPasswordField();
        tpass.setFont(new Font("arial;",Font.PLAIN,16));
        login = new JButton("LOGIN");
        login.setFont(new Font("arial;",Font.BOLD,18));
        reset = new JButton("RESET");
        reset.setFont(new Font("arial;",Font.BOLD,18));
     /*   resetpass = new JButton("Forgot Password");
        resetpass.setBackground(new Color(0,0,0,5));
        resetpass.setBorderPainted(false);
*/
        luser.setBounds(100,10,140,30); pan.add(luser);
        tuser.setBounds(230,10,250,30); pan.add(tuser);
        lpass.setBounds(100,50,140,30); pan.add(lpass);
        tpass.setBounds(230,50,250,30); pan.add(tpass);
        login.setBounds(140,130,120,40); pan.add(login);
        reset.setBounds(280,130,120,40); pan.add(reset);
  /*      resetpass.setBounds(160,100,180,30); pan.add(resetpass);
        resetpass.setBackground(Color.LIGHT_GRAY);
*/

        login.setMnemonic('l');
        reset.setMnemonic('r');

        login.setBorderPainted(true);

        login.addActionListener(this);
        reset.addActionListener(this);
        //      resetpass.addActionListener(this);

        setVisible(true);
    }

    void createHms()
    {

        addImg();
        setSize(760,660);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login)
        {
            user = tuser.getText();
            pass = String.valueOf(tpass.getPassword());

            if(user.equals(usercheat.getText()) && pass.equals(passcheat.getText())) {
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULL");
                this.setVisible(false);
                new Choose();
            }

            else
                JOptionPane.showMessageDialog(null,"LOGIN UNSUCCESSFULL");

        }

        if(e.getSource() == reset)
        {
            tuser.setText("");
            tpass.setText("");
        }
    }
}
