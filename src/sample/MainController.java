package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView addImageView;
    @FXML
    private ImageView eventImageView;
    @FXML
    private ImageView managementImageView;
    @FXML
    private ImageView citizenImageView;
    @FXML
    private ImageView settingImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("images/MenuIconB.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File addFile = new File("images/add.png");
        Image addImage = new Image(addFile.toURI().toString());
        addImageView.setImage(addImage);

        File eventFile = new File("images/events.png");
        Image eventImage = new Image(eventFile.toURI().toString());
        eventImageView.setImage(eventImage);

        File managementFile = new File("images/management.png");
        Image managementImage = new Image(managementFile.toURI().toString());
        managementImageView.setImage(managementImage);

        File citizenFile = new File("images/citizen.png");
        Image citizenImage = new Image(citizenFile.toURI().toString());
        citizenImageView.setImage(citizenImage);

        File settingFile = new File("images/settings.png");
        Image settingImage = new Image(settingFile.toURI().toString());
        settingImageView.setImage(settingImage);
    }
}
