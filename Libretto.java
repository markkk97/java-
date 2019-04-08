import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator; 
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 
import java.text.ParseException;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.BorderLayout; 
import java.lang.RuntimeException;



//classe realizzata con arraylist

public class Libretto{
   
    protected GenericStack<Esame> libretto;
    protected Studente x;
    private String notFound = "Attention! There are no exams matching your input. Please insert a correct one";
    
    public Libretto(String nome, String cognome, String matricola){
        x = new Studente(nome, cognome, matricola);
        this.libretto =  new GenericStack<Esame>();
                   
    }

    public void inizializzaLibretto(){
        //in questo caso non ci sono controlli sull'input del voto e della data
        //il controllo su voto e data viene fatto nel metodo caricaEsame. 
            caricaEsameInLista("storia", "mario", "scritto", "05-01-2019", 0,"cps");
            caricaEsameInLista("geografia", "carlo", "scritto", "10-01-2019", 0,"cps");
            caricaEsameInLista("informatica", "luigi", "scritto", "11-02-2019", 0,"cps");
            caricaEsameInLista("matematica", "francesco", "scritto", "02-02-2019", 0,"cps");
            caricaEsameInLista("italiano", "giacomo", "orale", "08-02-2019", 0,"cps");
            caricaEsameInLista("inglese", "maria", "progetto", "19-01-2019", 0,"cps");
            caricaEsameInLista("politica", "luca", "scritto", "23-01-2019", 0,"cps"); //non ancora sostenuto => bocciato è settato a fale
            caricaEsameInLista("legge", "giovanni", "progetto", "29-01-2019", 0,"cps"); //non ancora sostenuto => bocciato è settato a fale
            caricaEsameInLista("diritto", "francesco", "scritto", "20-01-2019", 0,"cps");
           
    }

    public boolean checkVoto(int x){
        if(x >= 0 && x <= 30){
            if(x < 18.0){            
                return true;
                    
            } else if( x >= 18.0){
                return true;
            }
        } else{
            return false;
        }
        return true; //default  
    }

    public boolean checkDataEsame(String dateEsame){
        boolean success = false;
        try {
            Date data =new SimpleDateFormat("dd-MM-yyyy").parse((String)dateEsame);  
            success = true;
        } catch (ParseException e) {
            System.out.println(e);
            success = false;
        }
        return success;
    }
   
    
    //stampa solo gli esami superati o quelli bocciati(ovvero con bocciato = true e voto > 0)
    public void getLibretto(){
        PrintLibretto p = new PrintLibretto(this,x);
        p.createList();
    }

    //ritorna arraylist con lista esami 

    public ArrayList<Esame> getLibrettoList(){

        ArrayList<Esame> list = new ArrayList<Esame>();

        libretto.setIteration();
        while(this.libretto.hasNext()){
            try {
                list.add(new Esame(libretto.getData().getMateria(), libretto.getData().getProfessore(), libretto.getData().getTipologia(), libretto.getData().getDataEsameString(), libretto.getData().getVotoInt(),libretto.getData().getNomeAteneo()));
                //System.out.println("aggiunto ");  
            } catch (Exception e) {
               System.out.println("Exceptio getLibrettoList " + e); 
            }
            this.libretto.next();
        }

    return list;
    }

    public boolean checkIfExists(String materia) {
        libretto.setIteration();
        while(this.libretto.hasNext()){
            if(libretto.getData().getMateria().equals(materia)){
                return true;
            }
            this.libretto.next();
        }
        return false;
    }

    //caricamento nuovo esame nella lista. setvoto in esame.java setta anche bocciato o no

    public boolean caricaEsameInLista(String materia,String professore,String tipologia,
                                    String dataEsame, int voto,String nomeAteneo){
        //questo trycatch funziona, se si sbaglia data o voto stmpa exception
        try {
            if(checkDataEsame(dataEsame) && checkVoto(voto)){
                libretto.add(new Esame(materia, professore, tipologia, dataEsame, voto, nomeAteneo));
                return true;    
            } else{
                String s = "Errore while adding exam. Check date and Grade";
                throw new RuntimeException(s);
            }
        } catch (RuntimeException e) {
            GuiException x = new GuiException(e);
            x.createGui();
            //x.setVisible(true);
            return false;
        }                                 
    }

    public int size(){
        libretto.setIteration();
        int c =0;
        while(this.libretto.hasNext()){
            c++;
                
            this.libretto.next();
        }
        return c;

    }

    //cancellazione di tutti i record = a materia

    public void cancellaEsameLista(String materia){

        boolean success = false;
        JLabel outputLabel[] = new JLabel[4];

        libretto.setIteration();
        while(this.libretto.hasNext()){
            if(libretto.getData().getMateria().equals(materia)){

                DialogBox choiceCancel = new DialogBox("Are you sure?",0);
                if (choiceCancel.choice() == JOptionPane.NO_OPTION) {
                  return; //esco dal metodo
                } else if (choiceCancel.choice() == JOptionPane.YES_OPTION) {
                        libretto.cancel();
                        success = true; //cosi stampo il messaggio di output positivo. devo usare outputLabel[0]
                        outputLabel[0] = new JLabel("Exam was cancelled correctly");
                        System.out.println("cancellato");
                        GetExamGui output = new GetExamGui(outputLabel, success);
                         output.createGui();
                        // output.createMessage();
                         output.setVisible(true);
                        return; //esco dal metodo,importante altrimenti vado ad eseguire il codice sottostante
                } else if (choiceCancel.choice() == JOptionPane.CLOSED_OPTION) {
                    //chiudo il box e esco dal metodo
                  return;
                }

                
            }
            this.libretto.next();
            }
            
            
        
        //se raggiungo questo punto la materia cercata non esiste e nella classe output setto
        //un messaggio di errore
        outputLabel[1] = new JLabel(notFound);
        GetExamGui output = new GetExamGui(outputLabel, success);  
        output.createGui();          
        output.setVisible(true);
        

    }
    
    //assegnamento voto e bocciato 

    public void assegnamentoVoto(String materia, int voto){
        boolean success = false;
        JLabel outputLabel[] = new JLabel[3];
        outputLabel[1] = new JLabel("Attention! Plese insert a correct grade"); //messaggio di errore personalizzato per la classe
                                                                                //GetEXamGui nel caso di un voto non valido
        
        String text = "";
        libretto.setIteration();
        while (libretto.hasNext()){
            if(libretto.getData().getMateria().equals(materia)){
                //esame trovato
                if(libretto.getData().setVoto(voto)){
                    //voto inserito corretto
                    success = true;
                    text =  libretto.getData().getMateria() + " - professore: " +  libretto.getData().getProfessore() + " - tipologia: " +  
                            libretto.getData().getTipologia() + " - voto: " +  libretto.getData().getVoto() + " - data: " + 
                            libretto.getData().getDataEsameString() + " - bocciato; " +  libretto.getData().getBocciato() + " " +  "\n";

                    outputLabel[0] = new JLabel(text);
                    outputLabel[2] = new JLabel("Grade was assigned correctly!");
                    GetExamGui get = new GetExamGui(outputLabel, success);
                    get.createGui();
                    get.createMessage();
                    get.setVisible(true);  
                    return;  
                    //getEsami(materia);//System.out.println("voto " + voto + " " + materia + " inserito con successo nell lista ");
                }   
                else{
                    //voto non valido
                    success = false;
                    GetExamGui get = new GetExamGui(outputLabel, success);
                    get.createGui();
                    get.setVisible(true);  
                    return;  
                }   
            }
            libretto.next();       
        }
        //esame non trovato
        outputLabel[1] = new JLabel(notFound); //cambio messaggio di errore personalizzato 
        GetExamGui get = new GetExamGui(outputLabel, success);
        get.createGui();
        get.setVisible(true);
    }

    //cancellazione voto settando bocciato a true e il voto a 0

    public void cancellaVoto(String materia){
        boolean success = false;
        JLabel outputLabel[] = new JLabel[4];
        libretto.setIteration();
        while (libretto.hasNext()){
            
            if(libretto.getData().getMateria().equals(materia)){
                DialogBox choiceCancel = new DialogBox("Are you sure?",0);
                if (choiceCancel.choice() == JOptionPane.NO_OPTION) {
                    //esco
                    return;
                } else if(choiceCancel.choice() == JOptionPane.YES_OPTION) {
                    libretto.getData().setVoto(0);
                    success = true; //cosi stampo il messaggio di output positivo
                    outputLabel[0] = new JLabel(materia + " : " + libretto.getData().getVoto());
                    outputLabel[2] = new JLabel("Grade was cancelled correctly!");
                    GetExamGui get = new GetExamGui(outputLabel, success);
                    get.createGui();
                    get.createMessage();
                    get.setVisible(true);  
                    return;
                } else if(choiceCancel.choice() == JOptionPane.CLOSED_OPTION){
                    //chiudo box e esco
                    return;
                }
                
            }
            libretto.next();
        }
        outputLabel[1] = new JLabel(notFound); //mex in caso di errore
        GetExamGui get = new GetExamGui(outputLabel, success);
        get.createGui();
        get.setVisible(true);  
        
    }

    public int getEsamiNoSost(){
        int sostenuti = 0;
        libretto.setIteration();
        while (libretto.hasNext()){
               
            if(libretto.getData().getVoto() == 0.0){
                sostenuti++;  
            }
            libretto.next();
        }
        if(sostenuti == 0)
            return 0;
         else 
            return  sostenuti;
        
    }

    public void getExamsStateUi(boolean passed){
        int passedExams = libretto.length() - this.getEsamiNoSost();
        
        JLabel exams;
        
        if (passed){
             exams = new JLabel("<html><h2>The total number of passed exams of the student " + x.getNome() + " " +
                                    x.getCognome() + " "  + x.getMatricola() + " " + "is : " + passedExams + "</h2></html>");
        } else{
             exams = new JLabel("<html><h2>The total number of not passed exams of the student " + x.getNome() + " " +
                                    x.getCognome() + " "  + x.getMatricola() + " " + "is : " + this.getEsamiNoSost() + "</h2></html>");
        }
        
        PassedExamGui p = new PassedExamGui(exams);
        p.createGui();
        p.setVisible(true);  
        
    }

    public int getEsamiSost(){
        return libretto.length() - this.getEsamiNoSost();
    }

    //stampa informazioni sul singolo esame a partirte dalla materia

    public void getEsami(String materia){
        boolean found = false;
        JLabel outputLabel[] = new JLabel[3];
        outputLabel[1] = new JLabel(notFound); //messaggio di errore personalizzato per la classe
        String text = "";
        outputLabel[2] = new JLabel("<html><p><lu><li> EXAM UPDATED SUCCESFULLY</li></lu></p><hr></html>");
        libretto.setIteration();
        while (libretto.hasNext()){
            if(libretto.getData().getMateria().equals(materia)){
                found = true;
                text = libretto.getData().getMateria() + " - Professore: " +  libretto.getData().getProfessore() + " - Tipologia: " +  
                        libretto.getData().getTipologia() + " - Voto: " +  libretto.getData().getVoto() + " - Data: " + 
                        libretto.getData().getDataEsameString() + " - Bocciato: " +  libretto.getData().getBocciato() + " " +
                        " - Ateneo: " + libretto.getData().getNomeAteneo() + "\n";

                outputLabel[0] = new JLabel(text);
                GetExamGui get = new GetExamGui(outputLabel, found);
                get.createGui();
                get.setVisible(true); 
                System.out.println("found"); 
                return;  
            } 
            libretto.next();
        }
                GetExamGui get = new GetExamGui(outputLabel, found);
                get.createGui();
                get.setVisible(true); 
                System.out.println("not found"); 
        
    }

    public double getMedia(){
        int j = 0;
        double media = 0;
    
        while(libretto.hasNext()){
            
            if(libretto.getData().getVoto() >= 18){
                j++;
                media += libretto.getData().getVoto();
            }
            libretto.next();
        }
        
        if(j <= 0){
            return 0;
        }    
        else 
            return media / j;
    }

    

    
       
}