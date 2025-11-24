package Thread;

class JoinExample {

    public static void main(String[] args) throws Exception {

        Thread t = new Thread(() -> {
            try {
                System.out.println("Child thread working...");
                Thread.sleep(3000);
                System.out.println("Child thread finished!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.start();

        System.out.println("Main thread waiting for child to finish...");
        t.join();  // waits for t, does NOT release lock
        System.out.println("Main thread resumed after join.");
    }
}

