package mvc;

/**
 * Created by Apipol on 28/03/15.
 */
public class Student {

    private String name;

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Student) )
            return false;

        Student compareStu = (Student)obj;
        boolean sameName = name.equalsIgnoreCase(compareStu.name);
        if(sameName)
            return true;
        return false;
    }

    public String getName() {return name;}
}
