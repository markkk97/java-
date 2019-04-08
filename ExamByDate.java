import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * ExamByDate
 */

public class ExamByDate implements ActionListener {
    private Libretto librettoLista;
    private JTextField input;
    private ArrayList<Esame> arrayExams;

    public ExamByDate(Libretto librettoLista,JTextField input){
        this.librettoLista = librettoLista;
        this.input = input;
        arrayExams = librettoLista.getLibrettoList();
    }


    public void actionPerformed (ActionEvent event) {
        LibrettoTrasf x = new LibrettoTrasf(librettoLista.x.getNome(), librettoLista.x.getCognome(),librettoLista.x.getMatricola(),arrayExams);
        System.out.println(input.getText());
         x.stampaDaData(input.getText());
       
    }
}