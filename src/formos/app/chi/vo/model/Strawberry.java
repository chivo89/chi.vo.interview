package formos.app.chi.vo.model;

import java.util.List;
import java.util.stream.Collectors;

public class Strawberry extends Ingredient {

  public Strawberry(String name, double quantity) {
    super(name, quantity);
  }

  @Override
  public boolean checkIngredientInStore(int quantity, FruitStore fruitStore) {
    List<Ingredient> ingredients = fruitStore.getIngredients();
    Ingredient strawberry = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Strawberry"))
        .collect(Collectors.toList()).get(0);

    if (strawberry.getQuantity() < quantity * 3 * RecipesConstant.FRUIT) {
      double buyStrawberry = (quantity * 3 * RecipesConstant.FRUIT) - strawberry.getQuantity();
      System.out.println("WARN !!! Not enough strawberry to sell strawberry smoothie. \n Need to buy " + buyStrawberry
          + RecipesConstant.GRAM);

      return false;
    }
    return true;
  }

  @Override
  public void sellFruit(int quantity, FruitStore fruitStore) {
    
    if (checkIngredientInStore(quantity, fruitStore)) {
      List<Ingredient> ingredients = fruitStore.getIngredients();
      
      Ingredient strawberry = (Ingredient) ingredients.stream().filter(item -> item.getName().equals("Strawberry"))
          .collect(Collectors.toList()).get(0);
      double sellStrawberry = strawberry.getQuantity() - (quantity * 3 * RecipesConstant.FRUIT);
      strawberry.setQuantity(sellStrawberry);
      fruitStore.viewFruitStore();
    }
  }

  @Override
  public Unit getUnit() {
    return Unit.g;
  }
}
