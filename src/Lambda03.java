import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilece","havucDilimi", "guvec", "kokorec",
                "kusleme", "araBasi", "waffle", "kunefe", "guvec"));
        alfBykTkrsz(menu);
        System.out.println("\n **********");
        chrSayisiTersSiraliUnique(menu);
        System.out.println("\n **********");
        chrSayisiniBykSirali(menu);
        System.out.println("\n **********");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n **********");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n **********");
        xIleBitenElKontrol(menu);
        System.out.println("\n **********");
        chrSayisiEnBykElPrint(menu);
        System.out.println("\n **********");
        ilkElHrcSonHrfSiraliPrint(menu);


    }

    // Task 1 : List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz.

    public static void alfBykTkrsz(List<String> yemek){

        yemek.
                stream().// akis basladi
                map(String::toUpperCase).// buyuk harf
                sorted().// dogal siralama
                distinct().// elemanlari tekrarsiz olmasi
                forEach(t -> System.out.print(t + " ")); // print
    }
    // Task 2 : List elemanlarinin chracter sayisini ters olarak tekrarsiz print ediniz.

    public static void chrSayisiTersSiraliUnique(List<String> ikram){
        ikram.
                stream().// akis basladi
                map(String::length).// akisi guncelledim, kelimelerin uzunlugu olarak
                sorted(Comparator.reverseOrder()). // dogal siralama int oldugu icin sayiya gore
                distinct(). // tekrarsiz
                forEach(Lambda01::yazdir); // Print
    }

    // Task 3 : List elemanlarini character sayisina gore kckten byge gore print edin.

    public static void chrSayisiniBykSirali(List<String> ikram){
        ikram.
                stream().// akis saglandi
                sorted(Comparator.comparing(String::length)).// String ifadeleri karakter
                // sayilarina gore siraladim
                forEach(Lambda01::yazdir);//print
    }
    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den
    // az olma durumunu kontrol ediniz.

    public  static void harfSayisi7denAzKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <=7) ? "List elemanlari 7 ve daha az harften olusuyor" :
                "List elemanlari 7 harften buyuk");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile
    // baslamasını noneMatch() ile kontrol ediniz.

    public static void wIleBaslayanElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek mi olur" :
                " w ile yemek icat ettik");
    }

    // Task-6 : List elelmanlarinin "x" ile
    // biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                anyMatch(t-> t.endsWith("x")) ? "masallah" :
                "x ile yemek ismi biter mi yaaa");
    }

    // Task 7 : Karakter sayisi en buyuk elemani yazdirin.

    public static void chrSayisiEnBykElPrint(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream().// akis saglandi
                sorted(Comparator.comparing(t-> t.toString().length()).
                        reversed()).// karakter sayisina gore tersten siralandi
                limit(1);// limit kullanilarak sadece ilk eleman cagrildi
                // limit method unun donen degeri Stream<String> yapidadir
        System.out.println(Arrays.toString(sonIsim.toArray()));
        // sonIsim.toArray() --> Stream olan akis Array e cevirdi
        // Arrays.toString(sonIsim.toArray()) --> Array i String yapiya ceviriyor

    }

    // Task-8 : list elemanlarini son harfine göre siralayıp
    // ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHrcSonHrfSiraliPrint(List<String> ikram){
        ikram.
                stream().// akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).// son harfine gore alftik siralandi
                skip(1).// akistaki ilk eleman haric tututldu
                forEach(Lambda01::yazdir);// print edildi
    }
}
