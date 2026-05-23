/**
 * Description of the Class
 *
 * @author G. Peck
 * @created July 18, 2002
 *
 *          Modified by Jason Quesenberry and Nancy Quesenberry February 9, 2006
 */

public class Item implements Comparable
{
    private int myId;
    private int myInv;

    /**
     * Constructor for the Item object
     *
     * @param id id value
     * @param inv inventory value
     */
    public Item(int id, int inv)
    {
        myId = id;
        myInv = inv;
    }

    /**
     * Gets the id attribute of the Item object
     *
     * @return The id value
     */
    public int getId()
    {
        return myId;
    }

    /**
     * Gets the inv attribute of the Item object
     *
     * @return The inv value
     */
    public int getInv()
    {
        return myInv;
    }


    public int compareTo(Object otherObject)
    {
        Item other = (Item) otherObject;

        return myId - other.myId;
    }

    public boolean equals(Object otherObject)
    {
        return this.compareTo(otherObject) == 0;
    }

    public String toString()
    {
        return "Item Id=" + myId + ", Inv=" + myInv;
    }
}
