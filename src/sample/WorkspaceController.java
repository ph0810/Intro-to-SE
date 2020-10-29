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
    @FXML
    private ImageView img12;

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

        File img4File = new File("images/familyB.png");
        Image img4Image = new Image(img4File.toURI().toString());
        img4.setImage(img4Image);

        File img5File = new File("images/search.png");
        Image img5Image = new Image(img5File.toURI().toString());
        img5.setImage(img5Image);

        File img6File = new File("images/rollback.png");
        Image img6Image = new Image(img6File.toURI().toString());
        img6.setImage(img6Image);

        File img7File = new File("images/add.png");
        Image img7Image = new Image(img7File.toURI().toString());
        img7.setImage(img7Image);

        File img8File = new File("images/deleteB.png");
        Image img8Image = new Image(img8File.toURI().toString());
        img8.setImage(img8Image);

        File img9File = new File("images/editB.png");
        Image img9Image = new Image(img9File.toURI().toString());
        img9.setImage(img9Image);

        File img10File = new File("images/list.png");
        Image img10Image = new Image(img10File.toURI().toString());
        img10.setImage(img10Image);

        File img11File = new File("images/calendar.png");
        Image img11Image = new Image(img11File.toURI().toString());
        img11.setImage(img11Image);

        File img12File = new File("images/statistics.png");
        Image img12Image = new Image(img12File.toURI().toString());
        img12.setImage(img12Image);
    }
}
