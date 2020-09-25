import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        final int SLEEP_TIME = 3000;
        final int TOTAL_NUMBER = 5;

        try {
            for (int i = 0; i < TOTAL_NUMBER; i++) {
                Thread.sleep(SLEEP_TIME);
                System.out.printf("My name is %s. Hi everybody!\n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {

        }

        return String.format("%s has sent %d messages", Thread.currentThread().getName(), TOTAL_NUMBER);
    }
}