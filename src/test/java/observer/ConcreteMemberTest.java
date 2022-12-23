package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {


    @Test
    void update() {
        GroupAdmin ga = new GroupAdmin();
        ConcreteMember moshe = new ConcreteMember();
        ConcreteMember yogev = new ConcreteMember();
        ga.register(moshe);
        ga.register(yogev);
        ga.append("have a nice day");
        ga.notifyMembers();
        assertEquals("have a nice day",moshe.getStringBuilder().toString());
        assertEquals("have a nice day",yogev.getStringBuilder().toString());
    }
}