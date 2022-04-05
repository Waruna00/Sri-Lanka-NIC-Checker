package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btn_nic_check,btn_im_check;

    @FXML
    private TextField tf_nic,tf_im;

    @FXML
    private Label lbl_val,lbl_fo,lbl_se,lbl_bi,lbl_im_val;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_nic_check.setOnAction(event -> {
            String id=tf_nic.getText();
            NIC nic =new NIC();
            nic.FormatChecker(id);
            lbl_val.setText(nic.getValidity());
            if (nic.getValidity().equals("Invalid")){
                lbl_bi.setText("--");
                lbl_se.setText("--");
                lbl_fo.setText("--");
            }
            else {
                lbl_bi.setText(nic.getB_year()+"-"+nic.getB_month()+"-"+nic.getB_date());
                lbl_fo.setText(nic.getFormat());
                lbl_se.setText(nic.getSex());
            }
        });
        btn_im_check.setOnAction(event -> {
            lbl_im_val.setText("--");
            String imNo=tf_im.getText();
            IM im =new IM();
            im.validation(imNo);
            lbl_im_val.setText(im.getValidity());
        });
    }
}
