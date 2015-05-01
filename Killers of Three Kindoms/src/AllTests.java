import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ai.test.AIActionTestCase;
import com.card.test.CardMainTestCase;
import com.card.test.EquipmentCardTestCase;
import com.card.test.ScrollCardTest;
import com.hero.test.HeroMainTestCase;
import com.logic.test.LogicMainTestCase;
import com.logic.test.LogicPlayerCases;
import com.logic.test.LogicTestCases;
import com.system.test.CardUtilTestcase;
import com.system.test.PlayerUtilTestcase;
import com.system.test.SystemMainTestCase;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	AIActionTestCase.class, 
	CardMainTestCase.class,
	EquipmentCardTestCase.class,
	ScrollCardTest.class,
	HeroMainTestCase.class, 
	LogicMainTestCase.class,
	LogicPlayerCases.class,
	LogicTestCases.class,
	CardUtilTestcase.class,
	PlayerUtilTestcase.class,
	SystemMainTestCase.class})
public class AllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("AllTests");
    }
}
