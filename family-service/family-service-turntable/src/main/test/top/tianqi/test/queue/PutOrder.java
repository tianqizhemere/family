package top.tianqi.test.queue;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import queue.DelayQueueManager;
import queue.DelayTask;



/**
 * @Author wkh
 * @Date 2020/8/4 13:32
 */
@SpringBootTest
public class PutOrder {

    @Test
    public void run() throws InterruptedException {
        Order order = new Order();
        order.setOrderId("测试");
        order.setOrderMoney(10.0);
        Order order1 = new Order();
        order1.setOrderId("1110");
        order1.setOrderMoney(1125.0);
        DelayQueueManager instance = DelayQueueManager.getInstance();
        DelayTask<Order> task = new DelayTask<>(5L, order, 1L);
        instance.put(task);
        DelayTask<Order> task2 = new DelayTask<>(10L, order, 2L);
        DelayTask<Order> task3 = new DelayTask<>(8L, order, 3L);
        instance.put(task2);
        instance.put(task3);
        instance.removeTask(task3);
        Thread.sleep(50000);
    }
}
