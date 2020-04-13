package method;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/4/12 17:27
 *
 *  使用阻塞队列编写生产者消费者
 **/

class MyResource
{
    private volatile boolean FLAG = true; // 默认开启， 进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());

    }

    public void myProd() throws Exception
    {
        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue)
            {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了， 表示FLAG=false,生产动作结束");
    }

    public void myConsumer() throws Exception{
        String result = null;
        while(FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == result|| result.equalsIgnoreCase(""))
            {
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒钟没有取到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");

    }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了， 表示FLAG=true,消费动作结束");
    }

    public void stop() throws Exception{
        this.FLAG = false;
    }

}
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动 ");
            try
            {
                myResource.myProd();
            }catch(Exception e){
                e.printStackTrace();
            }finally{

            }

        },"prod").start();

       try{ TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();}
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动 ");
            try
            {
                myResource.myConsumer();
            }catch(Exception e){
                e.printStackTrace();
            }finally{

            }

        },"customer").start();
        try
        { TimeUnit.SECONDS.sleep(5);
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println("大老板main线程叫停，活动结束");
            myResource.stop();
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }

}
