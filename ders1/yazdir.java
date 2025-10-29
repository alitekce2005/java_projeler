public class yazdir {

    String ad = "Ahmet";
    String soyad = "Yılmaz";
    int yas = 30;
    int numara = 12345;

    void degistir() {
        ad = "Mehmet";
        soyad = "Kara";
        yas = 18;
        numara = 54321;
    }

    public static void main(String[] args) {
        yazdir nesne = new yazdir();
        System.out.println("Ad: " + nesne.ad);
        System.out.println("Soyad: " + nesne.soyad);
        System.out.println("Yaş: " + nesne.yas);
        System.out.println("Numara: " + nesne.numara);
        nesne.degistir();
        System.out.println("Ad: " + nesne.ad);
        System.out.println("Soyad: " + nesne.soyad);
        System.out.println("Yaş: " + nesne.yas);
        System.out.println("Numara: " + nesne.numara);
    }
}
