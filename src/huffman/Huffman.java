package huffman;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Huffman {
    public static void print(HNode root,String str)
    {
        if(root.left == null && root.right == null && Character.isLetter(root.c))
        {
            System.out.println(root.c+" : "+ str);
            return;
        }
        print(root.left , str + "0");
        print(root.right , str + "1");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Character>charInput = new ArrayList<>();
        ArrayList<Integer>intInput = new ArrayList<>();
        int numOfElements;
        System.out.print("Enter number of elements : ");
        numOfElements=input.nextInt();
        for(int i = 0 ; i < numOfElements ; i++)
        {
            System.out.print("Enter the name of element number "+ (i+1) + " : ");
            charInput.add(input.next().charAt(0));
            System.out.print("Enter the frequency of element number "+ (i+1) + " : ");
            intInput.add(input.nextInt());
        }
        PriorityQueue<HNode> queue = new PriorityQueue<>(numOfElements, new comparing());
        for(int i = 0 ; i  <numOfElements ; i++)
        {
            HNode Node =new HNode();
            Node.c=charInput.get(i);
            Node.data=intInput.get(i);
            Node.left= null;
            Node.right= null;
            queue.add(Node);
        }
        HNode root=null;
        while(queue.size()>1)
        {
            HNode a = queue.peek();
            queue.poll();
            HNode b = queue.peek();
            queue.poll();
            HNode n = new HNode();
            n.data=a.data+b.data;
            n.c='*';
            n.left=a;
            n.right=b;
            root=n;
            queue.add(n);
        }
        print(root,"");
    }
}