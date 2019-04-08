import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator; 
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 
import java.text.ParseException;

public class LibrettoTrasf extends Libretto{
    private ArrayList<Esame> librettoArray;
    private Libretto esami;
    
    public LibrettoTrasf(String nome,String cognome , String matricola,ArrayList<Esame> librettoArray){
        //eredita tutto da libretto
        super(nome,cognome,matricola);
        this.librettoArray= librettoArray;
        
    }

    //metodo che stampa l'esame sostenuto in una certa data
    public void stampaDaData(String data){
        int cont = 0;
        //GenericStack<Esame> EsamiInData = new GenericStack<Esame>();
        try {
            Date date =new SimpleDateFormat("dd-MM-yyyy").parse(data);  
            for (Esame var : librettoArray) {
                if(var.getDataEsame().compareTo(date) == 0){
                    this.caricaEsameInLista(var.getMateria(), var.getProfessore(), var.getTipologia(), var.getDataEsameString(), 9, var.getNomeAteneo());                
                    cont++;
                }
            }
            if(cont == 0){
                DialogBox d = new DialogBox("No exams for the provided date", 3);
            }
            else
                this.getLibretto(); 
        } catch (ParseException e) {
            GuiException x = new GuiException(e);
                x.createGui();
                return;
        }
        
    }
   
    //METODI UTILI MA NON USATI E NON MODIFICATI PER QUESTA APPLICAZIONE
    //SOSTITUIRE ARRAYLIST
    
    // public void stampaConvalidati(){
    //     int cont = 0;
    //     Iterator<EsameConvalidato> it = libretto.iterator();
    //     while(it.hasNext()){
    //         EsameConvalidato Esameconsiderato = it.next();
    //         if(Esameconsiderato.getConvalidato() == true){
    //             System.out.println(Esameconsiderato.getMateria() + " " + Esameconsiderato.getVoto());
    //             cont++;
    //         }
    //     }
    //     if(cont == 0){
    //         System.out.println("non ci sonon esami convalidati");
    //     }
    // }

    // public void assegnamentoConv(String materia, String professore, String tipologia, String dataEsame, int voto,String dataconv,String ateneo){
    //     try {
    //         libretto.add(new EsameConvalidato(materia, professore, tipologia, dataEsame, voto,dataconv,ateneo));
    //         System.out.println("Esame convalidato inserito con successo : " + materia);

    //     } catch (Exception e) {
    //         System.out.println("ATTENZIONE -- errore inserimento" + e);
    //     }      
    // }

    
    // public void cancellaConvalida(String materia){
    //     Iterator<EsameConvalidato> it = libretto.iterator();
    //     while (it.hasNext()){
    //         EsameConvalidato Esameconsiderato = it.next();    
    //         if(Esameconsiderato.getMateria().equals(materia)){
    //             if(Esameconsiderato.setConvalidato(false,"11-11-1111"))
    //                 System.out.println( materia + ": convalida eliminata con successo");
                
    //             return;
    //         }
    //     }
    //     System.out.println("spiacente esame non trovato : " + materia);
    // }

    // public int getConvalidati(){
    //     int cont = 0;
    //     Iterator<EsameConvalidato> it = libretto.iterator();
    //     while(it.hasNext()){
    //         EsameConvalidato Esameconsiderato = it.next();
    //         if(Esameconsiderato.getConvalidato()== true){
    //             cont++;
    //         }
    //     }
    //     if(cont == 0)
    //         return 0;
    //     else
    //         return cont;
    // }

    // public double getMedia(){
    //     int j = 0;
    //     int media = 0;
    //     Iterator<EsameConvalidato> it = libretto.iterator();
    //     while(it.hasNext()){
    //         EsameConvalidato Esameconsiderato = it.next();
    //         if(Esameconsiderato.getConvalidato() == true){
    //             j++;
    //             media += Esameconsiderato.getVoto();
    //         }
    //     }
        
    //     if(j <= 0){
    //         System.out.println("non ci sonon esami convalidati");
    //         return 0;
    //     }    
    //     else 
    //         return media / j;
    // }
   

}