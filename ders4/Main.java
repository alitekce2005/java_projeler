package ders4;

public class Main {

    static class Cihaz{
        String marka;
        String model;
        public Cihaz(String marka, String model){
            this.marka = marka;
            this.model = model;
        }
        void ac(){
            System.out.println("Cihaz aciliyor");
        }
        void cihazBilgisiGoster() {
            System.out.println("markasi " + marka + " model " + model);
        }
    }

    static class AkilliTelefon extends Cihaz {
        String ekranBoyutu;

        AkilliTelefon(String marka, String model, String ekranBoyutu) {
            // super() must be the first statement in constructor
            super(marka, model);
            this.ekranBoyutu = ekranBoyutu;
        }

        void ac(){
            System.out.println(marka + " " + model + "Telefonum aciliyor.");
        }

        @Override
        void cihazBilgisiGoster() {
            System.out.println("markasi " + marka + " model " + model + "Ekran Boyutu: " + ekranBoyutu);
        }
    }

    static class DizustuBilgisayar extends Cihaz{
        public DizustuBilgisayar(String marka, String model){
            super(marka, model);
        }

        void ac(){
            System.out.println(marka + " " + model + "Disustu bilgisayar aciliyor.");
        }
    }

    public static void main(String[] args) {
        Cihaz[] myCihaz = {new AkilliTelefon("Embesil", "A 34", "1920x1080")
                ,new DizustuBilgisayar("Pitbull", "Karabacak")};

        for (Cihaz cihaz:myCihaz) {
            System.out.println("-------");
            cihaz.cihazBilgisiGoster();
            cihaz.ac();
        }
    }
};;
