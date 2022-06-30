package formos.app.chi.vo;

import java.util.Scanner;

import formos.app.chi.vo.model.Banana;
import formos.app.chi.vo.model.FruitStore;
import formos.app.chi.vo.model.Ice;
import formos.app.chi.vo.model.Mango;
import formos.app.chi.vo.model.Milk;
import formos.app.chi.vo.model.Strawberry;
import formos.app.chi.vo.model.Sugar;

/**
 * Sell smoothie fruit
 *
 */
public class App {
  public static void main(String[] args) {
    FruitStore fruitStore = new FruitStore();
    fruitStore.initData();

    int option = -1;
    while (option != 0) {
      mainMenu();
      option = parseInput();
      switch (option) {
        case 0:
          // quit application
          break;
        case 1:
          fruitStore.viewFruitStore();
          break;
        case 2:
          sellSmoothie(fruitStore);
          break;
        case 3:
          checkFourSmoothie(fruitStore);
          break;
        default:
          System.out.println("Incorrect !!!, Please choose in the menu");
      }
    }

  }

  private static void checkFourSmoothie(FruitStore fruitStore) {
     int quantity = 4;
     Ice ice = new Ice("Ice", quantity);
     Milk milk = new Milk("Milk", quantity);
     Sugar sugar = new Sugar("Sugar", quantity);
     Strawberry strawberry = new Strawberry("Strawberry", quantity);
     Mango mango = new Mango("Mango", quantity);
     Banana banana = new Banana("Banana", quantity);
     
     boolean checkStrawberry = strawberry.checkIngredientInStore(quantity, fruitStore);
     boolean checkBanana = banana.checkIngredientInStore(quantity, fruitStore);
     boolean checkMango = mango.checkIngredientInStore(quantity, fruitStore);
     
     boolean checkIce = ice.checkIngredientInStore(quantity, fruitStore);
     boolean checkSugar = sugar.checkIngredientInStore(quantity, fruitStore);
     boolean checkMilk = milk.checkIngredientInStore(quantity, fruitStore);
     if (checkStrawberry && checkBanana && checkMango && checkIce && checkMilk && checkSugar) {
     System.out.println("The fruit store can make 4 smoothies for each flavors");
     } else {
     System.out.println("WARN !!! Please buy more flavor.!!!!!!");
     }
  }

  private static void sellSmoothie(FruitStore fruitStore) {
    int option = -1;
    while (option != 4) {
      // Fruit fruit;
      smoothieMenu();
      option = parseInput();
      switch (option) {
        case 1:
          System.out.println("Please enter quantity: ");
          int strawberryQuantity = parseInput();
          Strawberry strawberry = new Strawberry("Strawberry", strawberryQuantity);
          Ice ice = new Ice("Ice", strawberryQuantity);
          Milk milk = new Milk("Milk", strawberryQuantity);
          Sugar sugar = new Sugar("Sugar", strawberryQuantity);
          sellStrawberry(strawberryQuantity, fruitStore, ice, milk, sugar, strawberry);
          break;
        case 2:
          System.out.println("Please enter quantity: ");
          int bananaQuantity = parseInput();
          Banana banana = new Banana("Banana", bananaQuantity);
          Ice ice1 = new Ice("Ice", bananaQuantity);
          Milk milk1 = new Milk("Milk", bananaQuantity);
          Sugar sugar1 = new Sugar("Sugar", bananaQuantity);
          sellBanana(bananaQuantity, fruitStore, ice1, milk1, sugar1, banana);
          break;
        case 3:
          System.out.println("Please enter quantity: ");
          int mangoQuantity = parseInput();
          Mango mango = new Mango("Mango", mangoQuantity);
          Ice ice2 = new Ice("Ice", mangoQuantity);
          Milk milk2 = new Milk("Milk", mangoQuantity);
          Sugar sugar2 = new Sugar("Sugar", mangoQuantity);
          sellMango(mangoQuantity, fruitStore, ice2, milk2, sugar2, mango);
          break;
        // Back to main menu
        case 4:
          break;
        default:
          System.out.println("Incorrect !!!, Please choose in the menu");
      }
    }

  }

  private static void sellStrawberry(int quantity, FruitStore fruitStore, Ice ice, Milk milk, Sugar sugar,
      Strawberry strawberry) {
    ice.sellFruit(quantity, fruitStore);
    milk.sellFruit(quantity, fruitStore);
    sugar.sellFruit(quantity, fruitStore);
    strawberry.sellFruit(quantity, fruitStore);

  }
  
  private static void sellMango(int quantity, FruitStore fruitStore, Ice ice, Milk milk, Sugar sugar,
      Mango mango) {
    ice.sellFruit(quantity, fruitStore);
    milk.sellFruit(quantity, fruitStore);
    sugar.sellFruit(quantity, fruitStore);
    mango.sellFruit(quantity, fruitStore);

  }
  
  private static void sellBanana(int quantity, FruitStore fruitStore, Ice ice, Milk milk, Sugar sugar,
      Banana banana) {
    ice.sellFruit(quantity, fruitStore);
    milk.sellFruit(quantity, fruitStore);
    sugar.sellFruit(quantity, fruitStore);
    banana.sellFruit(quantity, fruitStore);

  }

  private static void mainMenu() {
    System.out.println("\n");
    System.out.println("======================================================");
    System.out.println("1. View fruit store");
    System.out.println("2. Sell smoothie");
    System.out.println("3. Check Sell four smoothie");
    System.out.println("0. Exit");
    System.out.println("Please choose option: ");
  }

  private static void smoothieMenu() {
    System.out.println("\n");
    System.out.println("1. Strawberry: ");
    System.out.println("2. Banana: ");
    System.out.println("3. Mango: ");
    System.out.println("4. Back menu: ");
    System.out.println("Please choose smoothie: ");
  }

  private static String scanInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private static int parseInput() {
    try {
      return Integer.parseInt(scanInput());
    } catch (Exception ignore) {
    }
    return -1;
  }

}
