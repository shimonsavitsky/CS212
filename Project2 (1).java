/* Shimon Savitsky
     Lab: 11D
 */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.*;

public class Project2 {
    
    public static void main(String[] args){
        
        WordList unsortedList = new WordList();
        WordList sortedList = new WordList();
        String fileName = "words.txt";
        //set the constraints for the GUI
        WordGUI words = new WordGUI();
        words.setLayout(new GridLayout(1,2));
        Container wordsContentPane = words.getContentPane();
        TextArea unsorted = new TextArea();
        TextArea sorted = new TextArea();
        wordsContentPane.add(unsorted);
        wordsContentPane.add(sorted);
        words.setVisible(true);
        
        fillBothLists(fileName, unsortedList, sortedList);
        
        WordNode us = unsortedList.first.next;
        WordNode s = sortedList.first.next;
        while(us != null){
            unsorted.append(us.data.getWord() + "\n");
            sorted.append(s.data.getWord() + "\n");
            us = us.next;
            s = s.next;
        }//while
        
    }//main
    
    public static void fillBothLists(String file, WordList unsorted, WordList sorted){
        
        TextFileInput in = new TextFileInput("words.txt");
        String line = in.readLine() + ",";
        while(line != null){
            
            StringTokenizer st = new StringTokenizer(line, ",");
            
            while(st.hasMoreTokens()){
                
                String token = st.nextToken();
                
                if(token.length() == 3){
                    
                    Word wordHolder = new Word(token);
                    unsorted.append(wordHolder);
                    sorted.insert(wordHolder);
                }//if
                
                else System.out.println(token +"\n__");
            }//while2
            
            line = in.readLine();
            
        }//while1
        
    }//fillbothlists
 
}//class
