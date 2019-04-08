import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


    public class OutputLibretto implements ActionListener{

        public void actionPerformed (ActionEvent event) {

            JFrame f= new JFrame();  
            DefaultListModel<String> l1 = new DefaultListModel<>(); 
            l1.addElement("qwertyuio"); 
            JList<String> list = new JList<>(l1);  
            list.setBounds(10,10, 300,300);  
            f.add(list);
          
        }
    }
      

    