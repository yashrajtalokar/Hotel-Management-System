package project.hms;

import project.room.RoomData;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HmsLoginPanel extends JFrame implements ActionListener
{
    JPanel pan;
    JLabel luser,lpass;
    JLabel img = new JLabel(new ImageIcon("hms2.jpg"));
    JTextField tuser,usercheat = new JTextField("root"),passcheat = new JTextField("pass@123");
    JPasswordField tpass;
    JButton login,reset;
    String user,pass;

    Connection con;
    PreparedStatement pmt;

    String url = "jdbc:mysql://localhost : 3306/hotel_11_heaven_database";
    String sql_user = "root";
    String sql_pass = "HmsProject@2020";
    String query = null;


    public HmsLoginPanel()
    {
        super("11 HEAVEN ADMINISTRATOR LOGIN PANEL");

        ImageIcon img1 = new ImageIcon("bank-2010880_640.png");
        setIconImage(img1.getImage());

        setLayout(null);

        createHms();

        setSize(760,660);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }
        });

        setVisible(true);
    }

    public void exit()
    {
        int x = JOptionPane.showConfirmDialog(null,"Do you want to Exit from Application (Y/N)","MESSAGE",JOptionPane.YES_NO_OPTION);

        if(x == JOptionPane.YES_OPTION)
        {
            System.exit(62);
        }
    }

    void createHms()
    {
        img.setBounds(0,0,760,660);

        add(img);

        luser = new JLabel("USERNAME");
        luser.setFont(new Font("arial",Font.BOLD,18));
        luser.setForeground(Color.black);

        lpass = new JLabel("PASSWORD");
        lpass.setFont(new Font("arial",Font.BOLD,18));

        tuser = new JTextField();
        tuser.setFont(new Font("arial;",Font.BOLD,16));

        tpass = new JPasswordField();
        tpass.setFont(new Font("arial;",Font.PLAIN,16));

        login = new JButton("LOGIN");
        login.setFont(new Font("arial;",Font.BOLD,18));

        reset = new JButton("RESET");
        reset.setFont(new Font("arial;",Font.BOLD,18));

        /*   pan = new JPanel();
        getContentPane().add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.lightGray);
        pan.setBackground(new Color(0,0,0,5));
        pan.setBounds(150,130,460,360);
*/

        luser.setBounds(260,140,140,30); img.add(luser);
        tuser.setBounds(390,140,250,30); img.add(tuser);
        lpass.setBounds(260,180,140,30); img.add(lpass);
        tpass.setBounds(390,180,250,30); img.add(tpass);
        login.setBounds(300,260,120,40); img.add(login);
        reset.setBounds(440,260,120,40); img.add(reset);

        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        login.setMnemonic('l');
        reset.setMnemonic('r');

        login.setBorderPainted(true);

        login.addActionListener(this);
        reset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login)
        {
            user = tuser.getText();
            pass = String.valueOf(tpass.getPassword());

            if(user.equals(usercheat.getText()) && pass.equals(passcheat.getText()))
            {
                SimpleDateFormat sdf_time = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat sdf_date = new SimpleDateFormat("MMMM/dd/yyyy");
                Date date = new Date();
                Date time = new Date();

                try
                {

                    String store_date = sdf_date.format(date);
                    String store_time = sdf_time.format(time);

                    con = DriverManager.getConnection(url,sql_user,sql_pass);

                    query = "select * from login_data";
                    pmt = con.prepareStatement(query);
                    ResultSet rs = pmt.executeQuery();

                    int sr_no = 0;
                    while(rs.next())
                    {
                        sr_no = rs.getInt(1);
                    }

                    rs.close();
                    pmt.close();

                    if(sr_no == 0)
                    {
                        query = "insert into login_data values (?,?,?)";
                        pmt = con.prepareStatement(query);

                        pmt.setInt(1,++sr_no);
                        pmt.setString(2, store_date);
                        pmt.setString(3, store_time);

                        pmt.executeUpdate();

                        pmt.close();
                    }

                    else {
                        query = "insert into login_data values (?,?,?)";
                        pmt = con.prepareStatement(query);

                        pmt.setInt(1, ++sr_no);
                        pmt.setString(2, store_date);
                        pmt.setString(3, store_time);

                        pmt.executeUpdate();

                        pmt.close();
                    }
                    con.close();

                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULL");
                    this.setVisible(false);
                    new RoomData();
                }

                catch (Exception exp)
                {

                }

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
