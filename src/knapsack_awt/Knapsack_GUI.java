
package knapsack_awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Event;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Knapsack_GUI {
    JFrame jf;
    Box box,box1;
    JPanel inside,main,incdec;
    JLabel welcome,LWeight,back,mainValue,mainweight,maxprofit,info;
    JTextField TWeight;
    JButton dynamic,add,minus;
    ArrayList<Integer> weight,value;
    
    

    public Knapsack_GUI()
    {
     jf=new JFrame();
     jf.setLayout(null);
     jf.setSize(670,600);
     
     jf.setLocationRelativeTo(null);
     jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    
     //back=new JLabel(new ImageIcon("C:\\Users\\Lavish\\Desktop\\back.jpg"));
     back=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/back.jpg")));
     back.setLayout(null);
     back.setBounds(0,0,700,600);
     jf.add(back);
     
     welcome=new JLabel("WELCOME TO KNAPSACK WORLD");
     welcome.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,30));
     welcome.setForeground(Color.white);
     welcome.setBounds(100, 50,480, 100);
     //welcome.setBorder(BorderFactory.createLineBorder(Color.RED));
     back.add(welcome);

     mainValue=new JLabel("VALUE");
     mainValue.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,20));
     mainValue.setForeground(Color.white);
     mainValue.setBounds(10,200,80,50);
     back.add(mainValue);
     
     mainweight=new JLabel("WEIGHT");
     mainweight.setBounds(10,258,80,50);
     mainweight.setForeground(Color.white);
      mainweight.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,20));
     back.add(mainweight);
     
     main=new JPanel();
     main.setLayout(new BorderLayout() );
     main.setBounds(100,200,470, 110);
     main.setBackground(new Color(0,128,0));
    // main.setBorder(BorderFactory.createLineBorder(Color.RED));
     
     
    // add=new JButton(new ImageIcon("C:\\Users\\Lavish\\Desktop\\plus1.png"));
    add=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/plus1.png")));
     add.setSize(50,20);
     add.addActionListener(new EventHandler(this));
     add.setBorder(BorderFactory.createLineBorder(Color.RED));
     add.setOpaque(false);
     add.setContentAreaFilled(false);
   
     add.setBorder(null);
   
     //minus=new JButton(new ImageIcon("C:\\Users\\Lavish\\Desktop\\minus.png"));
     minus=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/minus.png")));
     minus.setSize(50,20);
     minus.addActionListener(new EventHandler(this));
     minus.setBorder(BorderFactory.createLineBorder(Color.RED));
     minus.setOpaque(false);
     minus.setContentAreaFilled(false);
     minus.setBorder(null);
     
     box=Box.createHorizontalBox();
     box.setOpaque(true);
     box.setBackground(new Color(111,220,111));
    // box.setBorder(BorderFactory.createLineBorder(Color.GREEN));
     
     box1=Box.createHorizontalBox();
     box1.setOpaque(true);
     box1.setBackground(new Color(99,198,99));
    // box1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
     
     main.add(box,BorderLayout.NORTH);
     main.add(box1,BorderLayout.SOUTH);
   
     box.add(add);
    
     value=new ArrayList<>();
     weight=new ArrayList<>();
     
        
       box1.add(minus);
     
     back.add(main);
     
     LWeight=new JLabel();
     LWeight.setBounds(240,310,150,50);
     LWeight.setText("KNAPSACK WEIGHT");
     LWeight.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,15));
     LWeight.setForeground(Color.WHITE);
     back.add(LWeight);
     
     TWeight=new JTextField();
     TWeight.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,20));
     TWeight.setForeground(Color.WHITE);
     TWeight.setBounds(265,350,100,50);
     TWeight.setHorizontalAlignment(JTextField.CENTER);
     TWeight.setBackground(new Color(111,220,111));
     TWeight.setBorder(null);
     TWeight.addFocusListener(new FocusAdapter() 
     {
         public void focusLost(FocusEvent e)
         {
             if(!TWeight.getText().isEmpty())
             {
                 TWeight.setEditable(false);
             }
         }
      });
     back.add(TWeight);
     
      maxprofit=new JLabel("Max Profit :: ");
      maxprofit.setBounds(20,490,200,50);
     // maxprofit.setBorder(BorderFactory.createLineBorder(Color.black));
     maxprofit.setVisible(false);
      maxprofit.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,25));
      maxprofit.setForeground(Color.white);
      back.add(maxprofit);
    
     dynamic=new JButton("CALCULATE");
     dynamic.setBounds(265,430,100, 50);
     dynamic.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,15));
     dynamic.setForeground(Color.white);
     dynamic.setBackground(new Color(0,128,0));
     dynamic.setMargin(new Insets(0, 0, 0, 0)); 
     dynamic.addActionListener(new EventHandler(this));
     dynamic.setBorder(null);
     back.add(dynamic);
     
     info=new JLabel();
     info.setText("<html>Developed By:<br>LAVISH VERMA</html>");
     info.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,20));
     info.setForeground(Color.white);
     info.setBounds(500,370,300,300);
     back.add(info);
     
     jf.setVisible(true);
     
    }
    
   JTextField textboxCreater()
   {
    JTextField jt=new JTextField();
    Dimension d=new Dimension(50, 40);
     jt.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,20));
     jt.setHorizontalAlignment(JTextField.CENTER);
     jt.setForeground(Color.white);
     jt.setBackground(new Color(255,88,88));
    jt.setBorder(null);
    jt.setMaximumSize(d);
    return jt;
    }
   
  
    public static void main(String[] args)
     {
        new Knapsack_GUI();
     }
    
}

class EventHandler implements ActionListener
{
     Knapsack_GUI december;
    
    
    public EventHandler(Knapsack_GUI d) 
    {
        december=d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==december.add)
     {
         if(december.box.getComponentCount()>=3&&!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty()&&!((JTextField)december.box1.getComponent(december.box1.getComponentCount()-3)).getText().isEmpty())
         {
             System.err.println("if");
           december.box.remove(december.add);
           december.box.add(december.textboxCreater());
       
           december.box.add(Box.createHorizontalStrut(10));
           december.box.add(december.add);
        
           december.box1.remove(december.minus);
           december.box1.add(december.textboxCreater());
           december.box1.add(Box.createHorizontalStrut(10));
           december.box1.add(december.minus);
           december.box1.revalidate();
          
           december.box.getComponent(december.box.getComponentCount()-3).addFocusListener(new FocusAdapter() 
           {
            public void focusLost(FocusEvent e)
            {
              if(!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty())
              {
                  december.value.add(Integer.valueOf(((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText()));
                  ((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).setEditable(false);
                  System.err.println("VALUE"+december.value);
              }
            }
            });
     
           december.box1.getComponent(december.box1.getComponentCount()-3).addFocusListener(new FocusAdapter() 
           {
             public void focusLost(FocusEvent e)
             {    if(!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty())
                   {
                    december.weight.add(Integer.valueOf(((JTextField)december.box1.getComponent(december.box1.getComponentCount()-3)).getText()));
                    ((JTextField)december.box1.getComponent(december.box1.getComponentCount()-3)).setEditable(false);
                    System.err.println("WEIGHT"+december.weight); 
                   } 
             }
            });
        }
    
     else
     {
        if(december.box.getComponentCount()<2)   
        {
                          System.err.println("hfdhdhr");
                 
          december.box.remove(december.add);
           december.box.add(december.textboxCreater());
       
           december.box.add(Box.createHorizontalStrut(10));
           december.box.add(december.add);
        
           december.box1.remove(december.minus);
           december.box1.add(december.textboxCreater());
           december.box1.add(Box.createHorizontalStrut(10));
           december.box1.add(december.minus);
           december.box1.revalidate();
  december.box.getComponent(december.box.getComponentCount()-3).addFocusListener(new FocusAdapter() 
           {
            public void focusLost(FocusEvent e)
            {
              if(!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty())
              {
                  december.value.add(Integer.valueOf(((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText()));
                  ((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).setEditable(false);
                  System.err.println("VALUE"+december.value);
              }
            }
            });
     
           december.box1.getComponent(december.box1.getComponentCount()-3).addFocusListener(new FocusAdapter() 
           {
             public void focusLost(FocusEvent e)
             {    if(!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty())
                   {
                    december.weight.add(Integer.valueOf(((JTextField)december.box1.getComponent(december.box1.getComponentCount()-3)).getText()));
                    ((JTextField)december.box1.getComponent(december.box1.getComponentCount()-3)).setEditable(false);
                    System.err.println("WEIGHT"+december.weight); 
                   } 
             }
            });
            
            }
     
     
     }
     }
     if(e.getSource()==december.minus)
     {
         if(december.box.getComponentCount()>3)
         {
             if(!((JTextField)december.box.getComponent(december.box.getComponentCount()-3)).getText().isEmpty())
         {
             december.value.remove(december.value.size()-1);
             System.err.println("!!minus"+december.value);
             december.weight.remove(december.weight.size()-1);
             System.err.println("minus"+december.weight);
           }
         december.box.remove(december.box.getComponentCount()-2);
         december.box.remove(december.box.getComponentCount()-2);
          
         december.box1.remove(december.box.getComponentCount()-2);
         december.box1.remove(december.box.getComponentCount()-2);
         
         december.box1.revalidate();
         december.box.revalidate();
         }
         else
         {
             if(december.box.getComponentCount()==3)
             {
                 if(!((JTextField)december.box.getComponent(0)).getText().isEmpty())
                 {
                    december.value.remove(december.value.size()-1);
                    december.weight.remove(december.weight.size()-1); 
                 }
                 
                 december.box.remove(0);
                 december.box1.remove(0);
                  december.box.remove(0);
                 december.box1.remove(0);
                 
                  december.box1.revalidate();
                  december.box.revalidate();
             } 
           
         }
     }
     
     if(e.getSource()==december.dynamic)
     {
        // december.ManageNext();
         if(!december.TWeight.getText().isEmpty())
         {
         knapsack knap=new knapsack();
          knap.accept(december.value, december.weight,december.TWeight.getText(),december.value.size());
         december.maxprofit.setText(december.maxprofit.getText().concat(knap.TotalWeight().toString()));
        
         JLabel finger[]=new JLabel[knap.items.size()];
        
         for(int i=0;i<knap.items.size();i++)
         {
             System.out.println("A1");
             
             //finger[i]=new JLabel(new ImageIcon("C:\\Users\\Lavish\\Desktop\\finger.png"));
             finger[i]=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/finger.png")));
             
             finger[i].setBounds(90+(60*knap.items.get(i)),150,50,50);
             
             
    
           december.back.add(finger[i]);
           december.maxprofit.setVisible(true);
           december.dynamic.setEnabled(false);
           december.back.repaint();
             
             
       }  
      }
     }
    }
   }
