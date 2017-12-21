/**
 * Shimon Savitsky
 * Kakai Bian 
 * Lab 11D
 */
import javax.swing.JOptionPane;
public class Project0 {

    public static void main(String[] args) {
       // our variable to hold the users sentence
        String sentence;
               sentence = JOptionPane.showInputDialog(null, "Enter a sentence");
      // variable to store a count of the E's and e's in the program as well as length to give the for loop an end condition
        int counterE = 0;
        int counter_e = 0;   
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
     // if else statements check the string for any upper and lower case E's in the string         
                    if (sentence.charAt(i) == 'E') counterE += 1;
                    if (sentence.charAt(i) == 'e') counter_e += 1;
                    if (sentence.contains("stop")) System.exit(0);
                    
                    
                    
                }
        JOptionPane.showMessageDialog(null, "There are " + counterE + " E's and " + counter_e + " e's in this sentence.");
        
        
      
    }

 }


