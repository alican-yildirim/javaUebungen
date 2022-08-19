import java.lang.Thread;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.*;

public class App {

    private static final String pw = "ali";
    private static int wrongTrys = 0;

    public static HashMap<Integer,String> trysList = new HashMap<Integer,String>();

    private static void missErfolg(JLabel label,JTextField txt) {
        
        label.setText("Das Passwort war NICHT richtig!!! Versuch es nocheinmal!");
        wrongTrys++;
        trysList.put(wrongTrys, txt.getText());

    }

    private static void lowerProgressBar(JProgressBar progressBalken){

        int subtractionOperand = progressBalken.getMaximum() / 5;

        int newValue = progressBalken.getValue() - subtractionOperand;
        //progressBalken.setValue(newValue);
        for(int i = progressBalken.getValue();i > newValue;i--){

            progressBalken.setValue(i);

            try{

                Thread.sleep(10);

            }catch(InterruptedException e){
                System.out.println("Fehler in der Methode lowerProgressBar!!!");
            }
            
        }

    }

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Passwort Überprüfer!!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,300,600,400);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setLayout(null);
        
        JLabel label = new JLabel("Geben Sie Ihr Passwort ein!!!");
        label.setVisible(true);
        label.setBounds(600/3,20,600,50);
        frame.add(label);

        JTextField txtField = new JTextField();
        txtField.setBounds(600/3,100,200,50);
        frame.add(txtField);

        JProgressBar progressBalken = new JProgressBar(0,100);
        progressBalken.setValue(100);
        progressBalken.setBounds(200,50,200,50);
        progressBalken.setVisible(true);
        frame.add(progressBalken);

        JButton btn = new JButton("Prüfen!");
        btn.setBounds(600/3,150,200,50);

        frame.add(btn);

        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){

                if(progressBalken.getValue() != 0){

                    if(!txtField.getText().isEmpty()){

                        if(App.pw.equals(txtField.getText())){

                            String finallyOutput = "Das Passwort war richtig!!!!\nSie haben " + wrongTrys + " Versuche gebraucht:\n\n";

                            for(Integer key : trysList.keySet()){
                                
                                finallyOutput += key + " - Versuch: " + trysList.get(key) + "\n";
                                
                            }

                            label.setText(finallyOutput);
                            txtField.setVisible(false);
                            btn.setVisible(false);
                            label.setBounds(0,0,6000,400);
                
                        }else{

                            App.missErfolg(label,txtField);
                            App.lowerProgressBar(progressBalken);

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


    }
}
