import java.util.Scanner;

class Main 
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 8};
        Node<Integer> list1 = buildlist(arr);
        //printlist(list1);
        int[] arr2 = {3, 7, 9, 10, 11};
        Node<Integer> list2 = buildlist(arr2);
        int[] arr3 = {1, 4, 2, 2, 6, 5};
        Node<Integer> list3 = buildlist(arr3);
        printlist(Once(list3));
        
        
    }
    //ex1
    public static Node<Integer> SortLists(Node<Integer>L1,Node<Integer>L2)
    {
        Node<Integer> p1=L1;
        Node<Integer> p2=L2;
        Node<Integer> head3=new Node<Integer>(null);
        Node<Integer> p3=head3;
        int v1=p1.getValue();
        int v2=p2.getValue();
        while (p1 !=null && p2 !=null) 
        {
            if(v1==v2) 
            {                 
                p3.setNext(new Node<Integer>(v1));
                p3=p3.getNext();
                p3.setNext(new Node<Integer>(v1));
                
                p1=p1.getNext();
                p2=p2.getNext();
            }
            if(v1>v2)
            {
                p3.setNext(new Node<Integer>(v2));
                p2=p2.getNext();
            }
            else
            {
                p3.setNext(new Node<Integer>(v1));
                p1=p1.getNext();
            }
            
            if(p1!=null)
                v1=p1.getValue();
            if(p2!=null)
                v2=p2.getValue();
            p3=p3.getNext();
        }

        while (p1!=null)
        {
            p3.setNext(new Node<Integer>(v1));
            v1=L1.getValue();
            p3=p3.getNext();
            p1=p1.getNext();
        }
        
        while (p2!=null)
        {
            p3.setNext(new Node<Integer>(v2));
            v2=p2.getValue();
            p3=p3.getNext();
            p2=p2.getNext();
        }
        return head3.getNext();
    }

    //ex2
    public static Node<Integer> SelectionSort(Node<Integer>L1)
    {
        if (L1 == null)
            return null;

        Node<Integer> sortedHead = null;
        Node<Integer> sortedTail = null;

        while (L1 != null)
        {
            Node<Integer> minNode = L1;
            Node<Integer> p = L1.getNext();

            while (p != null)
            {
                if (p.getValue() < minNode.getValue())
                    minNode = p;
                p = p.getNext();
            }

            Node<Integer> newNode = new Node<Integer>(minNode.getValue());

            if (sortedHead == null)
            {
                sortedHead = newNode;
                sortedTail = newNode;
            }
            else
            {
                sortedTail.setNext(newNode);
                sortedTail = newNode;
            }

            // remove minNode from L1
            if (minNode == L1)
            {
                L1 = L1.getNext();
            }
            else
            {
                Node<Integer> prev = L1;
                while (prev.getNext() != minNode)
                    prev = prev.getNext();

                prev.setNext(minNode.getNext());
            }
        }

        return sortedHead;
    }

    //ex3
    public static int Distance(Node<Integer>L1,int a)
    {
        Node<Integer> p=L1;
        int length=0;
        int Start_index=0;
        int End_index=0;

        boolean st=false;
        if(!appearsRec(L1, a))
        {
            return -1;
        }
        while (p!=null)
        {
            length++;
            if(p.getValue().equals(a) && !st)
            {
                Start_index=length;
                st=!st;
            }
            if(p.getValue().equals(a) && st)
            {
                End_index=length;
            }
            p=p.getNext();
                
        }
        Start_index--;
        End_index--;

        return Start_index+length-End_index-1;

    }

    //ex4
    public static boolean AllDiffrent(Node<Integer>L1)
    {
        Node<Integer>p1=L1;
        Node<Integer>p2=null;
        while(p1.getNext()!=null) 
        {
            p2=p1.getNext();
            while(p2!=null)
            {
                if(p1.getValue().equals(p2.getValue()))
                {
                    return false;
                }
                p2=p2.getNext();
            }
            p1=p1.getNext();
        }
        return true;
    }

    //ex5
    public static Node<Integer> Once(Node<Integer>L1)
    {
        Node<Integer>pl=L1;
        Node<Integer>head=new Node<Integer>(null,null);
        Node<Integer>p=head;
        while (pl !=null) 
        {
            if(!appearsRec(head.getNext(),pl.getValue()))
            {
                p.setNext(new Node<Integer>(pl.getValue(),null));
                p=p.getNext();
            }
            pl=pl.getNext();
        }
        return head.getNext();
    }

    //build list
    public static Node<Integer> buildlist(int[] a)
    {
        Node<Integer> p = new Node<Integer>(a[0]);
        Node<Integer> head = p;
        for (int i = 1; i < a.length; i++)
        {
            Node<Integer> x = new Node<Integer>(a[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return head;
    }

    //prints-list
    public static void printlist(Node<Integer> l)
    {
        while (l != null)
        {
            System.out.println(l.getValue());
            l = l.getNext();
        }
    }

    //HELPER-isin-rec
    public static boolean appearsRec(Node<Integer> l, int num)
    {
        if (l == null) return false;
        if (l.getValue() == num) return true;
        return appearsRec(l.getNext(), num);
    }

    //helper-deleteAT
    public static Node<Integer> deleteAt(Node<Integer> l,int num)
    {
        if(num<1) return l;
        if(num==1) return l.getNext();
        Node<Integer> p=l;
        int i=1;
        while (p!=null) 
        {
            if(i==num-1)
            {
                p.setNext(p.getNext().getNext());
            }
            p=p.getNext();
            i++;
        }
        return l;

    }
}
