package tzl.com.basicknowledage.datastructure.queue;

/**
 * author: tangzenglei
 * created on: 2018/9/25 下午5:29
 * description:
 */
public class MyCircularQueue {


    private final int maxSize;
    private int[] mDatas;

    private int front;

    private int rear;

    //避免rear 比 front 多走了 k步：https://www.cnblogs.com/smyhvae/p/4793339.html
    private int count ;


    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {

        mDatas = new int[k];
        maxSize = k;
        front = rear = 0;
        count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }
        rear =(rear+1)>=maxSize? (rear+1)%maxSize:rear+1;
        count++;
        mDatas[rear] = value;
//        mDatas.add(rear, value);
        return  true;


    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }
        mDatas[front] = 0;
        front =(front+1)>=maxSize? (front+1)%maxSize:front+1;
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {

            return -1;

        }
        return mDatas[front];




    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return mDatas[rear];


    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return (front == rear)&&(count==0);
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {

        if (isEmpty()) {
            return false;
        }
        return (front==(rear +1)%maxSize)&&(count>0);
    }




     public static void main(String[] args){
//         MyCircularQueue obj = new MyCircularQueue(6);
//         System.out.println(obj.enQueue(6));
//         System.out.println(obj.Rear());
//         System.out.println(obj.Rear());
//         System.out.println(obj.deQueue());
//         System.out.println(obj.enQueue(5));
//         System.out.println(obj.Rear());
//         System.out.println(obj.deQueue());
//         System.out.println(obj.Front());
//         System.out.println(obj.deQueue());
//         System.out.println(obj.deQueue());
//         System.out.println(obj.deQueue());


         MyCircularQueue obj = new MyCircularQueue(6);
         System.out.println(obj.enQueue(6));
         System.out.println(obj.Rear());
         System.out.println(obj.Rear());
         System.out.println(obj.deQueue());
         System.out.println(obj.enQueue(5));
         System.out.println(obj.Rear());
         System.out.println(obj.deQueue());
         System.out.println(obj.Front());
         System.out.println(obj.deQueue());
         System.out.println(obj.deQueue());
         System.out.println(obj.deQueue());

     }

}
