import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class GetExam implements ActionListener {
        Libretto librettoLista = new Libretto("","","");
        JTextField input;

        public GetExam(Libretto librettoLista,JTextField input){
            this.librettoLista = librettoLista;
            this.input = input;
        }

        public void actionPerformed (ActionEvent event) {
            librettoLista.getEsami(input.getText());
           
        }
    }
      

    