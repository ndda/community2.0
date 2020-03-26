public class MainTest {
    public static void main(String[] args) {
        String str="xx.jkjsdk.jdkajlg.jj";
        String[] strSplit=str.split("\\.");
        for(String string:strSplit){
            System.out.println(string);
        }
    }
}
