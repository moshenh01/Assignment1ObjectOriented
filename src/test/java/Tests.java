import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        logger.info(()->JvmUtilities.objectFootprint(moshe,yossi,david));
        ga.insert(7," gver");
        ga.notifyMembers();
        logger.info(()->JvmUtilities.objectFootprint(moshe,yossi,david));

        ga.undo();
        ga.notifyMembers();

        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.memoryStats(moshe));
        logger.info(() -> JvmUtilities.memoryStats(yossi));logger.info(() -> JvmUtilities.memoryStats(david));

       logger.info(() -> JvmUtilities.jvmInfo());

    }
}
