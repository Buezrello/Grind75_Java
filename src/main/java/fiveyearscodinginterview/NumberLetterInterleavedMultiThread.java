package fiveyearscodinginterview;

public class NumberLetterInterleavedMultiThread {

    private static final Object lock = new Object();
    private static volatile boolean letterPrint = true;

    private static void printLetters() {
        for (char lt = 'a'; lt <= 'j'; lt++) {
            synchronized (lock) {
                while (!letterPrint) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(lt);
                letterPrint = false;
                lock.notifyAll();
            }
        }

    }

    private static void printNumbers() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                while (letterPrint) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i + " ");
                letterPrint = true;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread lettersThread = new Thread(NumberLetterInterleavedMultiThread::printLetters);
        Thread numberssThread = new Thread(NumberLetterInterleavedMultiThread::printNumbers);
        lettersThread.start();
        numberssThread.start();
    }
}
