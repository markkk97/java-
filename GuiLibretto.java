import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.applet.Applet;


public class GuiLibretto extends JFrame{
    private static final int HEIGHT = 1200;
    private static final int WIDTH = 1400;
    private Libretto lib;  //creazione oggettolibretto 
    JLabel space = new JLabel("    ");
    
    
    public GuiLibretto(Libretto lib){ //prende come parametro l'ggetto libretto che gli sara passato nel main
        super();
        this.lib= lib;
        setSize(WIDTH,HEIGHT);
        setTitle("Libretto Studenti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TABBED PANES 
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel container1 = new JPanel();
        container1.setLayout(new GridLayout(2,1));

        JPanel container2 = new JPanel();
        container2.setLayout(new GridLayout(3,1));
        
        JPanel container3 = new JPanel();
        container3.setLayout(new GridLayout(1,2));
        
        tabbedPane.addTab(" READING OPERATIONS ", null, container1,"Libretto");
        tabbedPane.addTab(" HANDLE GRADES ", null, container2,"Libretto");
        tabbedPane.addTab(" HANDLE EXAMS ", null, container3,"Libretto");

        add(tabbedPane);
        
        
        // END TABBED PANES


        // --- TITLE PANEL 
        JPanel title = new JPanel();
        title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
        JLabel html = new JLabel("<html><h1>Libretto Universitario<br> </h1></html>");  
        title.add(html);
        add(title, BorderLayout.NORTH);

        // --- BUTTONS READING PANEL

         JPanel readButtons = new JPanel();
         readButtons.setLayout(new FlowLayout());

         //label
        JLabel operation = new JLabel("<html><h2> Reading Operations <br> </h2></html>");  
        readButtons.add(operation);

        //buttons
         JButton getLibretto = new JButton("Print record book");
         readButtons.add(getLibretto);
         JButton getPassed = new JButton("Print passed exams");
         readButtons.add(getPassed);
         JButton getNotPassed = new JButton("Print not passed exams");
         readButtons.add(getNotPassed);
         container1.add(readButtons);

        //actionlisteners
        ActionListener OutputLibretto = new OutputLibretto(lib);
        getLibretto.addActionListener(OutputLibretto);
        ActionListener passedExams = new PassedExams(lib);
        getPassed.addActionListener(passedExams);
        ActionListener NotPassedExams = new NotPassedExams(lib);
        getNotPassed.addActionListener(NotPassedExams);
    
        // --- END BUTTONS READING PANEL

        // --- SEARCH EXAM READING PANEL

        //panel
        JPanel searchExam = new JPanel();
        searchExam.setLayout(new FlowLayout());

        //label
        JLabel search = new JLabel("<html><h2> Search for an exam <br> </h2></html>"); 
        searchExam.add(search); 

        //text + button
        JTextField examSearchField = new JTextField(20);
        searchExam.add(examSearchField);
        JButton getExamButton = new JButton("Search");
        searchExam.add(getExamButton);

        container1.add(searchExam);

        //actionlistener
        ActionListener outputExam = new GetExam(lib,examSearchField);
        getExamButton.addActionListener(outputExam);
       
        // --- END SEARCH EXAM READING PANEL

        // --- START ASSIGN GRADE PANEL 
        //panel
        JPanel addMark = new JPanel();
        addMark.setLayout(new FlowLayout());

        //label
        JLabel addMarkLabel = new JLabel("<html><h2>Assign Exam Grade</html></h2>");
        JLabel subjectJLabel = new JLabel("Subject");
        JLabel gradeJLabel = new JLabel("Grade");
        addMark.add(addMarkLabel);
        addMark.add(space);

        //jtextfields + button
        JTextField subject = new JTextField(10);
        JTextField mark = new JTextField(3);
        JTextField output = new JTextField(10);
        addMark.add(subjectJLabel);
        addMark.add(subject);
        addMark.add(gradeJLabel);
        addMark.add(mark);
        JButton insert = new JButton("Insert");
        addMark.add(insert);
        

        //actionlistener
        ActionListener insertGrade = new InsertGrade(lib,subject,mark);
        insert.addActionListener(insertGrade);

        container2.add(addMark);

        // --- END ASSIGN GRADE PANEL 


        /**
         * START CANCEL GRADE PANEL 
         */
      
        //panel
        JPanel cancelGrade = new JPanel();
        cancelGrade.setLayout(new FlowLayout());

        //label
        JLabel cancelGradeLabel = new JLabel("<html><h2>Cancel Exam Grade</html></h2>");
        JLabel subCancJLabel = new JLabel("Subject");
        cancelGrade.add(cancelGradeLabel);
        cancelGrade.add(space);
        cancelGrade.add(subCancJLabel);

        //jtextfields + button
        JTextField subCanc = new JTextField(15);
        cancelGrade.add(subCanc);
        JButton cancelGradeJButton = new JButton("Cancel Exam Grade");
        cancelGrade.add(cancelGradeJButton);
        

        //actionlistener
        ActionListener cancelGradeListener = new CancelGrade(lib,subCanc);
        cancelGradeJButton.addActionListener(cancelGradeListener);

        container2.add(cancelGrade);
        
        /**
         *  END CANCEL GRADE PANEL 
         */

        // panel che contiene cancel esame e stampa esame in data x 
        JPanel cancelAndDatePanel = new JPanel();
        cancelAndDatePanel.setLayout(new GridLayout(2,1));

        /**
         * START CANCEL EXAM IN LIST PANEL
         */

        JPanel cancelExam = new JPanel();
        cancelExam.setLayout(new FlowLayout());

        //label
        JLabel cancelExamLabel = new JLabel("<html><h2>Cancel Exam </html></h2>");
        JLabel examCancJLabel = new JLabel("Subject");
        cancelExam.add(cancelExamLabel);
        cancelExam.add(space);
        cancelExam.add(examCancJLabel);

        //jtextfields + button
        JTextField examCanc = new JTextField(15);
        cancelExam.add(examCanc);
        JButton cancelExamJButton = new JButton("Cancel Exam ");
        cancelExam.add(cancelExamJButton);
        

        //actionlistener
        ActionListener cancelExamListener = new CancelExam(lib,examCanc);
        cancelExamJButton.addActionListener(cancelExamListener);

        cancelAndDatePanel.add(cancelExam);

        /**
         *  END CANCEL EXAM PANEL 
         */

        /**
        * START LIBRETTO TRASF STAMPA DATA PANEL
        */
        JPanel dataExam = new JPanel();
        dataExam.setLayout(new FlowLayout());

        //label
        JLabel dataExamLabel = new JLabel("<html><h2>Search exams by date</html></h2>");
        JLabel displayDataJLabel = new JLabel("Date (dd-mm-yyyy)");
        dataExam.add(dataExamLabel);
        dataExam.add(space);
        dataExam.add(displayDataJLabel);

        //jtextfields + button
        JTextField seeData = new JTextField(15);
        dataExam.add(seeData);
        JButton dataExamJButton = new JButton("Search Exam ");
        dataExam.add(dataExamJButton);
        

        //actionlistener
        ActionListener dataExamListener = new ExamByDate(lib,seeData);
        dataExamJButton.addActionListener(dataExamListener);

        cancelAndDatePanel.add(dataExam);

        /**
        * END LIBRETTO TRASF STAMPA DATA PANEL
        */

        //aggoungo i panel di cancel exam e stampa Esame in data x al container 3
        container3.add(cancelAndDatePanel);

        /**
         * START INSERT EXAM PANEL
         */

        JTextField[] insertArray = new JTextField[6];
        JPanel insertExam = new JPanel();
        insertExam.setLayout(new BoxLayout(insertExam,BoxLayout.PAGE_AXIS));
        insertExam.setBorder(BorderFactory.createEmptyBorder(1,200,1,200));

        //label
        JLabel insertExamLabel = new JLabel("<html><h2>Insert Exam </html></h2>");

        //jtextfields + button
        JTextField subText = new JTextField(15);
        insertArray[0] =subText ;
        JTextField profText = new JTextField(15);
        insertArray[1] = profText;
        JTextField typeText = new JTextField(15);
        insertArray[2] = typeText;
        JTextField dateText = new JTextField(15);
        insertArray[3] = dateText;
        JTextField gradeText = new JTextField(15);
        insertArray[4] = gradeText;
        JTextField uniText = new JTextField(15);
        insertArray[5] = uniText;

        JButton insertExamJButton = new JButton("Insert Exam ");
        

        insertExam.add(insertExamLabel);
        //insertExam.add(space);
        insertExam.add(new JLabel("Subject"));
        //insertExam.add(space);
        insertExam.add(subText);
        insertExam.add(new JLabel("Professor"));
        //insertExam.add(space);
        insertExam.add(profText);
        insertExam.add(new JLabel("Typology"));
        insertExam.add(typeText);
        insertExam.add(new JLabel("Date - format = dd-mm-yyyy"));
        //insertExam.add(space);
        insertExam.add(dateText);
        insertExam.add(new JLabel("<html>Grade - please insert integers between 0 and 30</html>"));
        //insertExam.add(space);
        insertExam.add(gradeText);
        insertExam.add(new JLabel("University"));
        //insertExam.add(space);
        insertExam.add(uniText);

        insertExam.add(insertExamJButton);
        

        //actionlistener
        ActionListener insertExamListener = new InsertExam(lib,insertArray);
        insertExamJButton.addActionListener(insertExamListener);

        container3.add(insertExam);


        /**
         *  END INSERT EXAM PANEL 
         */


         
}

}