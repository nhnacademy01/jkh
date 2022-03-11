package day4;
class Computer{
    DvdDrive dvdDrive =new DvdDrive();
    void play(Cd cd){
        System.out.println("cd");
    }
    void play(Dvd dvd){
        System.out.println("dvd");
    }
}
class DvdDrive extends CdDrive{

    void play(Dvd dvd){
        return;
    }
}
class Dvd{
    String i;
    Dvd(){
        i = "ddd";
    }
}class CdDrive {
    void play(Cd cd){
        return;
    }
}
class Cd{
    String i;
    public Cd(){
        i = "d1d2d";
    }
}
public class Ex04 {
    public static void main(String[] args) {
        Computer c = new Computer();
        Cd cd = new Cd();
        Dvd dvd = new Dvd();
        c.play(cd);
        c.play(dvd);
    }
}
