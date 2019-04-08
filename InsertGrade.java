import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class InsertGrade implements ActionListener {
        
        Libretto LibrettoLista;
        JTextField subject;
        JTextField grade;
        
        int intGrade;

        public InsertGrade(Libretto LibrettoLista,JTextField subject,JTextField grade){
            this.LibrettoLista = LibrettoLista;
            this.subject = subject;
            this.grade = grade;
            
            
        }

        public void actionPerformed (ActionEvent event) {
            try {
                this.intGrade = Integer.parseInt(this.grade.getText()); 
                System.out.println(this.intGrade);
            } catch (Exception e) {
                GuiException x = new GuiException(e);
                x.createGui();
               
                return;
            }
            
            LibrettoLista.assegnamentoVoto(this.subject.getText(),this.intGrade);
            

           
        }
    }
      

    