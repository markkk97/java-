import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//utilzzata per gestire input vuoto di jtextfield
public class GuiException {
    Exception ex;
    public GuiException(Exception e){
         ex = e;
    }
    public void createGui(){
        DialogBox choiceCancel = new DialogBox(ex.getMessage(),1);
    }
    
}