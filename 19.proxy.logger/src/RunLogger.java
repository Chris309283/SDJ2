public class RunLogger
{
  public static void main(String[] args)
  {
    Logger logger = new LogLevelController(LogLevelController.LOG_LEVEL.VERBOSE,new ConsoleLogger());

    logger.log("Warning: Twilight is close");
    logger.log("Warning: mother in law is approaching");
    logger.log("ERROR: Out of cola");
  }
}
