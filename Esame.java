
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 
import java.text.ParseException;


public class Esame{
    private String materia;
    private String professore;
    private String tipologia;
    private Date dataEsame; //utilizzo della classe Java.Util.Date per mostrare le date
    private String nomeAteneo;
    private int voto;
    private boolean bocciato;
    


public Esame(String materia,String professore,String tipologia,
             String dataEsame,int voto,String nomeAteneo){
    
        if(setDataEsame(dataEsame) && setVoto(voto)){
            //System.out.println("settimng esame");
            this.materia = materia;
            this.professore = professore;
            this.tipologia = tipologia;
            this.nomeAteneo = nomeAteneo;
            //this.dataEsame = data;
        } else {
            System.out.println("Errore nella creazione esame colpa di data o voto");
            return;
        }
}


public void setMateria(String mat){
    this.materia =  mat;
}

public void setProfessore(String prof){
    this.professore =  prof;
}

public void setTipologia(String tip){
    this.tipologia =  tip;
}

//la data viene passata come stringa e converrita in data in modo da essere memorizzata come oggetto Date
public boolean setDataEsame(String dataEsame){
    boolean success = false;
    try {
        Date data =new SimpleDateFormat("dd-MM-yyyy").parse((String)dataEsame);  
        this.dataEsame = data;
        success = true;
    } catch (ParseException e) {
        System.out.println("erroreeeee nella conversione della data inserirla con formato corretto : dd-MM-yyyy");
        success = false;
    }
    return success;
}




public String getMateria(){
    return this.materia;
}
public String getTipologia(){
    return this.tipologia;
}
public String getProfessore(){
    return this.professore;
}

// public boolean getBocciato(){
//     return this.bocciato;
// }
public Date getDataEsame(){
    return this.dataEsame;
}

/* 
metodo per convertire un oggetto Date in una stringa dato che i metodi set e
i costruttori necessitano come parametro un tipo string che poi viene 
convertito in date
*/
public String getDataEsameString(){
    try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dataStringa = formatter.format(this.dataEsame); 
        return dataStringa; 
    } catch (Exception ex ){
        System.out.println(ex);
        return "errore";
     }
     
}

public boolean getBocciato(){
    return this.bocciato;
 }

 public void setBocciato(boolean b){
     this.bocciato = b;
 }

 public boolean setVoto(int x){
     if(x >= 0 && x <= 30){
         if(x < 18.0){            
             this.voto =  x; //tolto il cast double
             this.bocciato = true;
             return true;
                 
         } else if( x >= 18.0){
             this.voto =  x; //tolto il cast double
             this.bocciato = false;
             return true;
         }
     } else{
         return false;
     }
     return true; //default  
 }

 



 public double getVoto(){
     return this.voto;
 }

 public int getVotoInt(){
     return (int) this.voto;
 }

 public void setNomeAteneo(String nomeAteneo) {
     this.nomeAteneo = nomeAteneo;
 }

 public String getNomeAteneo() {
     return nomeAteneo;
 }
 
    

}


