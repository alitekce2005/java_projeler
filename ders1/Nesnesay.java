public class Nesnesay {

    private static int kacN = 0;

    protected static int say() {
        return kacN;
    }

    Nesnesay() {
        Nesnesay.Nesneekle();
    }

    private static void Nesneekle() {
        kacN++;
    }

    public static void main(String[] args) {
        System.out.println(Nesnesay.say()+"dan başlayarak");
        for(int i=0;i<1000;i++){
            new Nesnesay();
        }
        System.out.println(Nesnesay.say()+" tane nesne oluşturuldu");
    }
}