class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n", Thread.currentThread().getName());
            }
        } catch (InterruptedException err) {

        }
    }
}