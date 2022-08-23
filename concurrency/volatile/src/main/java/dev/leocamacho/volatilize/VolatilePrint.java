package dev.leocamacho.volatilize;


//Based on example of https://www.baeldung.com/java-volatile
public class VolatilePrint {

    public static /*volatile*/ int number;
    public static boolean ready;

    public static class Reader extends Thread {

        private Output output;

        public Reader(Output output) {
            this.output = output;
        }

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            output.print(number);
        }
    }

    public static class Output {
        public void print(int number) {
            System.out.println(number);
        }

    }
}