package formos.app.chi.vo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStore {

  private List<Ingredient> ingredients = new ArrayList<Ingredient>();

  public void initData() {
    ingredients.add(new Sugar("Sugar", 400));
    ingredients.add(new Milk("Milk", 400));
    ingredients.add(new Ice("Ice", 400));
    ingredients.add(new Strawberry("Strawberry", 550));
    ingredients.add(new Mango("Mango", 600));
    ingredients.add(new Banana("Banana", 600));
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public void viewFruitStore() {
    if (ingredients.size() == 0) {
      System.out.println("There are not ingredient in the fruit store");
      return;
    }
    System.out.println(ingredients.stream().map(item -> item.viewDetail()).collect(Collectors.joining("\n")));
  }

}
