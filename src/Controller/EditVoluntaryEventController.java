package Controller;

import Dao.VE_Citizen;
import Dao.VoluntaryEventService;
import Model.VoluntaryEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class EditVoluntaryEventController implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private TextField nameTF;
    @FXML
    private TextArea noteTA;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<VE_Citizen, Integer> idCol;
    @FXML
    private TableColumn<VE_Citizen, String> nameCol;
    @FXML
    private TableColumn<VE_Citizen, Integer> moneyCol;
    @FXML
    private TableColumn<VE_Citizen, String> noteCol;

    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private Button update;

    public static ObservableList<VE_Citizen> veCitizens;
    public static VE_Citizen selected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save.setDefaultButton(true);
        cancel.setCancelButton(true);
        VoluntaryEvent voluntaryEvent = VE_WorkspaceController.selected;
        idLabel.setText(String.valueOf(voluntaryEvent.getId()));
        nameTF.setText(voluntaryEvent.getName());
        noteTA.setText(voluntaryEvent.getNote());
        if(voluntaryEvent.getDate1() != null) {
            datePicker1.setValue(LocalDate.parse(voluntaryEvent.getDate1().toString()));
        }
        if(voluntaryEvent.getDate2() != null) {
            datePicker2.setValue(LocalDate.parse(voluntaryEvent.getDate2().toString()));
        }

        veCitizens = FXCollections.observableArrayList();
        List<VE_Citizen> list = VE_Citizen.getDataFromVEId(voluntaryEvent.getId());
        for(var i : list) {
            veCitizens.add(i);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<VE_Citizen, Integer>("MaHo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<VE_Citizen, String>("tenChuHo"));
        moneyCol.setCellValueFactory(new PropertyValueFactory<VE_Citizen, Integer>("soTien"));
        noteCol.setCellValueFactory(new PropertyValueFactory<VE_Citizen, String>("ghiChu"));
        tableView.setItems(veCitizens);
    }

    @FXML
    public void cancelOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void saveOnAction(javafx.event.ActionEvent event) {
        VoluntaryEvent voluntaryEvent = new VoluntaryEvent();
        voluntaryEvent.setId(Integer.parseInt(idLabel.getText()));
        voluntaryEvent.setName(nameTF.getText());
        if(datePicker1.getValue() != null) {
            voluntaryEvent.setDate1(java.sql.Date.valueOf(datePicker1.getValue()));
        }
        if(datePicker2.getValue() != null) {
            voluntaryEvent.setDate2(java.sql.Date.valueOf(datePicker2.getValue()));
        }
        voluntaryEvent.setNote(noteTA.getText());
        VE_WorkspaceController.voluntaryEventsList.remove(VE_WorkspaceController.selected);
        VE_WorkspaceController.voluntaryEventsList.add(voluntaryEvent);
        VoluntaryEventService.edit(voluntaryEvent);
        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void updateOnAction(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Bạn cần chọn hộ gia đình muốn cập nhật số tiền");
            alert.show();
            return;
        }
        selected = (VE_Citizen) tableView.getSelectionModel().getSelectedItem();
        Stage stage = new Stage();
        Parent tableViewParent = null;
        try {
            stage.setTitle("Cập nhật, chỉnh sửa dữ liệu");
            tableViewParent = FXMLLoader.load(getClass().getResource("../View/EditVE_Citizen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);

        stage.setScene(tableViewScene);
        stage.show();
    }
}
