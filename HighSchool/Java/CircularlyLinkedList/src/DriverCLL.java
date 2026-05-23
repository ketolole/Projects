public class DriverCLL
{
    /* add this code to your CircularlyLinkedList class
     * 
     * 
     * public DListNode getFirstNode()
    {
    return first;
    }

    public DListNode getLastNode()
    {
    return last;
    }

     */

    public static void main(String[] args)
    {
        // 1
        /*
        CircularlyLinkedList cList = new CircularlyLinkedList();
        cList.addFirst(new Item(40, 60));
        DListNode node = cList.getFirstNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        //cList = new CircularlyLinkedList();
        cList.addLast(new Item(80, 60));
        node = cList.getLastNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        cList.addFirst(new Item(20, 60));
        node = cList.getFirstNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());
         */
        // verify all are linked where they should be

        // 2 (comment these out until #1 works, and then comment out #1 to test #2)
/*
        CircularlyLinkedList cList = new CircularlyLinkedList();
        cList.addLast(new Item(60, 60));
        DListNode node = cList.getFirstNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        //cList = new CircularlyLinkedList();
        cList.addFirst(new Item(20, 60));
        node = cList.getLastNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        cList.addLast(new Item(80, 60));
        node = cList.getFirstNode();
        System.out.println(node.getValue());
        System.out.println(node.getPrevious().getValue());
        System.out.println(node.getNext().getValue());

        // verify all are linked where they should be
*/
        CircularlyLinkedList labFour = new CircularlyLinkedList();
        COrderedList bingusCircle = new COrderedList();
        bingusCircle.mainMenu(labFour);
        
    }
}

