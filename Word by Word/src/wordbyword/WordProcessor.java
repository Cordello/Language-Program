package wordbyword;

import java.util.ArrayList;

/**
 * Created by Timothy on 1/1/2016.
 */
public class WordProcessor implements Runnable {
    //volatile means that it sort of gets updated while the Thread is running I think
    //Without it, the run method does not recognize that the ArrayList has been changed and won't retrieve any words
    private volatile ArrayList<String> wordList = new ArrayList<String>();
    //private volatile ArrayList<String> wordList;
    private int currIndex;

    //This constructor is necessary if using the other technique, as described in the comments for GUI.java
    /*public WordProcessor(ArrayList<String> array)
    {
        wordList = array;
    }*/

    public void run()
    {
        currIndex = 0;
        String word;
        while(true)
        {
            //It checks the next index of the array every time it loops, as long as there is an index that hasn't been checked
            //If there is a word to be processed, it takes the word and then increments currIndex, so it can check
            //the next index when it is available
            if (currIndex < wordList.size())
            {
                word = wordList.get(currIndex);
                //Instead of printing, you can have it process the word, or do whatever you want with it
                //Once it is done, it will get the next word if it is already there, or wait for it to be added
                System.out.println("\n" + word + " ");
                currIndex++;
            }
        }
    }

    public void addWord(String word)
    {
        wordList.add(word);
    }
}
