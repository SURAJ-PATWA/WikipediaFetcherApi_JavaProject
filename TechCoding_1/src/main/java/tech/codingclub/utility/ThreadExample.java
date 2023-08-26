package tech.codingclub.utility;
public class ThreadExample extends Thread {
    private String threadName;
    public int counter;
    private int waitTimeWhileLoop;



   // private final String name;

    public ThreadExample(String threadName,int counter,int waitTimeWhileLoop) {

        this.threadName = threadName;
        this.counter=counter;
        this.waitTimeWhileLoop=waitTimeWhileLoop;
    }


// we are overriding how run will gonna work
    public void run() {
        while (counter < 1000) {
            counter++;
            // we try to sleep concept
            while(counter<1000) {
                counter++;
                try {

                    Thread.sleep(waitTimeWhileLoop);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(threadName + ":" + counter);
            }
        }
    }
//        try {
//            for (int i=0;i<3 ;i++ ) {
//                System.out.println(name);
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("sleep interrupted");
//        }


    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample("Thread_A",0,500); // kabhi pahle first chalega kabhi pahle second chelga
        ThreadExample thread2 = new ThreadExample("Thread_B",0,1000);
        ThreadExample thread3 = new ThreadExample("Thread_C",0,2000);
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(thread1.counter);
        System.out.println(thread2.counter);
        System.out.println(thread3.counter);   // always chenge the output the value

    }
}