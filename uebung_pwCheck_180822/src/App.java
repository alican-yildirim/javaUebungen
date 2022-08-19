import java.util.HashMap;
import javax.swing.*;

import java.awt.event.*;


public class App {

    private static final String pw = "ali";
    public static int wrongTrys = 0;

    public static HashMap<Integer,String> trysList = new HashMap<Integer,String>();

    public static void missErfolg(JLabel label,JTextField txt) {
        
        label.setText("Das Passwort war NICHT richtig!!! Versuch es nocheinmal!");
        wrongTrys++;
        trysList.put(wrongTrys, txt.getText());

    }

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Passwort Überprüfer!!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,300,600,400);
        frame.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        

        JLabel label = new JLabel("Geben Sie Ihr Passwort ein!!!");
        label.setVisible(true);
        label.setBounds(600/3,50,600,50);
        frame.add(label);

        JTextField txtField = new JTextField();
        txtField.setBounds(200,100,200,50);
        frame.add(txtField);

        JButton btn = new JButton("Prüfen!");
        btn.setBounds(200,150,200,50);

        btn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                
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

                    }

                }else{

                    label.setText("Geben Sie etwas ein!!!");

                }

                txtField.setText("");
                
            }
            
        });
        frame.add(btn);

    }
}
