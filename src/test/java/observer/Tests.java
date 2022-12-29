package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin ga = new GroupAdmin();
        ConcreteMember moshe = new ConcreteMember();
        ConcreteMember david = new ConcreteMember();
        ConcreteMember yossi = new ConcreteMember();

        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.jvmInfo());
        ga.register(moshe);
        ga.register(david);
        ga.register(yossi);
        // stub method to check external dependencies compatibility


        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.memoryStats(moshe));
        logger.info(() -> JvmUtilities.memoryStats(yossi));logger.info(() -> JvmUtilities.memoryStats(david));

        ga.append("yom tov");
        ga.notifyMembers();
        logger.info(()-> JvmUtilities.objectFootprint(moshe,yossi,david));
        ga.insert(7," gver");
        ga.notifyMembers();
        logger.info(()-> JvmUtilities.objectFootprint(moshe,yossi,david));

        ga.undo();
        ga.notifyMembers();

        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.memoryStats(moshe));
        logger.info(() -> JvmUtilities.memoryStats(yossi));logger.info(() -> JvmUtilities.memoryStats(david));

       logger.info(() -> JvmUtilities.jvmInfo());

    }
}
class GroupAdminTest {


    @Test
    void testRegister() {
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
    void testInsert() {
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
