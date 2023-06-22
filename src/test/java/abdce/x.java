package abdce;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.testcases.BaseClass;

public class x extends BaseClass{
	@Test
	public void Skipped()
	{
	 String s="a";
	 
	 String b="a";
		Assert.assertTrue(false);
		logger.info("failed");
		
	}

}
