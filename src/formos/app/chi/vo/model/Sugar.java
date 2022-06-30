package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Sugar extends Ingredient {

  public Sugar(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {
    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient sugar = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Sugar"))
        .collect(Collectors.toList()).get(0);

    if (sugar.getQuantity() < quantity * 3 * RecipesConstant.SUGAR) {
      double buySugar = (quantity * 3 * RecipesConstant.SUGAR) - sugar.getQuantity();
      System.out.println(
          "WARN !!! Not enough sugar to sell smoothie. \n Need to buy " + buySugar + RecipesConstant.GRAM);
      return false;
    }
    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();

      Ingredient sugar = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Sugar"))
          .collect(Collectors.toList()).get(0);
      double sellSugar = sugar.getQuantity() - (quantity * 3 * RecipesConstant.SUGAR);
      sugar.setQuantity(sellSugar);
    }
  }

  @Override
  public Unit getUnit() {
    return Unit.g;
  }

}
