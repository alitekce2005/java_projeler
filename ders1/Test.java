public class Test {

    int a;
    public int b;
    private int c;

    void setC(int i) {
        c = i;
    }

    int getC() {
        return c;
    }

    public static void main(String[] args) {
        Test kucuktest = new Test();
        kucuktest.setC(25);
        kucuktest.a = kucuktest.c;
        kucuktest.b = kucuktest.a * 2;
        System.out.println("a: " + kucuktest.a);
        System.out.println("b: " + kucuktest.b);
        System.out.println("c: " + kucuktest.getC());
    }
}