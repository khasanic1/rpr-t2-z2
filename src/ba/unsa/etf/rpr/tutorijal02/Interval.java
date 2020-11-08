package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    boolean pripadaPrvoj, pripadaDrugoj;

    public Interval(double poc, double kraj, boolean prPrvoj, boolean prDrugoj)
    throws IllegalArgumentException{
        if(poc > kraj){
            throw new IllegalArgumentException("Pocetna tacka intervala veca od krajnje");
        }
        pocetnaTacka=poc;
        krajnjaTacka=kraj;
        pripadaPrvoj=prPrvoj;
        pripadaDrugoj=prDrugoj;
    }

    public Interval (){
        pocetnaTacka=0;
        krajnjaTacka=0;
        pripadaDrugoj=false;
        pripadaPrvoj=false;
    }

    public Interval intersect(Interval inter2){
        return intersect(this, inter2);
    }

    /*public static Interval intersect(Interval inter1, Interval inter2){
        if(Double.compare(inter1.pocetnaTacka, inter2.krajnjaTacka) > 0 ||
        Double.compare(inter2.pocetnaTacka, inter1.krajnjaTacka) > 0){
            return new Interval();
        }
        double poc;
        double kraj;
        boolean prPrvoj;
        boolean prDrugoj;

        if(inter1.pocetnaTacka > inter2.pocetnaTacka){
            poc = inter1.pocetnaTacka;
            prPrvoj=inter1.pripadaPrvoj;
        }else{
            poc = inter2.pocetnaTacka;
            prPrvoj=inter2.pripadaPrvoj;
        }

        if(inter1.krajnjaTacka < inter2.krajnjaTacka){
            kraj= inter1.krajnjaTacka;
            prDrugoj = inter1.pripadaDrugoj;
        }else{
            kraj= inter2.krajnjaTacka;
            prDrugoj= inter2.pripadaDrugoj;
        }
        return new Interval(poc, kraj, prPrvoj, prDrugoj);
    }*/

    public static Interval intersect(Interval i, Interval i2) {
        if (Double.compare(i.pocetnaTacka,i2.krajnjaTacka)>0 || Double.compare(i2.pocetnaTacka,i.krajnjaTacka)>0) return new Interval();
        double pocetna, krajnja;
        boolean pripadnostPrve, pripadnostDruge;

        if (i.pocetnaTacka > i2.pocetnaTacka) {
            pocetna=i.pocetnaTacka;
            pripadnostPrve=i.pripadaPrvoj;
        }
        else {
            pocetna=i2.pocetnaTacka;
            pripadnostPrve=i2.pripadaPrvoj;
        }

        if (i.krajnjaTacka< i2.krajnjaTacka){
            krajnja=i.krajnjaTacka;
            pripadnostDruge=i.pripadaDrugoj;
        }
        else {
            krajnja=i2.krajnjaTacka;
            pripadnostDruge=i2.pripadaDrugoj;
        }

        return new Interval(pocetna, krajnja, pripadnostPrve, pripadnostDruge);
    }

    public boolean isIn(double t){
        if(t > pocetnaTacka && t < krajnjaTacka){
            return true;
        }
        return (pripadaPrvoj && pocetnaTacka==t || pripadaDrugoj && krajnjaTacka==t);
    }

    public boolean isNull(){
        return (pocetnaTacka==0 && krajnjaTacka==0 && !pripadaPrvoj && !pripadaDrugoj);
    }

    @Override
    public String toString(){
        String s;
        if(pripadaPrvoj){
            s="[";
        }else{
            s="(";
        }
        if(!isNull()){
            s = s + pocetnaTacka + "," + krajnjaTacka;
        }
        if(pripadaDrugoj){
            s = s + ")";
        }else{
            s = s + ")";
        }
        return s;
    }

    @Override
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Interval inter = (Interval) o;
        return Double.compare(inter.pocetnaTacka, pocetnaTacka) == 0 &&
                Double.compare(inter.krajnjaTacka, krajnjaTacka) == 0 &&
                pripadaPrvoj == inter.pripadaPrvoj &&
                pripadaDrugoj == inter.pripadaDrugoj;
    }
}
