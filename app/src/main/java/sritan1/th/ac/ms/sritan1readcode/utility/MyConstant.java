package sritan1.th.ac.ms.sritan1readcode.utility;

/**
 * Created by asus on 3/22/2018.
 */

public class MyConstant {

    //    About URL
    private String urlGetAllUserString = "http://androidthai.in.th/mar/getAllUser.php";
    private String urlPostUserString = "http://androidthai.in.th/mar/postUser.php";

    //    About Array
    private String[] loginStrings = new String[]{"id", "Name", "User", "Password"};

    public String[] getLoginStrings() {
        return loginStrings;
    }

    public String getUrlGetAllUserString() {
        return urlGetAllUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
} // Main Class

