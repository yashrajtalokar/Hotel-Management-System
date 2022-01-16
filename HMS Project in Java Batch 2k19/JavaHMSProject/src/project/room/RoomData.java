package project.room;

import com.toedter.calendar.JDateChooser;
import project.hms.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomData extends JFrame
{
    Connection con;
    PreparedStatement pmt;
    ResultSet rs;
    String url = "jdbc:mysql://localhost : 3306/hotel_11_heaven_database";
    String user = "root";
    String pass = "HmsProject@2020";
    String query = null;

    String room_no;
    String room_type;
    String bed_type;
    String available;
    String cost;
    String name;
    int age;

    public static int imp_r[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; // most important variable imp_r

    String mobile_no;
    String address;
    SimpleDateFormat sdf;
    String date;

    String getid;
    String city;
    String state;
    String country;

    JLabel img3;
    JFrame list_of_rooms_frame = new JFrame("LIST OF ROOMS");
    JFrame booking_frame = new JFrame("ROOM BOOKING");
    JFrame display_frame = new JFrame("ALLOCATED ROOMS");
    JFrame search_frame = new JFrame("SEARCH CUSTOMER RECORD");
    JFrame bill_frame = new JFrame("BILL GENERATION");

    ImageIcon i = new ImageIcon("InnerRoom.jpg");
    JLabel img = new JLabel(i);
    JPanel pan1,pan2;
    JTable tab;
    DefaultTableModel model;
    ImageIcon img1;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int ht = (int)tk.getScreenSize().getHeight();
    int wt = (int)tk.getScreenSize().getWidth();

    JPanel pan3,pan4;

    JLabel lroom_no,troom_no,lname,lage,lphone_no,lcheckin,lgender,laddress,lcity,lstate,lcountry,lnationality,lid_proof;
    JLabel lroom_type,lbed_type,lcost,lavailable,troom_type,tbed_type,tcost,tavailable;
    JDateChooser checkin,checkout;
    JTextField tname,tage,tphone_no,tcity,tstate,tcountry,tnationality;
    JTextArea taddress;
    JRadioButton male,female;
    JComboBox id_proof;

    JButton save,reset;
    JButton back = new JButton(new ImageIcon("back.png"));


    public void displayRoomData() throws Exception
    {
        con = DriverManager.getConnection(url,user,pass);
        query = "select * from room_data";
        pmt = con.prepareStatement(query);
        ResultSet rs = pmt.executeQuery();

        display_frame.setLayout(null);
        JPanel display_panel = new JPanel();
        display_panel.setLayout(null);
        display_panel.setBounds(0,151,wt,ht-150);
        display_frame.getContentPane().add(display_panel);
        display_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        display_panel.setBackground(new Color(255,255,255,0));

        img1 = new ImageIcon("bank-2010880_640.png");
        display_frame.setIconImage(img1.getImage());

        JTable table = new JTable();
        DefaultTableModel model1 = new DefaultTableModel();
        table.setModel(model1);

        model1.setColumnIdentifiers(new String[]{"ID.No", "Room No", "Room Type", "Bed Type", "Tariff Per Room", "Availability", "Name", "Age", "Mobile No", "Address", "CheckIn", "CheckOut","Gender", "Id Proof", "City", "State", "Country"});

        while(rs.next())
        {
            int sr_no = rs.getInt(1);
            room_no = rs.getString(2);
            room_type = rs.getString(3);
            bed_type = rs.getString(4);
            available = rs.getString(6);
            cost = rs.getString(5);
            name = rs.getString(7);
            age = rs.getInt(8);
            mobile_no = rs.getString(9);
            address = rs.getString(10);;
            date = rs.getString(11);

            String gender = rs.getString(13);
            getid = rs.getString(14);
            city = rs.getString(15);
            state = rs.getString(16);
            country = rs.getString(17);

            model1.addRow(new Object[]{sr_no,room_no,room_type,bed_type,cost,available,name,age,mobile_no,address,date,rs.getString(12),gender,getid,city,state,country});
        }

        rs.close();

        JScrollPane jsp = new JScrollPane(table);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setModel(model1);
        table.setSize(wt-20,600);
        jsp.setBounds(10,0,wt-20,600);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JPanel display_header = new JPanel();
        display_header.setLayout(null);
        display_header.setBounds(0,0,wt,150);
        display_header.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        display_header.setBackground(Color.BLACK);

        JLabel lview_record = new JLabel("VIEW ALLOCATED ROOMS RECORD");
        lview_record.setOpaque(true);
        lview_record.setBounds(0,0,wt,130);
        lview_record.setFont(new Font("Engravers MT",Font.PLAIN,72));
        lview_record.setHorizontalAlignment(SwingConstants.CENTER);
        lview_record.setForeground(Color.WHITE);
        lview_record.setBackground(Color.GRAY);

        display_header.add(lview_record);
        display_header.setBackground(Color.GRAY);
        display_frame.getContentPane().add(display_header);

        //JTableHeader header = new JTableHeader();
        //table.setTableHeader(header);

        back.setBounds(20,800,70,30);
        display_panel.add(back);

        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Thread.sleep(200);
                    display_frame.setVisible(false);
                    new RoomData();
                }

                catch (Exception e1)
                {}
            }
        });

        display_panel.add(jsp);
        display_frame.setBounds(0,0,wt,ht-40);
        display_frame.setResizable(false);
        display_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        display_frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }
        });
        display_frame.setLocationRelativeTo(null);
        display_frame.setVisible(true);
    }

    public void searchRoomData() throws Exception
    {
        search_frame.setLayout(null);

        JLabel hotel_room = new JLabel(new ImageIcon("hotel_room.jpg"));

        JPanel search_panel = new JPanel();
        search_panel.setLayout(null);
        search_frame.getContentPane().add(search_panel);

        search_panel.setBounds(0,151,wt,ht-150);
        search_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        img1 = new ImageIcon("bank-2010880_640.png");
        search_frame.setIconImage(img1.getImage());

        hotel_room.setBounds(0,1,wt,ht-550);
        search_panel.add(hotel_room);

        JPanel search_header = new JPanel();
        search_header.setLayout(null);
        search_header.setBounds(0,0,wt,150);
        search_header.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        search_frame.getContentPane().add(search_header);

        JLabel lsearch_record = new JLabel("SEARCH ALLOCATED ROOMS");
        lsearch_record.setOpaque(true);
        lsearch_record.setBounds(0,0,wt,150);
        lsearch_record.setFont(new Font("Engravers MT",Font.PLAIN,72));
        lsearch_record.setHorizontalAlignment(SwingConstants.CENTER);
        lsearch_record.setForeground(Color.WHITE);
        lsearch_record.setBackground(Color.GRAY);
        search_header.add(lsearch_record);

        search_panel.setBackground(new Color(255,255,255,0));

        JTable search_table = new JTable();
        DefaultTableModel search_model = new DefaultTableModel();
        JScrollPane scrollPane = new JScrollPane(search_table);;

        search_table.setModel(search_model);
        search_model.setColumnIdentifiers(new String[]{"ID.No", "Room No", "Room Type", "Bed Type", "Tariff Per Room", "Availability", "Name", "Age", "Mobile No", "Address", "CheckIn", "CheckOut", "Gender", "Id Proof", "City", "State", "Country"});

        JLabel slname = new JLabel("CUSTOMER'S NAME");
        JTextField stname = new JTextField();

        slname.setBounds(200,600,250,30);
        slname.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slname);

        stname.setBounds(450,600,250,30);
        stname.setFont(new Font("Times New Roman",Font.PLAIN,22));
        stname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(stname);

        JLabel slroom_no = new JLabel("ROOM NO.");
        JTextField stroom_no = new JTextField();

        slroom_no.setBounds(750,600,150,30);
        slroom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slroom_no);

        stroom_no.setBounds(900,600,60,30);
        stroom_no.setFont(new Font("Times New Roman",Font.PLAIN,22));
        stroom_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(stroom_no);

        JLabel slphone_no = new JLabel("MOBILE NO");

        slphone_no.setBounds(1000,600,150,30);
        slphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slphone_no);

        JTextField st_phone_no = new JTextField();

        st_phone_no.setBounds(1200,600,180,30);
        st_phone_no.setFont(new Font("Times New Roman",Font.PLAIN,22));
        st_phone_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(st_phone_no);

        search_table.getTableHeader().setReorderingAllowed(false);
        search_table.getTableHeader().setResizingAllowed(false);
        search_table.setFillsViewportHeight(true);
        scrollPane.setBounds(0,1,wt,ht-550);
        search_table.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        back.setBounds(1,810,70,30);
        search_panel.add(back);

        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    Thread.sleep(200);
                    search_frame.setVisible(false);
                    new RoomData();
                }

                catch (Exception e)
                {}
            }
        });

        JButton search = new JButton("SEARCH");
        search.setFont(new Font("times new roman",Font.BOLD,24));
        search.setBounds(620,685,200,40);
        search_panel.add(search);

        JButton reset = new JButton("RESET");
        reset.setFont(new Font("times new roman",Font.BOLD,24));
        reset.setBounds(890,685,200,40);
        search_panel.add(reset);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stname.setText(" ");
                st_phone_no.setText(" ");
                stroom_no.setText(" ");
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    con = DriverManager.getConnection(url, user, pass);
                    query = "select * from room_data";
                    pmt = con.prepareStatement(query);
                    ResultSet rs = pmt.executeQuery();

                    while (rs.next()) {

                        int sr_no = rs.getInt(1);
                        room_no = rs.getString(2);
                        room_type = rs.getString(3);
                        bed_type = rs.getString(4);
                        available = rs.getString(6);
                        cost = rs.getString(5);
                        name = rs.getString(7);
                        age = rs.getInt(8);
                        mobile_no = rs.getString(9);
                        address = rs.getString(10);
                        date = rs.getString(11);

                        String gender = rs.getString(13);
                        getid = rs.getString(14);
                        city = rs.getString(15);
                        state = rs.getString(16);
                        country = rs.getString(17);

                        if(name.equals(stname.getText()) && room_no.equals(stroom_no.getText()) && mobile_no.equals(st_phone_no.getText()))
                        {
                            search_model.addRow(new Object[]{sr_no, room_no, room_type, bed_type, cost, available, name, age, mobile_no, address, date, rs.getString(12),gender, getid, city, state, country});
//                            search_panel.add(scrollPane);

                            JPanel trick_pan = new JPanel();
                            trick_pan.setLayout(null);
                            search_panel.add(trick_pan);

                            trick_pan.setBounds(0,1,wt,ht-550);
                            trick_pan.add(scrollPane);
                        }
                    }
                }

                catch (Exception exp)
                {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
        });

        search_frame.setSize(wt,ht-40);
        search_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        search_frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }
        });
        search_frame.setLocationRelativeTo(null);
        search_frame.setResizable(false);
        search_frame.setVisible(true);
    }

    public void showAvailableRooms() throws Exception
    {
        con = DriverManager.getConnection(url,user,pass);

        pan3 = new JPanel();
        pan4 = new JPanel();

        list_of_rooms_frame.setLayout(new BorderLayout());
        list_of_rooms_frame.getContentPane().add(pan3,BorderLayout.NORTH);
        list_of_rooms_frame.getContentPane().add(pan4,BorderLayout.SOUTH);

        img1 = new ImageIcon("bank-2010880_640.png");
        list_of_rooms_frame.setIconImage(img1.getImage());
        img3 = new JLabel(new ImageIcon("InnerRoom.jpg"));

        pan3.setLayout(new BorderLayout());
        pan3.setSize(wt,350);
        pan3.add(img3);
        pan3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        createTable();

        back.setBounds(0,660,70,30);
        pan4.add(back);

        list_of_rooms_frame.setSize(wt,ht);
        list_of_rooms_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        list_of_rooms_frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }
        });
        list_of_rooms_frame.setLocationRelativeTo(null);
        list_of_rooms_frame.setVisible(true);
    }

    public void createTable() throws Exception
    {

        String[] column_values = {"ROOM NO", "ROOM TYPE","BED TYPE", "TARIFF PER ROOM","AVAILABILITY"} ;

        list_of_rooms_frame.getContentPane().add(pan4);

        tab = new JTable();

        model = new DefaultTableModel();
        tab.setModel(model);
        model.setColumnIdentifiers(column_values);

        // Displaying data from database

        con = DriverManager.getConnection(url,user,pass);
        query = "select * from roomlist";
        pmt = con.prepareStatement(query);
        ResultSet rs = pmt.executeQuery();

        while (rs.next())
        {
            model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
        }

        rs.close();

        query = "select * from available_column";
        pmt = con.prepareStatement(query);
        rs = pmt.executeQuery();

        while(rs.next())
        {
            tab.setValueAt("NO", rs.getInt(2), 4);
        }

        rs.close();

        JScrollPane sp = new JScrollPane(tab);

        pan4.setLayout(null);
        sp.setBounds(300,80,1200,440);
        pan4.add(sp);
        pan4.setBounds(0,351,wt,ht-351);
        pan4.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JTableHeader header = new JTableHeader();
        tab.setFont(new Font("arial",Font.PLAIN,16));

        sp.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,false));
        tab.getTableHeader().setResizingAllowed(false);
        tab.getTableHeader().setReorderingAllowed(false);

        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    int r = tab.getSelectedRow();
                    if(tab.getValueAt(r,4).toString().equals("NO"))
                        JOptionPane.showMessageDialog(null,"ROOM IS ALREADY BOOKED");

                    else
                    {
                        Thread.sleep(250);
                        list_of_rooms_frame.setVisible(false);

                        booking_frame.setLayout(null);

                        createUI();

                        booking_frame.setSize(wt, ht);
                        booking_frame.setLocationRelativeTo(null);
                        booking_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

                        booking_frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e)
                            {
                                exit();
                            }
                        });
                        booking_frame.setVisible(true);
                    }
                }

                catch (Exception evt)
                {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }

    public void createUI() throws Exception
    {
        img1 = new ImageIcon("bank-2010880_640.png");
        booking_frame.setIconImage(img1.getImage());

        pan1 = new JPanel();
        booking_frame.getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(0,0,wt,150);
        img3.setBounds(0,0,wt,150);
        pan1.setBackground(Color.GRAY);
        pan1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        pan2 = new JPanel();
        booking_frame.getContentPane().add(pan2);
        pan2.setLayout(null);
        pan2.setBounds(0,131,wt,ht-130);
        pan2.setBackground(new Color(255,255,255,0));
        pan2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel interior_img = new JLabel(new ImageIcon("available_interior.jpg"));
        interior_img.setBounds(800,1,wt-800,ht-150);
        interior_img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        pan2.add(interior_img);

        JLabel display_header = new JLabel("ROOM DATA INFORMATION");
        display_header.setOpaque(true);
        display_header.setBounds(250,0,1600,130);
        display_header.setFont(new Font("Engravers MT",Font.PLAIN,80));
        display_header.setHorizontalAlignment(SwingConstants.CENTER);
        display_header.setForeground(Color.WHITE);
        display_header.setBackground(Color.GRAY);
        pan1.add(display_header);

        lroom_no = new JLabel("ROOM NO");
        lroom_no.setBounds(150,50,150,30);
        lroom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lroom_no);

        troom_no = new JLabel();
        troom_no.setText(tab.getValueAt(tab.getSelectedRow(),0).toString());
        troom_no.setBounds(300,50,240,30);
        troom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(troom_no);

        lroom_type = new JLabel("ROOM TYPE");
        lroom_type.setBounds(150,100,150,30);
        lroom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lroom_type);

        troom_type = new JLabel();
        troom_type.setBounds(300,100,100,30);
        troom_type.setText(tab.getValueAt(tab.getSelectedRow(),1).toString());
        troom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(troom_type);

        lavailable = new JLabel("AVAILABLE");
        lavailable.setBounds(410,100,150,30);
        lavailable.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lavailable);

        tavailable = new JLabel();
        tavailable.setBounds(570,100,100,30);
        tavailable.setText(tab.getValueAt(tab.getSelectedRow(),4).toString());
        tavailable.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tavailable);

        lbed_type = new JLabel("BED TYPE");
        lbed_type.setBounds(150,150,150,30);
        lbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lbed_type);

        tbed_type = new JLabel();
        tbed_type.setBounds(300,150,100,30);
        tbed_type.setText(tab.getValueAt(tab.getSelectedRow(),2).toString());
        tbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tbed_type);

        lcost = new JLabel("COST/Room");
        lcost.setBounds(410,150,150,30);
        lcost.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcost);

        tcost = new JLabel();
        tcost.setBounds(570,150,100,30);
        tcost.setText(tab.getValueAt(tab.getSelectedRow(),3).toString());
        tcost.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tcost);

        lname = new JLabel("NAME");
        lname.setBounds(150,200,150,30);
        lname.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lname);

        tname = new JTextField();
        tname.setBounds(300,200,300,30);
        tname.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tname);

        lage = new JLabel("AGE");
        lage.setBounds(150,250,150,30);
        lage.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lage);

        tage = new JTextField();
        tage.setBounds(300,250,60,30);
        tage.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tage.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tage);

        lphone_no = new JLabel("MOBILE NO");
        lphone_no.setBounds(410,250,150,30);
        lphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lphone_no);

        tphone_no = new JTextField();
        tphone_no.setBounds(570,250,180,30);
        tphone_no.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tphone_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tphone_no);

        laddress = new JLabel("ADDRESS");
        laddress.setBounds(150,300,150,30);
        laddress.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(laddress);

        taddress = new JTextArea();
        taddress.setBounds(300,300,450,60);
        taddress.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        taddress.setFont(new Font("Times New Roman",Font.PLAIN,22));
        pan2.add(taddress);

        lcheckin = new JLabel("CHECK IN");
        lcheckin.setBounds(150,380,150,30);
        lcheckin.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcheckin);

        checkin = new JDateChooser();
        checkin.setBounds(300,380,250,30);
        checkin.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        checkin.setFont(new Font("Times New Roman",Font.PLAIN,22));
        pan2.add(checkin);

        JLabel lcheckout = new JLabel("CHECK OUT");
        lcheckout.setBounds(150,430,150,30);
        lcheckout.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcheckout);

        checkout = new JDateChooser();
        checkout.setBounds(300,430,250,30);
        checkout.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        checkout.setFont(new Font("Times New Roman",Font.PLAIN,22));
        pan2.add(checkout);

        lgender = new JLabel("GENDER");
        lgender.setBounds(150,480,150,30);
        lgender.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lgender);

        male = new JRadioButton("MALE");
        male.setBounds(300,480,100,30);
        //male.setBackground(Color.cyan);
        male.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        male.setFont(new Font("Times New Roman",Font.BOLD,22));

        female = new JRadioButton("FEMALE");
        female.setBounds(400,480,120,30);
        //female.setBackground(Color.cyan);
        female.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        female.setFont(new Font("Times New Roman",Font.BOLD,22));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        pan2.add(male);
        pan2.add(female);

        lcity = new JLabel("CITY");
        lcity.setBounds(150,580,150,30);
        lcity.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcity);

        tcity = new JTextField();
        tcity.setBounds(300,580,300,30);
        tcity.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tcity.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tcity);

        lstate = new JLabel("STATE");
        lstate.setBounds(150,630,150,30);
        lstate.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lstate);

        tstate = new JTextField();
        tstate.setBounds(300,630,300,30);
        tstate.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tstate.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tstate);

        lcountry = new JLabel("COUNTRY");
        lcountry.setBounds(150,680,150,30);
        lcountry.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcountry);

        tcountry = new JTextField();
        tcountry.setBounds(300,680,300,30);
        tcountry.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tcountry.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tcountry);

/*      lnationality = new JLabel("NATIONALITY");
        lnationality.setBounds(300,660,150,30);
        lnationality.setFont(new Font("Times New Roman",Font.BOLD,20));
        pan2.add(lnationality);

        tnationality = new JTextField();
        tnationality.setBounds(450,660,300,30);
        tnationality.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tnationality.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tnationality);
*/
        lid_proof = new JLabel("ID PROOF");
        lid_proof.setBounds(150,530,150,30);
        lid_proof.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lid_proof);


        String[] values = {"","Aadhar Card","Voter ID","Passport","Driving License","Pan Card"};
        id_proof = new JComboBox(values);
        id_proof.setSelectedIndex(0);
        id_proof.setBounds(300,530,300,30);
        id_proof.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        id_proof.setFont(new Font("Times New Roman",Font.BOLD,20));
        id_proof.setEditable(false);
        pan2.add(id_proof);

        reset = new JButton("RESET");
        reset.setBounds(440,760,220,40);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        reset.setFont(new Font("Times New Roman",Font.BOLD,28));
        pan2.add(reset);

        back.setBounds(1,820,70,30);
        pan2.add(back);

        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    Thread.sleep(100);
                    booking_frame.setVisible(false);

                    showAvailableRooms();
                }

                catch (Exception e)
                {}
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tname.setText("");
                tage.setText("");
                tphone_no.setText("");
                taddress.setText("");
                buttonGroup.clearSelection();
                id_proof.setSelectedIndex(0);
                tcity.setText("");
                tstate.setText("");
                tcountry.setText("");
            }
        });

        save = new JButton("SAVE DATA");
        save.setBounds(180,760,220,40);
        save.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        save.setFont(new Font("Times New Roman",Font.BOLD,28));
        pan2.add(save);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tab.getSelectedRow();

                if ("NO".equals(tab.getValueAt(row, 4).toString()))
                {
                    JOptionPane.showMessageDialog(null, "ROOM IS ALREADY BOOKED");
                }

                else {
                    if (tname.getText().equals(null)) {
                        JOptionPane.showMessageDialog(null,"CHECK CREDENTIALS");
                    }

                    else
                    {

                        SimpleDateFormat sdf_date = new SimpleDateFormat("dd");
                        SimpleDateFormat sdf_month = new SimpleDateFormat("MM");
                        SimpleDateFormat sdf_year = new SimpleDateFormat("yyyy");

                        Date current_date = new Date();

                        if (sdf_date.format(current_date).equals(sdf_date.format(checkin.getDate())) && sdf_month.format(current_date).equals(sdf_month.format(checkin.getDate())) && sdf_year.format(current_date).equals(sdf_year.format(checkin.getDate()))) {
                            if (sdf_year.format(checkin.getDate()).compareTo(sdf_year.format(checkout.getDate())) <= 0) {
                                if (sdf_month.format(checkin.getDate()).compareTo(sdf_month.format(checkout.getDate())) == 0) {
                                    if (sdf_date.format(checkin.getDate()).compareTo(sdf_date.format(checkout.getDate())) <= 0) {
                                        try {
                                            query = "select * from room_data";
                                            pmt = con.prepareStatement(query);
                                            ResultSet rs = pmt.executeQuery();

                                            int sr_no = 0;
                                            while (rs.next()) {
                                                sr_no = rs.getInt(1);
                                            }

                                            rs.close();
                                            pmt.close();

                                            room_no = troom_no.getText();
                                            room_type = troom_type.getText();
                                            bed_type = tbed_type.getText();
                                            available = tavailable.getText();
                                            cost = tcost.getText();
                                            name = tname.getText();
                                            age = Integer.parseInt(tage.getText());
                                            mobile_no = tphone_no.getText();
                                            address = taddress.getText();
                                            sdf = new SimpleDateFormat("yyyy-MMMM-dd");
                                            date = sdf.format(checkin.getDate());

                                            getid = id_proof.getSelectedItem().toString();
                                            city = tcity.getText();
                                            state = tstate.getText();
                                            country = tcountry.getText();

                                            query = "insert into room_data values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                            pmt = con.prepareStatement(query);

                                            pmt.setInt(1, ++sr_no);
                                            pmt.setString(2, room_no);
                                            pmt.setString(3, room_type);
                                            pmt.setString(4, bed_type);
                                            pmt.setString(5, cost);
                                            pmt.setString(6, available);
                                            pmt.setString(7, name);
                                            pmt.setInt(8, age);
                                            pmt.setString(9, mobile_no);
                                            pmt.setString(10, address);
                                            pmt.setString(11, date);
                                            pmt.setString(12, sdf.format(checkout.getDate()));

                                            String setgender = null;

                                            if (male.isSelected())
                                                setgender = "MALE";

                                            if (female.isSelected())
                                                setgender = "FEMALE";

                                            pmt.setString(13, setgender);
                                            pmt.setString(14, getid);
                                            pmt.setString(15, city);
                                            pmt.setString(16, state);
                                            pmt.setString(17, country);

                                            pmt.executeUpdate();

                                            JOptionPane.showMessageDialog(null, "RECORD SUCCESSFULLY ADDED");

                                            tab.setValueAt("NO", row, 4);

                                            pmt.close();

                                            Thread.sleep(250);
                                            booking_frame.setVisible(false);

                                            generateBill();

                                        } catch (NullPointerException npex) {
                                            JOptionPane.showMessageDialog(null, "CHECK ROOM CREDENTIALS");
                                        } catch (Exception exp) {
                                            JOptionPane.showMessageDialog(null, "CHECK ROOM CREDENTIALS");

                                        }

                                    } else
                                        JOptionPane.showMessageDialog(null, "CHECKOUT DATE IS SMALLER THAN CHECKOUT DATE");
                                }


                                if (sdf_month.format(checkin.getDate()).compareTo(sdf_month.format(checkout.getDate())) < 0) {
                                    try {
                                        query = "select * from room_data";
                                        pmt = con.prepareStatement(query);
                                        ResultSet rs = pmt.executeQuery();

                                        int sr_no = 0;
                                        while (rs.next()) {
                                            sr_no = rs.getInt(1);
                                        }

                                        rs.close();
                                        pmt.close();

                                        room_no = troom_no.getText();
                                        room_type = troom_type.getText();
                                        bed_type = tbed_type.getText();
                                        available = tavailable.getText();
                                        cost = tcost.getText();
                                        name = tname.getText();
                                        age = Integer.parseInt(tage.getText());
                                        mobile_no = tphone_no.getText();
                                        address = taddress.getText();
                                        sdf = new SimpleDateFormat("yyyy-MMMM-dd");
                                        date = sdf.format(checkin.getDate());

                                        getid = id_proof.getSelectedItem().toString();
                                        city = tcity.getText();
                                        state = tstate.getText();
                                        country = tcountry.getText();

                                        query = "insert into room_data values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                        pmt = con.prepareStatement(query);

                                        pmt.setInt(1, ++sr_no);
                                        pmt.setString(2, room_no);
                                        pmt.setString(3, room_type);
                                        pmt.setString(4, bed_type);
                                        pmt.setString(5, cost);
                                        pmt.setString(6, available);
                                        pmt.setString(7, name);
                                        pmt.setInt(8, age);
                                        pmt.setString(9, mobile_no);
                                        pmt.setString(10, address);
                                        pmt.setString(11, date);
                                        pmt.setString(12, sdf.format(checkout.getDate()));

                                        String setgender = null;

                                        if (male.isSelected())
                                            setgender = "MALE";

                                        if (female.isSelected())
                                            setgender = "FEMALE";

                                        pmt.setString(13, setgender);
                                        pmt.setString(14, getid);
                                        pmt.setString(15, city);
                                        pmt.setString(16, state);
                                        pmt.setString(17, country);

                                        pmt.executeUpdate();

                                        JOptionPane.showMessageDialog(null, "RECORD SUCCESSFULLY ADDED");

                                        tab.setValueAt("NO", row, 4);

                                        pmt.close();

                                        Thread.sleep(500);
                                        booking_frame.setVisible(false);

                                        generateBill();

                                    } catch (NullPointerException rex) {
                                        JOptionPane.showMessageDialog(null, "CHECK ROOM CREDENTIALS");
                                    } catch (Exception exp) {
                                        JOptionPane.showMessageDialog(null, "CHECK ROOM CREDENTIALS");
                                    }
                                }
                            } else
                                JOptionPane.showMessageDialog(null, "CHECK CHECKIN OR CHECKOUT DATE");
                        } else
                            JOptionPane.showMessageDialog(null, "CHECK CHECKIN DATE");
                    }

                }
            }
        });
    }

    public void generateBill() throws Exception
    {
        bill_frame.setLayout(null);

        ht-=40;

        JPanel bill_panel1 = new JPanel();
        bill_frame.getContentPane().add(bill_panel1);
        bill_panel1.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        bill_panel1.setLayout(null);
        bill_panel1.setBounds(0, 0, 1400, 130);
        img1 = new ImageIcon("bank-2010880_640.png");
        bill_frame.setIconImage(img1.getImage());

        JLabel display_bill = new JLabel("BILL");
        display_bill.setOpaque(true);
        display_bill.setBounds(250,0,900,130);
        display_bill.setFont(new Font("Engravers MT",Font.PLAIN,100));
        display_bill.setHorizontalAlignment(SwingConstants.CENTER);
        display_bill.setForeground(Color.WHITE);
        display_bill.setBackground(Color.GRAY);
        bill_panel1.add(display_bill);
        bill_panel1.setBackground(Color.GRAY);

        JPanel bill_panel2 = new JPanel();
        bill_frame.getContentPane().add(bill_panel2);
        bill_panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        bill_panel2.setLayout(null);
        bill_panel2.setBounds(0, 121, 1400, ht - 130);
        bill_panel2.setBackground(new Color(255,255,255,0));

        JLabel clname = new JLabel("Customer's Name");
        clname.setBounds(200,30,200,30);
        clname.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clname);

        JLabel ctname = new JLabel();
        ctname.setText(tname.getText());
        ctname.setBounds(400,30,550,30);
        ctname.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctname);

        JLabel clage = new JLabel("Customer's Age");
        clage.setBounds(200,80,200,30);
        clage.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clage);

        JLabel ctage = new JLabel();
        ctage.setText(tage.getText() + " yrs");
        ctage.setBounds(400,80,100,30);
        ctage.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctage);

        JLabel clphone_no = new JLabel("Mobile No.");
        clphone_no.setBounds(200,130,200,30);
        clphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clphone_no);

        JLabel ctphone_no = new JLabel();
        ctphone_no.setText(tphone_no.getText());
        ctphone_no.setBounds(400,130,200,30);
        ctphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctphone_no);

        JLabel clid_proof = new JLabel("ID Proof");
        clid_proof.setBounds(200,180,200,30);
        clid_proof.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clid_proof);

        JLabel ctid_proof = new JLabel();
        ctid_proof.setText(id_proof.getSelectedItem().toString());
        ctid_proof.setBounds(400,180,200,30);
        ctid_proof.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctid_proof);

        JLabel clroom_no = new JLabel("Room No.");
        clroom_no.setBounds(200,230,200,30);
        clroom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clroom_no);

        JLabel ctroom_no = new JLabel();
        ctroom_no.setText(troom_no.getText());
        ctroom_no.setBounds(400,230,200,30);
        ctroom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctroom_no);

        JLabel clroom_type = new JLabel("Room Type");
        clroom_type.setBounds(200,280,200,30);
        clroom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clroom_type);

        JLabel ctroom_type = new JLabel();
        ctroom_type.setText(troom_type.getText());
        ctroom_type.setBounds(400,280,200,30);
        ctroom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctroom_type);

        JLabel clbed_type = new JLabel("Bed Type");
        clbed_type.setBounds(200,330,200,30);
        clbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clbed_type);

        JLabel ctbed_type = new JLabel();
        ctbed_type.setBounds(400,330,200,30);
        ctbed_type.setText(tbed_type.getText());
        ctbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctbed_type);

        JLabel clcheckin = new JLabel("Checkin Date");
        clcheckin.setBounds(200,380,200,30);
        clcheckin.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clcheckin);

        sdf = new SimpleDateFormat("yyyy-MMMM-dd");

        JLabel ctcheckin = new JLabel();
        ctcheckin.setText(sdf.format(checkin.getDate()));
        ctcheckin.setBounds(400,380,200,30);
        ctcheckin.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctcheckin);

        JLabel clcheckout = new JLabel("Checkout Date");
        clcheckout.setBounds(200,430,200,30);
        clcheckout.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clcheckout);

        JLabel ctcheckout = new JLabel();
        ctcheckout.setText(sdf.format(checkout.getDate()));
        ctcheckout.setBounds(400,430,200,30);
        ctcheckout.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctcheckout);

        JLabel clcost_per_room = new JLabel("Cost Per Day");
        clcost_per_room.setBounds(200,480,200,30);
        clcost_per_room.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clcost_per_room);

        JLabel ctcost_per_room = new JLabel();
        ctcost_per_room.setText(tcost.getText());
        ctcost_per_room.setBounds(400,480,200,30);
        ctcost_per_room.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctcost_per_room);

        JLabel cltotal_days = new JLabel("Total Days");
        cltotal_days.setBounds(200,530,200,30);
        cltotal_days.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(cltotal_days);

        SimpleDateFormat get_date = new SimpleDateFormat("dd");
        SimpleDateFormat get_month = new SimpleDateFormat("MM");
        SimpleDateFormat get_year = new SimpleDateFormat("yyyy");

        int ci_date = Integer.parseInt(get_date.format(checkin.getDate()));
        int co_date = Integer.parseInt(get_date.format(checkout.getDate()));

        int tot_day = 0;

        int ci_month = Integer.parseInt(get_month.format(checkin.getDate()));
        int co_month = Integer.parseInt(get_month.format(checkout.getDate()));

        int ci_year = Integer.parseInt(get_month.format(checkin.getDate()));
        int co_year = Integer.parseInt(get_month.format(checkout.getDate()));

        if(ci_year == co_year)
        {
            if(ci_month == co_month)
            {
                tot_day = co_date - ci_date + 1;
            }
        }


        JLabel cttotal_days = new JLabel();
        cttotal_days.setText(String.valueOf(tot_day) + " days");
        cttotal_days.setBounds(400,530,200,30);
        cttotal_days.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(cttotal_days);

        JLabel clpayment_mode = new JLabel("Payment Mode");
        clpayment_mode.setBounds(200,580,200,30);
        clpayment_mode.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clpayment_mode);

        String[] values = {"","Credit Card","Debit Card","Online Payment","Cash",};
        JComboBox payment_mode = new JComboBox(values);
        payment_mode.setSelectedIndex(0);
        payment_mode.setBounds(400,580,200,30);
        payment_mode.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        payment_mode.setFont(new Font("Times New Roman",Font.BOLD,20));
        payment_mode.setEditable(false  );
        bill_panel2.add(payment_mode);

        JLabel clnet_amt = new JLabel("Net Amount");
        clnet_amt.setBounds(200,630,200,30);
        clnet_amt.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clnet_amt);

        JLabel ctnet_amt = new JLabel();
        String cost = tcost.getText().substring(3);
        int cost_per_day = Integer.valueOf(cost);
        int net_amt = cost_per_day * tot_day;
        ctnet_amt.setText("Rs." + String.valueOf(net_amt));
        ctnet_amt.setBounds(400,630,200,30);
        ctnet_amt.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctnet_amt);

        int gst = (net_amt * 20) / 100;

        JLabel clgst = new JLabel("G.S.T [20% N.A.]");
        clgst.setBounds(200,680, 200,30);
        clgst.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(clgst);

        JLabel ctgst = new JLabel();
        ctgst.setText("Rs." + String.valueOf(gst));
        ctgst.setBounds(400,680, 200,30);
        ctgst.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(ctgst);

        JLabel cltotal_amt = new JLabel("TOTAL PAYABLE AMOUNT");
        cltotal_amt.setBounds(200,730, 300,30);
        cltotal_amt.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(cltotal_amt);

        int tot_amt = net_amt + gst;

        JLabel cttotal_amt = new JLabel();
        cttotal_amt.setText("Rs." + String.valueOf(tot_amt));
        cttotal_amt.setBounds(520,730, 300,30);
        cttotal_amt.setFont(new Font("Times New Roman",Font.BOLD,22));
        bill_panel2.add(cttotal_amt);

        JButton pay_bill = new JButton("Generate Bill");
        pay_bill.setBounds(350,780,500,50);
        pay_bill.setFont(new Font("Times New Roman",Font.BOLD,36));
        bill_panel2.add(pay_bill);
        pay_bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try {
                        query = "select * from bill_data";
                        pmt = con.prepareStatement(query);
                        ResultSet rs = pmt.executeQuery();

                        int sr_no = 0;
                        while (rs.next()) {
                            sr_no = rs.getInt(1);
                        }


                        try {

                            query = "insert into bill_data values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                            pmt = con.prepareStatement(query);

                            pmt.setInt(1, ++sr_no);
                            pmt.setString(2,ctname.getText());
                            pmt.setString(3,ctphone_no.getText());
                            pmt.setString(4,ctage.getText());
                            pmt.setString(5,ctid_proof.getText());
                            pmt.setString(6,ctroom_no.getText());
                            pmt.setString(7,ctroom_type.getText());
                            pmt.setString(8,ctbed_type.getText());
                            pmt.setString(9,ctcheckin.getText());
                            pmt.setString(10,ctcheckout.getText());
                            pmt.setString(11,ctcost_per_room.getText());
                            pmt.setString(12,cttotal_days.getText());
                            pmt.setString(13,payment_mode.getSelectedItem().toString());
                            pmt.setString(14,ctnet_amt.getText());
                            pmt.setString(15,ctgst.getText());
                            pmt.setString(16,cttotal_amt.getText());

                            pmt.executeUpdate();

                            pmt.close();
                            rs.close();

                            JOptionPane.showMessageDialog(null,"BILL GENERATED SUCCESSFULLY");

                            query = "select * from  available_column";
                            pmt = con.prepareStatement(query);
                            rs = pmt.executeQuery();
                            int srno = 0;
                            while (rs.next()) {
                                srno = rs.getInt(1);
                            }

                            query = "insert into available_column values (?,?)";
                            pmt = con.prepareStatement(query);

                            int r = tab.getSelectedRow();
                            imp_r[r] = r;

                            pmt.setInt(1,++srno);
                            pmt.setInt(2,imp_r[r]);

                            pmt.executeUpdate();

                            pmt.close();
                            rs.close();

                            Thread.sleep(250);
                            bill_frame.setVisible(false);

                            new RoomData();

                        }

                        catch (Exception e1)
                        {
                            JOptionPane.showMessageDialog(null,"CHECK INPUT CREDENTIALS");
                        }

                    }
                    catch (Exception exp)
                    {
                        JOptionPane.showMessageDialog(null,"CHECK INPUT CREDENTIALS");
                    }
                }

                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"CHECK INPUT CREDENTIALS");
                }
            }
        });

        bill_frame.setBounds(0,0,1400, ht);
        bill_frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        bill_frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent)
            {
                exit();
            }
        });
        bill_frame.setLocationRelativeTo(null);
        bill_frame.setResizable(false);
        bill_frame.setVisible(true);
    }

    ImageIcon i_icon = new ImageIcon("Hotel_Menu.jpg");
    JLabel hname;
    JLabel menu_img = new JLabel("",i_icon,JLabel.CENTER);

    public RoomData() throws Exception
    {
        super("HOTEL 11 HEAVEN DASHBOARD");

        img1 = new ImageIcon("bank-2010880_640.png");
        setIconImage(img1.getImage());

        setLayout(null);
        JLabel hname = new JLabel("HOTEL 11TH HEAVEN!");
        add(menu_img);

        hname.setLayout(null);
        hname.setBounds(300,150,1550,110);
        hname.setFont(new Font("times new roman",Font.BOLD,110));
        hname.setHorizontalAlignment(SwingConstants.CENTER);
        hname.setForeground(Color.DARK_GRAY);

        menu_img.setLayout(null);
        menu_img.setBounds(0,0,wt,ht-40);
        menu_img.add(hname);

        JMenuBar bar = new JMenuBar();
        bar.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        setJMenuBar(bar);

        JMenu manage_room = new JMenu("  MANAGE ROOM  ");
        manage_room.setFont(new Font("times new roman",Font.BOLD,26));
        manage_room.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        manage_room.setMnemonic('m');

        JMenuItem add_room = new JMenuItem("ADD RECORD");
        add_room.setFont(new Font("times new roman",Font.PLAIN,23));
        add_room.setMnemonic('a');
        add_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    setVisible(false);
                    Thread.sleep(200);
                    showAvailableRooms();
                }

                catch (Exception e1)
                {}
            }
        });

        JMenuItem display_room = new JMenuItem("VIEW RECORDS");
        display_room.setFont(new Font("times new roman",Font.PLAIN,23));
        display_room.setMnemonic('v');
        display_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    setVisible(false);
                    Thread.sleep(200);
                    displayRoomData();
                }

                catch (Exception e1)
                {}
            }
        });

        JMenuItem search_room = new JMenuItem("SEARCH RECORD");
        search_room.setFont(new Font("times new roman",Font.PLAIN,23));
        search_room.setMnemonic('s');
        search_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    setVisible(false);
                    Thread.sleep(200);
                    searchRoomData();
                }

                catch (Exception e1)
                {
                }
            }
        });

        manage_room.add(add_room);
        manage_room.addSeparator();
        manage_room.add(display_room);
        manage_room.addSeparator();
        manage_room.add(search_room);
        manage_room.addSeparator();

        JMenu manage_food = new JMenu("  MANAGE FOOD  ");
        manage_food.setMnemonic('f');
        manage_food.setFont(new Font("times new roman",Font.BOLD,26));
        manage_food.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JMenuItem order_food = new JMenuItem("ORDER FOOD");
        order_food.setFont(new Font("times new roman",Font.PLAIN,23));
        order_food.setMnemonic('o');
        manage_food.addSeparator();
        manage_food.add(order_food);

        order_food.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    setVisible(false);
                    Thread.sleep(200);

                    new Food();
                }
                catch (Exception e1)
                {}
            }
        });

        JMenu about = new JMenu("  ABOUT  ");
        about.setMnemonic('a');
        about.setFont(new Font("times new roman",Font.BOLD,26));
        about.addSeparator();
        about.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JFrame about_frame = new JFrame("ABOUT");
                    setLayout(null);
                    setBackground(new Color(255,255,255,0));


                    setSize(600,600);
                    setVisible(true);
                }
                catch (Exception e1)
                {}
            }
        });

        bar.add(manage_room);
        bar.add(manage_food);
        bar.add(about);

        setBounds(0,0,wt,ht-40);
        setLocationRelativeTo(null);
        setResizable(false);
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
}