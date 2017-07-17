package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sun.plugin.com.Utils;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    //adnotacja to dane o danych w kodzie
    //klsa anonimowa bez przekazania instancji
    @FXML
    private Button buttonHello;

    @FXML
    private Label labelWords;

    @FXML
    private TextField editText;

    @FXML
    private Button buttonAdd;

    private List<String> words;
    private List<String> randedWords = new ArrayList<>();

    private Random random;

    Utils.createDialog("Witaj", "Nie zapomnij o koncie premium")


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        words = new ArrayList<>();
        words.add("Życie jest piękne");
        words.add("Hadsdsad");
        random = new Random();

        buttonHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        buttonAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                words.add(editText.getText());
                editText.clear();
            }
        });

        editText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER ){
                    words.add(editText.getText());
                    editText.clear();
                }
            }
        });
    }

    private void handleKeyPressed(KayEvent e) {
        if (e.getCode() == KayCode.ENTER) {
            words.e
        }
    }
    private void handleButtonAdd(MouseEvent e){
        words.add(editText.getText());
        editText.clear();
    }


    public void handleRandomSentence(MouseEvent e){
        String randedWord = words.get(random.nextInt(words.size()));
        while (randedWords.contains(randedWord)) {
            randedWord = words.get(random.nextInt(words.size()));
            if (randedWords.size() == words.size()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Uwaga!");
                alert.setContentText("Skończyły się sentencje");
                alert.setHeaderText("Uwaga uwaga");
                alert.show();

                return;
            }
        }
        labelWords.setText(randedWord);
        randedWords.add(randedWord);
    }
}
