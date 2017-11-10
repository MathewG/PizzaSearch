package pizzaSearch.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pizzaSearch.models.utils.Confing;
import pizzaSearch.models.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {
    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getService() {
        return ourInstance;
    }

    private List<PizzaObserver> observers;

    public PizzaService() {
        observers = new ArrayList<>();
    }

    public void registerObserver(PizzaObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(PizzaData data){
        for (PizzaObserver observer : observers) {
            observer.onPizzaObserver(data);
        }
    }


    public void makeCall(String city, String choosen){
  //  HttpUtils.makeHttpRequest(Confing.URL_ID + "Cracow" + "&key=" + Confing.API_ID); //aby wywołać JSONa należy wywołać tę metodę (utworzyć obiekt tej klasy i odpalić w nim tę metodę)
parseJsonData(HttpUtils.makeHttpRequest(Confing.URL_ID + choosen +"+in+"+ city + "&key=" + Confing.API_ID));

    }

private void parseJsonData(String text){
    JSONObject root = new JSONObject(text);
    JSONArray main = root.getJSONArray("results");
float note = 0;
float maxnote = 0;
    JSONObject pizzerias;

    String pizzaName = " ";
    String pizzaAdres = " ";

    for (int i = 0; i < main.length(); i++){

        pizzerias = main.getJSONObject(i);

        note = pizzerias.getFloat("rating");

        if (note>maxnote){
            maxnote = note;
            pizzaAdres = pizzerias.getString("formatted_address");
            pizzaName = pizzerias.getString("name");

        }

    }
    PizzaData pizzaData = new PizzaData();
    pizzaData.setPizzaName(pizzaName);
    pizzaData.setPizzaAdres(pizzaAdres);
    pizzaData.setPizzaNote(maxnote);
    notifyObservers(pizzaData);





}


}
