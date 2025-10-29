import java.util.List;
import java.util.ArrayList;

public class BankaUygulamasi {

  public static void main(String[] args) {
    Banka hesap1 = new Banka("Ahmet Yılmaz", "123456789");
    hesap1.Goster();
    System.out.println();
    hesap1.paraYatir(800);
    hesap1.paraCek(500);
    hesap1.paraCek(600);
    hesap1.paraYatir(-200);
    System.out.println();
    hesap1.hareketleriGoster();

  }

  public static class Banka {
    String hesapad;
    String hesapno;
    double bakiye;
    List<String> hareketler;

    public Banka(String hesapad, String hesapno) {
      this.hesapad = hesapad;
      this.hesapno = hesapno;
      this.bakiye = 0;
      this.hareketler = new ArrayList<>();
    }

    public void paraYatir(double miktar) {
      if (miktar > 0) {
        bakiye += miktar;
        hareketler.add("+" + miktar);
        System.out.println(miktar + " TL yatırıldı.");
      } else {
        System.out.println("Yatırılacak miktar pozitif olmalıdır.");
      }
    }

    public void paraCek(double miktar) {
      if (miktar > 0 && miktar <= bakiye) {
        bakiye -= miktar;
        hareketler.add("-" + miktar);
        System.out.println(miktar + " TL çekildi.");
        System.out.println("Kalan bakiye: " + bakiye + " TL");
      } else if (miktar > bakiye) {
        System.out.println("Yetersiz bakiye.");
      } else {
        System.out.println("Çekilecek miktar pozitif olmalıdır.");
      }

    }

    public void Goster() {
      System.out.println("Hesap Sahibi: " + hesapad);
      System.out.println("Hesap Numarası: " + hesapno);
      System.out.println("Bakiye: " + bakiye + " TL");
    }

    public void hareketleriGoster() {
      System.out.println("Hesap Hareketleri:");
      for (String hareket : hareketler) {
        System.out.println(hareket);
      }
    }
  }

}