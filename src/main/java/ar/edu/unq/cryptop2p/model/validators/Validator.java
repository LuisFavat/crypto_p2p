package ar.edu.unq.cryptop2p.model.validators;

import ar.edu.unq.cryptop2p.model.exceptions.InvalidResourceException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static String message = "";
    private static  HashMap notFoundResponse ;
    private static HashMap badRequestRespponse;
    private static HashMap invalidRangeRequestResponse;
    private static HashMap response;
    private static String passwordExpetionMessage = "Invalid password format.";
    private static final int minLength = 3;
    private static final int maxLength = 30;
    private static final int minAddressLenght = 10;
    private static final int maxAddressLenght = 30;

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
    public static  void  validatePassword(String aPassword) throws InvalidResourceException
    {
        int minPasswordLength = 6;
        int maxPasswordLength = 30;
        validatehasAtLeastOneLowerCase(aPassword);
        validatehasAtLeastOneUpperCase(aPassword);
        validatehasSpecialCharacter(aPassword);
        validatePasswordLenght(aPassword, minPasswordLength, maxPasswordLength);

    }

    public static void validatePasswordLenght(String aString, int minLength ,int maxLength) throws InvalidResourceException {
        if ( ! validateLenght(aString, minLength,  maxLength))
        {
            message =   MessageFormat.format("Invalid password format. Incorrect length must be between {0} and {1}.", minLength, maxLength);
            badRequestResponse(message);
            throw new InvalidResourceException(message);

        }

    }

    public static void validatehasAtLeastOneLowerCase(String aPassword) throws InvalidResourceException
    {
       if ( ! hasAtLeastOneLowerCase(aPassword) )
        {
            message = "Invalid password format. At least one valid lowercase is needed.";
            badRequestResponse(message);
            throw new InvalidResourceException(message);
        }

    }

    public static void validatehasAtLeastOneUpperCase(String aPassword) throws InvalidResourceException
    {
        if ( ! hasAtLeastOneUpperCase(aPassword) )
        {   message = "Invalid password format. At least one valid uppercase is needed.";
            badRequestResponse(message);
            throw new InvalidResourceException(message);
        }

    }

    public static void validatehasSpecialCharacter(String aPassword) throws InvalidResourceException
    {
        if ( ! hasSpecialCharacter(aPassword) )
        {   message = "Invalid password format. At least one special character is needed.";
            badRequestResponse(message);
            throw new InvalidResourceException(message);
        }

    }


    private static boolean hasAtLeastOneLowerCase(String aPassword)
    {
        return ! aPassword.toUpperCase().equals(aPassword);
    }

    private static boolean hasAtLeastOneUpperCase(String aPassword)
    {
       return !aPassword.toLowerCase().equals(aPassword);//si la frase en minusculas no es igual a la frase original significa que por lo menos tiene una mayuscula

    }

    private static boolean hasSpecialCharacter(String aPassword)
    {
        // otra forma : aPassword.contains("?") && aPassword.contains("¿")... etc
        Pattern special = Pattern.compile ("[?!¡@¿.,´)#_]");
        Matcher hasSpecial = special.matcher(aPassword);
        return  hasSpecial.find();

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
        int cvuLength = 22;
        return validateLenght(aCvu, cvuLength, cvuLength);
    }
    //endregion

    public static boolean validateCrytoAddress(String aCryptoAddress)
    {
        int cryptoAddressLength = 8;
        return validateLenght(aCryptoAddress, cryptoAddressLength, cryptoAddressLength);
    }


    public static void notFoundResponse (String message){
        HashMap  mapResult = new HashMap();
        mapResult.put("Message", message);
        mapResult.put("Status", HttpStatus.NOT_FOUND);
        notFoundResponse = mapResult;
    }


    public static void badRequestResponse (String message){
        HashMap  mapResult = new HashMap();
        mapResult.put("Message", message);
        mapResult.put("Status", HttpStatus.BAD_REQUEST);
        badRequestRespponse = mapResult;
    }


    public static void InvalidRangeRequestResponse (String message){
        HashMap  mapResult = new HashMap();
        mapResult.put("Message", message);
        mapResult.put("Status", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        invalidRangeRequestResponse = mapResult;
    }

    public static HashMap getNotFoundResponse(){
        return  notFoundResponse;
    }

    public static HashMap getBadRequestResponse(){
        return  badRequestRespponse;
    }

    public static HashMap getInvalidRangeRequestResponse(){return invalidRangeRequestResponse;}

    public static void response(String message, HttpStatus status){
        HashMap  mapResult = new HashMap();
        mapResult.put("Message", message);
        mapResult.put("Status",status );
        response = mapResult;
       }

    public static HashMap getResponse(){
        return response;
    }
}
