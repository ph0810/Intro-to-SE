package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class WorkspaceController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File img1File = new File("images/calendar.png");
        Image img1Image = new Image(img1File.toURI().toString());
        img1.setImage(img1Image);

        File img2File = new File("images/calculator.png");
        Image img2Image = new Image(img2File.toURI().toString());
        img2.setImage(img2Image);

        File img3File = new File("images/eventsB.png");
        Image img3Image = new Image(img3File.toURI().toString());
        img3.setImage(img3Image);
    }
}
