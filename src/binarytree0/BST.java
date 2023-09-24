
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    Node root;

    public BST() {
        //rễ = null
        root = null;
    }

    boolean insert(Student x) {

        Node[] res = search(x);
        if (res[0] != null) //  found x.rollnum
        {
            return false;
        }
        Node t = new Node(x);
        if (res[1] == null) {
            root = t;
        } else {
            if (t.compareTo(res[1]) == +1) {
                res[1].right = t;
            } else {
                res[1].left = t;
            }
        }
        return true;
    }

    boolean deleteByCopyRight(Student x) {
        Node[] res = search(x);
        Node pos = res[0];
        Node parent = res[1];
        if (pos == null) //  found x.rollnum
        {
            return false;
        }

        if ((pos.left != null) && (pos.right != null)) {
            Node t = pos.right;
            Node tParent = pos;
            while (t.left != null) {
                tParent = t;
                t = t.left;
            }
            pos.data = t.data;
            parent = tParent;
            pos = t;
        }
        //th1
        Node posChild = pos.left;
        if (posChild == null) {
            posChild = pos.right;
        }
        if (parent == null) {
            root = posChild;
        } else if (pos.data.compareTo(parent.data) >= 0) {
            parent.right = posChild;
        } else {
            parent.left = posChild;
        }

        return true;
    }

    boolean deleteByCopyLeft(Student x) {
        Node[] res = search(x);
        Node pos = res[0];
        Node parent = res[1];
        if (pos == null) //  found x.rollnum
        {
            return false;
        }
        if ((pos.left != null) && (pos.right != null)) {
            int count = 0;
            Node t = pos.left;
            Node tParent = pos;
            while (t.right != null) {
                tParent = t;
                t = t.right;
            }
            pos.data = t.data;
            parent = tParent;
            pos = t;
        }

        //th1
        Node posChild = pos.left;
        if (posChild == null) {
            posChild = pos.right;
        }
        if (parent == null) {
            root = posChild;
        } else if (pos.data.compareTo(parent.data) > 0) {
            parent.right = posChild;
        } else {
            parent.left = posChild;
        }

        return true;
    }
    
    boolean deleteByMergingLeft(Student x) {
        Node[] res = search(x);
        Node pos = res[0];
        Node parent = res[1];
        if (pos == null) //  found x.rollnum
        {
            return false;
        }

        if ((pos.left != null) && (pos.right != null)) {
           Node t = pos.left;
           Node parentT = pos;
           while (t.right != null) {
               parentT = t;
               t = t.right;
           }
           t.right = pos.right;
           if (pos.compareTo(parent)>0) parent.right = pos.left;
           else parent.left = pos.left;
           return true;
        }

      
        Node posChild = pos.left;
        if (posChild == null) {
            posChild = pos.right;
        }
        if (parent == null) {
            root = posChild;
        } else if (pos.data.compareTo(parent.data) > 0) {
            parent.right = posChild;
        } else {
            parent.left = posChild;
        }

        return true;
    }
    
      boolean deleteByMergingRight(Student x) {
        Node[] res = search(x);
        Node pos = res[0];
        Node parent = res[1];
        if (pos == null) //  found x.rollnum
        {
            return false;
        }

        if ((pos.left != null) && (pos.right != null)) {
           Node t = pos.right;
           Node parentT = pos;
           while (t.left != null) {
               parentT = t;
               t = t.left;
           }
           t.left = pos.left;
           if (pos.compareTo(parent)>0) parent.right = pos.right;
           else parent.left = pos.right;
           return true;
        }

        //th1
        Node posChild = pos.left;
        if (posChild == null) {
            posChild = pos.right;
        }
        if (parent == null) {
            root = posChild;
        } else if (pos.data.compareTo(parent.data) > 0) {
            parent.right = posChild;
        } else {
            parent.left = posChild;
        }

        return true;
    }
    

    Node[] search(Student x) {
        Node t = root, parent = null;
        while (t != null && t.data.compareTo(x) != 0) {
            parent = t;
            if (t.data.compareTo(x) == +1) {
                t = t.left;
            } else // greater than
            {
                t = t.right;
            }
        }
        return new Node[]{t, parent};
    }

    public String descTraverse() {
        return descTraverse(root);
    }

    private String descTraverse(Node t) {
        if (t == null) {
            return "";
        }
        return descTraverse(t.right) + t + " " + descTraverse(t.left);
    }

    public String inOrder() {
        return inOrder(root);
    }

    private String inOrder(Node t) {
        if (t == null) {
            return "";
        }
        return inOrder(t.left) + t + inOrder(t.right);
    }

    public String preOrder() {
        return preOrder(root);
    }

    private String preOrder(Node t) {
        if (t == null) {
            return "";
        }
        return t + preOrder(t.left) + preOrder(t.right);
    }

    public String postOrder() {
        return postOrder(root);
    }

    private String postOrder(Node t) {
        if (t == null) {
            return "";
        }
        return postOrder(t.left) + postOrder(t.right) + t;
    }

    public String levelOrder() {
        String out = "";
        int level = 0;
        Queue<Node> Q = new LinkedList<>();
        if (root != null) {
            Q.add(root);
        }
        Q.add(null); // enqueue
        while (!Q.isEmpty()) {
            Node t = Q.poll();//dequeue
            if (t == null) {
                if (Q.isEmpty())////the last null
                {
                    break;
                }
                level++;
                Q.add(null);
                continue;
            }
            out += t + "(" + level + ")";
            if (t.left != null) {
                Q.add(t.left);
            }
            if (t.right != null) {
                Q.add(t.right);
            }
        }
        return out;
    }

    public String depthTraverse() {
        String out = "";
        int level = 0;
        Stack<Node> Q = new Stack<>();
        if (root != null) {
            Q.add(root);
        }
        while (!Q.isEmpty()) {
            Node t = Q.pop();
            out += t + " ";

            if (t.right != null) {
                Q.add(t.right);
            }
            if (t.left != null) {
                Q.add(t.left);
            }
        }
        return out;
    }
}
