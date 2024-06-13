

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	private static Logger logger = LogManager.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	logger.trace("trace msg...");
	logger.info("Info test");
	logger.warn("warn test");
	logger.error("warn test");
	}

}
