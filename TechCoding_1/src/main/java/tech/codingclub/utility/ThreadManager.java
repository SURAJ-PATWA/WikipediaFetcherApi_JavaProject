package tech.codingclub.utility;

import tech.codingclub.entity.Coders;

import java.util.Date;

public class ThreadManager {
    public static void main(String[] args) {
        System.out.println("This side is Suraj Patwa");
        System.out.println("Running ThreadManager Example "+ new Date().getTime());
        TaskManager taskManager=new TaskManager(100);
        for(int i=0;i<10000;i++){
            RunnableExample temp=new RunnableExample("Thread-No-"+i,0,500+i);
            taskManager.waitTillQueueIsFreeAndAddTask(temp);
            System.out.println("$$$$$$$$$$$$$$$$$$$");
        }
        System.out.println("###############################################");
    }
}
