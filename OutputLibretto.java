import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class OutputLibretto implements ActionListener {
        Libretto LibrettoLista;

        public OutputLibretto(Libretto LibrettoLista){
            this.LibrettoLista = LibrettoLista;
        }

        public void actionPerformed (ActionEvent event) {
            LibrettoLista.getLibretto();
        }
    }
      

    