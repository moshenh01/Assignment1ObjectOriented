package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {


    @Test
    void register() {
        GroupAdmin ga = new GroupAdmin();
        ConcreteMember moshe = new ConcreteMember();
        ga.register(moshe);
        assertEquals(moshe,ga.getLastMember());

    }

    @Test
    void unregister() {
        GroupAdmin ga = new GroupAdmin();
        ConcreteMember moshe = new ConcreteMember();
        ga.register(moshe);
        ga.unregister(moshe);
        assertNull(ga.getLastMember());

    }

    @Test
    void insert() {
        GroupAdmin ga = new GroupAdmin();
        ga.append("yom tov");
        ga.insert(7," gver");
        assertEquals("yom tov gver",ga.getStringBuilder().toString());

    }

    @Test
    void append() {
        GroupAdmin ga = new GroupAdmin();
        ga.append("good day");
        assertEquals("good day",ga.getStringBuilder().toString());

    }

    @Test
    void delete() {
        GroupAdmin ga = new GroupAdmin();
        ga.append("good day");
        ga.delete(4,8);
        assertEquals("good",ga.getStringBuilder().toString());

    }

    @Test
    void undo() {
        GroupAdmin ga = new GroupAdmin();
        ga.append("good day");
        ga.delete(4,8);
        ga.undo();
        assertEquals("good day",ga.getStringBuilder().toString());
    }
}