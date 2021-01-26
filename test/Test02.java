import java.lang.invoke.MethodHandles;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test02 {
	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Test
	public void test() {
		int[] o = {1,2,3};
		String result = String.format("Hi %s", o);
		log.info(result);
	}
}
