/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.percivallucena.search;

/**
 *
 * @author percivallucena
 */
public class Result {
    
    private int pageID;
    private int score;

    public Result(){}
    
    public Result(int pageID, int score){
        this.pageID = pageID;
        this.score = score;
    }
    
    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
