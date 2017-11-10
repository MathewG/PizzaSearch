package pizzaSearch.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    @FXML

    ListView ListViewChoose;

    private PizzaService pizzaService = PizzaService.getService();

    public void initialize(URL location, ResourceBundle resources) {
        buttonShow.setOnMouseClicked(e -> showPizza());
        pizzaService.registerObserver(this);
        ListViewChoose.getItems().addAll("Pizzeria", "Bar","Restauracja", "Kawiarnia");
        ListViewChoose.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    private void showPizza() {
        String choosen = (String)ListViewChoose.getSelectionModel().getSelectedItem();
        pizzaService.makeCall(textCity.getText(),choosen);
    }



    @Override
    public void onPizzaObserver(PizzaData data) {

        labelPizza.setText("Powinieneś wybrać się do:  "  + data.getPizzaName()+ '\n'
       + "Pod adres: " + data.getPizzaAdres());

    }


}
