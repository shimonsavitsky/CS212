/**
 *  Shimon Savitsky - shimmy.savitsky@gmail.com
 * CSCI 211 - MoWe 10:05am - Dr. Kenneth Lord
 * 
 * Project 1
 * 
 * 
 * @author Shimon Savitsky
 *
 */
import java.awt.*;
import java.util.*;

public class Project1{
    
    public static void main(String[] args){
        //Set the fileName to the file that needs to be used as the input file
        String fileName = args[0];
        //declare an empty array of words
        String[] USList = new String[50];
        Word[] USWords = new Word[50];
        Word[] SWords = new Word[50];
        //set the constraints for the GUI
        WordGUI words = new WordGUI();
        words.setLayout(new GridLayout(1,2));
        Container wordsContentPane = words.getContentPane();
        TextArea sorted = new TextArea();
        TextArea unsorted = new TextArea();
        wordsContentPane.add(unsorted);
        wordsContentPane.add(sorted);
        
        
        /*Create the input file variable, set line to the first line and create a blank string
         * Go through the file and add each line to the string while adding commas to the ends of each line
         */
        TextFileInput in = new TextFileInput(fileName);
        String line = in.readLine();
        String string = new String();
        while(line != null){
            string+= line+ ",";
            line = in.readLine();
        }//while
        //Create a  string tokenizer to go through the string and separate by commas
        StringTokenizer st = new StringTokenizer(string, ",");
        String token = st.nextToken();
        /*Go through the string tokenizer and add each three letter word to the unsorted array and each non 3 letter
         * should print to the console
         */
        int i = 0;        
        while(st.hasMoreTokens()){
            if(token.length() == 3){
                USList[i] = token;
                i+=1;
                token = st.nextToken();
            }//if
            else{
                System.out.println(token);
                token = st.nextToken();
            }//else
        }//whuile
        for(int k=0;k<i;k++){
            Word unsortedWord = new Word(USList[k]);
            Word sortedWord = new Word(createSorted(USList, i)[k]);
            USWords[k] = unsortedWord;
            SWords[k] = sortedWord;
        }//loop
            for(int k = 0; k < i; k++){
                unsorted.append(USWords[k].getWord()+"\n");
                sorted.append(SWords[k].getWord()+"\n");
            }//loop
    
       words.setVisible(true); 
    }//main
    
    public static String[] createSorted(String[] unsortList, int i){
        String[] sortList = new String[50];
        String[] copy = new String[50];
        for(int k = 0; k<i; k++){
            copy[k] = unsortList[k];
        }//loop
        Arrays.sort(copy, 0, i);
        for(int k = 0; k<i; k++){
            sortList[k] = copy[k];
        }//loop
        return sortList;
    }//createSorted
}//class