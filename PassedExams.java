import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class PassedExams implements ActionListener {
        Libretto LibrettoLista = new Libretto("","","");

        public PassedExams(Libretto LibrettoLista){
            this.LibrettoLista = LibrettoLista;
        }

        public void actionPerformed (ActionEvent event) {
            boolean passed = true;
            LibrettoLista.getExamsStateUi(passed);
        }
    }
      

    