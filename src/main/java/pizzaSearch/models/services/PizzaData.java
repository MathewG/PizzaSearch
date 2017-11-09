package pizzaSearch.models.services;

public class PizzaData {
    private float pizzaNote;
    private String pizzaAdres;
    private String pizzaName;

    public PizzaData(String pizzaName, String pizzaAdres, float pizzaNote) {
        this.pizzaAdres = pizzaAdres;
        this.pizzaNote = pizzaNote;
        this.pizzaName = pizzaName;
    }

    public float getPizzaNote() {
        return pizzaNote;
    }

    public void setPizzaNote(float pizzaNote) {
        this.pizzaNote = pizzaNote;
    }

    public String getPizzaAdres() {
        return pizzaAdres;
    }

    public void setPizzaAdres(String pizzaAdres) {
        this.pizzaAdres = pizzaAdres;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    @Override
    public String toString() {
        return "PizzaData{" +
                "pizzaNote=" + pizzaNote +
                ", pizzaAdres='" + pizzaAdres + '\'' +
                ", pizzaName='" + pizzaName + '\'' +
                '}';
    }
}
