package tzl.com.basicknowledage.datastructure.linkedList;

/**
 * author: tangzenglei
 * created on: 2018/9/11 下午11:58
 * description: 单链表
 */
public class MyLinkedList {

    static Node head;

    int size = 0;


    class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
        head.next = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        return node(index)!=null?node(index).val:0;
    }




    private Node node(int index) {
        if (!isIndexExistence(index)) {
            return null;
        }
        Node currentNode = head.next;
        while (index > 0) {
            if (currentNode==null||(!currentNode.hasNext())) {
                currentNode = null;
            }else{
                currentNode = currentNode.next;
            }
            index--;
        }
        return currentNode;

    }

    private boolean isIndexExistence(int index) {
        return index >= 0&&index <size;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        //初始化头节点
        Node node = new Node(val);
        node.next = null;
        head.next = node;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        //初始化尾节点
        Node tailNode = new Node(val);
        if (head.next == null) {
            addAtHead(val);
        }else{
            //遍历找到当前最后的一个节点
            Node current = head.next;
            while (current.hasNext()) {
                current = current.next;
            }

            //当前链表中的最后一个节点 next 赋值给 当前节点
            tailNode.next = current.next ;
            //将节点放到当前节点
            current.next = tailNode;
        }

        size++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (!isIndexExistence(index)) {
            return;
        }
        Node newNode = new Node(val);
        Node indexNode = node(index-1);
        if (index == size) {
            addAtTail(val);
        }else{


            newNode.next = indexNode.next;
            indexNode.next = newNode;
        }
        size++;


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (!isIndexExistence(index)) {
            return;
        }

        //查找到前一个 节点
        Node preNode = node(index - 1);
        Node deleteNode = node(index);


        if (preNode==null) {
            head = deleteNode.next;
        }else{
            preNode.next = deleteNode.next;
        }
        preNode.next = deleteNode.next;

        deleteNode = null;
        size--;



    }







    public static void printLinkedList(Node head) {
        if (head == null) {
            return;
        }
        Node currentNode = head.next;
        while (currentNode!=null) {
            System.out.print("-->"+currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.print("\n");
    }




    public static Node removeNthFromEnd(Node head, int n) {

        Node fast = head.next;
        Node slow = head.next;



        //想将 fast 移动至 与slow 相差 n 个节点的位置
        for(int i = 0;i<n&&fast!=null;i++){
            fast = fast.next;
        }

        while(slow!=null&& fast!=null&&fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //遍历出来 fast 为最后一个节点，slow 指向 倒数 n+1 个节点

        //删除 slow.next 指向的对象
        if(slow == null){
            head = null;
        }
        else if (slow.next == null) { //一个元素
            head = null;
        }else{
            slow.next = slow.next.next;
        }



//        else if(slow.next==null){
//            slow.next = null;
//        }


        return head;


    }


    public static void main(String[] args){
//         MyLinkedList obj = new MyLinkedList();
//        printLinkedList();
//         obj.addAtHead(1);
//        printLinkedList();
//
//        obj.addAtTail(3);
//        printLinkedList();
//        obj.addAtIndex(1,2);
//        printLinkedList();
//
//        int param_1 = obj.get(1);
//        System.out.println(param_1);
//
//
//        obj.deleteAtIndex(1);
//        printLinkedList();
//
//        int param_2 = obj.get(1);
//        System.out.println(param_2);




        MyLinkedList lastNList = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            lastNList.addAtTail(i+1);
        }

        printLinkedList(lastNList.head);

        Node node = removeNthFromEnd(head, 2);
        printLinkedList(node);



    }



}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


