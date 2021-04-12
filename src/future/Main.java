package future;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FutureData futureData = new FutureData();
        new Thread(()->{
            IData data = new IData("hi from client");
            futureData.setData(data);
        }).start();
        System.out.println("hi");
        System.out.println(futureData.fetch());

//        FutureTask<String> task = new FutureTask<>(() -> {
//            System.out.println("start future task");
//            Thread.sleep(2000);
//            System.out.println("future finish");
//            return "this is the future task";
//        });
//        new Thread(task).start();
//
//        System.out.println("main thread start to sleep");
//        Thread.sleep(500);
//        System.out.println("main thread sleep over");
//
//        try {
//            System.out.println(task.get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
