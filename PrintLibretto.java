import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.applet.Applet;
/**
 * PrintLibretto
 */
public class PrintLibretto extends JFrame {

    private GenericStack<Esame> libretto;
    private Libretto librettoLista;
    private Studente student;
    public PrintLibretto(Libretto x, Studente s){
        super();
        this.librettoLista =  x;
        this.student = s;
       
    }
    public void createList(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        setSize(xSize,500); 
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        String studentInfo = "<html><p font-size=+4> STUDENT INFO </p><lu><li>" + student.getNome() + student.getCognome() + " </li><li>"+ "Number: " + student.getMatricola() +"</li></lu><li>"+"The average score of the student is: " +  librettoLista.getMedia() +"</li></lu></p></html>";
        JPanel layout = new JPanel();
        JPanel title = new JPanel();
        layout.setLayout(new GridLayout(1,3));
        title.setLayout(new FlowLayout());
        layout.setBorder(new LineBorder(Color.black));
        JLabel card = new JLabel("<html><h1> STUDENT CARD </h1></html>");
        title.add(card);
        DefaultListModel<String> l1 = new DefaultListModel<>(); 
        ArrayList<Esame> a = this.librettoLista.getLibrettoList();
        for (Esame var : a) {
            l1.addElement(var.getMateria() + " / VOTO= " + var.getVotoInt() + " / DATA ESAME = " + var.getDataEsameString() + " / TIPOLOGIA = " + var.getTipologia()+ " / ATENEO =  " + var.getNomeAteneo() + " / PROFESSORE = " + var.getProfessore()); 
        }
        //The average score of the Exams is : " +  librettoLista.getMedia()),BorderLayout.WEST); 
        layout.add(new JLabel(studentInfo));
        JList<String> list = new JList<>(l1);  

        layout.add(list);
        container.add(title);
        container.add(layout);
        //add(container);
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
        setVisible(true);  
    }
}

