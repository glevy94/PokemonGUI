import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.util.*;
/**
* JPanel subclass for Frame-based GUI.
* @author Grayson Levy
* @since 12/11/20
*/

public class PokemonPanelGlevy4 extends JPanel {

   /** label. */
   private JLabel title = new JLabel("Pokedex");
   /** label. */
   private JLabel errorM = new JLabel("                ");
   /** button. */
   private JButton add = new JButton(" Add Pokemon ");
   /** button. */
   private JButton clear = new JButton(" Clear ");
   /** button. */
   private JButton list = new JButton(" Make List ");
   /** Choice drop down menu for pokemon. */
   private Choice chPokemon = new Choice();
      
   /** sub-panel. */
   private JPanel topSubPanel = new JPanel();
   /** sub-panel. */
   private JPanel centerSubPanel = new JPanel();
   /** sub-panel. */
   private JPanel westSubPanel = new JPanel();
   /** sub-panel. */
   private JPanel southSubPanel = new JPanel();
   /** ActionListener obj.*/ 
   private GUIListener listener = new GUIListener();


   /** text are for displaying Pokemon.toString()s. */
   private JTextArea textAreaC = new JTextArea(20, 20);
   
   /** text are for displaying Array list of pokemon. */
   private JTextArea textAreaS = new JTextArea(20, 20);
   
   /** Make TextArea scrollable. */
   //textArea is put inside this.                   
   private JScrollPane scroll = new JScrollPane(textAreaS, 
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   
   /** pokemon. */
   private Pokemon p;
   /** pokemon array list. */
   private ArrayList<Pokemon> pArray = new ArrayList<>();
   /** counter printing for array. */
   private int counter = 0;
 
   
   
   /**
   * Constructor builds layout.
   */
   public PokemonPanelGlevy4() {
   
      this.setLayout(new BorderLayout()); //Border panel layout
      this.setPreferredSize(new Dimension(600, 700));
      topSubPanel.setBackground(Color.white); //north area color
      centerSubPanel.setBackground(Color.gray); //center area color
      westSubPanel.setBackground(Color.gray); //bottomSubPanel area color
      
      
      /** adds to top panel */
      topSubPanel.add(title); //adds title
      this.add("North", topSubPanel); 
      
       /** adds to the center sub-panel */
      //make sub=panel with grid layout
      GridLayout gl = new GridLayout(2, 1);
      JPanel centerSubPanel = new JPanel();
      centerSubPanel.setLayout(gl);
      textAreaC.setEditable(false); //make it not editable by user
      textAreaC.setBackground(Color.LIGHT_GRAY);
      centerSubPanel.add(textAreaC); //to display pokemone added to array
      
       //set up the textArea for holding list
      textAreaS.setBackground(Color.LIGHT_GRAY);
      //make it not editable by user
      textAreaS.setEditable(false);
      //set up scrollPane appearance and size (textArea already inside it) 
      scroll.setBorder(null);
      centerSubPanel.add(scroll);  //add scrollPane to panel, textArea inside.        
      scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
   
      add("Center", centerSubPanel);
      
    
      
      /** adds to west subpanel */
      //make sub=panel with grid layout
      GridLayout g2 = new GridLayout(2, 1);
      westSubPanel.setLayout(gl);
      westSubPanel.setSize(200, 600);
      
      //add choices to the choice dropdown list
      chPokemon.add("Bulbasaur");
      chPokemon.add("Venusaur");
      chPokemon.add("Ivysaur");
      chPokemon.add("Squirtle");
      chPokemon.add("Wartortle");
      chPokemon.add("Blastoise");
      chPokemon.add("Charmander");
      chPokemon.add("Charmeleon");
      chPokemon.add("Charizard");
      
      westSubPanel.add(chPokemon); //add chooice dropdown
      westSubPanel.add(add); //add button
      westSubPanel.add(list); //button to make list
      add.addActionListener(listener); //add listener to button 
      add("West", westSubPanel); 
      
      GridLayout g3 = new GridLayout(1, 2);
      southSubPanel.setLayout(g3);
      southSubPanel.add(clear); //clears area
      clear.setEnabled(false);
      clear.addActionListener(listener); //add listener to button 
      list.addActionListener(listener); //add listener to button 
      add("South", southSubPanel); 
      
   } //closes JPanel constructor
   
   
   /**
   * Private ActionListener class.
   */ 
   private class GUIListener implements ActionListener {
   
      /**
      * ActionPerformed method.
      * @param event what button is clicked.
      */ 
      public void actionPerformed(ActionEvent event) {
         
         //clears array and text fields if button is clicked 
         if (event.getSource() == clear) {
            counter = 0;
            textAreaS.setText("");
            textAreaC.setText("");
            pArray.clear();
            clear.setEnabled(false);
         
         }
         
         //if add button is clicked 
         if (event.getSource()  == add) { 
         
            String species = "";
            String name = "";
            int hp = 0;
            int pNum = 0;
            Random randGen = new Random();
            int min = 0;
            int max = 401;
            
         
         
            //get pokemon selection
            species = chPokemon.getSelectedItem();
            //set hp
            hp = randGen.nextInt((max - min)) + min;            
            //set Pokemon number
            switch (species) {
               case "Bulbasaur":
                  pNum = 1;
                  break;
               case "Venusaur":
                  pNum = 2;
                  break;
               case "Ivysaur":
                  pNum = 3;
                  break;       
               case "Squirtle":
                  pNum = 4;
                  break;           
               case "Wartortle":
                  pNum = 5;
                  break;
               case "Blastoise":
                  pNum = 6;
                  break; 
               case "Charmander":
                  pNum = 7;
                  break;  
               case "Charmeleon":
                  pNum = 8;
                  break;  
               case "Charizard":
                  pNum = 9;
                  break;
               default :
                  
                       
            } //end switch 
            
            //makes new pokemon object 
            p = new Pokemon(species, name, pNum, hp);
            //print pokemon to text area
            textAreaC.setText(p.toString());
            //add pokemon to array
            pArray.add(p);
         
         } //end if for add button
         
         //if make list button is clicked
         if (event.getSource()  == list) {
            clear.setEnabled(true);
            int arrayL = 0;
            arrayL = pArray.size();
            String pList = "";
            Pokemon tempP;
            
            while (counter < arrayL) {
               tempP = pArray.get(counter);
               pList += "Pokemon #" + (counter + 1) + "\n" + tempP.toString() + "\n\n";
               counter++;  
            
            } //end for loop for printing array
            
            //adds list to text area
            textAreaS.setText(pList);
            counter = 0;
         
         
         } //end if for make list button
         
         
         
         
         
         
      
      } //end actionEvent method
   
   }  //end GUIListener
   

} //close Panel Class