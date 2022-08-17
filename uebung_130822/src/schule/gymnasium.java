package schule;

public class gymnasium extends schule{

    public int schuelerAnzahl;
    public String dirketor;
    public int lehrerAnzahl;

    public String get(){

        return "Gründedatum: " + gruendeDatum + "\nName: " + name + "\nLand: " + land + "\nStadt: " + stadt + "\nSchüler Anzahl: " + schuelerAnzahl + "\nDirektor: " + dirketor + "\nLehreranzahl: " + lehrerAnzahl;

    }

}
