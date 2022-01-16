package hms.mainthread;

import project.hms.HmsLoginPanel;
import project.hms.HmsWindow;
import project.room.RoomData;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class HmsSoftware extends JFrame implements ActionListener
{
    String url = "jdbc:mysql://localhost : 3306/practice";
    String user = "root";
    String pass = "HmsProject@2020";
    Connection con;
    PreparedStatement pmt;
    ResultSet rs;
    String query = null;

    JTable table1;
    JScrollPane sp;
    DefaultTableModel model;
    JPanel pan1,pan2,pan3;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int ht = (int)tk.getScreenSize().getHeight();
    int wt = (int)tk.getScreenSize().getWidth();

    JLabel lname = new JLabel("NAME"),lage = new JLabel("AGE");
    JTextField tname = new JTextField(),tage = new JTextField();
    JButton insert = new JButton("INSERT"),view = new JButton("VIEW"),search = new JButton("SEARCH");

    void createTable()
    {
        pan3 = new JPanel();
        pan3.setLayout(null);
        table1 = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"NAME","AGE"});

        table1.setModel(model);
        sp = new JScrollPane(table1);
        sp.setBounds(400,400,780,70);

        JButton addData = new JButton("ADD INFO");
        addData.setBounds(400,100,120,50);
        pan3.add(addData);

        JFrame f1 = new JFrame("Search Panel");
        f1.getContentPane().add(pan3);
        pan3.setBounds(0,0,wt,ht);
        pan3.add(sp);

        try {
            query = "select * from user1";
            pmt = con.prepareStatement(query);
            rs = pmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("name"), rs.getInt("age")});
            }
        }

        catch (Exception evt)
        {
            evt.getMessage();
        }

        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int row = table1.getSelectedRow();
                    String name = table1.getValueAt(row, 0).toString();

                    String sql = "delete from user1 where name = ?";
                    pmt = con.prepareStatement(sql);
                    pmt.setString(1,name);
                    pmt.executeUpdate();
                    pmt.close();
                }

                catch (Exception exp)
                {
                    exp.printStackTrace();
                }
            }
        });



        f1.setLayout(null);
        f1.setSize(wt,ht);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void searchData()
    {
        pan3 = new JPanel();
        pan3.setLayout(null);
        table1 = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"NAME","AGE"});

        table1.setModel(model);
        sp = new JScrollPane(table1);
        sp.setBounds(400,380,780,50);

        JLabel l1 = new JLabel("AGE");
        JTextField t1 = new JTextField();

        l1.setBounds(350,150,160,50);
        l1.setFont(new Font("times new roman",Font.BOLD,26));
        pan3.add(l1);

        t1.setBounds(550,150,260,50);
        t1.setFont(new Font("times new roman",Font.BOLD,26));
        pan3.add(t1);


        JFrame f1 = new JFrame("Search Panel");
        f1.getContentPane().add(pan3);
        pan3.setBounds(0,0,wt,ht);
        pan3.add(sp);

        JButton sd = new JButton("SEARCH RECORD");
        sd.setBounds(450,300,260,50);
        pan3.add(sd);

        sd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    query = "select * from user1";
                    pmt = con.prepareStatement(query);
                    rs = pmt.executeQuery();

                    while (rs.next()) {
                        if(rs.getInt("age") == Integer.parseInt(t1.getText()))
                            model.addRow(new Object[]{rs.getString("name"), rs.getInt("age")});
                    }
                }


                catch (Exception evt)
                {
                    evt.getMessage();
                }

            }
        });

        f1.setLayout(null);
        f1.setSize(wt,ht);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public HmsSoftware() throws Exception
    {
        super("11th Heaven");
        setLayout(null);

        pan1 = new JPanel();
        pan1.setLayout(null);
        getContentPane().add(pan1);
        pan1.setBounds(0,0,wt,100);
        pan1.setBackground(Color.LIGHT_GRAY);

        pan2 = new JPanel();
        pan2.setLayout(null);
        getContentPane().add(pan2);
        pan2.setBackground(Color.cyan);
        pan2.setBounds(0,81,wt,ht-100);

        lname.setBounds(350,150,160,50);
        lname.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(lname);

        tname.setBounds(580,150,260,50);
        tname.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(tname);

        lage.setBounds(350,290,160,50);
        lage.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(lage);

        tage.setBounds(580,290,260,50);
        tage.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(tage);

        insert.setBounds(400,500,160,50);
        insert.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(insert);

        view.setBounds(600,500,160,50);
        view.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(view);

        search.setBounds(800,500,160,50);
        search.setFont(new Font("times new roman",Font.BOLD,26));
        pan2.add(search);

        insert.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);

        setSize(wt,ht);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == insert) {
            try {
                con = DriverManager.getConnection(url,user,pass);

                query = "insert into  user1 values(?,?)";
                pmt = con.prepareStatement(query);
                pmt.setString(1, tname.getText());
                pmt.setInt(2, Integer.parseInt(tage.getText()));
                pmt.executeUpdate();
                pmt.close();
                con.close();

                JPanel pan = new JPanel();
                pan.setSize(200, 50);
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }

        if(e.getSource() == view)
        {
            try{
                con = DriverManager.getConnection(url,user,pass);
                createTable();
            }

            catch (Exception evt)
            {
                evt.printStackTrace();
            }
        }

        if(e.getSource() == search)
        {
            try{
                con = DriverManager.getConnection(url,user,pass);
                searchData();
            }

            catch (Exception evt)
            {
                evt.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        new HmsWindow();
    }
}
