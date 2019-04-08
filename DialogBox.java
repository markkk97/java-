/**
 * DialogBox crea box diversi in base a come è settata la variabile mode
 */
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class DialogBox {
    private int response;
    private String message;
    private int mode;

    public DialogBox(String message,int mode) {
        this.message = message;
        this.mode = mode;

        if (this.mode == 1) { //caso in cui si mostra un dialog fa output dell'exception
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(null, this.message, "ERROR", JOptionPane.ERROR_MESSAGE);    
        } else if(this.mode == 0) { //caso in cui si crea un dialog di conferma
            JDialog.setDefaultLookAndFeelDecorated(true);
            this.response = JOptionPane.showConfirmDialog(null, this.message, "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);     
        } else{
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(null, this.message, "SUCCESS", JOptionPane.INFORMATION_MESSAGE); 
        }

        
           
    }

    public int choice() {
        return this.response;
    }
    
}