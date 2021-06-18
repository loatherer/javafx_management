import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2;
    JLabel l1;
    JComboBox c1,c2,c3;
    JButton b1,b2;

        AddRooms(){

            JLabel l1=new JLabel("Add Rooms");
            l1.setFont(new Font("Tahoma",Font.BOLD,18));
            l1.setBounds(200,20,100,20);
            add(l1);

            JLabel room = new JLabel("Room Number : ");
            room.setFont(new Font("Tahoma",Font.BOLD,16));
            room.setBounds(60,80,150,30);
            add(room);

            t1=new JTextField();
            t1.setBounds(200,80,150,30);
            add(t1);

            JLabel available = new JLabel("Available : ");
            available.setFont(new Font("Tahoma",Font.BOLD,16));
            available.setBounds(60,130,150,30);
            add(available);

            c1=new JComboBox(new String[]{"Available","Occupied"});
            c1.setBounds(200,130,150,30);
            c1.setBackground(Color.white);
            add(c1);

            JLabel status = new JLabel("Cleaning Status : ");
            status.setFont(new Font("Tahoma",Font.BOLD,16));
            status.setBounds(60,180,150,30);
            add(status);

            c2=new JComboBox(new String[]{"Clean","Dirty"});
            c2.setBounds(200,180,150,30);
            c2.setBackground(Color.white);
            add(c2);


            JLabel price = new JLabel("Price : ");
            price.setFont(new Font("Tahoma",Font.BOLD,16));
            price.setBounds(60,230,150,30);
            add(price);

            t2=new JTextField();
            t2.setBounds(200,230,150,30);
            add(t2);

            JLabel type=new JLabel("Bed Type :");
            type.setFont(new Font("Tahoma",Font.BOLD,16));
            type.setBounds(60,280,150,30);
            add(type);

            c3=new JComboBox(new String[]{"Single Bed","Double Bed"});
            c3.setBounds(200,280,150,30);
            c3.setBackground(Color.white);
            add(c3);

            b1=new JButton("Add Room");
            b1.setBounds(60,350,130,30);
            b1.setBackground(Color.BLACK);
            b1.addActionListener(this);
            b1.setForeground(Color.white);
            add(b1);

            b2=new JButton("Cancel");
            b2.setBounds(220,350,130,30);
            b2.setBackground(Color.BLACK);
            b2.addActionListener(this);
            b2.setForeground(Color.white);
            add(b2);

            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
            JLabel l2=new JLabel(i1);
            l2.setBounds(400,30,500,350);
            add(l2);

            getContentPane().setBackground(Color.white);


            setBounds(500,200,940,470);
            setLayout(null);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==b1){

                String room=t1.getText();
                String price=t2.getText();
                String available=(String)c1.getSelectedItem();
                String status=(String)c2.getSelectedItem();
                String type=(String)c3.getSelectedItem();

                conn c=new conn();
                try{
                    String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"New Room Added");
                    this.setVisible(false);
                }catch (Exception ex){
                    System.out.println(ex);
                }

            }else if(ae.getSource()==b2){
                this.setVisible(false);
            }
        }

        public static void main(String[] args){
            new AddRooms().setVisible(true);
        }

}
