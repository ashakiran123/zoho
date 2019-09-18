package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.doli_bar_FWUtil1;
import page.SingInPage;

public class TestLaunch extends BaseTest {
	@Test
	public void testLaunch() throws InterruptedException {
		String un=doli_bar_FWUtil1.getXLData(INPUT_PATH, "TestLaunch",1,0);
		String pw=doli_bar_FWUtil1.getXLData(INPUT_PATH, "TestLaunch",1,1);
		SingInPage s=new SingInPage(driver);
		s.setUserName(un);
		s.setPassword(pw);
		s.clickSingIn();
		Thread.sleep(5000);
	}

}
