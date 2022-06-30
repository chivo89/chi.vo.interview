package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Milk extends Ingredient {

  public Milk(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {
    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient milk = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Milk"))
        .collect(Collectors.toList()).get(0);

    if (milk.getQuantity() < quantity * 3 * RecipesConstant.MILK) {
      double buyMilk = (quantity * 3 * RecipesConstant.MILK) - milk.getQuantity();
      System.out.println(
          "WARN !!! Not enough milk to sell smoothie. \n Need to buy " + buyMilk + RecipesConstant.ML);
      return false;
    }
    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();

      Ingredient milk = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Milk"))
          .collect(Collectors.toList()).get(0);
      double sellMilk = milk.getQuantity() - (quantity * 3 * RecipesConstant.MILK);
      milk.setQuantity(sellMilk);
    }
  }

  @Override
  public Unit getUnit() {
    return Unit.ml;
  }

}
