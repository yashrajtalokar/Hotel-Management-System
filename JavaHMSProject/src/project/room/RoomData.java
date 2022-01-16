package project.room;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class RoomData extends JFrame
{

    Connection con;
    PreparedStatement pmt;
    ResultSet rs;
    String url = "jdbc:mysql://localhost : 3306/practice";
    String user = "root";
    String pass = "HmsProject@2020";
    String query = null;

    int sr_no;
    String room_no;
    String room_type;
    String bed_type;
    String available;
    String cost;
    String name;
    int age;
    String mobile_no;
    String address;
    SimpleDateFormat sdf;
    String date;

    String getid;
    String city;
    String state;
    String country;

     ImageIcon icon = new ImageIcon("bank-2010880_640.png");


    JFrame insert_frame = new JFrame("ROOM BOOKING");
    JFrame display_frame = new JFrame("ALLOCATED ROOMS");
    JFrame search_frame = new JFrame("SEARCH CUSTOMER RECORD");

    ImageIcon i = new ImageIcon("InnerRoom.jpg");
    JLabel img = new JLabel(i);
    JLabel img3 = new JLabel(new ImageIcon("InnerRoom.jpg"));
    JPanel pan1,pan2;
    JTable tab;
    DefaultTableModel model;
    ImageIcon img1;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int ht = (int)tk.getScreenSize().getHeight();
    int wt = (int)tk.getScreenSize().getWidth();

    JPanel pan3,pan4;

    JLabel lroom_no,troom_no,lname,lage,lphone_no,lcheckin,lgender,laddress,lcity,lstate,lcountry,lnationality,lid_proof;
    JLabel lsr_no,lroom_type,lbed_type,lcost,lavailable,troom_type,tbed_type,tcost;
    JDateChooser checkin;
    JTextField tsr_no,tname,tage,tphone_no,tcity,tstate,tcountry,tnationality,tavailable;
    JTextArea taddress;
    JRadioButton male,female;
    JComboBox id_proof;

    JButton save,reset;

    void displayRoomData() throws Exception
    {
        con = DriverManager.getConnection(url,user,pass);
        query = "select * from room";
        pmt = con.prepareStatement(query);
        ResultSet rs = pmt.executeQuery();

        display_frame.setLayout(null);
        JPanel display_panel = new JPanel();
        display_panel.setLayout(null);
        display_panel.setBounds(0,0,wt,ht);
        display_frame.getContentPane().add(display_panel);

        JTable table = new JTable();
        DefaultTableModel model1 = new DefaultTableModel();
        table.setModel(model1);

        model1.setColumnIdentifiers(new String[]{"ID.No", "Room No", "Room Type", "Bed Type", "Tariff Per Room", "Availability", "Name", "Age", "Mobile No", "Address", "CheckIn", "Gender", "Id Proof", "City", "State", "Country"});

        while(rs.next())
        {
            sr_no = rs.getInt(1);
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

            String gender = rs.getString(12);
            getid = rs.getString(13);
            city = rs.getString(14);
            state = rs.getString(15);
            country = rs.getString(16);

            model1.addRow(new Object[]{sr_no,room_no,room_type,bed_type,cost,available,name,age,mobile_no,address,date,gender,getid,city,state,country});
        }

        rs.close();

        JScrollPane jsp = new JScrollPane(table);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setFillsViewportHeight(true);
        table.setModel(model1);
        table.setSize(wt,1000);
        jsp.setBounds(0,100,wt,500);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        display_panel.add(jsp);
        display_frame.setSize(wt,ht);
        display_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        display_frame.setResizable(false);
        display_frame.setVisible(true);
    }

    void searchRoomData() throws Exception
    {
        search_frame.setLayout(null);
        JPanel search_panel = new JPanel();
        search_panel.setLayout(null);
        search_frame.getContentPane().add(search_panel);
        search_panel.setBounds(0,0,wt,ht);

        JTable table = new JTable();
        DefaultTableModel model1 = new DefaultTableModel();
        table.setModel(model1);

        model1.setColumnIdentifiers(new String[]{"ID.No", "Room No", "Room Type", "Bed Type", "Tariff Per Room", "Availability", "Name", "Age", "Mobile No", "Address", "CheckIn", "Gender", "Id Proof", "City", "State", "Country"});

        JLabel slname = new JLabel("NAME");
        JTextField stname = new JTextField();

        slname.setBounds(300,150,150,30);
        slname.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slname);

        stname.setBounds(450,150,160,30);
        stname.setFont(new Font("Times New Roman",Font.PLAIN,22));
        stname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(stname);

        JLabel slage = new JLabel("AGE");
        JTextField stage = new JTextField();

        slage.setBounds(300,200,150,30);
        slage.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slage);

        stage.setBounds(450,200,60,30);
        stage.setFont(new Font("Times New Roman",Font.PLAIN,22));
        stage.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(stage);

        JLabel slphone_no = new JLabel("MOBILE NO");

        slphone_no.setBounds(300,250,150,30);
        slphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        search_panel.add(slphone_no);

        JTextField st_phone_no = new JTextField();

        st_phone_no.setBounds(450,250,60,30);
        st_phone_no.setFont(new Font("Times New Roman",Font.PLAIN,22));
        st_phone_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        search_panel.add(st_phone_no);

        JScrollPane jsp = new JScrollPane(table);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setFillsViewportHeight(true);
        table.setModel(model1);
        table.setSize(wt,1000);
        jsp.setBounds(0,400,wt,500);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JButton search = new JButton("SEARCH");
        search.setBounds(300,350,130,30);
        search_panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    con = DriverManager.getConnection(url, user, pass);
                    query = "select * from room";
                    pmt = con.prepareStatement(query);
                    ResultSet rs = pmt.executeQuery();

                    while (rs.next()) {

                        sr_no = rs.getInt(1);
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

                        String gender = rs.getString(12);
                        getid = rs.getString(13);
                        city = rs.getString(14);
                        state = rs.getString(15);
                        country = rs.getString(16);

                        if(name.equals(stname.getText()) && age == Integer.parseInt(stage.getText()) && mobile_no.equals(st_phone_no.getText()))
                        {
                            model1.addRow(new Object[]{sr_no, room_no, room_type, bed_type, cost, available, name, age, mobile_no, address, date, gender, getid, city, state, country});
                            search_panel.add(jsp);
                        }
                    }

                }

                catch (Exception exp)
                {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
        });

        search_frame.setSize(wt,ht);
        search_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        search_frame.setResizable(false);
        search_frame.setVisible(true);
    }

    public void createUI() throws Exception
    {
        pan1 = new JPanel();
        insert_frame.getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(0,0,wt,130);
        img3.setBounds(0,0,wt,130);
        pan1.setBackground(Color.LIGHT_GRAY);
        setIconImage(icon.getImage());

        pan2 = new JPanel();
        insert_frame.getContentPane().add(pan2);
        pan2.setLayout(null);
        pan2.setBounds(0,131,wt,ht-130);
        pan2.setBackground(Color.CYAN);

        lroom_no = new JLabel("ROOM NO");
        lroom_no.setBounds(560,30,150,30);
        lroom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lroom_no);

        troom_no = new JLabel();
        troom_no.setText(tab.getValueAt(tab.getSelectedRow(),1).toString());
        troom_no.setBounds(720,30,240,30);
        troom_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(troom_no);

        lsr_no = new JLabel("ID.NO.");
        lsr_no.setBounds(300,30,150,30);
        lsr_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lsr_no);

        tsr_no = new JTextField();
        tsr_no.setBounds(450,30,60,30);
        tsr_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        tsr_no.setText(tab.getValueAt(tab.getSelectedRow(),0).toString());
        tsr_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tsr_no);

        lroom_type = new JLabel("ROOM TYPE");
        lroom_type.setBounds(300,80,150,30);
        lroom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lroom_type);

        troom_type = new JLabel();
        troom_type.setBounds(450,80,100,30);
        troom_type.setText(tab.getValueAt(tab.getSelectedRow(),2).toString());
        troom_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(troom_type);

        lavailable = new JLabel("AVAILABLE");
        lavailable.setBounds(560,80,150,30);
        lavailable.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lavailable);

        tavailable = new JTextField();
        tavailable.setBounds(720,80,100,30);
        tavailable.setText(tab.getValueAt(tab.getSelectedRow(),5).toString());
        tavailable.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tavailable);

        lbed_type = new JLabel("BED TYPE");
        lbed_type.setBounds(300,130,150,30);
        lbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lbed_type);

        tbed_type = new JLabel();
        tbed_type.setBounds(450,130,100,30);
        tbed_type.setText(tab.getValueAt(tab.getSelectedRow(),3).toString());
        tbed_type.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tbed_type);

        lcost = new JLabel("COST/Room");
        lcost.setBounds(560,130,150,30);
        lcost.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcost);

        tcost = new JLabel();
        tcost.setBounds(720,130,100,30);
        tcost.setText(tab.getValueAt(tab.getSelectedRow(),4).toString());
        tcost.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(tcost);

        lname = new JLabel("NAME");
        lname.setBounds(300,180,150,30);
        lname.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lname);

        tname = new JTextField();
        tname.setBounds(450,180,300,30);
        tname.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tname);

        lage = new JLabel("AGE");
        lage.setBounds(300,230,150,30);
        lage.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lage);

        tage = new JTextField();
        tage.setBounds(450,230,60,30);
        tage.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tage.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tage);

        lphone_no = new JLabel("MOBILE NO");
        lphone_no.setBounds(560,230,150,30);
        lphone_no.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lphone_no);

        tphone_no = new JTextField();
        tphone_no.setBounds(720,230,180,30);
        tphone_no.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tphone_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tphone_no);

        laddress = new JLabel("ADDRESS");
        laddress.setBounds(300,280,150,30);
        laddress.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(laddress);

        taddress = new JTextArea();
        taddress.setBounds(450,280,450,60);
        taddress.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        taddress.setFont(new Font("Times New Roman",Font.PLAIN,22));
        pan2.add(taddress);

        lcheckin = new JLabel("CHECK IN");
        lcheckin.setBounds(300,360,150,30);
        lcheckin.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcheckin);

        checkin = new JDateChooser();
        checkin.setBounds(450,360,250,30);
        checkin.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        checkin.setFont(new Font("Times New Roman",Font.PLAIN,22));
        pan2.add(checkin);

        lgender = new JLabel("GENDER");
        lgender.setBounds(300,410,150,30);
        lgender.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lgender);

        male = new JRadioButton("MALE");
        male.setBounds(450,410,100,30);
        male.setBackground(Color.cyan);
        male.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        male.setFont(new Font("Times New Roman",Font.BOLD,22));

        female = new JRadioButton("FEMALE");
        female.setBounds(550,410,120,30);
        female.setBackground(Color.cyan);
        female.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        female.setFont(new Font("Times New Roman",Font.BOLD,22));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        pan2.add(male);
        pan2.add(female);

        lcity = new JLabel("CITY");
        lcity.setBounds(300,510,150,30);
        lcity.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcity);

        tcity = new JTextField();
        tcity.setBounds(450,510,300,30);
        tcity.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tcity.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tcity);

        lstate = new JLabel("STATE");
        lstate.setBounds(300,560,150,30);
        lstate.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lstate);

        tstate = new JTextField();
        tstate.setBounds(450,560,300,30);
        tstate.setFont(new Font("Times New Roman",Font.PLAIN,22));
        tstate.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        pan2.add(tstate);

        lcountry = new JLabel("COUNTRY");
        lcountry.setBounds(300,610,150,30);
        lcountry.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lcountry);

        tcountry = new JTextField();
        tcountry.setBounds(450,610,300,30);
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
        lid_proof.setBounds(300,460,150,30);
        lid_proof.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan2.add(lid_proof);


        String[] values = {"","Aadhar Card","Voter ID","Passport","Driving License","Pan Card"};
        id_proof = new JComboBox(values);
        id_proof.setSelectedIndex(0);
        id_proof.setBounds(450,460,300,30);
        id_proof.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        id_proof.setFont(new Font("Times New Roman",Font.BOLD,20));
        id_proof.setEditable(false);
        pan2.add(id_proof);

        reset = new JButton("RESET");
        reset.setBounds(620,700,180,40);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        reset.setFont(new Font("Times New Roman",Font.BOLD,24));
        pan2.add(reset);

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
        save.setBounds(400,700,180,40);
        save.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        save.setFont(new Font("Times New Roman",Font.BOLD,24));
        pan2.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tab.getSelectedRow();

                if ("NO".equals(tab.getValueAt(row, 5).toString()))
                {
                    JOptionPane.showMessageDialog(null, "ROOM is Already Booked");
                }

                else
                {
                    try
                    {
                        sr_no = Integer.parseInt(tsr_no.getText());
                        room_no = troom_no.getText();
                        room_type = troom_type.getText();
                        bed_type = tbed_type.getText();
                        available = tavailable.getText();
                        cost = tcost.getText();
                        name = tname.getText();
                        age = Integer.parseInt(tage.getText());
                        mobile_no = tphone_no.getText();
                        address = taddress.getText();
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                        date = sdf.format(checkin.getDate());

                        getid = id_proof.getSelectedItem().toString();
                        city = tcity.getText();
                        state = tstate.getText();
                        country = tcountry.getText();

                        query = "insert into room values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        pmt = con.prepareStatement(query);

                        pmt.setInt(1, sr_no);
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

                        String setgender = null;

                        if (male.isSelected())
                            setgender = "MALE";

                        if (female.isSelected())
                            setgender = "FEMALE";

                        pmt.setString(12, setgender);
                        pmt.setString(13, getid);
                        pmt.setString(14, city);
                        pmt.setString(15, state);
                        pmt.setString(16, country);

                        pmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Record Successfully Added");

                        tab.setValueAt("NO", row, 5);

                        pmt.close();

                        //                        query = "update roomlist set Available = " + tab.getValueAt(row,5).toString() + "where SrNo = " +tab.getValueAt(row,0);
                        //                        pmt = con.prepareStatement(query);
                        //                        Statement smt = con.createStatement();
                        //                        smt.executeUpdate(query);
                        //                        JOptionPane.showMessageDialog(null,"Update Successfully");
                        //
                        //                        pmt.close();
                    }
                        catch (Exception exp)
                        {
                            JOptionPane.showMessageDialog(null, "Check ROOM Credentials");
                        }

                }
            }
        });
    }

    public RoomData() throws Exception
    {
        super("Room Booking");

        con = DriverManager.getConnection(url,user,pass);

        pan3 = new JPanel();
        pan4 = new JPanel();

        setLayout(new BorderLayout());
        getContentPane().add(pan3,BorderLayout.NORTH);
        getContentPane().add(pan4,BorderLayout.SOUTH);

        img1 = new ImageIcon("bank-2010880_640.png");
        setIconImage(img1.getImage());

        pan3.setLayout(new BorderLayout());
        pan3.setSize(wt,350);
        pan3.add(img);

        createTable();

        setSize(wt,ht);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //img.add(check);
    }

    void createTable() throws Exception
    {

        String[] column_values = {"ID.NO.","ROOM NO", "ROOM TYPE","BED TYPE", "TARIFF PER ROOM","AVAILABILITY"} ;

        getContentPane().add(pan4);

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
            model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
        }

        rs.close();

        JScrollPane sp = new JScrollPane(tab);

        pan4.setLayout(null);
        sp.setBounds(300,80,1200,440);
        pan4.add(sp);
        pan4.setBounds(0,351,wt,ht-351);

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
                    insert_frame.setLayout(null);

                    createUI();

                    insert_frame.setSize(wt,ht);
                    insert_frame.setLocationRelativeTo(null);
                    insert_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    insert_frame.setVisible(true);
                }

                catch (Exception evt)
                {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }
}

    /*void choosePage()
    {
        JLabel hname = new JLabel("HOTEL 11TH HEAVEN!");

        //pan.setLayout(null);
        //pan.setBounds(0,0,1000,650);

        add(imgg);

        //this.pack();

        room = new JButton("Room");
        room.setLayout(null);
        room.setBounds(420,200,150,35);
        room.setFont(new Font("Lucida Console",Font.BOLD,25));
        room.setBackground(Color.PINK);
        room.setForeground(Color.BLACK);

        food = new JButton("Food");
        food.setLayout(null);
        food.setBounds(420,270,150,35);
        food.setFont(new Font("Lucida Console",Font.BOLD,25));
        food.setBackground(Color.CYAN);
        food.setForeground(Color.BLACK);

        hname.setLayout(null);
        hname.setBounds(150,50,750,90);
        hname.setFont(new Font("Arial",Font.PLAIN,68));
        hname.setForeground(Color.BLACK);

        imgg.setLayout(null);
        imgg.setBounds(0,0,1000,650);
        imgg.add(hname);
        imgg.add(room);
        imgg.add(food);


        setLayout(null);
        setBounds(200,50,1000,650);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



}
    }





*/
































