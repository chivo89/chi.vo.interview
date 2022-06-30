package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Banana extends Ingredient {

  public Banana(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {
    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient banana = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Banana"))
        .collect(Collectors.toList()).get(0);

    if (banana.getQuantity() < quantity * 120 * 1.5) {
      double buyBanana = (quantity * 120 * 1.5) - banana.getQuantity();
      System.out.println(
          "WARN !!! Not enough banana to sell banana smoothie. \n Need to buy" + buyBanana + RecipesConstant.GRAM);

      return false;
    }
    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();

      Ingredient banana = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Banana"))
          .collect(Collectors.toList()).get(0);
      double sellBanana = banana.getQuantity() - (quantity * 120 * 1.5);
      banana.setQuantity(sellBanana);
      fruitStore.viewFruitStore();
    }

  }

  @Override
  public Unit getUnit() {
    return Unit.g;
  }
}
