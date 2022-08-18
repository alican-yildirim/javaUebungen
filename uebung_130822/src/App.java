import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.lang.Character;

import schule.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        String[] werkzeug = new String[3];

        werkzeug[0] = "Hammer";
        werkzeug[1] = "Säge";
        werkzeug[2] = "Schraube";

        String[] personen = {"Thomas","Lala","Lena"};

        personen[2] = "Alican";

        ArrayList<String> autos = new ArrayList<String>();

        autos.add("Audi");
        autos.add("BMW");
        autos.add("Mercedes");

        //System.out.println(autos.get(2));




        int[] aufzaehlung = new int[10];

        for(int i=0;i<aufzaehlung.length;i++){

            aufzaehlung[i] = i+1;

        }

        //durchschnittberechner berechner = new durchschnittberechner(aufzaehlung);

        //System.out.println(berechner.schnitt);

        hunde dackel = new hunde("dackel",7,true,"dackelias");
        hunde labrador = new hunde("labrador",10,false,"tobias");
        hunde goldenRetriver = new hunde("golden retriver",2,true,"booma");
        hunde rotweiler = new hunde("rotweiler",5,true,"lenu");
        hunde pitbull = new hunde("pitbull",8,false,"simba");

        hunde[] hundeArray = {dackel,labrador,goldenRetriver,rotweiler,pitbull};

        for(int i=0;i<hundeArray.length;i++){

            if(hundeArray[i].bellen == true){

                //System.out.println(hundeArray[i].name + " sagt: " + hunde.bellen());

            }else{

                //System.out.println(hundeArray[i].name + " kann leider nicht bellen!");

            }

        }

        

        // Strings miteinander vergleichen:

        String str1 = "Mein Name ist Alican";
        String str2 = "Mein Name ist Alican";

        if(str1 == str2){

            //System.out.println("Der Name ist Idennt");

        }else{

            //System.out.println("Der Name ist NICHT Idennt");

        }
        
        //String[] gesplittet = str1.split(" ");

        // OHNE die Klasse StringBuilder

        String[] textStuecke = {"Hallo,","mein","Name","ist","Alican!"};

        String zeichenKette = "";

        for(String i : textStuecke){

            zeichenKette += " " + i;

        }

        //System.out.println(zeichenKette);

        // MIT die Klasse StringBuilder

        StringBuilder builder = new StringBuilder();

        for(String i : textStuecke){

            builder.append(" " + i);

        }

        //System.out.println(builder.toString());

        schule school = new gymnasium();

        school.gruendeDatum = 1970;
        school.name = "Hans-peter-schule";
        school.land = "Österreich";
        school.stadt = "Linz";

        schule neu = (schule) school;

        //System.out.println(neu.get());

        ArrayList liste = new ArrayList();

        char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for(char i : abc){

            liste.add(Character.toString(Character.toUpperCase(i)));

        }

        liste.sort(Comparator.reverseOrder());

        for(int i=0;i<liste.size();i++){
        
            //System.out.println(liste.get(i));
        
        }

        HashMap<String,Integer> map = new HashMap<String,Integer>();

        Map map2 = new HashMap();

        map2.put("Alican",25);
        map2.put("2020 war eine Pandemie",true);
        map2.put("Jahreszahl", 2022);
        map2.put("Geschlecht Bundesminister",'M');

        map.put("Wien", 4010);
        map.put("Wels", 4600);
        map.put("Linz", 4020);

        map.containsKey("Wels"); // prüft Key

        map.replace("Wien", 1100); // Wert verändern

        if(map.containsValue(4600)){ // prüft Wert

            System.out.println("Wels gibt es!");

        }

        for(Integer i : map.values()){ // Alle Value - Werte ausgeben

            System.out.println();

        }

        for(String i : map.keySet()){ // Alle Key - Werte ausgeben

            System.out.println(i);

        }
        

        HashSet uniqueArr = new HashSet<>();

        int controll = 0;

        for(char val : abc){

            if(uniqueArr.contains(val)){

                controll++;

            }else{

                uniqueArr.add(val);

                System.out.println(val);

            }

        }

        System.out.println(controll);
        
    }
}