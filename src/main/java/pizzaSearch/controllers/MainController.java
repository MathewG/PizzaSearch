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


public class MainController implements Initializable, PizzaObserver{


    @FXML
    Label labelPizza;

    @FXML
    TextField textCity;

    @FXML
    Button buttonShow;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void PizzaObserver(PizzaData data) {

    }
}
