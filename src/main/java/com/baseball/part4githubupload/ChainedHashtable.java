package com.baseball.part4githubupload;
/***********************************************************************************
 * Title: ChainedHashtable
 * Author: Sean Laverty
 * Course Section: CMIS202-ONL1 (Seidel) Fall 2022
 * File: ChainedHashtable.java
 * Description: Using a linked list to create a hashtable to store players
 *              Time complexity of O(n)
 ***********************************************************************************/
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
    // Attributes: Linked list that represents the hashTable
    protected LinkedList<StoredPlayer>[] hashtable;

    // Constructor
    public ChainedHashtable() {
        // baseball team has a 40-man roster
        hashtable = new LinkedList[40];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredPlayer>();
        }
    }

    // Puts the players into the hashTable
    public void put(String key, Player player) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredPlayer(key, player));
    }

    // Gets the players from the hashTable
    public Player get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredPlayer> iterator = hashtable[hashedKey].listIterator();
        StoredPlayer player = null;
        while (iterator.hasNext()) {
            player = iterator.next();
            if (player.key.equals(key)) {
                return player.player;
            }
        }
        return null;
    }

    // Removes the players from the hashTable
    public Player remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredPlayer> iterator = hashtable[hashedKey].listIterator();
        StoredPlayer player = null;
        int index = -1;
        while (iterator.hasNext()) {
            player = iterator.next();
            index++;
            if (player.key.equals(key)) {
                break;
            }
        }
        if (player == null) {
            return null;
        }
        else {
            hashtable[hashedKey].remove(index);
            return player.player;
        }
    }
    // Creates a simple hashKey that uses the Math.abs() method to avoid the negative numbers
    protected int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }

    // Prints hashTable for testing
    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            }
            else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredPlayer> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().player);
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }

} // ChainedHashTable (class)
