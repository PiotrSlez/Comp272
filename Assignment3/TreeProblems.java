/*
 * *** Piotr Slezak / Section 1 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

    Set<Integer> tempA = new TreeSet<>(); //creates new TreeSet temp1
    Set<Integer> tempB = new TreeSet<>(); // and temp2

    tempA.addAll(setA); //copies elements from setA
    tempA.removeAll(setB); //deletes elements from setB that match

    tempB.addAll(setB); //copies elements from setB
    tempB.removeAll(setA); //deletes elements from setA that match

    tempA.addAll(tempB); //adds unique elements from tempB to tempA

    return tempA;
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {

    Iterator <Map.Entry <Integer,String>> it = treeMap.entrySet().iterator();
    //creates iterator to traverse treeMap

    while(it.hasNext()) {
      Map.Entry<Integer, String> current = it.next(); //iterates through the treeMap
      if (current.getKey() % 2 == 0){ //checks if even
        it.remove(); //removes mapping from treeMap
      }
    }

    return;
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {
    int key;
    String value;

    Iterator <Map.Entry<Integer,String>> it = tree1.entrySet().iterator(); //creates iterator

    while(it.hasNext()) {
      Map.Entry<Integer, String> current = it.next();
      key = current.getKey(); //gets key of tree1
      value = current.getValue(); //gets value of tree1
      if(!(tree2.containsKey(key) && tree2.get(key).equals(value))){ //compares tree1s mapping to tree2s
        return false;
      }
    }

    if(tree1.size() != tree2.size()){
      return false; //checks to see if tree2 has any extra elements that are not in tree1
    }

    return true;
  }

} // end treeProblems class
