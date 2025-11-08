package ders5;

import ders5.Main3.Karakter.Oyuncu;
import ders5.Main3.Karakter.Zombi;

public class Main3 {

    static class Karakter {
        protected String isim;
        protected int can;
        protected int guc;

        public Karakter(String isim, int can, int guc) {
            this.isim = isim;
            this.can = can;
            this.guc = guc;
            System.out.println("Karakter oluşturuldu: ");
        }

        public void BilgileriGoster() {
            System.out.println("İsim: " + isim);
            System.out.println("Can: " + can);
            System.out.println("Güç: " + guc);
        }

        interface SaldırıYenetegi {
            void saldir();
        }

        interface CanDegistirilebilir {
            void canAzalt(int miktar);

            void canArttir(int miktar);
        }

        static class Oyuncu extends Karakter implements SaldırıYenetegi, CanDegistirilebilir {
            private int seviye;

            public Oyuncu(String isim, int can, int guc, int seviye) {
                super(isim, can, guc);
                this.seviye = seviye;
                System.out.println("Oyuncu oluşturuldu: ");
            }

            @Override
            public void saldir() {
                System.out.println(isim + " saldırıyor!" + "Seviye: " + seviye + ", Güç: " + guc);
            }

            @Override
            public void canAzalt(int miktar) {
                can -= miktar;
                if (can < 0)
                    can = 0;
                System.out.println(isim + " canı " + miktar + " azaldı. Kalan can: " + can);
            }

            @Override
            public void canArttir(int miktar) {
                can += miktar;
                System.out.println(isim + " canı " + miktar + " arttı. Toplam can: " + can);
            }

            public void seviyeAtla() {
                seviye++;
                guc += 10;
                System.out.println(isim + " seviye atladı! Yeni seviye: " + seviye + ", Yeni güç: " + guc);
            }
        }

        static class Zombi extends Karakter implements SaldırıYenetegi {
            private String tur;

            public Zombi(String isim, int can, int guc, String tur) {
                super(isim, can, guc);
                this.tur = tur;
                System.out.println("Zombi oluşturuldu: ");
            }

            @Override
            public void saldir() {
                System.out.println(isim + " (" + tur + ") saldırıyor! AAAAAAAAAAA!");
            }

            public void turBilgisiGoster() {
                System.out.println(isim + "Zombi Türü: " + tur);
            }
        }

    }

    public static void main(String[] args) {
        Oyuncu oyuncu1 = new Oyuncu("Lord Kamil ab", 100, 50, 1);
        Zombi zombi1 = new Zombi("Çığırtkan", 80, 40, "Yavaş Zombi");

        System.out.println();
        oyuncu1.BilgileriGoster();
        oyuncu1.saldir();
        oyuncu1.canAzalt(30);
        oyuncu1.canArttir(20);
        oyuncu1.seviyeAtla();
        System.out.println();

        zombi1.BilgileriGoster();
        zombi1.saldir();
        zombi1.turBilgisiGoster();
        System.out.println();

        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢦⣝⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢳⣝⢷⣝⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⢸⣿⣷⣝⢷⣌⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣷⣝⢷⣌⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⡿⣿⣿⣿⣿⣷⡹⣧⡘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢡⢻⣿⣿⣿⣿⣷⢹⣿⡌⣿⣿⠿⣫⣽⣯⣭⣭⣭⣭⣛⡻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠈⡔⣬⠟⢉⣶⠶⠒⣒⡡⠈⠱⡊⢍⣠⣴⣿⣿⡿⠟⣉⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠠⡳⣡⠔⡉⣴⡾⠿⢛⣛⣤⣤⣥⣭⣭⣭⣛⣀⡠⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢟⣛⣩⣽⣭⣉⡁⢠⠁⠚⣨⣵⣶⣿⠿⢟⣛⣭⣷⣾⡿⢟⣻⣯⣭⣷⣌⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⡩⣵⣾⣿⣯⣤⣤⣄⠠⡀⠠⣾⢾⣿⠟⣫⣴⣾⣿⣿⡿⢛⣥⣾⣿⣿⣿⣿⣿⣿⣿⣧⣔⠢⡙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠡⣠⣶⣶⣶⣦⣍⠉⠁⣊⣴⡇⡟⢨⣴⣿⣿⣿⣿⠟⢁⣼⣿⣿⠟⣫⣾⣿⣿⣿⣿⣿⣿⣿⢳⡙⣦⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⡿⢿⣿⣿⣿⣿⠟⢋⣴⢞⣿⣿⡿⢛⣫⠍⢀⡐⣪⣿⠟⠁⣰⣿⣿⣫⣾⠟⡡⣠⡿⣡⠟⢁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣷⢸⣷⡀⠹⢿⡿⠛⢩⣤⣶⣶⣶⡶⣶⣤⣭\r\n" + //
                "⣿⣿⣿⡇⢱⡙⠟⡋⢁⣤⣿⡇⡾⣛⡵⠞⣋⣵⣾⡿⡱⢛⢕⢕⣴⣿⢋⣿⡿⣫⠞⣼⡿⠰⠃⢢⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⡏⣿⣧⢣⡠⣴⣾⠝⣫⣵⣶⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣧⡐⠭⠵⣴⣿⣿⠿⠘⣪⠥⣒⣿⡿⢟⣉⡤⣪⡴⢣⣾⡿⣱⣿⢟⣴⠏⣼⡿⡠⡡⣱⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⡸⣷⠙⣵⣾⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⡿⠿⠛⣀⣘⡫⢵⣖⣑⢍⣴⣿⢛⣥⣾⣿⣿⣿⣟⣠⣭⣭⡰⡿⢣⢞⡅⢠⣿⢇⠇⣱⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⡿⣹⣿⢻⣿⣿⡇⣿⡦⢻⣿⣿⣿⣿⣿⠿⣻⡿⠛\r\n" + //
                "⡛⠅⣴⣿⣿⣿⣷⣿⣿⣿⡿⣸⣿⣥⣿⣿⣿⣿⣿⣿⣿⣿⠟⠫⡤⠅⣁⡛⠰⢼⣿⣸⢣⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢏⣾⣿⢇⢹⡿⢸⣿⣿⣧⣿⣧⠊⣛⣻⣭⣭⡶⠛⣡⣴⣿\r\n" + //
                "⠀⠀⢻⣿⣿⣿⣿⣿⢟⣵⢾⣿⣿⣿⣿⣿⣿⡿⢟⢫⣭⢢⡇⣖⢄⣾⣿⢃⣷⢦⡻⢹⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⣸⣿⡍⡜⣼⠃⣾⢹⣿⣿⣿⣿⣠⢛⣛⣉⣡⣶⣿⣿⣿⣿\r\n" + //
                "⠀⠀⠀⠙⠿⣿⣿⣿⣮⣟⣻⠿⣿⣿⠿⡋⢡⣾⢏⢸⢃⣿⡧⢏⣾⣿⣿⢀⣏⢼⡇⣿⣿⣿⣿⣿⣿⣿⣿⡟⡿⠣⣱⣿⡟⠄⡇⡏⢰⡏⣾⣿⣿⣿⣿⣿⢠⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⠠⠀⣂⠀⡀⢶⡔⡂⢠⡍⢩⣵⣶⡆⣕⠇⣼⠏⡾⡜⡸⠿⠧⠰⠶⣭⣝⢸⢻⠘⣧⢻⣿⣿⣿⡿⢋⣼⢋⡞⢑⣼⣿⠟⢈⡆⣗⡌⡾⢸⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣷⣌⠻⢧⣜⠁⡄⢸⣿⡇⣿⡀⡏⢰⠟⠀⣀⢤⠔⠂⠀⠀⠙⢸⡌⣦⢹⢸⣿⡿⠛⠁⠊⡡⡪⢂⣶⣤⠍⠀⠺⢸⡟⡼⠁⣾⣿⣿⣿⣿⣿⡟⠀⣙⡛⢿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣶⣶⡆⢀⢸⣿⣿⢸⣇⠃⣦⡀⢢⡾⢁⡈⠉⢠⣤⠀⢆⠃⠏⣦⠃⠏⢀⢑⠵⢛⡨⣢⣾⡿⢃⣵⣿⡆⣌⠱⠁⣼⣿⢡⣿⣿⣿⣿⠉⣆⢿⣿⣦⠘⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⡿⠰⢸⡜⣿⣿⡜⣿⡄⣿⢗⡘⠇⢛⣇⡀⣤⢁⣧⣾⣆⣬⣤⠖⢔⣫⣴⡿⢋⡴⢟⣫⣴⣿⣿⡟⣸⠕⠄⢰⡿⠁⣾⢻⣿⣿⣿⢠⣿⡎⣿⣿⣷⢹⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⡿⠡⡁⣿⣷⢌⢟⢿⡘⢷⡘⣾⣿⣷⣮⣝⣑⣩⣾⣿⣿⣿⣿⣷⣾⣿⣿⣥⣼⣶⣾⣿⣿⣿⣿⡿⠑⣣⠎⣰⠇⡕⡸⢡⣿⣿⣿⡿⡀⡙⠇⣿⣿⣿⣸⣿⣿⣿\r\n" + //
                "⠿⠿⣿⣿⣿⣿⣿⢁⢠⢡⣿⡇⣦⠈⢡⡌⢂⠹⠮⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⣿⣿⣿⣿⣿⣷⡿⠋⢖⡉⡼⡱⢡⣿⣿⣿⣿⢇⣿⢸⣎⣿⣿⣿⡇⣿⣿⣿\r\n" + //
                "⣿⣿⣦⣍⠙⠿⢃⢢⡿⢸⣿⢸⣿⡇⢿⡇⣾⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣛⠙⠻⣮⣝⡻⣿⣿⣿⣶⣿⡟⣸⡑⣠⣿⣿⣿⣿⡿⣸⣿⡟⣿⣿⣿⣿⠃⢿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣷⣦⣤⣚⠿⢸⣇⣾⣿⣿⡜⣀⢹⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠉⠛⠶⠿⣿⣿⡿⡱⢋⣴⣿⣿⣿⣿⡟⢠⣿⣿⣧⣿⣿⣿⣿⢰⢸⣿⣿\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣧⣾⣿⣿⣿⣿⣧⠋⡌⣸⣿⣿⣿⣿⢏⣿⣭⡝⣛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣄⢤⢠⠘⠑⣡⣿⣿⣿⣿⣿⠟⠀⢸⡿⣿⢳⣿⣿⡟⡏⡘⢦⣝⡟\r\n" + //
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢠⣿⣄⢻⣿⣿⣿⢸⣿⣯⣝⡲⢭⡢⣝⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢛⣡⣴⣿⣿⣿⣿⣿⣿⢋⠂⣤⠀⡇⡟⣼⣿⡿⡑⢣⣬⣥⣬⣾\r\n" + //
                "⣿⣿⣿⣿⣿⣿⢿⣿⠏⢹⣿⣿⣿⣿⠃⣼⣿⣿⣮⠻⣿⣿⣎⢿⣿⣿⣿⣷⣌⠊⣼⣿⣿⣿⣿⣿⣯⣝⠖⢲⢚⠻⣛⣿⣿⣿⣿⡿⢛⠕⢁⣾⡟⠀⡘⣰⣿⠟⡕⢍⣾⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣶⡙⠿⡋⣾⢃⣾⢸⣿⣿⣿⣿⠀⠈⠿⢿⣿⢡⡙⢿⣿⣾⣿⣿⣿⣯⣵⣾⣿⣿⣿⣿⣿⣿⣿⠛⠥⠶⣶⣿⣿⣿⠿⠛⣉⠔⣋⠀⠘⠛⣡⠀⠞⣋⣵⢊⢌⣼⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⣿⣿⡞⡼⢃⣾⣿⢸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠹⣿⣮⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢟⡋⣡⣾⡿⢗⣠⣶⣶⣶⣥⢆⣴⡟⠌⣠⣌⡙⠛⠟⠛⠉⠀⢠⣾⣿⣿⣿⣿⣿⣿\r\n" + //
                "⢿⣿⣿⣿⣷⢢⣾⣿⠏⣾⣿⣿⣿⠀⠀⢀⣠⣴⡄⠀⠈⠻⠿⢶⣶⣶⣶⡶⠖⠐⠶⣾⣿⣿⡟⠀⣀⣵⣾⣿⣿⣿⣿⡿⣡⣾⣿⠣⢠⣿⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣷⡙⢿⣿⣿⡸⢟⢕⢡⣿⣿⣿⠏⢠⣴⣿⣿⣿⣿⣄⡀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠘⣿⡿⠀⣽⣿⣿⣿⣿⣿⣿⢏⣴⣿⣿⣿⠃⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⢟⣥⢸⢻⢟⠕⠕⣡⣾⣿⣿⡟⡰⣊⠻⣿⡿⠋⠉⠭⡰⣿⣷⣶⣾⣿⡶⠋⠀⠀⠀⠀⠈⠁⣼⣿⣿⣿⣿⣿⡟⣡⣿⣿⡟⣿⡏⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + //
                "⣿⣿⠀⣁⣭⣶⣿⣿⣿⣿⡟⣁⣾⣿⣿⣶⣅⠧⠤⠜⣡⣿⣿⣿⣿⠏⢀⣀⣀⣀⣀⡀⠀⣸⣿⣿⣿⣿⡿⢋⣾⣿⣿⣿⣼⣿⠃⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
    }

}
