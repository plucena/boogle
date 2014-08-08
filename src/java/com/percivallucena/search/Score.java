/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.percivallucena.search;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author plucena
 */
public class Score {
    
    private LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
    // document id and document frequency
    private HashMap<Integer, Integer> Score = new  HashMap<Integer, Integer>();  
    
    public void addReseult(LinkedList<Integer> result){
           if(result!=null) { 
                this.results.add(result);
           }    
    }
    
    public int matchingWords() {
        return results.size();
    }
        
    public LinkedList<Result> calculateScore() {
        // for each word result, update the score card
        for(LinkedList<Integer> result: results){
            for(Integer docID: result){
                if(Score.containsKey(docID)) {
                    int frequency = Score.get(docID);
                    frequency++;
                    Score.put(docID, frequency);
                }
                else {
                    Score.put(docID, 1);
                }
            }
        }
        LinkedList<Result> result = new LinkedList<Result>();
          for(Integer pageID: Score.keySet())  
            result.add(new Result(pageID, Score.get(pageID)));
   
        return result;        
    }
    
    
}
