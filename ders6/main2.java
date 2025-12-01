
import java.util.Base64;

import dersyedi.main2;

public class main2 {

    public static abstract class Sifreleyici {
        protected String anahtar;

        public Sifreleyici(String anahtar) {
            this.anahtar = anahtar;
        }

        public abstract String sifrele(String metin);

        public abstract String sifrecoz(String sifreliMetin);

        public void anahtarGöster() {
            System.out.println("Kullanılan anahtar: " + anahtar);
        }

        public final void logKaydi(String islem) {
            System.out.println("İşlem kaydı: " + islem + " | Anahtar: " + anahtar);
        }

        public static void BİLGİ() {
            System.out.println("Bu sınıf şifreleme işlemleri için kullanılır.");
        }
    }

    class BasitBase64Sifreleyici extends Sifreleyici {

        public BasitBase64Sifreleyici(String anahtar) {
            super(anahtar);
        }

        @Override
        public String sifrele(String metin) {
            logKaydi("Metin şifreleniyor...");
            String birleşikMetin = metin + anahtar;
            return java.util.Base64.getEncoder().encodeToString(birleşikMetin.getBytes());
        }

        @Override
        public String sifrecoz(String sifreliMetin) {
            logKaydi("Metin şifresi çözülüyor...");
            byte[] cozulmus = java.util.Base64.getDecoder().decode(sifreliMetin);
            String sonuc = new String(cozulmus);
            return sonuc.replace(anahtar, "");
        }
    }

    public static void main(String[] args) {
        System.out.println("<><><><><> Şifreleme Sistemi <><><><><>");
        System.out.println("-----------------------------------");
        Sifreleyici.BİLGİ();
        Sifreleyici sifreleyici = new main2().new BasitBase64Sifreleyici("Gizli Anahtar 123");
        sifreleyici.anahtarGöster();
        String sifreli = sifreleyici.sifrele("Merhaba Dünya!");
        System.out.println("Şifreli Metin: " + sifreli);
        String cozulmus = sifreleyici.sifrecoz(sifreli);
        System.out.println("Çözülmüş Metin: " + cozulmus);
        System.out.println("-----------------------------------");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠛⠃⠉⢉⣉⣁⣁⣠⣤⣤⣤⣤⣠⣀⣈⣈⡀⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡻⠛⠛⢉⣀⣤⣤⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣀⠉⠛⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠃⢁⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣀⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⡿⠋⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⠈⠻⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⡟⠁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠹⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⢿⠋⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠘⢿⣿⣿⣿\r\n" + //
                "⣿⣿⠃⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠈⣿⣿⣿\r\n" + //
                "⣿⠇⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡋⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠸⣿⣿\r\n" + //
                "⡟⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿\r\n" + //
                "⡇⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿⡇⠘⠿⠋⢘⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿\r\n" + //
                "⠇⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⢿⣷⣦⠀⣰⣼⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿\r\n" + //
                "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠈⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⢻\r\n" + //
                "⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀\r\n" + //
                "⡄⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠰⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢛⣿⣿⣿⠀⣿⣿⣆⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\r\n" + //
                "⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⢺⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢋⡉⢴⣿⣿⣿⣋⣼⣿⣿⣿⣷⣦⡙⢿⣿⣿⣿⣿⣿⣿⣿⣿⠏⢀\r\n" + //
                "⡇⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣳⣄⢾⣿⣿⣿⣿⣯⣉⢉⣩⣤⣴⣶⣿⣿⣿⣷⣌⢻⣿⣿⣿⣿⠇⣾⠟⣫⣤⣶⣬⣙⡛⠻⠟⣿⡿⠁⣠⣾\r\n" + //
                "⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣌⡛⠿⠿⢿⡿⢡⠾⠛⣛⡋⠉⠉⠉⠙⢛⡛⠂⠹⣿⣿⣿⢀⣥⣾⣿⠿⠿⠿⣿⣿⣅⡌⣿⠁⢰⣿⣿\r\n" + //
                "⣿⡆⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠷⢒⣴⠰⣾⣿⣿⣧⡀⠀⠀⣀⣼⣿⠇⣰⣿⣿⣿⡈⢡⣶⣶⣶⠀⠀⠀⠀⢠⡆⠙⠀⢸⣿⣿\r\n" + //
                "⣿⣿⡀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢻⣿⣿⣿⣉⣴⣿⣿⣿⣧⣜⠻⣿⣿⣿⣿⣿⣿⠟⡋⢲⣿⣿⣿⣿⣿⣦⡙⢿⣿⣷⣤⣤⣴⠟⣴⣿⣆⠀⣿⣿\r\n" + //
                "⣿⣿⣷⡀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⠍⢠⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣬⣭⣥⡴⢞⣴⣿⣿⣿⣿⣿⣿⣿⣿⠈⢛⣛⣛⣭⣴⣾⣿⣿⣿⡀⠸⣿\r\n" + //
                "⣿⣿⣿⣿⣄⠈⢻⣻⣿⣿⣿⣿⣿⣿⣿⡏⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⢛⣡⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢀⣶⣦⣭⣭⣽⣿⣿⣿⣿⣷⠀⢻\r\n" + //
                "⣿⣿⣿⣿⣿⣷⡀⠘⠿⣿⣿⣿⣿⣿⣿⠇⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⢸\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣶⣄⠈⠻⢿⣿⣿⣿⣿⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢫⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⢠⣾\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡈⠙⠛⠛⠳⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢣⣼⣿⣿⣿⣿⣿⣿⣿⣿⣇⢨⡙⢿⣿⣿⣿⡿⠟⠃⣀⣴⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⠀⣶⣾⣶⡄⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⡀⣿⡛⠛⢿⣿⣿⣿⣿⣿⣿⡟⢸⢡⣿⣿⢿⠏⠀⣴⣾⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠸⣿⣿⣿⡇⢸⣷⣦⣤⣬⣍⣁⠀⣿⣿⣿⣿⡟⣠⣇⢻⣧⢹⣷⣌⠿⣿⣿⣿⣿⣿⠀⡈⣿⣿⠂⢠⣾⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⢠⣷⣿⣿⣿⠁⣽⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⡿⢠⣿⣿⣿⣿⣿⣿⣿⣷⣈⠻⠟⣋⣡⣾⣷⠸⡿⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⣾⣿⣿⣿⡟⠀⣾⣿⣿⣿⣿⣿⣿⠀⢿⣿⡿⢃⣿⣿⣿⣿⣿⣿⣿⡿⠿⠟⣛⡻⠿⣿⣿⣿⡀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⣾⣿⣿⣿⣿⣗⠀⣿⣿⣿⣿⣿⣿⣿⣤⣸⣿⠆⣼⣿⣿⣿⣿⡿⠟⣡⣶⣶⡖⡀⣶⣶⡉⢿⣿⣴⠇⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡟⠀⣼⣼⣿⣿⣿⣿⣷⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣠⣽⣿⣿⣿⠋⣱⣿⡿⠟⠁⣼⣿⠟⠀⠿⠈⣿⣿⡅⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠗⠀⣼⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⢶⣶⣶⣿⣷⣬⣴⣶⣿⡶⢀⣿⣿⠰⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⡟⠌⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣙⠻⢿⣿⣿⣿⡿⢋⣴⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⡇⠀⠚⠻⠿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣬⣭⣥⣶⣿⣿⣿⣿⣿⠠⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣷⣿⣷⣶⣤⣀⠙⠻⠿⣿⣿⣿⠀⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣬⣑⣛⣩⣴⣿⣿⣿⣿⣿⣚⠀⢹⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡈⠙⠻⠇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠉⠽⠽⠿⣿⣿⣿⣿⣿⣿⣦⠈⠻⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⡀⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣤⡈⠻⣿⣿⣿⣿⣷⡄⠘⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢻⣿⣿⣿⣿⣿⡀⢸⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣄⡈⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⣾⣿⣿⣿⣿⠿⠀⣸⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣈⠉⠙⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠋⠉⠉⠉⣁⣤⣾⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⢶⢦⣤⣄⣀⡉⠛⠛⠛⠋⢁⡀⣤⣾⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿");

    }
}
