import javax.swing.*;
import java.awt.event.*;
import java.lang.RuntimeException;
import java.text.ParseException;



    public class InsertExam implements ActionListener {
        Libretto librettoLista;
        JTextField[] input;
        int grade;

        public InsertExam(Libretto librettoLista,JTextField[] input){
            this.librettoLista = librettoLista;
            this.input = input;
        }

        public void actionPerformed (ActionEvent event) {
            if(!librettoLista.checkIfExists(input[0].getText())){ //se l'esame non esiste gia

                String s= "One of the input fields is empty";
                String gradeText=input[4].getText();
                //caricaEsame
                //ci va un try catch per controllare voto e che i campi non siano vuoti 
                

                try {
                    for (JTextField var : input) { //controllo che nessun field sia vuoto
                        if(var.getText().isEmpty()){
                            throw new RuntimeException(s);
                        }
                    }
                } catch (RuntimeException e) {
                    GuiException x = new GuiException(e);
                    x.createGui();
                    return;
                }

                try {
                    this.grade = Integer.parseInt(gradeText); //controlla che grade sia effettivamente un numero
                } catch (NumberFormatException e) {
                    GuiException x = new GuiException(e);
                    x.createGui();
                    return;
                }
                
                    if(this.librettoLista.caricaEsameInLista(input[0].getText(), input[1].getText(), input[2].getText(), input[3].getText(), this.grade, input[5].getText())){
                        DialogBox success = new DialogBox("Exam added correctly", 2);
                    }    
            } else{ //se l'esame esiste stampo errroe
                DialogBox success = new DialogBox("Exam exists already", 1);
            }
            
           
            
            
           
        }
    }
      

    