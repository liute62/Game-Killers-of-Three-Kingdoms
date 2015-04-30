import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ai.test.AIActionTestCase;
import com.card.test.CardMainTestCase;
import com.card.test.EquipmentCardTestCase;
import com.card.test.ScrollCardTest;
import com.hero.test.HeroMainTestCase;
import com.logic.test.LogicMainTestCase;
import com.logic.test.LogicTestCases;
import com.system.test.SystemMainTestCase;
import com.system.utils.CardUtilTestcase;
import com.system.utils.PlayerUtilTestcase;



@RunWith(Suite.class)
@Suite.SuiteClasses({AIActionTestCase.class, 
	EquipmentCardTestCase.class,  HeroMainTestCase.class, 
	LogicMainTestCase.class,LogicTestCases.class,
	SystemMainTestCase.class,CardUtilTestcase.class,PlayerUtilTestcase.class})
public class AllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("AllTests");
    }
}
