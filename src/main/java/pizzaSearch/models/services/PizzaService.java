package pizzaSearch.models.services;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {

    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getService() {
        return ourInstance;
    }




}
