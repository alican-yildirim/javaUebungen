import java.lang.Thread;
import javax.swing.*;
import java.awt.event.*;

public class App {

    private static final String pw = "ali"; // Valid Password!
    private static int wrongTrys = 0;
    private static final int maximumTrys = 3; // Maximum Trys!
    private static int availableTrys = maximumTrys;
    private static DefaultListModel<String> listenModel = new DefaultListModel<String>();
    private static JList anzeigeListe = new JList<>();
    private static JButton resumeBtn = new JButton("Resume");
    private static JProgressBar progressBalken = new JProgressBar(0,100);
    private static JFrame frame = new JFrame("Passwort Überprüfer!!!!");
    private static JLabel label = new JLabel("Geben Sie Ihr Passwort ein!!!");
    private static JTextField txtField = new JTextField();
    private static JButton btn = new JButton("Prüfen!");

    private static void addWrongTrysToList() {
        
        label.setText("Das Passwort war NICHT richtig!!! Versuch es nocheinmal!");
        wrongTrys++;
        listenModel.addElement(wrongTrys + " - Try: " + txtField.getText());

    }

    private static void lowerProgressBar(){

        int subtractionOperand = progressBalken.getMaximum() / maximumTrys;

        int newValue = progressBalken.getValue() - subtractionOperand;
        progressBalken.setValue(availableTrys == 0 ? 0 : newValue);

    }

    private static void showResumeBtn(int y){

        resumeBtn.setBounds(600/3,y,200,50);
        resumeBtn.setVisible(true);

    }

    public static void main(String[] args) throws Exception {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,300,600,400);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setLayout(null);
        
        label.setVisible(true);
        label.setBounds(600/3,20,600,50);
        frame.add(label);

        txtField.setBounds(600/3,100,200,50);
        txtField.setVisible(true);
        frame.add(txtField);

        progressBalken.setValue(100);
        progressBalken.setBounds(200,50,200,50);
        progressBalken.setVisible(true);
        progressBalken.setStringPainted(true);
        progressBalken.setString(Integer.toString(availableTrys));
        frame.add(progressBalken);

        btn.setBounds(600/3,150,200,50);
        btn.setVisible(true);
        frame.add(btn);

        anzeigeListe.setVisible(false);
        frame.add(anzeigeListe);

        resumeBtn.setVisible(false);
        frame.add(resumeBtn);

        btn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){

                if(availableTrys != 0){

                    if(!txtField.getText().isEmpty()){

                        if(App.pw.equals(txtField.getText())){

                            String finallyOutput = "Das Passwort war richtig!!!!\nSie haben " + wrongTrys + " Versuche gebraucht:";

                            anzeigeListe.setVisible(true);
                            anzeigeListe.setBounds(0,200,600,300);
                            anzeigeListe.setModel(listenModel);

                            label.setText(finallyOutput);
                            txtField.setVisible(false);
                            btn.setVisible(false);
                            label.setBounds(0,150,600,20);
                            progressBalken.setVisible(false);

                            showResumeBtn(10);
                
                        }else{

                            availableTrys--;
                            progressBalken.setString(Integer.toString(availableTrys));
                            App.addWrongTrysToList();
                            App.lowerProgressBar();

                            if(availableTrys==0){
                                showResumeBtn(200);
                            }

                        }

                    }else{

                        label.setText("Geben Sie etwas ein!!!");

                    }

                }else{

                    label.setText("Sie haben keine Chancen mehr!!!");

                }

                txtField.setText("");
                
            }
            
        });
        
        resumeBtn.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
             
                availableTrys = maximumTrys;
                progressBalken.setValue(100);
                progressBalken.setVisible(true);
                resumeBtn.setVisible(false);
                anzeigeListe.setVisible(false);
                listenModel.clear();
                txtField.setVisible(true);
                btn.setVisible(true);
                label.setBounds(600/3,20,600,50);
                label.setText("Geben Sie Ihr Passwort ein!!!");
                progressBalken.setString(Integer.toString(maximumTrys));
                wrongTrys=0;

            }

        });

        frame.setVisible(true);

        for(int i = 0;i < 100;i++){

            progressBalken.setValue(i);

            try{
                
                Thread.sleep(20);

            }catch(Exception e){

            }

        }

    }
}
