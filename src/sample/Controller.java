package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class Controller {

   @FXML
   public javafx.scene.control.TextField TextField;
   @FXML
   public Text txt1;

   @FXML
   public TextArea WindowChat;

   @FXML
   public Text txt2;

   @FXML
    public void clickBtn1(ActionEvent actionEvent) {
        System.out.println("Привет!");
        actionEvent.getEventType();
        Map<String ,String> map = new HashMap<>();

    }

    /*public void Btn2(ActionEvent actionEvent) {
        TextAr1.appendText("hello! \n");
    }*/
@FXML
    public void Add(ActionEvent actionEvent) {
        WindowChat.appendText(TextField.getText()+"\n");
        TextField.clear();
        TextField.requestFocus();
    }
@FXML
    public void Clear(ActionEvent actionEvent) {
        WindowChat.clear();
    }
}
