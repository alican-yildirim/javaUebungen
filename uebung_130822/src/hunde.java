public class hunde {
    
    String art;
    int alter;
    boolean bellen;
    String name;

    public hunde(String art,int alter, boolean bellen, String name){

        this.art = art;
        this.alter = alter;
        this.bellen = bellen;
        this.name = name;

    }

    public static String bellen(){

        return "WOOF WOOF!";

    }

}
