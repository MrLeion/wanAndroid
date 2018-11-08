package tzl.com.basicknowledage.datastructure.tree;

/**
 * author: tangzenglei
 * created on: 2018/11/8 下午1:52
 * description: 增删改查 都达到 logN 的时间复杂度，相对链表和队列等结构得到了很大的改善
 * <p>
 * 假设data 唯一
 */
public class BinaryOrderTree {


    BNode root;//根节点

    public class BNode {
        public BNode left;
        public BNode right;
        public BNode parent;
        public int   data;

        public BNode(int data) {
            this.data = data;
        }
    }


    private boolean insert(int data) {
        BNode newNode = new BNode(data);
        if (root == null) {
            root = newNode;
        } else {
            //判断大小
            BNode current = root;
            while (true) {
                if (current.data > newNode.data) {
                    //如果新节点比当前节点小,作为左节点(第一个比新节点小)的右叶子节点
                    if (current.right == null) {
                        current.right = newNode;
                        newNode.parent = current;
                        return true;
                    } else {
                        current = current.left;

                    }
                } else {
                    //如果新节点比当前节点大,作为右节点(第一个比新节点大)的左叶子节点
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.parent = current;
                        return true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        return true;
    }


    private boolean delete(int data) {


        if (root == null) {
            return false;
        }


        //查找要删除的节点和与其父节点的关系
        BNode current = root;
        BNode deleteNode = null;
        boolean isLeftNode = true;
        while (current.data != data) {
            if (data < current.data) {
                current = current.left;
                if (current.data == data) {
                    deleteNode = current;
                    isLeftNode = true;
                }

            } else {
                current = current.right;
                if (current.data == data) {
                    deleteNode = current;
                    isLeftNode = false;
                }
            }
        }


        //删除节点
        if (deleteNode.left != null && deleteNode.right != null) {
            return deleteTwo(deleteNode, isLeftNode);
        } else if (deleteNode.left != null || deleteNode.right != null) {
            return deleteOne(deleteNode, isLeftNode, deleteNode.left != null);
        } else {
            return deleteNone(deleteNode, isLeftNode);
        }


    }


    private boolean deleteOne(BNode deleteNode, boolean isLeftNode, boolean hasLeftChild) {
        if (deleteNode == null) {
            return false;
        }
        if (root == deleteNode) {
            if (hasLeftChild) {
                root = root.left;
            } else {
                root = root.right;
            }
        }


        if (hasLeftChild) {

            if (isLeftNode) {
                //左孩子左节点，继承节点为父节点
                deleteNode.left.parent = deleteNode.parent;
                deleteNode.parent.left = deleteNode.left;
            } else {
                //左孩子右节点，继承节点为右子树最左节点
                BNode succesor = getLeft(deleteNode.right);
                succesor.parent.left = null;
                succesor.parent = deleteNode.parent;
                deleteNode.parent.left = succesor;
            }


        } else {

            if (isLeftNode) {
                //右孩子左节点，继承节点为左子树最右节点
                BNode successor = getRight(deleteNode.left);
                successor.parent.right = null;
                successor.parent = deleteNode.parent;
                deleteNode.parent.right = successor;
            } else {
                //右孩子右节点，继承节点为右子树最左节点
                BNode successor = getLeft(deleteNode.right);
                successor.parent.left = null;
                successor.parent = deleteNode.parent;
                successor.parent.right = successor;

            }


        }

        return true;
    }

    private boolean deleteTwo(BNode deleteNode, boolean isLeftNode) {


        if (deleteNode == null) {
            return false;
        }
        BNode successor = getLeft(deleteNode.right);
        successor.parent.left = null;
        successor.parent = deleteNode.parent;
        if (isLeftNode) {
            deleteNode.parent.left = successor;
        }else{
            deleteNode.parent.right = successor;
        }
        return true;
    }


    //当前节点为叶子节点，删除 = 父节点置null
    private boolean deleteNone(BNode deleteNode, boolean isLeftNode) {
        if (deleteNode == null) {
            return false;
        }
        if (deleteNode == root) {
            root = null;
            return true;
        }
        if (isLeftNode) {
            deleteNode.parent.left = null;
        } else {
            deleteNode.parent.right = null;
        }
        return true;
    }


    //获取当前二叉树最左边的节点
    private BNode getLeft(BNode root) {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current != null) {
            current = current.left;
        }
        return current;
    }


    //获取当前二叉树最右边的节点
    private BNode getRight(BNode root) {

        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current != null) {
            current = current.right;
        }
        return current;
    }


    private BNode find(int data) {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (true) {

            if (current.data == data) {
                return current;
            }

            if (data < current.data) {
                current = current.left;

                if (current == null) {
                    return null;
                }
                if (current.data == data) {
                    return current;
                }

            } else {
                current = current.right;
                if (current == null) {
                    return null;
                }
                if (current.data == data) {
                    return current;
                }

            }
        }

    }


    /**
     * https://www.ibm.com/developerworks/cn/java/j-lo-enum/index.html
     */
    enum Operation {
        PREORDER,
        INORDER,
        POSTORDER,
        BFS,
        DFS
    }


    private void traverse(Operation operation) {
        switch (operation) {

            case PREORDER:
                preOrder(root);
                break;
            case INORDER:
                inOrder(root);
                break;
            case POSTORDER:
                postOrder(root);
                break;
            case BFS:

                break;

            case DFS:

                break;
        }


    }

    private void postOrder(BNode root) {

        if (root == null) {
            System.out.println("");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        //当前节点为叶子节点
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }


    }

    private void inOrder(BNode root) {

        if (root == null) {
            System.out.println("");
            return;
        }

        inOrder(root.left);
        //当前节点为叶子节点
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        inOrder(root.right);


    }

    private void preOrder(BNode root) {


        if (root == null) {
            System.out.println("");
            return;
        }


        //当前节点为叶子节点
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }

        preOrder(root.left);
        preOrder(root.right);
    }


}
