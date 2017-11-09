package pizzaSearch.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pizzaSearch.models.services.PizzaData;
import pizzaSearch.models.services.PizzaObserver;
import pizzaSearch.models.services.PizzaService;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable, PizzaObserver {

    @FXML
    Label labelPizza;

    @FXML
    TextField textCity;

    @FXML
    Button buttonShow;

    private PizzaService pizzaService = PizzaService.getService();

    public void initialize(URL location, ResourceBundle resources) {
        buttonShow.setOnMouseClicked(e -> showPizza());
        pizzaService.registerObserver(this);

    }

    private void showPizza() {
        pizzaService.makeCall(textCity.getText());
    }

    @Override
    public void onPizzaObserver(PizzaData data) {

        labelPizza.setText("Najlepsza pizza w mieście  "  + data.getPizzaName()+ '\n'
       + "Jej adres to: " + data.getPizzaAdres());

    }


}
