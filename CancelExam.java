import javax.swing.*;
import java.awt.event.*;


    public class CancelExam implements ActionListener {
        Libretto librettoLista;
        JTextField input;

        public CancelExam(Libretto librettoLista,JTextField input){
            this.librettoLista = librettoLista;
            this.input = input;
        }

        public void actionPerformed (ActionEvent event) {
            librettoLista.cancellaEsameLista(input.getText());
            
        }
    }
      

    