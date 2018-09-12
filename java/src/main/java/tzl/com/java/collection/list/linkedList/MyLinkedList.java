package tzl.com.java.collection.list.linkedList;

/**
 * author: tangzenglei
 * created on: 2018/9/11 下午11:58
 * description:
 */
public class MyLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        addAtHead(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        return 0;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = null;
        
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

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


