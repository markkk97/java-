import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//utilzzata per gestire input vuoto di jtextfield
public class PassedExamGui extends JFrame{
    private JLabel j;

    public PassedExamGui(JLabel j){
         super();
         this.j = j;
         
    }
    public void createGui(){ 
        JPanel p =new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        setSize(1000,100); 
        setTitle("Passed Exams");
        setLayout(new BorderLayout());
        p.add(this.j,BorderLayout.CENTER);
        add(p,BorderLayout.NORTH);
        
    }
    
}