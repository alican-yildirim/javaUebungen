package schule;

public class schule {

    public int gruendeDatum;
    public String name;
    public String land;
    public String stadt;

    protected String[] regeln = {"Rauchen","Gewalt","Mobbing","Stehlen","Drogen konsum","Telefonieren"};

    public String get(){

        return "Gründedatum: " + gruendeDatum + "\nName: " + name + "\nLand: " + land + "\nStadt: " + stadt;

    }

}