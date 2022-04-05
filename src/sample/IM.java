package sample;
import java.util.regex.Pattern;

public class IM {
    String validity;
    void validation(String im){
        boolean valid1,valid2,valid3,valid4,valid;
        String[] imList;
        imList=im.split("/");
        if (imList.length!=3){
            setValidity("Invalid");
        }
        else {
            valid1=Pattern.matches("[Ii][Mm]",imList[0]);
            valid2=Pattern.matches("201[9876]",imList[1]);
            valid3=Pattern.matches("[0-9]{3}",imList[2]);
            valid4=!(Pattern.matches("[0]{3}",imList[2]));
            valid=valid1&&valid2&&valid3&&valid4;


            if (valid){
                setValidity("Valid");
            }
            else {
                setValidity("Invalid");
            }
        }
    }


    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValidity() {
        return validity;
    }
}
