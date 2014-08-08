
package com.percivallucena.search;

import com.percivallucena.search.exception.IndexingException;
import com.percivallucena.search.exception.InvalidDocumentException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author plucena
 * 
 * THIS CLASS REPRESENTS THE SEARCH INDEX
 */
public class Index {

  
    private HashMap<String, LinkedList<Integer>> Index = new HashMap<String, LinkedList<Integer>>();
   
    private LinkedList<Document> DocumentList = new LinkedList<Document>();
    
    public  LinkedList<Document> ListAllDocs(){
        return DocumentList(); 
    }
    
    public int addDocument(Document doc){
          try {
              updateList(doc);
              updateIndex(doc);
              return 200;
          }
          catch(InvalidDocumentException e){
              return 500;
          }
          catch (IndexingException e) {
              return 500;
  
          }
    }

    
    private void updateList(Document doc) throws InvalidDocumentException {
           if(doc!=null && doc.getContent()!=null) {
               DocumentList.add(doc);
           }
           else 
           throw new InvalidDocumentException();    
    }
    
    
    private void updateIndex(Document doc) throws IndexingException, InvalidDocumentException {
           // check if doc is valid
            if(doc!=null && doc.getContent()!=null) {
            try 
            {    
                // split document into words to be indexed
                 String[] arr = doc.getContent().split(" ");
                 
                 if(arr.length>0) {
                 
                 for(int i=0; i<arr.length; i++)
                     
                     // word already indexed
                     if(Index.containsKey(arr[i])){
                         LinkedList<Integer> docList =Index.get(arr[i]);
                         // if a document contains repeated word it will show 
                         // multiple times on the index
                         // we could use an object with number of entries...
                         docList.add(doc.getPageID());
                     }
                     else {  // new word
                         LinkedList<Integer> docList =  new LinkedList<Integer>();
                         docList.add(doc.getPageID());
                         Index.put(arr[i],docList );
                     }    
                  }            
                
           }
           catch(Exception e){
               throw new IndexingException();
           } 
        }
        throw new InvalidDocumentException();
    }
    
    public LinkedList<Integer> findWord(String word) {
        return Index.get(word);
    }
    
  
    public  LinkedList<Document> DocumentList() {
       return DocumentList;
    }
    
}


