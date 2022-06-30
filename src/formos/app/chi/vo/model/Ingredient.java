package formos.app.chi.vo.model;

public abstract class Ingredient {

  public String name;

  public double quantity;
  
  public enum Unit {
    ml, g
  }

  public Ingredient(String name, double quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public abstract boolean checkIngredientInStore(int quantity, FruitStore fruitStore);

  public abstract void sellFruit(int quantity, FruitStore fruitStore);
  
  public abstract Unit getUnit();

  public String viewDetail() {
    return String.format("%s in the fruit store: %s%s", name, quantity, getUnit());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

}
