import javax.swing.JFrame;
/**
*GUI for Pokemon.
*@author Grayson Levy
* @since 12/11/20
*/
public class PokemonGUIGlevy4 {

   /**
   *makes main panel.
   *runs the GUI
   *@param args not used
   */
   public static void main(String[] args) {
      
      JFrame f = new JFrame("Pokedex");
      
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //add the panel
      //making a panel object
      PokemonPanelGlevy4 p = new PokemonPanelGlevy4();
      //adding the panel to the frame
      f.add(p);
      //putting the content pane into GUI
      f.getContentPane();
      
      
      f.pack();
      f.setVisible(true);
   
   
   }

}