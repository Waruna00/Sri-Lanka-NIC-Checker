package sample;
import java.util.regex.Pattern;

public class NIC {
    String format;
    String validity;
    String sex;
    int B_date,B_year,B_month;

    void birthday(int days,boolean YType){
        int feb;
        if (YType){
            feb=29;
        }
        else {
            feb=28;
        }
        for(int i=1; i<13;i++){
            if (days>0){
                if (i<=7){
                    if(i==2){
                        days=days-feb;
                    }
                    else if(i%2==0){
                        days=days-30;
                    }
                    else {
                        days=days-31;
                    }
                }
                else {
                    if(i%2==0){
                        days=days-31;
                    }
                    else {
                        days=days-30;
                    }
                }
            }
            else {
                if(i<=8){
                    if(i==3){
                        setB_date(days+feb);
                    }
                    else if(i%2==0){
                        setB_date(days+31);
                    }
                    else {
                        setB_date(days+30);
                    }
                }
                else {
                    if(i%2==0){
                        setB_date(days+30);
                    }
                    else {
                        setB_date(days+31);
                    }
                }
                setB_month(i-1);
                break;
            }
        }
    }

    void sexuality(String format,String id){
        int IntDate,b_year;
        boolean YType;
        String StrDate;

        if(format.equals("New")){
            b_year = Integer.parseInt(String.valueOf(id.charAt(0)) + id.charAt(1) + id.charAt(2) + id.charAt(3));
            StrDate = String.valueOf(id.charAt(4))+ id.charAt(5) + id.charAt(6);
        }
        else{
            b_year = Integer.parseInt("19"+ id.charAt(0) + id.charAt(1));
            StrDate = String.valueOf(id.charAt(2))+ id.charAt(3) + id.charAt(4);
        }

        IntDate =Integer.parseInt(StrDate);
        setB_year(b_year);
        YType = (b_year %4==0);

        if(IntDate>500){
            setSex("Female");
            birthday(IntDate-500,YType);
        }
        else if(IntDate<500){
            setSex("Male");
            birthday(IntDate,YType);
        }
        else {
            setValidity("Invalid");
        }
    }


    void FormatChecker(String id){
        int size=id.length();
        if (size == 10){
            setFormat("Old");
            if(Pattern.matches("[1-9][0-9]{8}[vVxX]" ,id)) {
                setValidity("Valid");
                sexuality(format,id);
            }
            else {
                setValidity("Invalid");
            }


        }
        else if(size==12){
            setFormat("New");
            if (Pattern.matches("[1-9][0-9]{11}" ,id)){
                setValidity("Valid");
                sexuality(format,id);
            }
            else {
                setValidity("Invalid");
            }

        }
        else {
            setValidity("Invalid");
        }
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setB_date(int b_date) {
        if(b_date<=31){
            B_date = b_date;
        }
        else {
            setValidity("Invalid");
        }

    }

    public void setB_month(int b_month) {
        if (b_month<=12){
            B_month = b_month;
        }
        else {
            setValidity("Invalid");
        }

    }

    public void setB_year(int b_year) {
        B_year = b_year;
    }

    public int getB_date() {
        return B_date;
    }

    public int getB_month() {
        return B_month;
    }

    public int getB_year() {
        return B_year;
    }

    public String getFormat() {
        return format;
    }

    public String getSex() {
        return sex;
    }

    public String getValidity() {
        return validity;
    }
}
