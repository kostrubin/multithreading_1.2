public class Main {
    public static void main(String[] args) {
        final int SLEEP_TIME = 15000;

        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        final Thread thread1 = new Thread(mainGroup, new MyThread());
        final Thread thread2 = new Thread(mainGroup, new MyThread());
        final Thread thread3 = new Thread(mainGroup, new MyThread());
        final Thread thread4 = new Thread(mainGroup, new MyThread());

        thread1.setName("поток 1");
        thread2.setName("поток 2");
        thread3.setName("поток 3");
        thread4.setName("поток 4");

        System.out.println("Создаю потоки...");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.getStackTrace();
        } finally {
            System.out.println("Завершаю все потоки.");
            mainGroup.interrupt();
        }
    }
}
