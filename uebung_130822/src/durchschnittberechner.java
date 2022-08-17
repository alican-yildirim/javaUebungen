public class durchschnittberechner {

    public int sum = 0;
    public float schnitt = 0;

    public durchschnittberechner(int[] zahlen){

        for(int i=0;i<zahlen.length;i++){

            this.sum += i;

        }

        this.schnitt = this.sum / zahlen.length;

    }

}
