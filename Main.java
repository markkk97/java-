import java.util.Scanner;
/**
 * Main Del progetto intero
 */

public class Main {

    public static void main(String[] args) {
        boolean success = true;
        do{
        System.out.println("Insert Name");
        Scanner stud1 = new Scanner(System.in);
        String nome = stud1.nextLine();
        System.out.println("Insert Surname");
        Scanner stud2 = new Scanner(System.in);
        String cognome = stud2.nextLine();
        System.out.println("Insert Student Number");
        Scanner stud3 = new Scanner(System.in);
        String matricola = stud3.nextLine();

        if(nome.equals("") || cognome.equals("") || matricola.equals("")){
            System.out.println("Error provide input");
        }
        else{
            Libretto x = new Libretto(nome,cognome,matricola);
            x.inizializzaLibretto();
            GuiLibretto test = new GuiLibretto(x);
            test.setVisible(true);
            success = false;
        }
        } while(success);

        
    }
}