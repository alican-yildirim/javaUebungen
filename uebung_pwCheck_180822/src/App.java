import java.util.Scanner;
import java.util.HashMap;
import javax.swing.*;

public class App {

    public static final String pw = "ali";
    public static int wrongTrys = 0;

    public static HashMap<Integer,String> trysList = new HashMap<Integer,String>();

    public static void scanInput() {
            
        Scanner scan = new Scanner(System.in);

        if(scan.hasNextLine()) {

            App.checkInput(scan.nextLine());

        }

    }

    public static void checkInput(String input) {
        
        if(App.pw.equals(input)){

            System.out.println("Das Passwort war richtig!!!!\nSie haben " + wrongTrys + " Versuche gebraucht:");

            for(Integer key : trysList.keySet()){

                System.out.println(key + " - Versuch: " + trysList.get(key));

            }

        }else{

            System.out.println("Das Passwort war NIIIIICHT richtig!!!!\nVersuchen Sie es nocheinmal!!!");
            wrongTrys++;
            trysList.put(wrongTrys, input);
            App.scanInput();

        }

    }

    public static void main(String[] args) throws Exception {

        System.out.println("Geben Sie Ihr Passwort ein!!!!");

        App.scanInput();

    }
}
