package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ice extends Ingredient {

  public Ice(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {
    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient ice = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Ice"))
        .collect(Collectors.toList()).get(0);

    if (ice.getQuantity() < quantity * 3 * RecipesConstant.ICE) {
      double buyIce = (quantity * 3 * RecipesConstant.ICE) - ice.getQuantity();
      System.out.println(
          "WARN !!! Not enough ice to sell smoothie. \n Need to buy " + buyIce + RecipesConstant.ML);
      return false;
    }
    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();
      
      Ingredient ice = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Ice"))
          .collect(Collectors.toList()).get(0);
      double sellIce = ice.getQuantity() - (quantity * 3 * RecipesConstant.ICE);
      ice.setQuantity(sellIce);
    }
  }

  @Override
  public Unit getUnit() {
    return Unit.ml;
  }

}
