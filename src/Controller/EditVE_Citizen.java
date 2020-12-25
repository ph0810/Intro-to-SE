package Controller;

import Dao.VE_Citizen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditVE_Citizen implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField moneyTF;
    @FXML
    private TextField noteTF;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idLabel.setText(String.valueOf(EditVoluntaryEventController.selected.getMaHo()));
        nameLabel.setText(EditVoluntaryEventController.selected.getTenChuHo());
        moneyTF.setText(String.valueOf(EditVoluntaryEventController.selected.getSoTien()));
        noteTF.setText(EditVoluntaryEventController.selected.getGhiChu());
    }

    @FXML
    public void cancelOnAction(ActionEvent event) {
        Stage stage = (Stage) idLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void saveOnAction(ActionEvent event) {
        VE_Citizen veCitizen = new VE_Citizen();
        veCitizen.setMaHo(Integer.parseInt(idLabel.getText()));
        veCitizen.setTenChuHo(nameLabel.getText());
        veCitizen.setSoTien(Integer.parseInt(moneyTF.getText()));
        veCitizen.setGhiChu(noteTF.getText());
        VE_Citizen.editVE_Citizen(veCitizen);
        EditVoluntaryEventController.veCitizens.remove(EditVoluntaryEventController.selected);
        EditVoluntaryEventController.veCitizens.add(veCitizen);
        Stage stage = (Stage) idLabel.getScene().getWindow();
        stage.close();
    }
}
