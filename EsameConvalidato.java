
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 
import java.text.ParseException;

/**
 * CLASSE NON USATA PER QUESTA APPLICAZIONE
 */

public class EsameConvalidato extends Esame{
    
    private String nomeAteneo;
    private boolean convalidato; //convalida coordinata insieme all'assegnamento e l'eliminazione dei voti
    private Date dataConvalida;
    private int voto;
    private boolean bocciato;

    

    public EsameConvalidato(String materia,String professore,String tipologia,
                            String dataEsame, int voto, String nomeAteneo, 
                            String dataConvalida) {
        super(materia, professore, tipologia,  dataEsame);
        this.nomeAteneo = nomeAteneo;
        this.convalidato = true; 
        //conversione da stringa a date
        try {
            Date data =new SimpleDateFormat("dd-MM-yyyy").parse((String)dataConvalida);  
            this.dataConvalida = data;
        } catch (ParseException e) {
            System.out.println("ERRORE nella conversione della data inserirla con formato corretto : dd-MM-yyyy");
            System.exit(0);
        }
        this.voto =  voto; //tolto il cast double
        if(voto < 18 && voto > 0)
            this.bocciato = true; 
        else if (voto >= 18 && voto <= 30)
            this.bocciato = false;    
        
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

    //setta anche la data
    public boolean setConvalidato(boolean convalidato,String data) {
        this.convalidato = convalidato;
        this.dataConvalida = setDataConvalida(data);
        return true;
    }
   
    public Date setDataConvalida(String dataConvalida) { //"dd-mm-yyyy"
        
        try {
            Date data =new SimpleDateFormat("dd-MM-yyyy").parse((String)dataConvalida);  
            this.dataConvalida = data;
        } catch (ParseException e) {
            System.out.println("errore nella conversione della data inserirla con formato corretto : dd-MM-yyyy");
        }
        return this.dataConvalida;
    }

    
    public Date getDataConvalida() {
        return this.dataConvalida;
    }

    public String getDataConvalidaString(){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dataStringa = formatter.format(this.dataConvalida); 
            return dataStringa; 
                   
        } catch (Exception ex ){
            System.out.println(ex);
            return "errore";
         }
         
    }
    
    public boolean getConvalidato(){
        return this.convalidato;
    }
                        

}