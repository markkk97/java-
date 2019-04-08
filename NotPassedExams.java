import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

    public class NotPassedExams implements ActionListener {
        Libretto LibrettoLista = new Libretto("","","");

        public NotPassedExams(Libretto LibrettoLista){
            this.LibrettoLista = LibrettoLista;
        }

        public void actionPerformed (ActionEvent event) {
            boolean passed = false;
            LibrettoLista.getExamsStateUi(passed);
        }
    }
      

    