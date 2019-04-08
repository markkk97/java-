import javax.swing.*;

import java.awt.event.*;



    public class CancelGrade implements ActionListener {
        Libretto librettoLista = new Libretto("","","");
        JTextField input;

        public CancelGrade(Libretto librettoLista,JTextField input){
            this.librettoLista = librettoLista;
            this.input = input;
        }

        public void actionPerformed (ActionEvent event) {
            librettoLista.cancellaVoto(input.getText());
            
        }
    }
      

    