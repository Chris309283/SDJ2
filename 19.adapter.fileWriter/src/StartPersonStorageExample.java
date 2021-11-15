public class StartPersonStorageExample
{
  public static void main(String[] args)
  {
    FilePersonStorage storage = new FilePersonStorage();
    UIPersonStorage uiPersonStorage = new UIPersonStorage(storage);
    uiPersonStorage.startUI();
  }
}
