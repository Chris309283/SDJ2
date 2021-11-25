package Mine;

import java.util.concurrent.ThreadLocalRandom;

public class Mine

{
  public Mine()
  {
  }

  public Valuable mineValuable()
  {
    int ranNumber = ThreadLocalRandom.current().nextInt(0,4+1);
    switch (ranNumber){
      case 0:
        return new Diamond();
      case 1:
        return new GoldNugget();
      case 2:
        return new Jewel();
      case 3:
        return new Ruby();
      default:
        return new WoodenCoin();
    }
  }
}

