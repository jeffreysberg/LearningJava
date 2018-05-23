/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapractice.sortingcomparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}*/

class Solution {

    public static void main(String[] args) {
        /*  5
            amy 100
            david 100
            heraldo 50
            aakansha 75
            aleksa 150*/
        
        //Scanner scan = new Scanner(System.in);
        
        Solution solution = new Solution();
        
        List<String> lines = new ArrayList<String>();
        
        lines = solution.readFile();
        int n = Integer.parseInt(lines.get(0)); 
        lines.remove(0);
        Player[] player = new Player[n];
        
        int counter = 0;
        lines.forEach((String l) -> {
            if (counter > 0){
               System.out.println(l); 
            }
        });
        
        
        Checker checker = new Checker(
            new PlayerScoreComparator(),
            new PlayerNameComparator());

        for (int i = 0; i < player.length; i++){
            String[] result = lines.get(i).split("\\s");
            player[i] = new Player(result[0], Integer.parseInt(result[1]));
            //System.out.println(result[0] + " | " + Integer.parseInt(result[1]));
        }
       
        
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
    
    
    public List readFile () {
        BufferedReader input = null;
        
        List<String> lines = new ArrayList();
        //try to read the file
        try {
            input = new BufferedReader(
                    new FileReader("//Users//jeffberg//NetBeansProjects//SandBox//fileForPractice//SortingComparatorInput.txt"));
            String inputLine;
            Integer charCount = 0;
            
            
            while (input.ready()) {
            // read each line of input file to a String, then parse into string
            // tokens if not empty or null add to Array of Strings for keywords
            // to search for
                lines.add(input.readLine());
                /*String[] tokenArray;
                tokenArray = inputLine.split("\\W");
                if (inputLine != null && !inputLine.isEmpty() ) {
                    for (int i = 0; i < tokenArray.length; i++) {
                        String noSpaceToken = tokenArray[i].trim(); 
                        if (noSpaceToken != null && !noSpaceToken.isEmpty() ) {	
                            List<Integer> blankList = new ArrayList<Integer>();
                            keywordMap.put(noSpaceToken, blankList);
 
                        }          
                    }
                }*/
            }
            
        //Catch errors if they occur
        } catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Failed to read input file" + "you are here");
            fnfe.printStackTrace();
            System.exit(0);
        } catch (Exception exception) {
            System.out.println("General Error");
            exception.printStackTrace();
            System.exit(0);
        //finally try to close the file being read
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (java.io.IOException ioe) {
                System.out.println("Failed to close input file");
                ioe.printStackTrace();
            }
        }
        return lines;
    }
    
}
