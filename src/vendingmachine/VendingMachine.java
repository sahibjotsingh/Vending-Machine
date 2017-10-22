package vendingmachine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class VendingMachine 
{
    JLabel vm, result, soda1, soda2, soda3;
    JTextArea transitionTable, message;
    JButton selectSoda1, selectSoda2, selectSoda3, b1, b2, b3;
    double startstate=0.00, amount=0.00, change=0.00, select=0.00;
    boolean freeze=false;
    
    JFrame frame = new JFrame("Vending Machine");
    JPanel panel = (JPanel) frame.getContentPane();
    public VendingMachine()
    {
        panel.setLayout(null);
        frame.setSize(700, 730);
        setup();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        
        int x=20, y=43, y2=50;
        
        soda1 = new JLabel("SODA 1");
        soda1.setHorizontalAlignment(SwingConstants.CENTER);
        soda1.setBounds(47 + 8, 52, 70, 250);
        soda1.setBackground(Color.white);
        soda1.setOpaque(true);
        panel.add(soda1);
        
        selectSoda1 = new JButton("Select");
        selectSoda1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("Change = " + Double.toString(amount - 1.25));
                        result.setText("SODA 1");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ); 
        selectSoda1.setFont(new Font("Tahoma", 0, 12));
        panel.add(selectSoda1);
        selectSoda1.setBounds(47 + 8, 320, 70, 20);
        
        soda2 = new JLabel("SODA 2");
        soda2.setHorizontalAlignment(SwingConstants.CENTER);
        soda2.setBounds(47 + 100 - 8, 52, 70, 250);
        soda2.setBackground(Color.white);
        soda2.setOpaque(true);
        panel.add(soda2);
        
        selectSoda2 = new JButton("Select");
        selectSoda2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("Change = " + Double.toString(amount - 1.25));
                        result.setText("SODA 2");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );
        selectSoda2.setFont(new Font("Tahoma", 0, 12));
        panel.add(selectSoda2);
        selectSoda2.setBounds(47 + 100 - 8, 320, 70, 20);
        
        soda3 = new JLabel("SODA 3");
        soda3.setHorizontalAlignment(SwingConstants.CENTER);
        soda3.setBounds(47 + 190 -8, 52, 70, 250);
        soda3.setBackground(Color.white);
        soda3.setOpaque(true);
        panel.add(soda3);
        
        selectSoda3 = new JButton("Select");
        selectSoda3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(select >= 1.25)
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        message.setText("Change = " + Double.toString(amount - 1.25));
                        result.setText("SODA 3");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );
        selectSoda3.setFont(new Font("Tahoma", 0, 12));
        panel.add(selectSoda3);
        selectSoda3.setBounds(47 + 190 -8, 320, 70, 20);
        
        
        b1 = new JButton("$0.25");
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
                    message.setText("Money inserted=" + Double.toString(amount));
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
        b1.setBounds(47 + 330, 52, 70, 20 + y2);
        
        
        b2 = new JButton("$1.00");
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
                    message.setText("Money inseted=" + Double.toString(amount));
                    select = startstate;
                    if (finalstates.contains(startstate))
                    {
                        freeze=true;
                    } 
                }
                else
                {
                    message.setText("Money inserted=" + Double.toString(amount));
                }
            }
        }
        );
        b2.setFont(new Font("Tahoma", 0, 12));
        panel.add(b2);
        b2.setBounds(47 + 330, 52 + 2 * y, 70, 20 + y2);
        
        
        b3 = new JButton("Take");
        b3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                result.setText("");
                amount=0;
                startstate=0.00;
                change=0.00;
                select=0.00;
                freeze=false;
                message.setText("");
            }
        }
        );
        b3.setFont(new Font("Tahoma", 0, 12));
        panel.add(b3);
        b3.setBounds(47 + 330, 52 + 4 * y, 70, 20 + y2);
        
        message = new JTextArea();
        message.setFont(new Font("Tahoma", 0, 12));
        message.setEditable(false);
        panel.add(message);
        message.setBounds(47 + 280 - 8, 320, 130, 20);
        
        result = new JLabel();
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setBounds(47, 320 + 50, 400, 80);
        result.setBackground(Color.white);
        result.setOpaque(true);
        panel.add(result);
    }
    
    public static void main(String[] args) 
    {
        VendingMachine o=new VendingMachine();
    }
}
