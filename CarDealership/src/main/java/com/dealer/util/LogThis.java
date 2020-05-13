package com.dealer.util;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	public class LogThis {
		
		static Logger Logger=LogManager.getLogger();
		
		public static void LogIt(String level, String message) {
			/* 
			 * debug
			 * warn
			 * error
			 * fatal
			 * info
			 * trace
			 */
			switch(level) {
			case "debug":
				Logger.debug(message);
				break;
			case "warn":
				Logger.warn(message);
				break;
			case "error":
				Logger.error(message);
				break;
			case "fatal":
				Logger.fatal(message);
				break;
			case "info":
				Logger.info(message);
				break;
			case "trace":
				Logger.trace(message);
				break;
			default:
				System.out.println("logger dumb");
				break;	
			}

		}

	

}
