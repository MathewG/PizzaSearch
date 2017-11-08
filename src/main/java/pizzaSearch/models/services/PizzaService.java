package pizzaSearch.models.services;

import pizzaSearch.models.utils.Confing;
import pizzaSearch.models.utils.HttpUtils;

public class PizzaService {
    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getInstance() {
        return ourInstance;
    }

    private PizzaService() {
    }

    public void makeCall(String city){
       HttpUtils.makeHttpRequest(Confing.URL_ID + "Cracow" + "&key=" + Confing.API_ID);
    }

private void parseJsonData(String text){


}


}
