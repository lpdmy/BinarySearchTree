
public class Main {

    public static void main(String[] args) {
        BST T = new BST();
//        T.insert(new Student(20));
//        T.insert(new Student(5));
//        T.insert(new Student(2));
//        T.insert(new Student(10));
//        T.insert(new Student(1));
//        T.insert(new Student(4));
//        T.insert(new Student(7));
//        T.insert(new Student(3));
//        T.insert(new Student(6));
//        T.insert(new Student(9));
//        T.insert(new Student(8));
    T.insert(new Student(10));
    T.insert(new Student(5));
    T.insert(new Student(16));
    T.insert(new Student(3));
    T.insert(new Student(13));
    T.insert(new Student(7));
    T.insert(new Student(6));
    T.insert(new Student(9));
    T.insert(new Student(19));
    T.insert(new Student(1));
        T.insert(new Student(2));

    
        System.out.println(T.deleteByMergingRight(new Student(5)));
        System.out.println("Descending order: " + T.descTraverse());
        System.out.println("Inorder :" + T.inOrder());
        System.out.println("Preorder :" + T.preOrder());
        System.out.println("Postorder :" + T.postOrder());
        System.out.println("Levelorder :" + T.levelOrder());
        System.out.println("Depth order: " + T.depthTraverse());
    }
}
