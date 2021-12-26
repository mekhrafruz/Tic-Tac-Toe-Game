package com.example.firstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button butA;

    @FXML
    private Button butB;

    @FXML
    private Button butC;

    @FXML
    private Button butD;

    @FXML
    private Button butE;

    @FXML
    private Button butF;

    @FXML
    private Button butG;

    @FXML
    private Button butH;

    @FXML
    private Button butI;

    @FXML
    private Text mainTic;

    private int playerTurn = 0;

    ArrayList<Button> buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(butA,butB,butC,butD,butE,butF,butG,butH,butI));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void resetGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        mainTic.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> butA.getText() + butB.getText() + butC.getText();
                case 1 -> butD.getText() + butE.getText() + butF.getText();
                case 2 -> butG.getText() + butH.getText() + butI.getText();
                case 3 -> butA.getText() + butE.getText() + butI.getText();
                case 4 -> butC.getText() + butE.getText() + butG.getText();
                case 5 -> butA.getText() + butD.getText() + butG.getText();
                case 6 -> butB.getText() + butE.getText() + butH.getText();
                case 7 -> butC.getText() + butG.getText() + butI.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                mainTic.setText("X won!");
            }

            //O winner
            else if (line.equals("OOO")) {
                mainTic.setText("O won!");
            }
        }
    }
}