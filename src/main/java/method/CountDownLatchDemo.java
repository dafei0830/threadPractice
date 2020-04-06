package method;

import constant.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wuzhenfei
 * @Description  CountDownLatch类的使用场景
 * @Date 2020/4/6 21:24
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        closeDoor();
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++)
        {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "\t上完自习，离开教师");
                countDownLatch.countDown();
            }, CountryEnum.getBycode(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+ "\t ******************班长最后关门走人");
    }
}
