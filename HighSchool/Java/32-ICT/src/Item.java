/**
 * Description of the Class
 *
 * @author G. Peck
 * @created July 18, 2002
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


  public int hashCode()
  {

    // 48.66%
    /*
     * double valOne = myId/10000; double valTwo = myId/1000%10; double valThree = myId/100%100;
     * double valFour = myId/10%10; double valFive = myId%10; //return (int)(myId * temp % 599);
     * double temp = valOne * valTwo + valThree * valFour + valFive; return (int)(myId * temp %
     * 599);
     */
    return (int) (myId * 1.6719654889212254E10 % 599);
  }


  /**
   * Compares two Item objects by their Id (myId) fields
   *
   * @param otherObject Item object to compare to
   * @return positive int if myId > otherObject.myId 0 if myId == otherObject.myId negative int if
   *         myId < otherObject.myId
   */
  public int compareTo(Object otherObject)
  {
    Item other = (Item) otherObject;
    return myId - other.myId;
  }


  /**
   * Compares the Item to the specified object
   *
   * @param otherObject Item object to compare to
   * @return true if equal, false otherwise
   */
  public boolean equals(Object otherObject)
  {
    return this.compareTo(otherObject) == 0;
    // Item other = (Item)otherObject;
    // return myId == other.myId;
  }


  public String toString()
  {
    return "Id= " + myId + ", Inv= " + myInv;
  }
}


