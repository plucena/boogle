package com.percivallucena.search;

/**
 *
 * @author plucena
 */
public class Search {

   
    public static Score Search(Index index, String exp){
        
        Score score = new Score();
        
        // no support for regExp yet...
        String arr[] = exp.split(" ");
        
        // for all words
        for(int i=0; i< arr.length; i++)
            // add documents that match that word
            score.addReseult(index.findWord(arr[i]));
       
        return score;
    }
    
    
}
