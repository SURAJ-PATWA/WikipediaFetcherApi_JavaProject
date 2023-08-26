package tech.codingclub.entity;

import tech.codingclub.utility.RunnableExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Coders {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Coders(){

    }

    public Coders(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public static class KeywordCount {

        public String keyword;
        public int count;


        public KeywordCount(String keyword, int count) {
            this.keyword = keyword;
            this.count = count;
        }


        //    public KeywordCount(String keyword) {
        //        this.keyword = keyword;
        //    }

    } }

    /**
     * Created by Coding Club India.
     */
//    public static class TaskManager {
//
//        private int threadCount;
//        private ExecutorService executorService;
//
//        public TaskManager(int threadCount) {
//            this.threadCount = threadCount;
//            this.executorService = Executors.newFixedThreadPool(threadCount);
//        }
//
//        public void waitTillQueueIsFreeAndAddTask(Runnable runnable) {
//            while (getQueueSize() >= threadCount) {
//                try {
//                    System.out.println("Sleeping");
//                    Thread.currentThread().sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            addTask(runnable);
//        }
//
//        public void addTask(Runnable runnable) {
//            this.executorService.submit(runnable);
//        }
//
//        private int getQueueSize() {
//            ThreadPoolExecutor executor = (ThreadPoolExecutor) (executorService);
//            return executor.getQueue().size();
//        }
//    }
//
//    public static class ThreadManager {
//        public static void main(String[] args) {
//            ExecutorService service = Executors.newFixedThreadPool(10);
//            // now submit our jobs
////            service.submit(new RunnableExample(" ExecutorService:Thread A"));
////            service.submit(new RunnableExample(" ExecutorService:Thread B"));
////            service.submit(new RunnableExample(" ExecutorService:Thread C "));
//
//
//        }
//    }
//}
