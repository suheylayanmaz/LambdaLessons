import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
/*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bil muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi muh", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayiGoreByktenKcgeSirala(unv));
    }
    // task 1 : Universitelerin tamaminin notOrt' larinin 74'den buyuk olanlari kontrol eden bir method create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().//akis sagladik
                allMatch(t->t.getNotOrtalamasi()>74); //
        }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().//akis saglandi
                anyMatch(t->t.getBolum().// objelerin bolum isimleri geldi
                        toLowerCase().// bolum isimlerindeki karakterler kucuk harfe cevrildi
                        contains("matematik"));// matematik kelimesi var mi kontrol edildi
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiGoreByktenKcgeSirala(List<Universite> unv){
       return unv.
               stream().//akis saglandi
               sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
               // universiteler ogr sayisina gore tersten siralandi
               collect(Collectors.toList());
                //gelen universiteleri liste cevirdi

    }
}
