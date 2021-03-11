package Helpers;

public class Validators {
    final static int PASSWORD_MIN_LENGTH = 5;
    public  static  boolean checkEmptyField(String word){
        return word.trim().length()==0;
    }

    // method to check uniqueness of username //
    public static boolean checkUsernameReplication(String username){
        return !Database.checkItemValueReplication(username);
    }

    public static boolean checkPasswordMinLength(String password){
        return !(password.length()< PASSWORD_MIN_LENGTH );
    }


}
