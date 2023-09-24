


public class Node implements Comparable<Node>{
    Student data;
    Node left, right;

    public Node(Student x) {
        data = x;
        left = right = null;
    }

    @Override
    public int compareTo(Node o) {
        return this.data.compareTo(o.data) ;
        
    }

    @Override
    public String toString() {
        return data+"";
    }
    
    
}
