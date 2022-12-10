package com.baseball.part4githubupload;
/***********************************************************************************
 * Title: StoredPlayer
 * Author: Sean Laverty
 * Course Section: CMIS202-ONL1 (Seidel) Fall 2022
 * File: StoredPlayer.java
 * Description: Creates a simple Stored player for the chained hashtable class
 ***********************************************************************************/
public class StoredPlayer {
    // Attributes
    public String key;
    public Player player;

    // Constructor
    public StoredPlayer(String key, Player player) {
        this.key = key;
        this.player=player;
    }
} // StoredPlayer
