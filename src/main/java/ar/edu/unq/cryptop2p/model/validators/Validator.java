package ar.edu.unq.cryptop2p.model.validators;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static int minPasswordLength = 6;
    private static int maxPasswordLength = 30;
    private static String passwordExpetionMessage = "Invalid password format.";
    private static int minLength = 3;
    private static int maxLength = 30;
    private static int cvuLength = 22;
    private static int cryptoAddressLength = 8;
    private static int minAddressLenght = 10;
    private static int maxAddressLenght = 30;

    public static boolean validateLenght(String aString, int minLength, int maxLength)
    {
        boolean isValid = aString.length() >= minLength && aString.length() <= maxLength;
        if(!isValid)
        {
            passwordExpetionMessage += MessageFormat.format(" Incorrect length must be between {0} and {1}.", minLength, maxLength);
        }

        return isValid;
    }

    //region Email

    public static boolean validEmail(String aEmail)
    {
        return validateAtSign(aEmail) && validateDotCom(aEmail) && validateCharBeforeAtSign(aEmail);
    }

    private  static boolean validateAtSign(String aEmail)
    {
        return aEmail.contains("@");
    }

    private static boolean validateDotCom(String aEmail)
    {
        return aEmail.contains(".com");
    }

    private static boolean validateCharBeforeAtSign(String aEmail) throws StringIndexOutOfBoundsException
    {
        int atSignIndex = aEmail.indexOf("@");
        try
        {
            char character = aEmail.charAt(atSignIndex - 1);
        }
        catch (Exception ex)
        {
            return false;
        }

        return true;
    }

    //endregion

    //region password
    public static boolean validatePassword(String aPassword)
    {
        return hasAtLeastOneLowerCase(aPassword) & hasAtLeastOneUpperCase(aPassword) & hasSpecialCharacter(aPassword) & validateLenght(aPassword, minPasswordLength, maxPasswordLength);
    }

    public static String getPasswordExpetionMessage()
    {
        String msg = passwordExpetionMessage;
        passwordExpetionMessage = "Invalid password format.";
        return msg;
    }



    private static boolean hasAtLeastOneLowerCase(String aPassword)
    {
        String upperCase = aPassword.toUpperCase();
        boolean valid = !upperCase.equals(aPassword);

        if(!valid)
        {
            passwordExpetionMessage += " At least one valid lowercase is needed.";
        }

        // si son distintas significa que tiene por lo menos una miniscula
        return valid;
    }

    private static boolean hasAtLeastOneUpperCase(String aPassword)
    {
        String lowerCase = aPassword.toLowerCase();
        boolean valid = !lowerCase.equals(aPassword);//si la frase en minusculas no es igual a la frase original significa que por lo menos tiene una mayuscula
        if(!valid)
        {
            passwordExpetionMessage += " At least one valid uppercase is needed.";
        }
        return  valid;
    }

    private static boolean hasSpecialCharacter(String aPassword)
    {
        // otra forma : aPassword.contains("?") && aPassword.contains("¿")... etc
        Pattern special = Pattern.compile ("[?!¡@¿.,´)#_]");
        Matcher hasSpecial = special.matcher(aPassword);

        boolean isValid = hasSpecial.find();

        if(!isValid)
        {
            passwordExpetionMessage += " At least one special character is needed.";
        }
        return isValid;
    }

    //endregion

    //region name
    public static boolean validateNameLenght(String aName)
    {
        return validateLenght(aName, minLength, maxLength);
    }

    public static int minNameLenght()
    {
        return minLength;
    }

    public static int maxNameLenght()
    {
        return maxLength;
    }
    //endregion

    //region lastname
    public static int minLastNameLength()
    {
        return minLength;
    }

    public static int maxLastNameLength()
    {
        return maxLength;
    }

    public static boolean validateAddressLenght(String aAddress)
    {
        return validateLenght(aAddress, minAddressLenght, maxAddressLenght);
    }

    public static String addressExceptionMessage()
    {
        return MessageFormat.format("Incorrect length must be between {0} and {1}.", minAddressLenght, maxAddressLenght);
    }

    public static boolean validateLastNameLenght(String aLastName)
    {
        return validateLenght(aLastName, minLength, maxLength);
    }
    //endregion

    //region CVU
    public static boolean validateCvuLength(String aCvu)
    {
        return validateLenght(aCvu, cvuLength, cvuLength);
    }
    //endregion

    public static boolean validateCrytoAddress(String aCryptoAddress)
    {
        return validateLenght(aCryptoAddress, cryptoAddressLength, cryptoAddressLength);
    }
}
