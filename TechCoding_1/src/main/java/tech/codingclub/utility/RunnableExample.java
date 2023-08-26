//package tech.codingclub.utility;
//public class RunnableExample implements Runnable {
//    private final String name;
//
//    public RunnableExample(String name) {
//        this.name = name;
//    }
//
//    public void run() {
//        try {
//            for (int i=0;i<3 ;i++ ) {
//                System.out.println(name);
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("sleep interrupted");
//        }
//    }
//
//    public static void main(String[] args) {
//        RunnableExample t=new RunnableExample("First Thread");
//        RunnableExample th=new RunnableExample("Second Thread");
//        Thread t1 = new Thread(t);
//        Thread t2 = new Thread(th);
//        t1.start();
//        t2.start();
//    }
//}
package tech.codingclub.utility;
public class RunnableExample implements Runnable {
    private String threadName;
    public int counter;
    private int waitTimeWhileLoop;

    // private final String name;
    public RunnableExample(String threadName,int counter,int waitTimeWhileLoop) {

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
    public static void main(String[] args) {
        RunnableExample runnable1 = new RunnableExample("Thread_A",0,500); // kabhi pahle first chalega kabhi pahle second chelga
        RunnableExample runnable2 = new RunnableExample("Thread_B",0,1000);
        RunnableExample runnable3 = new RunnableExample("Thread_C",0,2000);

        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);
        Thread thread3=new Thread(runnable3);



        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(runnable1.counter);
        System.out.println(runnable2.counter);
        System.out.println(runnable3.counter);   // always chenge the output the value

    }
}