package Controller;

import Dao.VoluntaryEventService;
import Model.VoluntaryEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddVoluntaryEventController implements Initializable {
    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextArea noteTA;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private DatePicker datePicker2;
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
    public void saveOnAction(ActionEvent event) {
        if(idTF.getText().isBlank()) {
            saveMessageLabel.setText("ID không được để trống");
            return;
        }
        if(nameTF.getText().isBlank()) {
            saveMessageLabel.setText("Tên khoản thu không được để trống");
            return;
        }
        VoluntaryEvent voluntaryEvent = new VoluntaryEvent();
        voluntaryEvent.setId(Integer.parseInt(idTF.getText()));
        voluntaryEvent.setName(nameTF.getText());
        if(datePicker1.getValue() != null) {
            voluntaryEvent.setDate1(java.sql.Date.valueOf(datePicker1.getValue()));
        }
        if(datePicker2.getValue() != null) {
            voluntaryEvent.setDate2(java.sql.Date.valueOf(datePicker2.getValue()));
        }
        voluntaryEvent.setNote(noteTA.getText());
        VE_WorkspaceController.voluntaryEventsList.add(voluntaryEvent);
        Stage stage = (Stage) save.getScene().getWindow();
        VoluntaryEventService.add(voluntaryEvent);
        stage.close();
    }

    @FXML
    public void cancelButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

}
