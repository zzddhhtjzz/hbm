% Junit 
% package 
import static org.junit.Assert.*;
public class ConcateTest {
	@Test
	public void testConcatenate() {
		Junit test= new Junit();
		String result=test.concatenate("one","two");
		assertEquals("onetwo",result);
	}
}

