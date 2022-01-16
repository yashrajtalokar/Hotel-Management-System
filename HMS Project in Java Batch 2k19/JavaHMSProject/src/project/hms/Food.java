package project.hms;

import project.frame.Frame;
import project.room.RoomData;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Food extends JFrame
{
    ImageIcon i = new ImageIcon("food_paper.jpg");

    JLabel image_label  = new JLabel(i);
    JLabel text_label	= new JLabel("11th Heaven Meals");
    Font f 				=  new Font("Algerian",Font.PLAIN,140);

    public Food()
    {
        setImage();
        setLabel();
        Frame.set(this);

        try
        {
            Thread.sleep(2000);
        }catch(Exception e)
        {}
        setVisible(false);
        new FoodInfo();
    }

    void setLabel()
    {
        text_label.setForeground(Color.RED);
        text_label.setFont(f);
        text_label.setBounds(60,50,1500,200);
        image_label.add(text_label);
    }

    void setImage()
    {
        add(image_label);
        image_label.setSize(i.getIconWidth(),i.getIconHeight());
    }
}

class FoodInfo extends JFrame
{
    ImageIcon i2          = new ImageIcon("pepper.jpg");
    JLabel image_label_fi = new JLabel(i2);
    Font f2               = new Font("Comic Sans MS",Font.PLAIN,30);//font applied to the labels
    Font f3               = new Font("Lucida Bright",Font.BOLD,70);//Font applied to the heading
    Font text 			  = new Font("Times new Roman",Font.BOLD,25);	//font applied to the textbox
    Font radio 			  = new Font("Comic Sans MS",Font.PLAIN,27);//"" "" "" to the RadioButton

    JLabel cus_info = new JLabel("CUSTOMER'S INFO");
    JLabel name     = new JLabel("NAME");
    JLabel ph_no    = new JLabel("PHONE NUMBER");
    JLabel addr     = new JLabel("ADDRESS");
    JLabel payment  = new JLabel("PAYMENT OF BILL");
    JLabel email_id = new JLabel("EMAIL ID");

    JRadioButton credit     = new JRadioButton("Credit");
    JRadioButton mobile_pay = new JRadioButton("Mobile Payment");
    JRadioButton cash       = new JRadioButton("Cash");
    JRadioButton others 	= new JRadioButton("Others");
    ButtonGroup payment_ways = new ButtonGroup();

    JTextField name_text 	= new JTextField();
    JTextField email_text 	= new JTextField();
    JTextField phone_text 	= new JTextField();
    JTextField addr_text 	= new JTextField();

    String nam,pay_bill;
    JButton next =  new JButton("NEXT");

    public static FinalBill f = new FinalBill();

    FoodInfo()
    {
        setCustomer_Info();
        setImage();
        addButton();

        Frame.set(this);
    }

    void setImage()//adds image to the label and label to the frame
    {
        add(image_label_fi);
        image_label_fi.setSize(i2.getIconWidth(),i2.getIconHeight());

    }

    void setCustomer_Info()//adds labels, radiobuttons and textboxes
    {
        /////////Labels/////////////

        cus_info.setBounds(600,10,720,250);
        image_label_fi.add(cus_info);
        cus_info.setFont(f3);
        cus_info.setForeground(Color.RED);

        name.setBounds(200,300,200,50);
        image_label_fi.add(name);
        name.setFont(f2);
        name.setForeground(Color.PINK);

        payment.setBounds(200,390,300,80);
        image_label_fi.add(payment);
        payment.setFont(f2);
        payment.setForeground(Color.PINK);

        email_id.setBounds(200,500,300,50);
        image_label_fi.add(email_id);
        email_id.setFont(f2);
        email_id.setForeground(Color.PINK);

        ph_no.setBounds(200,600,270,50);
        image_label_fi.add(ph_no);
        ph_no.setFont(f2);
        ph_no.setForeground(Color.PINK);

        addr.setBounds(200,700,200,50);
        image_label_fi.add(addr);
        addr.setFont(f2);
        addr.setForeground(Color.PINK);

//////////////RadioButton///////////////
        credit.setOpaque(false);
        credit.setBounds(500,400,150,50);
        image_label_fi.add(credit);
        credit.setFont(radio);
        credit.setForeground(Color.PINK);

        mobile_pay.setOpaque(false);
        mobile_pay.setBounds(630,400,240,50);
        image_label_fi.add(mobile_pay);
        mobile_pay.setFont(radio);
        mobile_pay.setForeground(Color.PINK);

        cash.setOpaque(false);
        cash.setBounds(870,400,100,50);
        image_label_fi.add(cash);
        cash.setFont(radio);
        cash.setForeground(Color.PINK);

        others.setOpaque(false);
        others.setBounds(980,400,130,50);
        image_label_fi.add(others);
        others.setFont(radio);
        others.setForeground(Color.PINK);

        payment_ways.add(credit);
        payment_ways.add(mobile_pay);
        payment_ways.add(cash);
        payment_ways.add(others);

//////////////TextBox////////////////

        image_label_fi.add(name_text);
        name_text.setBounds(500,300,350,45);
        name_text.setFont(text);

        image_label_fi.add(email_text);
        email_text.setBounds(500,600,350,45);
        email_text.setFont(text);

        image_label_fi.add(phone_text);
        phone_text.setBounds(500,500,350,45);
        phone_text.setFont(text);

        image_label_fi.add(addr_text);
        addr_text.setBounds(500,700,350,45);
        addr_text.setFont(text);
    }

    void addButton()//adds the next page button
    {
        next.setFont(new Font("Bookman Old Style",Font.PLAIN,35));
        next.setBounds(200,850,130,50);
        image_label_fi.add(next);
        next.setContentAreaFilled(false);
        next.setForeground(Color.RED);
        next.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        next.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                nam = name_text.getText();
                if(credit.isSelected())
                {
                    pay_bill = credit.getText();
                }
                else
                if(mobile_pay.isSelected())
                {
                    pay_bill = mobile_pay.getText();
                }
                else
                if(cash.isSelected())
                {
                    pay_bill = cash.getText();
                }
                else
                if (others.isSelected())
                {
                    pay_bill = others.getText();
                }

                setVisible(false);
                f.setCusInfo(nam,pay_bill);
                new FoodMenu();
            }
        });
    }
}

class FoodMenu extends JFrame
{
    ImageIcon i3      = new ImageIcon("taste.jpg");
    JLabel menu_image = new JLabel(i3);
    JLabel menu_title = new JLabel(" TASTE OF INDIA");
    Font f4           = new Font("News701 BT",Font.BOLD,70);
    Font f5           = new Font("Lucida Calligraphy",Font.BOLD,35);

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back         =  new JButton(back_image);

    JLabel veg      = new JLabel("1. Vegetarian Speciality");
    JLabel rice     = new JLabel("2. Rice Speciality");
    JLabel breads   = new JLabel("3. Indian Breads");
    JLabel desserts = new JLabel("4. Desserts");
    JLabel bev      = new JLabel("5. Special Beverages");

    JButton bill = new JButton("BILL");

    static Vector vname  = new Vector();
    static Vector vprice = new Vector();

    FoodMenu()
    {
        setImage();
        setMenuInfo();//TYPES OF DISHES
        setLabelClick();//adds mouselistener to them
        callBill();//displays the bill frame of ordered dishes

        Frame.set(this);
    }

    void setImage()
    {
        add(menu_image);
        menu_image.setSize(i3.getIconWidth(),i3.getIconHeight());
        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setLocation(100,24);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        menu_image.add(back);
        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new FoodInfo();
            }

        });
    }

    void setMenuInfo()//menu provided
    {
        menu_title.setBounds(600,24,710,100);
        menu_image.add(menu_title);
        menu_title.setFont(f4);			///////////displays the title "TASTE OF INDIA"
        menu_title.setForeground(Color.MAGENTA);
        menu_title.setOpaque(true);
        menu_title.setBackground(Color.BLACK);

        veg.setBounds(650,250,530,50);
        menu_image.add(veg);
        veg.setFont(f5);
        veg.setForeground(Color.WHITE);

        rice.setBounds(650,350,500,50);
        menu_image.add(rice);
        rice.setFont(f5);
        rice.setForeground(Color.WHITE);

        breads.setBounds(650,450,500,50);
        menu_image.add(breads);
        breads.setFont(f5);
        breads.setForeground(Color.WHITE);

        desserts.setBounds(650,550,500,50);
        menu_image.add(desserts);
        desserts.setFont(f5);
        desserts.setForeground(Color.WHITE);

        bev.setBounds(650,650,500,50);
        menu_image.add(bev);
        bev.setFont(f5);
        bev.setForeground(Color.WHITE);
    }

    void setLabelClick()//displaying the food items provided in repactive menu
    {
        veg.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Vegetarian();
            }
        });

        rice.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Rice();
            }
        });

        breads.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Breads();
            }
        });

        desserts.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Desserts();
            }
        });

        bev.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Beverages();
            }
        });
    }

    void callBill()
    //opens the new frame showing ordered food and sets the name and mode of payment in the bill receipt
    {
        bill.setBounds(800,800,150,40);
        bill.setFont(new Font("Bookman Old Style",Font.PLAIN,30));
        bill.setBorder(BorderFactory.createBevelBorder(0));
        bill.setForeground(Color.GREEN);
        bill.setBackground(Color.RED);
        menu_image.add(bill);

        bill.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Bill(vname,vprice); //sets the name and mode of payment in the bill receipt
            }

        });
    }
}

class Vegetarian extends JFrame
{
    ImageIcon i4 = new ImageIcon("veg.jpg");
    JLabel vegLabel = new JLabel("Vegetarian Speaciality");
    JLabel vegImage = new JLabel(i4);

    Font f6 = new Font("Comic Sans MS",Font.PLAIN,40);//font applied to the contents
    Font f7 = new Font("Lucida Bright",Font.BOLD,70);//font applied to the heading


    JCheckBox paneer =  new JCheckBox("Matar Paneer");
    JCheckBox kofta =  new JCheckBox("Malai Kofta");
    JCheckBox chana =  new JCheckBox("Chana Masala");
    JCheckBox chawal =  new JCheckBox("Dal Chawal");
    JCheckBox bharta =  new JCheckBox("Baingan Bharta");
    JCheckBox alu =  new JCheckBox("Dam Alu");

    JLabel paneer_butt =  new JLabel("100 Rs.");
    JLabel kofta_butt =  new JLabel("120 Rs.");
    JLabel chana_butt =  new JLabel("90 Rs.");
    JLabel chawal_butt =  new JLabel("90 Rs.");
    JLabel bharta_butt =  new JLabel("100 Rs.");
    JLabel alu_butt =  new JLabel("100 Rs.");

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back =  new JButton(back_image);///////////back and done button code//////////
    JButton done = new JButton("DONE");
    JButton bill = new JButton("BILL");

    Vegetarian()
    {
        setImage();
        setLabel();//adds title
        setList();//adds components
        setBackDone();

        Frame.set(this);
    }

    void setImage()
    {
        add(vegImage);
        vegImage.setSize(i4.getIconWidth(),i4.getIconHeight());
    }

    void setBackDone()
    {

        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setLocation(100,860);
        vegImage.add(back);

        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                setVisible(false);
                new FoodMenu();

            }

        });

        done.setBounds(700,860,150,40);
        done.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        done.setContentAreaFilled(false);
        done.setForeground(Color.BLUE);
        done.setBorder(BorderFactory.createLineBorder(Color.ORANGE,3));
        vegImage.add(done);

        done.addMouseListener(new MouseAdapter()
        {
            int c = 0;
            public void mouseClicked(MouseEvent e)
            {

                if(paneer.isSelected())
                {
                    FoodMenu.vname.addElement(paneer.getText());////////////CheckBox selecetion/////
                    FoodMenu.vprice.addElement(paneer_butt.getText());c++;

                }

                if(kofta.isSelected())
                {
                    FoodMenu.vname.addElement(kofta.getText());
                    FoodMenu.vprice.addElement(kofta_butt.getText());c++;
                }

                if(chana.isSelected())
                {
                    FoodMenu.vname.addElement(chana.getText());
                    FoodMenu.vprice.addElement(chana_butt.getText());c++;
                }

                if(chawal.isSelected())
                {
                    FoodMenu.vname.addElement(chawal.getText());
                    FoodMenu.vprice.addElement(chawal_butt.getText());c++;
                }

                if(bharta.isSelected())
                {
                    FoodMenu.vname.addElement(bharta.getText());
                    FoodMenu.vprice.addElement(bharta_butt.getText());c++;
                }

                if(alu.isSelected())
                {
                    FoodMenu.vname.addElement(alu.getText());
                    FoodMenu.vprice.addElement(alu_butt.getText());c++;
                }

                if(c==0)
                {
                    JOptionPane.showMessageDialog(null,"Select the dishes!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Dishes Confirmed!!!");
            }
        });
    }

    void setLabel()
    {
        vegImage.add(vegLabel);
        vegLabel.setBounds(100,10,800,150);
        vegLabel.setFont(f7);
        vegLabel.setForeground(Color.ORANGE);
    }

    void setList()
    {
        /////////CheckBox/////////
        vegImage.add(paneer);
        paneer.setBounds(150,230,300,50);
        paneer.setFont(f6);
        paneer.setForeground(Color.BLUE);

        vegImage.add(kofta);
        kofta.setBounds(150,330,300,50);
        kofta.setFont(f6);
        kofta.setForeground(Color.BLUE);

        vegImage.add(chana);
        chana.setBounds(150,430,350,50);
        chana.setFont(f6);
        chana.setForeground(Color.BLUE);

        vegImage.add(chawal);
        chawal.setBounds(150,530,300,50);
        chawal.setFont(f6);
        chawal.setForeground(Color.BLUE);

        vegImage.add(bharta);
        bharta.setBounds(150,630,350,50);
        bharta.setFont(f6);
        bharta.setForeground(Color.BLUE);

        vegImage.add(alu);
        alu.setBounds(150,730,300,50);
        alu.setFont(f6);
        alu.setForeground(Color.BLUE);

////////////////Labels///////////////////////

        vegImage.add(paneer_butt);
        paneer_butt.setBounds(700,230,200,50);
        paneer_butt.setFont(f6);
        paneer_butt.setForeground(Color.BLUE);


        vegImage.add(kofta_butt);
        kofta_butt.setBounds(700,330,200,50);
        kofta_butt.setFont(f6);
        kofta_butt.setForeground(Color.BLUE);

        vegImage.add(chana_butt);
        chana_butt.setBounds(700,430,200,50);
        chana_butt.setFont(f6);
        chana_butt.setForeground(Color.BLUE);

        vegImage.add(chawal_butt);
        chawal_butt.setBounds(700,530,200,50);
        chawal_butt.setFont(f6);
        chawal_butt.setForeground(Color.BLUE);

        vegImage.add(bharta_butt);
        bharta_butt.setBounds(700,630,200,50);
        bharta_butt.setFont(f6);
        bharta_butt.setForeground(Color.BLUE);

        vegImage.add(alu_butt);
        alu_butt.setBounds(700,730,200,50);
        alu_butt.setFont(f6);
        alu_butt.setForeground(Color.BLUE);

    }
}

class Rice extends JFrame
{
    ImageIcon i5 = new ImageIcon("rice.jpg");
    JLabel ricelabel = new JLabel("Rice Speciality");
    JLabel riceImage = new JLabel(i5);

    Font f8 = new Font("Comic Sans MS",Font.PLAIN,40);
    Font f9 = new Font("Lucida Bright",Font.BOLD,70);

    JCheckBox veg =  new JCheckBox("Vegetable Biryani");
    JCheckBox  nonveg =  new JCheckBox("Chicken Biryani");
    JCheckBox beef =  new JCheckBox("Beef Biryani");
    JCheckBox shrimp =  new JCheckBox("Shrimp Biryani");
    JCheckBox plain =  new JCheckBox("Plain Basmati Rice");
    JCheckBox house =  new JCheckBox("House Biryani");

    JLabel veg_lab =  new JLabel("120 Rs.");
    JLabel nonveg_lab =  new JLabel("150 Rs.");
    JLabel beef_lab =  new JLabel("120 Rs.");
    JLabel shrimp_lab =  new JLabel("130 Rs.");
    JLabel plain_lab =  new JLabel("80 Rs.");
    JLabel house_lab =  new JLabel("80 Rs.");

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back =  new JButton(back_image);
    JButton done = new JButton("DONE");

    Rice()
    {
        setImage();
        setLabel();
        setList();
        setBackDone();

        Frame.set(this);
    }

    void setImage()//adds image to the label
    {
        add(riceImage);
        riceImage.setSize(i5.getIconWidth(),i5.getIconHeight());
    }

    void setBackDone()//code  of back and done button
    {
        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setLocation(100,860);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        riceImage.add(back);

        back.addMouseListener(new MouseAdapter()//goes back to the food menu frame
        {
            public void mouseClicked(MouseEvent e)
            {

                setVisible(false);
                new FoodMenu();
            }

        });

        done.setBounds(700,860,150,40);
        done.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        done.setContentAreaFilled(false);
        done.setForeground(Color.RED);
        done.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        riceImage.add(done);

        done.addMouseListener(new MouseAdapter()//stores the ordered dishes in the Vector
        {
            public void mouseClicked(MouseEvent e)
            {
                int c = 0;

                if(veg.isSelected())
                {
                    FoodMenu.vname.addElement(veg.getText());////////////CheckBox selecetion/////
                    FoodMenu.vprice.addElement(veg_lab.getText());c++;

                }

                if(nonveg.isSelected())
                {
                    FoodMenu.vname.addElement(nonveg.getText());
                    FoodMenu.vprice.addElement(nonveg_lab.getText());c++;
                }

                if(beef.isSelected())
                {
                    FoodMenu.vname.addElement(beef.getText());
                    FoodMenu.vprice.addElement(beef_lab.getText());c++;
                }

                if(shrimp.isSelected())
                {
                    FoodMenu.vname.addElement(shrimp.getText());
                    FoodMenu.vprice.addElement(shrimp_lab.getText());c++;
                }

                if(plain.isSelected())
                {
                    FoodMenu.vname.addElement(plain.getText());
                    FoodMenu.vprice.addElement(plain_lab.getText());c++;
                }

                if(house.isSelected())
                {
                    FoodMenu.vname.addElement(house.getText());
                    FoodMenu.vprice.addElement(house_lab.getText());c++;
                }

                if(c==0)
                {
                    JOptionPane.showMessageDialog(null,"Select the dishes!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Dishes Confirmed!!!");

            }

        });

    }

    void setLabel()
    {
        riceImage.add(ricelabel);
        ricelabel.setBounds(100,10,800,150);
        ricelabel.setFont(f9);
        ricelabel.setForeground(Color.RED);

    }

    void setList()
    {
        /////////CheckBox/////////
        riceImage.add(veg);
        veg.setBounds(150,230,400,50);
        veg.setFont(f8);
        veg.setForeground(Color.BLACK);
        veg.setOpaque(false);

        riceImage.add(nonveg);
        nonveg.setBounds(150,330,400,50);
        nonveg.setFont(f8);
        nonveg.setForeground(Color.BLACK);
        nonveg.setOpaque(false);

        riceImage.add(beef);
        beef.setBounds(150,430,400,50);
        beef.setFont(f8);
        beef.setForeground(Color.BLACK);
        beef.setOpaque(false);

        riceImage.add(shrimp);
        shrimp.setBounds(150,530,400,50);
        shrimp.setFont(f8);
        shrimp.setForeground(Color.BLACK);
        shrimp.setOpaque(false);

        riceImage.add(plain);
        plain.setBounds(150,630,450,50);
        plain.setFont(f8);
        plain.setForeground(Color.BLACK);
        plain.setOpaque(false);

        riceImage.add(house);
        house.setBounds(150,730,400,50);
        house.setFont(f8);
        house.setForeground(Color.BLACK);
        house.setOpaque(false);



////////////////Labels///////////////////////

        riceImage.add(veg_lab);
        veg_lab.setBounds(700,230,200,50);
        veg_lab.setFont(f8);
        veg_lab.setForeground(Color.BLACK);

        riceImage.add(nonveg_lab);
        nonveg_lab.setBounds(700,330,200,50);
        nonveg_lab.setFont(f8);
        nonveg_lab.setForeground(Color.BLACK);

        riceImage.add(beef_lab);
        beef_lab.setBounds(700,430,200,50);
        beef_lab.setFont(f8);
        beef_lab.setForeground(Color.BLACK);

        riceImage.add(shrimp_lab);
        shrimp_lab.setBounds(700,530,200,50);
        shrimp_lab.setFont(f8);
        shrimp_lab.setForeground(Color.BLACK);

        riceImage.add(plain_lab);
        plain_lab.setBounds(700,630,200,50);
        plain_lab.setFont(f8);
        plain_lab.setForeground(Color.BLACK);

        riceImage.add(house_lab);
        house_lab.setBounds(700,730,200,50);
        house_lab.setFont(f8);
        house_lab.setForeground(Color.BLACK);

    }

}

class Desserts extends JFrame
{
    ImageIcon i6 = new ImageIcon("desserts.jpg");
    JLabel dessert_label = new JLabel("Sweet Desserts");
    JLabel dessert_image = new JLabel(i6);

    Font f10 = new Font("Comic Sans MS",Font.PLAIN,40);
    Font f11 = new Font("Lucida Bright",Font.BOLD,80);

    JCheckBox alaska =  new JCheckBox("Baked Alaska");
    JCheckBox  cake =  new JCheckBox("Cake");
    JCheckBox pastry =  new JCheckBox("Danish Pastry");
    JCheckBox icecream =  new JCheckBox("Ice Cream");
    JCheckBox pie =  new JCheckBox("Apple Pie");
    JCheckBox brownie =  new JCheckBox("Chocolate Brownie");

    JLabel alaska_lab =  new JLabel("140 Rs.");
    JLabel cake_lab =  new JLabel("120 Rs.");
    JLabel pastry_lab =  new JLabel("100 Rs.");
    JLabel icecream_lab =  new JLabel("50 Rs.");
    JLabel pie_lab =  new JLabel("120 Rs.");
    JLabel brownie_lab =  new JLabel("80 Rs.");

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back =  new JButton(back_image);
    JButton done = new JButton("DONE");

    Desserts()
    {
        setImage();
        setLabel();
        setList();
        setBackDone();

        Frame.set(this);
    }

    void setImage()
    {
        add(dessert_image);
        dessert_image.setSize(i6.getIconWidth(),i6.getIconHeight());
    }

    void setBackDone()
    {
        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setLocation(100,860);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        dessert_image.add(back);

        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                setVisible(false);
                new FoodMenu();

            }

        });

        done.setBounds(700,860,150,40);
        done.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        done.setContentAreaFilled(false);
        done.setForeground(Color.MAGENTA);
        done.setBorder(BorderFactory.createLineBorder(Color.CYAN,3));
        dessert_image.add(done);

        done.addMouseListener(new MouseAdapter()//stores the ordered dishes in the Vector
        {
            public void mouseClicked(MouseEvent e)
            {
                int c = 0;
                if(alaska.isSelected())
                {
                    FoodMenu.vname.addElement(alaska.getText());////////////CheckBox selecetion/////
                    FoodMenu.vprice.addElement(alaska_lab.getText());c++;

                }

                if(cake.isSelected())
                {
                    FoodMenu.vname.addElement(cake.getText());
                    FoodMenu.vprice.addElement(cake_lab.getText());c++;
                }

                if(pastry.isSelected())
                {
                    FoodMenu.vname.addElement(pastry.getText());
                    FoodMenu.vprice.addElement(pastry_lab.getText());c++;
                }

                if(icecream.isSelected())
                {
                    FoodMenu.vname.addElement(icecream.getText());
                    FoodMenu.vprice.addElement(icecream_lab.getText());c++;
                }

                if(pie.isSelected())
                {
                    FoodMenu.vname.addElement(pie.getText());
                    FoodMenu.vprice.addElement(pie_lab.getText());c++;
                }

                if(brownie.isSelected())
                {
                    FoodMenu.vname.addElement(brownie.getText());
                    FoodMenu.vprice.addElement(brownie_lab.getText());c++;
                }

                if(c==0)
                {
                    JOptionPane.showMessageDialog(null,"Select the dishes!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Dishes Confirmed!!!");

            }

        });
    }

    void setLabel()
    {
        dessert_image.add(dessert_label);
        dessert_label.setBounds(100,10,800,150);
        dessert_label.setFont(f11);
        dessert_label.setForeground(Color.MAGENTA);

    }

    void setList()
    {
        /////////CheckBox/////////
        dessert_image.add(alaska);
        alaska.setBounds(150,230,400,50);
        alaska.setFont(f10);
        alaska.setForeground(Color.CYAN);
        alaska.setOpaque(false);

        dessert_image.add(cake);
        cake.setBounds(150,330,400,50);
        cake.setFont(f10);
        cake.setForeground(Color.CYAN);
        cake.setOpaque(false);

        dessert_image.add(pastry);
        pastry.setBounds(150,430,400,50);
        pastry.setFont(f10);
        pastry.setForeground(Color.CYAN);
        pastry.setOpaque(false);

        dessert_image.add(icecream);
        icecream.setBounds(150,530,400,50);
        icecream.setFont(f10);
        icecream.setForeground(Color.CYAN);
        icecream.setOpaque(false);

        dessert_image.add(pie);
        pie.setBounds(150,630,450,50);
        pie.setFont(f10);
        pie.setForeground(Color.CYAN);
        pie.setOpaque(false);

        dessert_image.add(brownie);
        brownie.setBounds(150,730,400,50);
        brownie.setFont(f10);
        brownie.setForeground(Color.CYAN);
        brownie.setOpaque(false);



////////////////Labels///////////////////////

        dessert_image.add(alaska_lab);
        alaska_lab.setBounds(700,230,200,50);
        alaska_lab.setFont(f10);
        alaska_lab.setForeground(Color.CYAN);

        dessert_image.add(cake_lab);
        cake_lab.setBounds(700,330,200,50);
        cake_lab.setFont(f10);
        cake_lab.setForeground(Color.CYAN);

        dessert_image.add(pastry_lab);
        pastry_lab.setBounds(700,430,200,50);
        pastry_lab.setFont(f10);
        pastry_lab.setForeground(Color.CYAN);

        dessert_image.add(icecream_lab);
        icecream_lab.setBounds(700,530,200,50);
        icecream_lab.setFont(f10);
        icecream_lab.setForeground(Color.CYAN);

        dessert_image.add(pie_lab);
        pie_lab.setBounds(700,630,200,50);
        pie_lab.setFont(f10);
        pie_lab.setForeground(Color.CYAN);

        dessert_image.add(brownie_lab);
        brownie_lab.setBounds(700,730,200,50);
        brownie_lab.setFont(f10);
        brownie_lab.setForeground(Color.CYAN);

    }

}

class Breads extends JFrame
{

    ImageIcon i5	=new ImageIcon("breads.jpg");
    JLabel breLabel = new JLabel( "Indian Breads");
    JLabel breImage = new JLabel(i5);


    Font f1  = new Font("Lucida Bright",Font.BOLD,70);
    Font f2  = new Font(" Comic Sans MS",Font.BOLD,35);
    Font fbd = new Font("Comic Sans MS",Font.PLAIN,30);

    JCheckBox Tandoori = new JCheckBox(" Tandoori Roti");
    JCheckBox Paratha  = new JCheckBox(" Paratha");
    JCheckBox Bhatura  = new JCheckBox(" Bhatura");
    JCheckBox Shahi    = new JCheckBox(" Shahi Kulcha");
    JCheckBox Alu      = new JCheckBox(" Alu Nan");
    JCheckBox Special  = new JCheckBox(" Special Breads");


    JLabel Tandoori_p1 = new JLabel("40 Rs.");
    JLabel Paratha_p2  = new JLabel("50 Rs.");
    JLabel Bhatura_p3  = new JLabel("80 Rs.");
    JLabel Shahi_p4    = new JLabel("90 Rs.");
    JLabel Alu_p5      = new JLabel("90 Rs.");
    JLabel Special_p6  = new JLabel("70 Rs.");

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back 		 =  new JButton(back_image);
    JButton done 		 = new JButton("DONE");

    Breads()
    {

        setImage();
        setLabel();
        setList();
        setBackDone();

        Frame.set(this);
    }

    void setImage()
    {
        add(breImage);
        breImage.setSize(i5.getIconWidth(),i5.getIconHeight());
    }

    void setBackDone()
    {
        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setLocation(100,860);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        breImage.add(back);
        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new FoodMenu();

            }

        });

        done.setBounds(700,860,150,40);
        done.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        done.setContentAreaFilled(false);
        done.setForeground(Color.MAGENTA);
        done.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
        breImage.add(done);
        done.addMouseListener(new MouseAdapter()//stores the ordered dishes in the Vector
        {
            public void mouseClicked(MouseEvent e)
            {
                int c = 0;
                if(Tandoori.isSelected())
                {
                    FoodMenu.vname.addElement(Tandoori.getText());////////////CheckBox selecetion/////
                    FoodMenu.vprice.addElement(Tandoori_p1.getText());c++;

                }


                if(Paratha.isSelected())
                {
                    FoodMenu.vname.addElement(Paratha.getText());
                    FoodMenu.vprice.addElement(Paratha_p2.getText());c++;
                }

                if(Bhatura.isSelected())
                {
                    FoodMenu.vname.addElement(Bhatura.getText());
                    FoodMenu.vprice.addElement(Bhatura_p3.getText());c++;
                }

                if(Shahi.isSelected())
                {
                    FoodMenu.vname.addElement(Shahi.getText());
                    FoodMenu.vprice.addElement(Shahi_p4.getText());c++;
                }

                if(Alu.isSelected())
                {
                    FoodMenu.vname.addElement(Alu.getText());
                    FoodMenu.vprice.addElement(Alu_p5.getText());c++;
                }

                if(Special.isSelected())
                {
                    FoodMenu.vname.addElement(Special.getText());
                    FoodMenu.vprice.addElement(Special_p6.getText());c++;
                }

                if(c==0)
                {
                    JOptionPane.showMessageDialog(null,"Select the dishes!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Dishes Confirmed!!!");

            }
        });

    }

    void setLabel()
    {
        breImage.add(breLabel);
        breLabel.setBounds(100,10,800,150);
        breLabel.setFont(f1);
        breLabel.setForeground(Color.MAGENTA);
    }

    void setList()
    {

        ////Checkbox////
        breImage.add(Tandoori);
        Tandoori.setBounds(150,230,300,50);
        Tandoori.setFont(f2);
        Tandoori.setForeground(Color.BLUE);
        Tandoori.setOpaque(false);

        breImage.add(Paratha);
        Paratha.setBounds(150,330,300,50);
        Paratha.setFont(f2);
        Paratha.setForeground(Color.BLUE);
        Paratha.setOpaque(false);

        breImage.add(Bhatura);
        Bhatura.setBounds(150,430,300,50);
        Bhatura.setFont(f2);
        Bhatura.setForeground(Color.BLUE);
        Bhatura.setOpaque(false);

        breImage.add(Shahi);
        Shahi.setBounds(150,530,300,50);
        Shahi.setFont(f2);
        Shahi.setForeground(Color.BLUE);
        Shahi.setOpaque(false);

        breImage.add(Alu );
        Alu.setBounds(150,630,300,50);
        Alu.setFont(f2);
        Alu.setForeground(Color.BLUE);
        Alu.setOpaque(false);

        breImage.add(Special);
        Special.setBounds(150,730,300,50);
        Special.setFont(f2);
        Special.setForeground(Color.BLUE);
        Special.setOpaque(false);


        ///Label///
        breImage.add(Tandoori_p1);
        Tandoori_p1.setBounds(700,230,200,50);
        Tandoori_p1.setFont(f2);
        Tandoori_p1.setForeground(Color.BLUE);

        breImage.add(Paratha_p2);
        Paratha_p2.setBounds(700,330,200,50);
        Paratha_p2.setFont(f2);
        Paratha_p2.setForeground(Color.BLUE);

        breImage.add(Bhatura_p3);
        Bhatura_p3.setBounds(700,430,200,50);
        Bhatura_p3.setFont(f2);
        Bhatura_p3.setForeground(Color.BLUE);

        breImage.add(Shahi_p4);
        Shahi_p4.setBounds(700,530,200,50);
        Shahi_p4.setFont(f2);
        Shahi_p4.setForeground(Color.BLUE);

        breImage.add(Alu_p5);
        Alu_p5.setBounds(700,630,200,50);
        Alu_p5.setFont(f2);
        Alu_p5.setForeground(Color.BLUE);

        breImage.add(Special_p6);
        Special_p6.setBounds(700,730,200,50);
        Special_p6.setFont(f2);
        Special_p6.setForeground(Color.BLUE);

    }
}

class Beverages extends JFrame
{
    ImageIcon i7 = new ImageIcon("bev.jpg");
    JLabel bev_label = new JLabel("Special Beverages");
    JLabel bev_image = new JLabel(i7);

    Font f12 = new Font("Comic Sans MS",Font.PLAIN,40);
    Font f13 = new Font("Lucida Bright",Font.BOLD,80);
    Font fbd = new Font("Comic Sans MS",Font.PLAIN,30);

    JCheckBox drink =  new JCheckBox("Soft Drink");
    JCheckBox hot =  new JCheckBox("Hot Chocolate");
    JCheckBox cold =  new JCheckBox("Cold Cofee");
    JCheckBox darjeeling =  new JCheckBox("Darjeeling Tea");
    JCheckBox milkshake =  new JCheckBox("MilkShake");
    JCheckBox lipson =  new JCheckBox("Lipson Tea");

    JLabel drink_lab =  new JLabel("100 Rs.");
    JLabel hot_lab =  new JLabel("80 Rs.");
    JLabel cold_lab =  new JLabel("90 Rs.");
    JLabel darjeeling_lab =  new JLabel("70 Rs.");
    JLabel milkshake_lab =  new JLabel("70 Rs.");
    JLabel lipson_lab =  new JLabel("75 Rs.");

    ImageIcon back_image = new ImageIcon("back.png");
    JButton back =  new JButton(back_image);
    JButton done = new JButton("DONE");
    Color c = new Color(25,25,112);
    Color t = new Color(127,255,212);

    Beverages()
    {
        setImage();
        setLabel();
        setList();
        setBackDone();

        Frame.set(this);

    }

    void setImage()
    {
        add(bev_image);
        bev_image.setSize(i7.getIconWidth(),i7.getIconHeight());
    }

    void setLabel()
    {
        bev_image.add(bev_label);
        bev_label.setBounds(100,10,800,150);
        bev_label.setFont(f13);
        bev_label.setForeground(t);

    }

    void setBackDone()
    {
        back.setSize(back_image.getIconWidth(),back_image.getIconHeight());
        back.setLocation(100,830);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        bev_image.add(back);

        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                setVisible(false);
                new FoodMenu();

            }

        });

        bev_image.add(done);
        done.setBounds(700,860,150,40);
        done.setFont(new Font("Bookman Old Style",Font.BOLD,30));
        done.setContentAreaFilled(false);
        done.setForeground(t);
        done.setBorder(BorderFactory.createLineBorder(c,3));
        bev_image.add(done);
        done.addMouseListener(new MouseAdapter()//stores the ordered dishes in the Vector
        {
            public void mouseClicked(MouseEvent e)
            {
                int c = 0;
                if(drink.isSelected())
                {
                    FoodMenu.vname.addElement(drink.getText());////////////CheckBox selecetion/////
                    FoodMenu.vprice.addElement(drink_lab.getText());c++;

                }

                if(hot.isSelected())
                {
                    FoodMenu.vname.addElement(hot.getText());
                    FoodMenu.vprice.addElement(hot_lab.getText());c++;
                }

                if(cold.isSelected())
                {
                    FoodMenu.vname.addElement(cold.getText());
                    FoodMenu.vprice.addElement(cold_lab.getText());c++;
                }

                if(darjeeling.isSelected())
                {
                    FoodMenu.vname.addElement(darjeeling.getText());
                    FoodMenu.vprice.addElement(darjeeling_lab.getText());c++;
                }

                if(milkshake.isSelected())
                {
                    FoodMenu.vname.addElement(milkshake.getText());
                    FoodMenu.vprice.addElement(milkshake_lab.getText());c++;
                }

                if(lipson.isSelected())
                {
                    FoodMenu.vname.addElement(lipson.getText());
                    FoodMenu.vprice.addElement(lipson_lab.getText());c++;
                }

                if(c==0)
                {
                    JOptionPane.showMessageDialog(null,"Select the dishes!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Dishes Confirmed!!!");
            }

        });
    }

    void setList()
    {
        /////////CheckBox/////////
        bev_image.add(drink);
        drink.setBounds(150,230,400,50);
        drink.setFont(f12);
        drink.setForeground(c);
        drink.setOpaque(false);

        bev_image.add(hot);
        hot.setBounds(150,330,400,50);
        hot.setFont(f12);
        hot.setForeground(c);
        hot.setOpaque(false);


        bev_image.add(cold);
        cold.setBounds(150,430,400,50);
        cold.setFont(f12);
        cold.setForeground(c);
        cold.setOpaque(false);

        bev_image.add(darjeeling);
        darjeeling.setBounds(150,530,400,50);
        darjeeling.setFont(f12);
        darjeeling.setForeground(c);
        darjeeling.setOpaque(false);

        bev_image.add(milkshake);
        milkshake.setBounds(150,630,450,50);
        milkshake.setFont(f12);
        milkshake.setForeground(c);
        milkshake.setOpaque(false);

        bev_image.add(lipson);
        lipson.setBounds(150,730,400,50);
        lipson.setFont(f12);
        lipson.setForeground(c);
        lipson.setOpaque(false);

////////////////Labels///////////////////////

        bev_image.add(drink_lab);
        drink_lab.setBounds(700,230,200,50);
        drink_lab.setFont(f12);
        drink_lab.setForeground(c);

        bev_image.add(hot_lab);
        hot_lab.setBounds(700,330,200,50);
        hot_lab.setFont(f12);
        hot_lab.setForeground(c);

        bev_image.add(cold_lab);
        cold_lab.setBounds(700,430,200,50);
        cold_lab.setFont(f12);
        cold_lab.setForeground(c);

        bev_image.add(darjeeling_lab);
        darjeeling_lab.setBounds(700,530,200,50);
        darjeeling_lab.setFont(f12);
        darjeeling_lab.setForeground(c);

        bev_image.add(milkshake_lab);
        milkshake_lab.setBounds(700,630,200,50);
        milkshake_lab.setFont(f12);
        milkshake_lab.setForeground(c);

        bev_image.add(lipson_lab);
        lipson_lab.setBounds(700,730,200,50);
        lipson_lab.setFont(f12);
        lipson_lab.setForeground(c);
    }
}

class Bill extends JFrame
{

    ImageIcon i8 =  new ImageIcon("bill.jpg");
    JLabel bill_label = new JLabel("ORDERED DISHES");
    JLabel bill_image = new JLabel(i8);
    Font f14 = new Font("Clarendon Blk BT",Font.PLAIN,90);
    Font f15 = new Font("Century Gothlic",Font.PLAIN,26);

    JLabel title[] = new JLabel[20];
    JLabel price[] = new JLabel[20];

    JButton bill = new JButton("BILL");
    int s;
    Bill(Vector <String> vn,Vector <String> vp)
    {

        Frame.set(this);
        setImage();

        ABC:
        for(int i = 0, y = 250; i<vn.size() ; i++,y+=70)
        {
            title[i] = new JLabel(vn.get(i));
            bill_image.add(title[i]);
            title[i].setBounds(450,y,300,40);		//prints the dishes ordered on the bill
            title[i].setFont(f15);
            title[i].setForeground(Color.BLACK);

            if(y > 700)
            {
                continue_label(i,vn);
                break ABC;
            }
        }

        PQR:
        for(int j = 0, y1 = 250; j<vp.size() ; j++,y1+=70)
        {
            price[j] = new JLabel(vp.get(j));
            bill_image.add(price[j]);
            price[j].setBounds(700,y1,200,40);		//prints the prices on the bill
            price[j].setFont(f15);
            price[j].setForeground(Color.BLACK);

            if(y1 > 700)
            {
                continue_price(j,vp);
                break PQR;
            }
        }

        getTotal(vp);
        setBillBtn();
    }

    void continue_label(int i,Vector <String>vn)
    {
        for( int y = 250; i<vn.size() ; i++,y+=70)
        {
            title[i] = new JLabel(vn.get(i));
            bill_image.add(title[i]);				//goes dishes name to next coloumn
            title[i].setBounds(950,y,300,40);
            title[i].setFont(f15);
            title[i].setForeground(Color.BLACK);
        }
    }


    void continue_price(int j,Vector <String>vp)
    {
        for(int y1 = 250; j<vp.size() ; j++,y1+=70)
        {
            price[j] = new JLabel(vp.get(j));
            bill_image.add(price[j]);
            price[j].setBounds(1200,y1,300,40);		//goes prices name to next coloumn
            price[j].setFont(f15);
            price[j].setForeground(Color.BLACK);
        }
    }

    void setImage()
    {
        add(bill_image);
        bill_image.setSize(i8.getIconWidth(),i8.getIconHeight());
        bill_image.add(bill_label);
        bill_label.setBounds(450,5,1000,200);
        bill_label.setFont(f14);
        bill_label.setForeground(Color.RED);
    }

    void setBillBtn()
    {
        bill_image.add(bill);
        bill.setBounds(1000,800,150,40);
        bill.setFont(f15);
        bill.setContentAreaFilled(false);
        bill.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        bill.setForeground(Color.RED);

        bill.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                FoodInfo.f.setTotal(s);
                setVisible(false);
                FoodInfo.f.setVisible(true);
            }
        });
    }

    void getTotal(Vector <String> vp)
    {
        s = 0;
        for(int i = 0; i<vp.size(); i++)
        {
            String str = vp.get(i);
            str = str.replace(" Rs.","");
            s = s + Integer.parseInt(str);
        }
    }
}

class FinalBill extends JFrame
{
    ImageIcon i = new ImageIcon("bank-2010880_640.png");

    JLabel nam_of_cus = new JLabel("NAME :");
    JLabel bill_pay = new JLabel("PAYMENT OF BILL :");
    JLabel nam_of_cus1 = new JLabel();
    JLabel bill_pay1 = new JLabel();
    JLabel tot = new JLabel("TOTAL :");
    JLabel tot1 = new JLabel();
    JLabel bill  =  new JLabel("BILL");
    JLabel visit  =  new JLabel("Visit Again!!!");
    JLabel thank  =  new JLabel("  Thank  You");


    Font f15 = new Font("Century Gothlic",Font.PLAIN,30);
    Font f16 = new Font("Engravers MT",Font.PLAIN,100);
    Font ty = new Font("Gabriola",Font.PLAIN,155);
    Font vs = new Font("Verdana",Font.PLAIN,65);

    FinalBill()
    {
        setLayout(null);
        setSize(900,940);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int a = JOptionPane.showConfirmDialog(null,"Do u want to Continue (Y/N)","message",JOptionPane.YES_NO_OPTION);

                if(a == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        dispose();

                        new RoomData();
                    }

                    catch (Exception e1)
                    {}
                }
            }
        });
        setIconImage(i.getImage());
        setResizable(false);
        //setVisible(true);
        setLabel();
        setEndLabels();
    }

    public void setTotal(int s)
    {
        tot1.setBounds(500,430,200,40);
        tot.setFont(f15);
        tot1.setFont(f15);
        tot.setForeground(Color.BLACK);
        tot1.setForeground(Color.BLACK);
        add(tot);
        add(tot1);
        setTot(s);
    }

    void setTot(int s)
    {
        String rs = " Rs.";

        tot.setBounds(100,430,250,40);
        String str = Integer.toString(s);
        str = str.concat(rs);
        tot1.setText(str);
    }

    void setCusInfo(String n,String p)
    {
        nam_of_cus1.setText(n);
        bill_pay1.setText(p);
    }

    void setLabel()
    {
        bill.setOpaque(true);
        bill.setBounds(0,0,900,130);
        bill.setFont(f16);
        bill.setHorizontalAlignment(SwingConstants.CENTER);
        bill.setForeground(Color.WHITE);
        bill.setBackground(Color.BLACK);
        add(bill);

        nam_of_cus.setBounds(100,230,200,40);
        nam_of_cus1.setBounds(500,230,400,40);
        bill_pay.setBounds(100,330,350,40);
        bill_pay1.setBounds(500,330,400,40);
        nam_of_cus.setFont(f15);
        nam_of_cus1.setFont(f15);
        bill_pay.setFont(f15);
        bill_pay1.setFont(f15);
        nam_of_cus.setForeground(Color.BLACK);
        nam_of_cus1.setForeground(Color.BLACK);
        bill_pay.setForeground(Color.BLACK);
        bill_pay1.setForeground(Color.BLACK);

        add(nam_of_cus);
        add(nam_of_cus1);
        add(bill_pay);
        add(bill_pay1);
    }

    void setEndLabels()
    {
        add(visit);
        add(thank);

        visit.setBounds(230,780,500,75);
        thank.setBounds(100,580,750,190);
        visit.setFont(vs);
        thank.setFont(ty);
        visit.setForeground(Color.BLACK);
        thank.setForeground(Color.BLACK);
    }
}
