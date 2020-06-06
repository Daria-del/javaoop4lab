package po82.nazar.oop.test;

import org.junit.Test;
import po82.nazar.oop.model.AbstractAccount;
import po82.nazar.oop.model.Account;

import static org.junit.Assert.*;

public class AbstractAccountTest {

    Account a;
    Account equal;

    public AbstractAccountTest(){
        a = new AbstractAccount(32 , "3821");
        equal = new AbstractAccount(31, "3661");
    }

    @Test
    public void testToString() {
        System.out.println(a.toString());
    }

    @Test
    public void testEquals() {
        System.out.println(a.equals(equal));
    }

    @Test
    public void testHashCode() {
        System.out.println(a.hashCode());
        System.out.println(equal.hashCode());
    }
}