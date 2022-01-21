/** 
*throws exception for pokemon object class
*@author Grayson Levy
*@since 11/19/2020
*/

/**
*requirements.
*refrence pokemon.java
*
*/


public class PokemonException extends RuntimeException { //java inheritance
   
   /** constructor with message.
   * if exception is used without message no exception will be thrown/error.
   * @param message error message
   */
   public PokemonException(String message) {
      //send message through to RuntimeException
      //constructor
      super(message);
   }
   
    /*are the requirements meet?
        yes
     *project finished?
        yes
     *submited date 
        11/22/2020 
     */
   
} //close class