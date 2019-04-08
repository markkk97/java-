import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;;


public class Studente{
    private String nome;
    private String cognome;
    private String matricola;

    public Studente(String nome, String cognome ,String matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    
    }
    
    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setCognome(String cognome) {
       this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    
    
}