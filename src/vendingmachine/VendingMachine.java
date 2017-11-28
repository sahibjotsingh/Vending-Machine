package vendingmachine;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class VendingMachine 
{
    JLabel vm, machineLeft;
    JTextArea transitionTable, message;
    JTextField result;
    JButton b1, b2, b3, sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9, sb10, sb11, sb12, sb13, sb14, sb15;
    Color c;
    double startstate=0.00, amount=0.00, change=0.00, select=0.00;
    boolean freeze=false;
    
    JFrame frame = new JFrame("Vending Machine");
    JPanel panel = (JPanel) frame.getContentPane();
    
    public VendingMachine()
    {
        panel.setBackground(Color.decode("#FF1643"));
        frame.setSize(665, 690);
        frame.setResizable(false);
        setup();
        setup1();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void setup1()
    {
        ImageIcon iconLogo = new ImageIcon("C:\\Users\\Hp-user\\Desktop\\kabir\\final.png");
        machineLeft = new JLabel(iconLogo);
        machineLeft.setVisible(true);
        machineLeft.setBounds(0, 0, 20, 20);
        machineLeft.setHorizontalAlignment(SwingConstants.LEFT);
        machineLeft.setVerticalAlignment(SwingConstants.TOP);
        panel.add(machineLeft);
    }
    
    public void setup()
    {
        double[][] Transition = new double[9][3];
        int alphaset=3, stateset=9;
        double A=0.25;
        
        ArrayList<Double> states = new ArrayList <Double> ();
        for(Double i=0.00;i<9.00;++i)
        {
            states.add(0.00 + i * A);
        }
        
        ArrayList<Double> alphabets = new ArrayList <Double> ();
        alphabets.add(0.25);
        alphabets.add(1.00);
                
        Transition[0][0]=0.25;
        Transition[0][1]=1.00;
        Transition[0][2]=0.00;
        Transition[1][0]=0.50;
        Transition[1][1]=1.25;
        Transition[1][2]=0.25;
        Transition[2][0]=0.75;
        Transition[2][1]=1.50;
        Transition[2][2]=0.50;
        Transition[3][0]=1.00;
        Transition[3][1]=1.75;
        Transition[3][2]=0.75;
        Transition[4][0]=1.25;
        Transition[4][1]=2.00;
        Transition[4][2]=1.00;
        Transition[5][0]=1.25;
        Transition[5][1]=1.25;
        Transition[5][2]=0.00;
        Transition[6][0]=1.50;
        Transition[6][1]=1.50;
        Transition[6][2]=0.00;
        Transition[7][0]=1.75;
        Transition[7][1]=1.75;
        Transition[7][2]=0.00;
        Transition[8][0]=2.00;
        Transition[8][1]=2.00;
        Transition[8][2]=0.00;
        
        startstate=0.00;
        
        HashSet<Double> finalstates = new HashSet<>();
        finalstates.add(1.25);
        finalstates.add(1.50);
        finalstates.add(1.75);
        finalstates.add(2.00);
        
        int x=20, y=70, y2=20;
        
        message = new JTextArea();
        message.setFont(new Font("Tahoma", 0, 42));
        message.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        message.setForeground(Color.red);
        message.setEditable(false);
        message.setBounds(495, 10, 100, 60);
        panel.add(message);
        
        b1 = new JButton("$0.25");
        b1.setBackground(Color.lightGray);
        b1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(freeze==false)
                {
                    int index1, index2;
                    index1 = states.indexOf(startstate);
                    index2 = alphabets.indexOf(0.25);
                    startstate = Transition[index1][index2];
                    amount = amount + 0.25;
                    message.setText(Double.toString(amount));
                    select = startstate;
                    if (finalstates.contains(startstate))
                    {
                        freeze=true;
                    } 
                }
            }
        }
        );
        b1.setFont(new Font("Tahoma", 0, 12));
        panel.add(b1);
        b1.setBounds(440, 10 + y + y2, 100, 30);
        
        b2 = new JButton("$1.00");
        b2.setBackground(Color.lightGray);
        b2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(freeze==false)
                {
                    int index1, index2;
                    index1 = states.indexOf(startstate);
                    index2 = alphabets.indexOf(1.00);
                    startstate = Transition[index1][index2];
                    amount = amount + 1.00;
                    message.setText(Double.toString(amount));
                    select = startstate;
                    if (finalstates.contains(startstate))
                    {
                        freeze=true;
                    } 
                }
                else
                {
                    message.setText(Double.toString(amount));
                }
            }
        }
        );
        b2.setFont(new Font("Tahoma", 0, 12));
        panel.add(b2);
        b2.setBounds(550, 10 + y + y2, 100, 30);
        
        c = Color.decode("#C4CAEA");
        
        sb1 = new JButton("Water");
        sb1.setBackground(c);
        sb1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Water");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb1.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb1);
        sb1.setBounds(440, 50 + y + y2*2, 100, 30);
        
        sb2 = new JButton("Rasberry");
        sb2.setBackground(c);
        sb2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Rasberry");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb2.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb2);
        sb2.setBounds(550, 50 + y + y2*2, 100, 30);
        
        sb3 = new JButton("Alovera");
        sb3.setBackground(c);
        sb3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Alovera");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb3.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb3);
        sb3.setBounds(440, 90 + y + y2*3, 100, 30);
        
        sb4 = new JButton("Mint");
        sb4.setBackground(c);
        sb4.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Mint");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb4.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb4);
        sb4.setBounds(550, 90 + y + y2*3, 100, 30);
        
        sb5 = new JButton("Lemon");
        sb5.setBackground(c);
        sb5.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Lemon");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb5.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb5);
        sb5.setBounds(440, 130 + y + y2*4, 100, 30);
        
        sb6 = new JButton("Lime");
        sb6.setBackground(c);
        sb6.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Lime");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb6.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb6);
        sb6.setBounds(550, 130 + y + y2*4, 100, 30);
        
        sb7 = new JButton("Pink Lemonade");
        sb7.setBackground(c);
        sb7.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Pink Lemonade");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb7.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb7);
        sb7.setBounds(440, 170 + y + y2*5, 100, 30);
        
        sb8 = new JButton("Jaljeera");
        sb8.setBackground(c);
        sb8.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Jaljeera");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb8.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb8);
        sb8.setBounds(550, 170 + y + y2*5, 100, 30);
        
        sb9 = new JButton("Pineapple");
        sb9.setBackground(c);
        sb9.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Pineapple");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb9.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb9);
        sb9.setBounds(440, 210 + y + y2*6, 100, 30);
        
        sb10 = new JButton("Bluo");
        sb10.setBackground(c);
        sb10.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Bluo");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb10.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb10);
        sb10.setBounds(550, 210 + y + y2*6, 100, 30);
        
        sb11 = new JButton("Creme");
        sb11.setBackground(c);
        sb11.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Creme");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb11.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb11);
        sb11.setBounds(440, 250 + y + y2*7, 100, 30);
        
        sb12 = new JButton("Blueberry");
        sb12.setBackground(c);
        sb12.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Blueberry");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb12.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb12);
        sb12.setBounds(550, 250 + y + y2*7, 100, 30);
        
        sb13 = new JButton("Kalakhatta");
        sb13.setBackground(c);
        sb13.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Kalakhatta");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb13.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb13);
        sb13.setBounds(440, 290 + y + y2*8, 100, 30);
        
        sb14 = new JButton("Cola");
        sb14.setBackground(c);
        sb14.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Cola");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb14.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb14);
        sb14.setBounds(550, 290 + y + y2*8, 100, 30);
        
        sb15 = new JButton("Sweet Corn");
        sb15.setBackground(c);
        sb15.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("-" + Double.toString(amount - 1.25));
                        result.setText("Sweet Corn");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        sb15.setFont(new Font("Tahoma", 0, 12));
        panel.add(sb15);
        sb15.setBounds(440, 330 + y + y2*9, 100, 30);
        
        b3 = new JButton("Select");
        b3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if((amount>=1.25)&&(!"".equals(result.getText())))
                {
                    result.setText("");
                    //message.setText("-" + Double.toString(amount - 1.25));
                    amount=0;
                    startstate=0.00;
                    change=0.00;
                    select=0.00;
                    freeze=false;
                    message.setText("");
                }
                else
                {
                    select = startstate;
                }
            }
        }
        );
        b3.setFont(new Font("Tahoma", 0, 12));
        panel.add(b3);
        b3.setBounds(550, 330 + y + y2*9, 100, 30);
        
        result = new JTextField();
        result.setFont(new Font("Tahoma", 0, 20));
        result.setForeground(Color.BLACK);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setBounds(170, 550, 100, 30);
        result.setBackground(Color.white);
        result.setEditable(false);
        panel.add(result);
    }
    
    public static void main(String[] args) 
    {
        VendingMachine o=new VendingMachine();
    }
}
