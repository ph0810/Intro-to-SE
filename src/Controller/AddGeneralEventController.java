package Controller;

import Dao.GEService;
import Model.GeneralEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddGeneralEventController implements Initializable {
    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextArea noteTA;
    @FXML
    private TextField moneyTF;
    @FXML
    private Label saveMessageLabel;

    @FXML
    private Button save;
    @FXML
    private Button cancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void cancelButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void saveOnAction(ActionEvent event) {
        if(idTF.getText().isBlank()) {
            saveMessageLabel.setText("ID không được để trống");
            return;
        }
        if(nameTF.getText().isBlank()) {
            saveMessageLabel.setText("Tên khoản thu không được để trống");
            return;
        }
        GeneralEvent generalEvent = new GeneralEvent();
        generalEvent.setId(Integer.parseInt(idTF.getText()));
        generalEvent.setName(nameTF.getText());
        generalEvent.setNote(noteTA.getText());
        generalEvent.setMoney(Integer.parseInt(moneyTF.getText()));
        WorkspaceController.generalEvents.add(generalEvent);
        Stage stage = (Stage) save.getScene().getWindow();
        GEService.add(generalEvent);
        stage.close();
    }
}
