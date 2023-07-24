package InnerClass;



public class Static {

    static class Node{
        int value;
        Node next;
        Node(int value, Node next){
            this.value= value;
            this.next= next;
        }
    }

    public static void main(String[] args) {
        Node first= new Node(1, null);
        Node second= new Node(2, first);
        Node third  = new Node(3, second);

        print(third);
    }

    public static void print(Node head){
        while(head != null){
            System.out.println(head.value);
            head=head.next;
        }

    }
}
