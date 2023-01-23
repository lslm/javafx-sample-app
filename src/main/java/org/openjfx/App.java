package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TextField val1TextField = new TextField();
        TextField val2TextField = new TextField();
        HBox valuesInputs = new HBox(val1TextField, val2TextField);

        Text resultText = new Text("Clique em um botão para ver o resultado");

        Button sumButton = new Button("Somar");
        sumButton.setOnAction(event -> {
            var val1 = Integer.parseInt(val1TextField.getText());
            var val2 = Integer.parseInt(val2TextField.getText());

            int result = val1 + val2;

            resultText.setText("O resultado da soma é: " + result);
        });

        Button subtractionButton = new Button("Subtrair");
        subtractionButton.setOnAction(action -> {
            var val1 = Integer.parseInt(val1TextField.getText());
            var val2 = Integer.parseInt(val2TextField.getText());

            int result = val1 - val2;

            resultText.setText("O resultado da subtração é: " + result);
        });

        Button multiplicationButton = new Button("Multiplicar");
        multiplicationButton.setOnAction(action -> {
            var val1 = Integer.parseInt(val1TextField.getText());
            var val2 = Integer.parseInt(val2TextField.getText());

            int result = val1 * val2;

            resultText.setText("O resultado da multiplicação é: " + result);
        });

        Button divisionButton = new Button("Dividir");
        divisionButton.setOnAction(action -> {
            var val1 = Integer.parseInt(val1TextField.getText());
            var val2 = Integer.parseInt(val2TextField.getText());

            if (val2 == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Impossível dividir por 0");
                alert.show();
            } else {
                int result = val1 / val2;
                resultText.setText("O resultado da divisão é: " + result);
            }
        });

        HBox buttons = new HBox(sumButton, subtractionButton, multiplicationButton, divisionButton);

        HBox results = new HBox(resultText);

        VBox vBox = new VBox(valuesInputs, buttons, results);

        var scene = new Scene(vBox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}