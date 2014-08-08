/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.percivallucena.search.test;

import com.percivallucena.search.Document;
import com.percivallucena.search.Index;
import com.percivallucena.search.Score;
import com.percivallucena.search.Search;
import com.percivallucena.search.Result;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author plucena
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Index index = new Index();
        Document d = new Document("the quick brown fox jumped over the lazy dog");
        index.addDocument(d);
        Document d1 = new Document("the fire fox is a web browser");
        index.addDocument(d1);
        Score score = Search.Search(index,"the crazy fox");
        
        // prints score for each document
        LinkedList<Result> results = score.calculateScore();
        System.out.println(results.size() + " results");
        for(Result result: results)
            System.out.println(result.getPageID() + ":" + result.getScore());
    }
    
}
