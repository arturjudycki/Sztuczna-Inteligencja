package zestaw2;

import java.util.Arrays;
import java.util.Hashtable;

public class ex1 {
    public static void main(String[] args) {

        stanOdkurzacza stanPoczatkowy  = new stanOdkurzacza(new boolean[]{true, false}, new boolean[]{true,true});
        BFS(stanPoczatkowy);
        System.out.println();
        stanOdkurzacza stanPoczatkowy2  = new stanOdkurzacza(new boolean[]{false, true}, new boolean[]{true,true});
        BFS(stanPoczatkowy2);

    }

    public static void BFS(stanOdkurzacza stan){
        Hashtable<Węzeł, Integer> FIFO = new Hashtable<>();
        int counter = 0;
        String akcja;

        stanOdkurzacza stanCelu  = new stanOdkurzacza(new boolean[]{false, true}, new boolean[]{false,false});
        stanOdkurzacza stanCelu2  = new stanOdkurzacza(new boolean[]{true, false}, new boolean[]{false,false});

        Węzeł node = new Węzeł(stan,"");
        while(!(node.getStan().equals(stanCelu)||node.getStan().equals(stanCelu2))){
            akcja = Action(node.getStan());
            node.setAkcja(akcja);
            FIFO.put(node, ++counter);
            wypisz(FIFO);
            stanOdkurzacza wynik = Result(node.getStan(), akcja);
            node.setStan(wynik);
        }
        node.setAkcja("Koniec - osiągnięto cel");
//        counter++;
        FIFO.put(node, ++counter);
        wypisz(FIFO);
    }

    public static String Action(stanOdkurzacza stan){

        if(stan.getLokalizacja()[0]){
            if(stan.getCzy_brudne()[0]){
                return "ssij";
            }
            else{
                return "ruszaj w prawo";
            }
        }
        else{
            if(stan.getCzy_brudne()[1]){
                return "ssij";
            }
            else{
                return "ruszaj w lewo";
            }
        }
    }

    public static stanOdkurzacza Result(stanOdkurzacza stan, String action){

        if(stan.getLokalizacja()[0]){
            if(action.equals("ruszaj w prawo")){
                return new stanOdkurzacza(new boolean[]{false, true}, new boolean[]{false,true});
            }
            else{
                if(stan.getCzy_brudne()[1]){
                    return new stanOdkurzacza(new boolean[]{true, false}, new boolean[]{false,true});
                }
                else{
                    return new stanOdkurzacza(new boolean[]{true, false}, new boolean[]{false,false});
                }
            }
        }
        else{
            if(action.equals("ruszaj w lewo")){
                return new stanOdkurzacza(new boolean[]{true, false}, new boolean[]{true,false});
            }
            else{
                if(stan.getCzy_brudne()[0]){
                    return new stanOdkurzacza(new boolean[]{false, true}, new boolean[]{true,false});
                }
                else{
                    return new stanOdkurzacza(new boolean[]{false, true}, new boolean[]{false,false});
                }
            }
        }
    }

    public static void wypisz(Hashtable<Węzeł, Integer> FIFO) {
        FIFO.forEach(
                (k,v)->{
                    System.out.println("A = ["+k.getStan().getLokalizacja()[0]+","+k.getStan().getLokalizacja()[1]+"] B = ["+k.getStan().getCzy_brudne()[0]+","+k.getStan().getCzy_brudne()[1]+"] "+"Akcja: "+k.getAkcja());
                }
        );
    }
}

class stanOdkurzacza{
    private boolean[] lokalizacja;
    private boolean[] czy_brudne;

    public stanOdkurzacza(boolean[] lokalizacja, boolean[] czy_brudne){
        this.lokalizacja = lokalizacja;
        this.czy_brudne = czy_brudne;
    }

    public boolean[] getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(boolean[] lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public boolean[] getCzy_brudne() {
        return czy_brudne;
    }

    public void setCzy_brudne(boolean[] czy_brudne) {
        this.czy_brudne = czy_brudne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stanOdkurzacza that = (stanOdkurzacza) o;
        return Arrays.equals(lokalizacja, that.lokalizacja) &&
                Arrays.equals(czy_brudne, that.czy_brudne);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(lokalizacja);
        result = 31 * result + Arrays.hashCode(czy_brudne);
        return result;
    }
}

class Węzeł{
    private stanOdkurzacza stan;
    private String akcja;

    public Węzeł(stanOdkurzacza stan, String akcja){
        this.stan = stan;
        this.akcja = akcja;
    }

    public stanOdkurzacza getStan() {
        return stan;
    }

    public void setStan(stanOdkurzacza stan) {
        this.stan = stan;
    }

    public String getAkcja() {
        return akcja;
    }

    public void setAkcja(String akcja) {
        this.akcja = akcja;
    }
}
