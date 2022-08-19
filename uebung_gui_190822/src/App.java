import java.awt.Color;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.plaf.TextUI;
import javax.swing.text.EditorKit;

public class App {

    public static HashMap<Integer,String> map = new HashMap<Integer,String>();
    public static void main(String[] args) throws Exception {

        // ---------------------------------------- Dialog Fenster

        // JDialog dialog = new JDialog();

        // dialog.setTitle("Mein ersts Dialog-fenster");
        // dialog.setSize(700,500);
        // dialog.setLocation(300, 300);
        // dialog.setModal(true);
        
        // JLabel label = new JLabel("Text...");
        // label.setBounds(0,0,0,0);
        
        
        // dialog.add(label);
        // dialog.setVisible(true);

        // ---------------------------------------- Farbauswahl Fenster

        // JFrame frame = new JFrame("Farbauswahl");

        // JColorChooser farbauswahl = new JColorChooser();

        // frame.setVisible(true);
        // frame.setSize(800,500);
        // frame.setDefaultLookAndFeelDecorated(true);
        // frame.getContentPane().add(farbauswahl);

        JFrame fenster = new JFrame("Fenster");
        fenster.setDefaultLookAndFeelDecorated(true);
        fenster.setLayout(null);
        fenster.setDefaultCloseOperation(fenster.EXIT_ON_CLOSE);
        
        fenster.setLocation(100,100);
        fenster.setSize(800,500);
        
        JLabel txt = new JLabel("Ein Text!");
        txt.setBounds(10,10,800,10);
        txt.setVisible(true);
        fenster.add(txt);

        // ---------------------------------------- JCheckBox

        JCheckBox box = new JCheckBox("Box");
        box.setBounds(10,40,800,50);
        box.setVisible(true);
        fenster.add(box);

        // ---------------------------------------- JComboBox (ähnelt dem select-tag in HTML)

        JComboBox comboBox = new JComboBox<>();
        comboBox.setBounds(10,70,800,70);
        comboBox.setVisible(true);
        for(int i=0;i<10;i++){
            comboBox.addItem("Eintrag - " + i);
        }
        fenster.add(comboBox);

        // ---------------------------------------- JList
        
        DefaultListModel listModel = new DefaultListModel<>();
        for(int i=0;i<10;i++){
            listModel.addElement("Eintrag - " + i);
        }
        JList Eintragsliste = new JList<>(listModel);
        Eintragsliste.setBounds(10,150,800,100);
        Eintragsliste.setVisible(true);
        fenster.add(Eintragsliste);

        // ---------------------------------------- JProgressBar

        JProgressBar progressBar = new JProgressBar(0,100);
        progressBar.setValue(0);
        progressBar.setBounds(10,250,800,100);
        progressBar.setVisible(true);
        fenster.add(progressBar);





        fenster.setVisible(true);

        for(int i=0;i<70;i++){
            progressBar.setValue(i);

			Thread.sleep(15);
        }

    }
}