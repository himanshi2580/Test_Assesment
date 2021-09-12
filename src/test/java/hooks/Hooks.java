package hooks;

import commonfunctions.Utils;
import io.cucumber.java.After;

public class Hooks {

	@After
	public void tearDown() {
		Utils.getDriver().quit();
	}
}
