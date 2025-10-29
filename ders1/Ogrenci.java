public class Ogrenci {
    public static void main(String[] args) {
        System.out.println("This is Ogrenci class.");

        // Dizi tanımlama ve değer atama
        int[] dizi = { 1, 2, 3, 4, 5 };
        int[] dizi2 = new int[5];

        dizi[0] = 10;
        dizi[1] = 20;

        // Dizi2 elemanlarını yazdırma
        for (int sayac = 0; sayac < 5; sayac++) {
            System.out.println(dizi2[sayac]);
        }

        // Char dizisi tanımlama
        // Char dizisi String dizisi gibi tanımlanamaz
        char[] kelime = { 'a', 'b', 'c', 'd', 'e' };
        char[] kelime2 = new char[5];

        System.out.println(kelime[0]);
        System.out.println(kelime[1]);

        kelime2[0] = 'f';
        kelime2[1] = 'g';

        // Kelime2 elemanlarını yazdırmak isterseniz
        for (int i = 0; i < kelime2.length; i++) {
            System.out.println(kelime2[i]);
        }
        
    }
    // Sınıf değişkenleri
    boolean a = true;
    byte b = 1;
    short c = 2;
    int d = 3;
    long e = 4;
    float f = 5.0f;
    double g = 6.0;
    char h = '7';
    String i = "8";
    Integer j = 9;
    Double k = 10.0;
    final int l = 11;
    static int m = 12;
    int n = 13;
}
