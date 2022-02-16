public class CookieBaker implements Runnable
{
  private CookieJar cookieJar;
  private String typeOfCookie;

  public CookieBaker(CookieJar cookieJar, String typeOfCookie)
  {
    this.cookieJar = cookieJar;
    this.typeOfCookie = typeOfCookie;
  }

  @Override public void run()
  {
    while (true)
    {
    /*  cookieJar.startBaking();
      spendSomeTime("Waiting for cookies to bake.",1000,2000);
      cookieJar.*/
    }
  }
}
