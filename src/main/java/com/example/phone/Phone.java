package com.example.phone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Phone extends Application {
    double windowHeight = 600;
    double windowWidth = 300;
    private Button createButton(String buttonText)
    {
        Button button = new Button(buttonText);
        button.setMinWidth(windowWidth / 3);
        button.setMinHeight(windowHeight / 11);
        button.setFont(new Font("Verdana",20));
        button.setTextFill(Color.color(0.9, 0.9, 0.9));
        button.setBackground(new Background(new BackgroundFill(Color.color(0.3, 0.3, 0.3), CornerRadii.EMPTY, Insets.EMPTY)));
        return button;
    }

    private void setDigitButtonAction(Button button, Label text, String digit)
    {
        button.setOnAction( event -> {
            text.setText(text.getText() + digit);
        });
    }

    @Override
    public void start(Stage stage) throws IOException {


        VBox root = new VBox();

        Label text = new Label();
        text.setMinWidth(windowWidth);
        text.setMinHeight(4 * windowHeight / 11);
        text.setFont(new Font(23));
        text.setAlignment(Pos.BOTTOM_RIGHT);
        text.setPadding(new Insets(20, 20, 20, 20));

        HBox buttonText = new HBox(windowWidth / 3);
        buttonText.setMinWidth(windowWidth);
        buttonText.setMinHeight(windowHeight / 11);

        Label okbottonText = new Label("Ok");
        okbottonText.setMinWidth(windowWidth / 3);
        okbottonText.setMinHeight(1 * windowHeight / 11);
        okbottonText.setFont(new Font("Verdana",20));
        okbottonText.setPadding(new Insets(10, 10, 10, 10));
        okbottonText.setAlignment(Pos.CENTER_LEFT);

        Label cancelbottonText = new Label("Cancel");
        cancelbottonText.setMinWidth(windowWidth / 3);
        cancelbottonText.setMinHeight(1 * windowHeight / 11);
        cancelbottonText.setFont(new Font("Verdana",20));
        cancelbottonText.setPadding(new Insets(10, 10, 10, 10));
        cancelbottonText.setAlignment(Pos.CENTER_RIGHT);

        buttonText.getChildren().addAll(okbottonText, cancelbottonText);

        HBox row1 = new HBox();
        Button okButton = createButton("---");
        Button upButton = createButton("/\\");
        Button canselButton = createButton("---");
        row1.getChildren().addAll(okButton, upButton, canselButton);

        HBox row2 = new HBox();
        Button callButton = createButton("Accept");
        callButton.setTextFill(Color.color(0.11, 0.81, 0.0));
        Button downButton = createButton("\\/");
        Button endCallButton = createButton("Decline");
        endCallButton.setTextFill(Color.color(0.88, 0.0, 0.0));
        row2.getChildren().addAll(callButton, downButton, endCallButton);

        HBox row3 = new HBox();
        Button button1 = createButton("1");
        Button button2 = createButton("2");
        Button button3 = createButton("3");
        row3.getChildren().addAll(button1, button2, button3);

        HBox row4 = new HBox();
        Button button4 = createButton("4");
        Button button5 = createButton("5");
        Button button6 = createButton("6");
        row4.getChildren().addAll(button4, button5, button6);

        HBox row5 = new HBox();
        Button button7 = createButton("7");
        Button button8 = createButton("8");
        Button button9 = createButton("9");
        row5.getChildren().addAll(button7, button8, button9);

        HBox row6 = new HBox();
        Button starButton = createButton("*");
        Button button0 = createButton("0");
        Button hashButton = createButton("#");
        row6.getChildren().addAll(starButton, button0, hashButton);

        root.getChildren().addAll(text, buttonText, row1, row2, row3, row4, row5, row6);

        setDigitButtonAction(button1, text, "1");
        setDigitButtonAction(button2, text, "2");
        setDigitButtonAction(button3, text, "3");
        setDigitButtonAction(button4, text, "4");
        setDigitButtonAction(button5, text, "5");
        setDigitButtonAction(button6, text, "6");
        setDigitButtonAction(button7, text, "7");
        setDigitButtonAction(button8, text, "8");
        setDigitButtonAction(button9, text, "9");
        setDigitButtonAction(starButton, text, "*");
        setDigitButtonAction(button0, text, "0");
        setDigitButtonAction(hashButton, text, "#");

        canselButton.setOnAction(event -> {
            String currentText = text.getText();
            text.setText((currentText == null || currentText.length() == 0)
                    ? ""
                    : (currentText.substring(0, currentText.length() - 1)));
        });

        callButton.setOnAction(event -> {
            String currentNumber = text.getText();
            text.setText("Calling " + currentNumber + " . . .");
        });

        endCallButton.setOnAction(event -> {
            text.setText("");
        });

        Scene scene = new Scene(root, windowWidth, windowHeight);
        stage.setTitle("Old phone!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
