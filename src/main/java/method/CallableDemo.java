package method;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author wuzhenfei
 * @Description  Callable接口的使用方法
 * @Date 2020/4/6 20:01
 **/

class MyThread implements Runnable{

    public void run() {

    }
}

class MyThread2 implements Callable<Integer>
{

    public Integer call() throws Exception {
        System.out.println("--------------come in callable");
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread2());
       new Thread(futureTask, "AA").start();

        int result01=100;
        System.out.println("-----------get result01 = " + result01);
        while(!futureTask.isDone()){

        }

        int result02 = futureTask.get();

        System.out.println("-------result " + result01+result02);



    }
}
