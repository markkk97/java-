
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// le posizioni 0 e 1 conrengono i messaggi rispettivamente dell'
// if e dell'else. quindi per succes = true uso 0 e per success = false uso 2
// nel metodo create gui. la 2 è per il metodo createMessage
// in questo modo metodo che invoca la classe deve istamnziare un array di almeno 2 elem
//se non usa il metodo createMessage

public class GetExamGui extends JFrame{
    private JLabel j;
    private boolean success;
    private JLabel[] messages;  
    JPanel content =new JPanel();
    JPanel one =new JPanel();
    JPanel two =new JPanel();

    // TRY CATCHn AGGIUNTI PER GESTIRE EVENTUASLITA CHE VENGANO INVOCATI
    // I METODI SENZA PASSARE ARRAY CON PARAMETRI

    public GetExamGui(JLabel[] messages,boolean success){
        super();
        this.success = success;
        this.messages = messages;
        content.setLayout(new GridLayout(3,1)); 
        content.setBorder(new EmptyBorder(10, 10, 10, 10));
        setSize(1000,400); 
        setTitle("Exam Informaton");
        add(content);
    }

    public void createGui(){ 
        try {
            JLabel outputLabel = new JLabel();
            content.add(new JLabel("<html><h1>INFORMATION PANEL</h1><hr></html>"));
                if(success){
                    outputLabel.setText("<html><h1><lu><li>" + messages[0].getText() + "</lu></h1></html>"); //output messages[0]
                } else{
                    outputLabel.setText("<html><h1><lu><li>" + messages[1].getText() + "</lu></h1></html>"); //output messages[1]
                }
            content.add(outputLabel);    
         } catch (Exception e) {
             GuiException x = new GuiException(e);
             x.createGui();
         }
    }

    public void createMessage(){
        //try catch nel caso si invochi il metodo ma alla posizione 1 l'array è null
        try {
            content.add( new JLabel("<html><h1>" + messages[2].getText()+ "</h1></html>"));    
        } catch (Exception e) {
             GuiException x = new GuiException(e);
             x.createGui();
         }
    }
    
}