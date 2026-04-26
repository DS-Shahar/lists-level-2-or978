class Main
{
    public static void main(String[]args)
    {
        //Node<Integer> n6 = new Node<Integer>(2); 
        Node<Integer> n5 = new Node<Integer>(5); 
        Node<Integer> n4 = new Node<Integer>(5,n5); 
        Node<Integer> n3 = new Node<Integer>(2,n4); 
        Node<Integer> n2 = new Node<Integer>(5,n3); 
        Node<Integer> n1 = new Node<Integer>(3,n2); 
        Node<Integer> List = new Node<Integer>(6,n1); 

    }

    public static Node<Integer> max_of_threes(Node<Integer>L)
    {
        Node<Integer> max_L=new Node<Integer>(null);
        Node<Integer> max_p=max_L;
        int count=0;
        int index=0;
        int max=L.getValue();
        while(L.getNext()!=null)
        {
            if(count!=3)
            {
                if(L.getValue()>max)
                    max = L.getValue();
                L=L.getNext();
                index++;
                count++;
            }
            count=0;
            max_p.setNext(new Node<Integer>(index));
            max_p=max_p.getNext();
            max=L.getNext().getValue();
        }
        return max_L.getNext();
    }

}