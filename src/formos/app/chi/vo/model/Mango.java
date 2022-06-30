package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Mango extends Ingredient {
  
  public Mango(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {

    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient mango = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Mango"))
        .collect(Collectors.toList()).get(0);

    if (mango.getQuantity() < quantity * 140 * 1.5) {
      double buyMango = (quantity * 140 * 1.5) - mango.getQuantity();
      System.out
          .println("WARN !!! Not enough mango to sell mango smoothie. \n Need to buy" + buyMango + RecipesConstant.GRAM);
      return false;
    }

    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();
      
      Ingredient mango = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Mango"))
          .collect(Collectors.toList()).get(0);
      double sellMango = mango.getQuantity() - (quantity * 140 * 1.5);
      mango.setQuantity(sellMango);
      fruitStore.viewFruitStore();
    }
  }

  @Override
  public Unit getUnit() {
    return Unit.g;
  }
}
