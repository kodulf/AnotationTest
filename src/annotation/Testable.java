package annotation;

import annotation.UseCase;

import java.util.List;

public class Testable {

    public void execute(){
        System.out.println("Executeing..");
    }

//    @Test void testEecute(){
//        execute();
//    }
    @UseCase(id = 1, description = "Password must contain at least one numeric")
    public static boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 2)
    public static String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 3)
    public static boolean checkForNewPassword(List<String> prevPasswords, String password){
        return prevPasswords.contains(password);
    }

    public static void main(String[] args){
        validatePassword("helloworld");
    }
}
