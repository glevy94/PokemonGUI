/** 
*object class for pokemon 
*enables another program to create profiles for pokemon
*@author Grayson Levy
*@since 11/14/2020
*/

/**
*requirements.
*create exception class 
*rewrite to include exceptions for
      HP
      Species
      Pokedex Number
*String name should not be empty
*instead of throwing a PokemonException if the incoming name String is empty
*the name instance variable should be set to be the same as species
*/


public class Pokemon {

   //INSTANCE VARIABLES
   
   /** RULES:
   1.species should not be empty or contain only spaces
   2.pokedex number should be a number between 1 and 151 (inclusive)
   3.HP should be between 0 - 401 (inclusive)
   
   /** species name. */
   private String species = "";
   /** pokemon name. */
   private String name = "";
   /** pokedex number. */
   private int number = 0;
   /** hit power. */
   private int hp = 0;
   
   
   /** constructor for Pokemon.
   * @param newSpecies the pokemon species.
   * @param newName the pokemon name from user.
   * @param newNumber the pokemon pokedex number.
   * @param newHP the pokemon hit power.
   */
   
   public Pokemon(String newSpecies, String newName, int newNumber, int newHP) {
   
      //trims string so spaces are not confused with a input
      newSpecies = newSpecies.trim(); 
      newName = newName.trim(); 
      
      //assigns strings and ints "constructs"
      this.setSpecies(newSpecies);
      this.setName(newName);
      this.setNumber(newNumber);
      this.setHP(newHP);
   } //end constructor 
      
   //Get METHODS
   /**
   * Returns the species name.
   * @return the species name.
   */
   public String getSpecies() {
      return this.species;
   }
    /**
   * Returns the pokemons name.
   * @return the pokemons name.
   */
   public String getName() {
      return this.name;
   }
    /**
   * Returns the pokedex number.
   * @return the pokedex number.
   */
   public int getNumber() {
      return this.number;
   }
    /**
   * Returns the pokemons hp.
   * @return the pokemons hp.
   */
   public int getHP() {
      return this.hp;
   }
   // end of get method 
   
   
   //Set methods
   /**
   * Sets the pokemons name.
   * @param newName The new pokemon name.
   */
   public void setName(String newName) {
   
      newName = newName.trim(); //trims users input
   
      if (newName.length() > 1) {
         this.name = newName;
      } else { //if string name is empty sets to species name 
         this.name = species;
      } //end if else
   }
   
   /**
   * Sets the pokemons hp.
   * @param newHP The new hp for the pokemon.
   * @throws PokemonException if the HP is out of range
   */
   public void setHP(int newHP) throws PokemonException {
   
      if ((newHP >= 0) && (newHP <= 401)) {
         this.hp = newHP;
      } else { //HP out of range
         throw new PokemonException("HP must be in the range of 0-401");
      } //end if else
   }
   
   /**
   * Sets the pokemons pokedex number.
   * @param newNumber The new pokedex number for the pokemon.
   * @throws PokemonException if pokedex number is out of range 
   */
   public void setNumber(int newNumber) throws PokemonException {
   
      if ((newNumber >= 1) && (newNumber <= 151)) {
         this.number = newNumber;
      } else { //pokedex number out of range
         throw new PokemonException("Pokedex number must be in the range of 1-151");
      } //end if else
   }
   
   /**
   * Sets the pokemons species.
   * @param newSpecies The new Species for the pokemon.
   * @throws PokemonException if species is left blank
   */
   public void setSpecies(String newSpecies) throws PokemonException {
   
      newSpecies = newSpecies.trim(); //trims user input
   
      if (newSpecies.length() > 0) {
         this.species = newSpecies;
      } else { //species is left blank
         throw new PokemonException("A species name must be input");
      } //end if else
   }
   
    // end set method
   
   
   /** toString method.
   * @return String representation of the pokemon
   */
   
   public String toString() {
      String p = "Species: " + this.species + "\nName: " + this.name 
            + "\nNumber: " + this.number + "\nHP: " + this.hp;
      return p;
   }
   // end toString method
   
   
   /*are the requirements meet?
        yes
     *project finished?
        yes
     *submited date 
        11/22/2020 
     */
   
   
} //end class