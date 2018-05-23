/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.sortingcomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jeffberg
 */
class Checker implements Comparator<Player>{
    private List<Comparator<Player>> listComparators;
    
    Checker(Comparator<Player>... comparators){
        this.listComparators = Arrays.asList(comparators);
    }
    @Override
    public int compare(Player o1, Player o2) {
        for (Comparator<Player> comparator : listComparators) {
            int result = comparator.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

class PlayerNameComparator implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        return o1.name.compareTo(o2.name);
        //return o1.score - o2.score;
    } 
    
}

class PlayerScoreComparator implements Comparator<Player> {
    public int compare(Player o1, Player o2) {
        //return o1.name.compareTo(o2.name);
        return o2.score - o1.score;
    } 
}