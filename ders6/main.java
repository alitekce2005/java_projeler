public class main {

    static public abstract class Odeme{
        public double miktar;
        public Odeme(double miktar){
            this.miktar = miktar;
        }
        public abstract void odeme_yap();

        public void odemeBilgisi(){
            System.out.println("Ödenecek miktar: " + miktar + " TL");
        }   

    }

    static class KrediKartiOdeme extends Odeme{
        private String kartNumarasi;
        public KrediKartiOdeme(double miktar, String kartNumarasi){
            super(miktar);
            this.kartNumarasi = kartNumarasi;
        }

        @Override
        public void odeme_yap() {
            System.out.println("Kredi kartı(" + kartNumarasi +") ile " + miktar + " TL ödendi.");
        }
    }

    static class NakitOdeme extends Odeme{
        public NakitOdeme(double miktar){
            super(miktar);
        }

        @Override
        public void odeme_yap() {
            System.out.println("Nakit olarak " + miktar + " TL ödendi.");
        }
    }


    public static void main(String[] args) {
        System.out.println("<><><><><> Ödeme Sistemi <><><><><>");
        System.out.println("-----------------------------------");
        Odeme odeme1 = new KrediKartiOdeme(250.75, "1234-5678-9012-3456");
        odeme1.odemeBilgisi();
        odeme1.odeme_yap();
        System.out.println("-----------------------------------");
        Odeme odeme2 = new NakitOdeme(100.00);
        odeme2.odemeBilgisi();
        odeme2.odeme_yap();
        System.out.println("-----------------------------------");


        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⢀⠀⠀⡀⠀⠀⠂⠀⢀⠀⠂⣀⠐⢀⠂⡐⢀⠒⡈\r\n" + //
                        "⡁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠁⠀⠀⡀⠀⠀⠈⠒⢲⣤⣤⣀⡀⠀⠀⠀⠂⠁⠀⠄⠀⠐⠀⠀⡁⢀⠐⠠⠀⠂⠀⠠⠂⢁⠠⠂⠄⡁\r\n" + //
                        "⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⡀⠀⠈⠀⠀⠀⠀⡀⠀⢀⠂⠀⠀⣼⣿⣿⣿⣷⠀⢀⠁⠈⠀⡀⠀⠌⠀⢀⠀⠀⠄⠈⡀⠀⡁⠈⠠⢈⠀⠂⡉⠄⡀\r\n" + //
                        "⠂⠀⠀⠀⠀⠀⠀⠀⠂⠀⠀⠀⠀⡀⠀⠐⠀⠀⠀⠐⠀⠂⠀⠂⠀⠀⠀⠄⠀⠰⣿⣿⣿⣽⣾⡆⠀⠀⠂⠀⠀⠂⠀⠐⠀⠐⠀⠂⢀⠀⢂⠀⠐⠠⠀⢀⠡⠀⢂⠐\r\n" + //
                        "⡁⠂⠀⠀⠀⠀⠀⠁⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠄⠈⠀⠀⡁⠀⠄⠀⣸⣿⣿⣿⣿⣿⣇⠀⠈⠀⠁⠀⠌⠀⠠⠀⠠⠁⠠⠀⠀⠄⠀⠡⢀⠈⠠⠀⠡⢈⠀\r\n" + //
                        "⠄⠂⠀⢀⠀⠀⡀⠀⠂⠀⠀⠀⠀⠐⠀⠀⠐⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡿⣷⣿⣿⣿⠀⠀⠀⠐⠈⠀⡀⠄⠐⠀⠀⠂⠁⠈⡀⠂⡀⠀⢈⠀⠌⠠⠐⡀\r\n" + //
                        "⠂⠄⠀⠀⠀⠄⠀⠀⢀⣀⣤⣤⣤⣤⣄⣂⣀⣀⠀⢄⣀⣂⣤⣤⣥⣤⣤⣀⣾⣿⣿⣿⡿⣽⡷⢯⡇⠀⠀⠐⠀⠀⠀⠀⢄⠀⠠⠀⠀⢂⠀⠄⠀⠈⠄⠐⠠⠁⠂⠄\r\n" + //
                        "⡁⠀⠀⡀⠠⠀⠂⠀⠀⠈⠛⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣭⣿⢿⣯⣿⣝⣾⣻⡽⣿⣟⣷⠀⠀⢈⣠⣴⣿⣿⣿⣿⠷⠂⠐⡀⠀⠠⠈⢀⠈⡀⠁⠌⠐⡀\r\n" + //
                        "⡄⠁⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣾⣽⣛⡽⣿⣿⣾⣽⣴⣾⣿⣿⣿⣿⣿⡿⠉⠀⠀⠠⠀⠂⡀⠁⠀⡀⠀⠂⠐⠠⠀\r\n" + //
                        "⠄⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⡿⣻⠇⠀⠀⢁⠠⠐⠀⠀⠁⠀⠀⠁⠄⠡⠀⠀\r\n" + //
                        "⠂⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣦⡄⠀⢂⠀⠂⡀⠄⠁⢈⠐⠈⡀⠂⢁⠂\r\n" + //
                        "⡁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣯⣿⣥⣤⣀⣀⠀⠀⠀⠂⠀⠠⠐⠀⡐⠠⠀\r\n" + //
                        "⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⡀⠀⠹⣿⣷⣿⣾⢿⣿⣿⡟⠻⣿⣿⣿⣿⣿⠟⠉⠀⠐⠄⠀⠄⠀⠈⠀⡀⠁⡀⠡⠁\r\n" + //
                        "⠂⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣷⣿⡿⣿⣿⣷⠀⠈⢻⣿⣿⣽⣆⠀⠂⢀⠁⠀⠠⠐⠈⠀⠀⠠⠀⠁⠄\r\n" + //
                        "⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⢀⠀⡀⠄⠁⠠⠀⠛⣿⣿⣿⣿⣿⣿⠀⠀⠄⠙⣿⣿⣿⣆⠠⠀⠈⠀⠁⠠⠀⠁⠌⡀⠡⠈⠂\r\n" + //
                        "⠄⠁⠀⠀⠀⠀⡐⠀⠂⠀⠀⠀⠂⠀⠀⠂⠀⠀⠀⠀⠀⠀⠂⠀⠐⠀⠀⠀⢀⠂⠐⠀⠀⢽⣿⣿⣻⣿⣿⡄⡀⠄⡁⠈⠻⣿⣿⣇⢀⠈⡀⠂⠠⢁⠈⡐⠀⣁⢂⠁\r\n" + //
                        "⠂⡁⠀⠐⠀⠐⠀⠀⠠⠀⠄⠀⠀⠀⠂⠀⠀⠀⠄⠐⠀⠐⠀⠠⠐⠀⠀⠁⠀⠠⠀⠂⠐⠀⠻⣿⣿⣿⣿⡇⠀⠀⠄⠐⡀⠉⠉⠃⠀⠄⡀⠌⠀⠄⡐⠄⠡⢀⠢⢈\r\n" + //
                        "⠅⡀⠀⠈⡀⠀⠄⠈⠀⢀⠀⡀⠈⢀⠀⠠⠈⠀⠠⠐⠀⢁⠈⠀⢀⠠⠀⠂⠠⢀⠁⠄⡀⠂⣀⡹⣿⣿⣿⢿⠀⠀⡐⠀⢀⠡⠁⡈⠠⠐⠀⠄⡉⡐⠠⢈⡐⠄⣁⠆\r\n" + //
                        "⡂⠄⠂⢀⠀⠀⠂⠀⠈⠀⠀⠀⠄⡀⠈⠀⡀⠁⠂⠐⠀⠀⢀⠂⢀⠀⠄⠂⠁⠀⡀⠀⠀⠀⠄⠉⠉⠙⠛⠛⠀⠠⠐⠈⠀⡀⠄⢀⠐⢈⠀⠒⠐⡀⢁⠂⠔⡐⢠⠊\r\n" + //
                        "⡐⡀⠄⠀⠌⠀⠁⠐⠈⠀⠄⠠⠀⠀⠠⠁⠀⠂⠈⠄⠀⠌⠀⠄⠀⠀⠄⠂⠀⠁⠀⠁⠌⠁⠠⠀⠀⠂⢀⠐⠀⠠⠐⠈⠠⠐⠈⠠⢀⠂⠈⡄⠡⠐⡈⡐⠌⡠⠡⢌");

    }

}
