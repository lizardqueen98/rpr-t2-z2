package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
private double prva_tacka, druga_tacka;
private boolean prva_pripada, druga_pripada;
public Interval(double prva, double druga, boolean prva_pripada, boolean druga_pripada){
    if(prva>druga) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
    prva_tacka=prva;
    druga_tacka=druga;
    this.prva_pripada=prva_pripada;
    this.druga_pripada=druga_pripada;
}
public Interval(){
    prva_tacka=0;
    druga_tacka=0;
    prva_pripada=false;
    druga_pripada=false;
}
public boolean isNull(){
    if(prva_tacka ==0 && druga_tacka == 0 && prva_pripada == false && druga_pripada ==false) return true;
    return false;
}
public boolean isIn(double tacka){
    if(tacka>prva_tacka && tacka<druga_tacka || tacka==prva_tacka && prva_pripada || tacka==druga_tacka && druga_pripada) return true;
    return false;
}
public Interval intersect(Interval i){
    Interval novi=new Interval();
    if(i.prva_tacka>prva_tacka){
        if(i.druga_tacka<druga_tacka) {
            novi.prva_tacka = i.prva_tacka;
            novi.druga_tacka = i.druga_tacka;
            novi.prva_pripada = i.prva_pripada;
            novi.druga_pripada = i.druga_pripada;
        }
        else{
            novi.prva_tacka = i.prva_tacka;
            novi.druga_tacka = druga_tacka;
            novi.prva_pripada = i.prva_pripada;
            novi.druga_pripada = druga_pripada;
        }
    }
    else{
        if(i.druga_tacka<druga_tacka) {
            novi.prva_tacka = prva_tacka;
            novi.druga_tacka = i.druga_tacka;
            novi.prva_pripada = prva_pripada;
            novi.druga_pripada = i.druga_pripada;
        }
        else{
            novi.prva_tacka = prva_tacka;
            novi.druga_tacka = druga_tacka;
            novi.prva_pripada = prva_pripada;
            novi.druga_pripada = druga_pripada;
        }
    }
    return novi;
}
public static Interval intersect (Interval i1, Interval i2){
    return i1.intersect(i2);
}
@Override
    public String toString(){
    if(prva_pripada && druga_pripada){
        return "["+prva_tacka+","+druga_tacka+"]";
    }
    else if(prva_pripada && !druga_pripada){
        return "["+prva_tacka+","+druga_tacka+")";
    }
    else if(!prva_pripada && druga_pripada){
        return "("+prva_tacka+","+druga_tacka+"]";
    }
    else if(this.isNull()) return "()";
    return "("+prva_tacka+","+druga_tacka+")";
}
@Override
public boolean equals(Object o){
    Interval novi = (Interval) o;
    if(novi.prva_tacka == prva_tacka && novi.druga_tacka == druga_tacka && novi.prva_pripada == prva_pripada && novi.druga_pripada == druga_pripada)
        return true;
    return false;
}
}
