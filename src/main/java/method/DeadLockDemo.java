package method;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Author wuzhenfei
 * @Description   死锁的代码实现
 * @Date 2020/4/11 17:48
 **/

@Data
class HoldLockThread implements Runnable
{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有：" +lockA);
            try
            {
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB);
            }

        }
    }
}



public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA), "ThreadBBB").start();
    }

}
