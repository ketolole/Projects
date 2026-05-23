import java.util.*;
import java.io.*;

public class EMDirectory
{
    private Map<Name, String> dir;

    /**
    Constructs an empty email directory map.
     */
    public EMDirectory()
    {
        dir = new TreeMap<Name, String>();//do generics
    }

    /**
    Constructs an email directory map by reading name and email
    information from the indicated file name and adding them to the
    email directory map. The name information serves as the key for
    the email address items

    @param dirFile - file name containing names and email addresses
     */
    public EMDirectory(String dirFile)
    {
        dir = new TreeMap<Name, String>();

        Scanner in;

        try
        {
            in = new Scanner(new File(dirFile));
            while(in.hasNext())
            {
                String lastName = "";
                String firstName = "";
                String emailAddr = "";
                if(in.hasNext())
                {
                    firstName = in.next();
                }
                if(in.hasNext())
                {
                    lastName = in.next();
                }
                if(in.hasNext())
                {
                    emailAddr = in.next();
                }

                addEntry(new Name(lastName, firstName), emailAddr);
            }
        }
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
    }

    /**
    Your description here

    @param name  Your description here
    @param emailAddr  Your description here
     */
    public void addEntry(Name name, String emailAddr)
    {
        dir.put(name, emailAddr);
    }

    /**
    Your description here

    @param name a Name class
    @returns email
     */
    public String lookup(Name name)
    {
        return dir.get(name);
    }

    /**
    the lookupLastName(String lastName) takes a last name, as a string, 
    and returns a set of all email addresses stored with any
    name that has that last name.

    @param lastName  Your description here
    @returns  Your description here
     */
    public Set lookupLastName(String lastName)
    {
        Set<String> result = new TreeSet<String>();

        Iterator<Name> nameSet = dir.keySet().iterator();
        while (nameSet.hasNext()) //no object and set of what, use iterators
        {
            Name fullName = nameSet.next();
            if(fullName.last().equals(lastName)) 
            {
                result.add(dir.get(fullName));
            }
        }

        return result;
    }

    /**
    gets all keys and prints key and associated value
     */
    public void listAll()
    {
        Iterator<Name> iterator = dir.keySet().iterator();
        System.out.printf("%-17s", "Name(First Last)");
        System.out.printf("%s", "Email\n");
        while (iterator.hasNext()) 
        {
            Name key = iterator.next();
            String value = dir.get(key);

            System.out.printf("%-17s", key + ",");
            System.out.printf("%s", value + "\n");
        }
    }
}

