package com.teamtreehouse;

import java.util.HashMap;
import java.util.Map;

public class LeaderBoard {
    private Map<String,Integer> highScores = new HashMap<>();

    public Map<String, Integer> getHighScores() {
        return highScores;
    }

    public void addResult(String s, int i) {
        if(!highScores.containsKey(s))
            this.highScores.put(s,i);
        else if (highScores.get(s)>i)
            this.highScores.put(s,i);
    }

    public void display() {
        System.out.println("---------------");
        System.out.println("Leaders Board:");
        //highScores.forEach((k,v)-> System.out.printf("%s scored %d%n", k,v));
        highScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .forEach((e)-> System.out.printf("%s scored: %d%n", e.getKey(),e.getValue()));
        System.out.println("--------------");
    }
}
