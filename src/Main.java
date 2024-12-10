import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        System.out.println("enter no.of players:");
        int n=in.nextInt();
        in.nextLine();

        Queue<String> players=new LinkedList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter player name:");
            String playerName=in.nextLine();
            players.add(playerName);
        }

        HashMap<String,Integer> score=new HashMap<>();
        for(String i:players){
            score.put(i,0);
        }
        SnakesAndLadder sl=new SnakesAndLadder();

        boolean game=false;

        do {
            for (String i : players) {
                Dice dice = new NormalDice();
                System.out.println("Roll Dice");
                String e = in.nextLine();
                int roll = dice.rollDice();
                int cur_score = score.get(i);

                int k=0;
                if ((cur_score + roll) > 100) {
                    k = cur_score;
                    System.out.println("got more than 100, try next time!");
                } else {
                    k= cur_score + roll;
                }
                int new_score=k;

                score.put(i, new_score);
                int updated_score = score.get(i);

                if (sl.isWhat(updated_score).equals("snake")) {
                    int to_pos = sl.jump(updated_score);
                    score.put(i, to_pos);
                    System.out.println("snake bit");
                } else if (sl.isWhat(updated_score).equals("ladder")) {
                    int to_pos = sl.jump(updated_score);
                    score.put(i, to_pos);
                    System.out.println("climbed ladder");
                }

                System.out.println(i + "rolled" + roll + "and is now at position" + score.get(i));

                if (score.get(i) == 100) {
                    game = true;
                    System.out.println(i + "wins the game!");
                    break;
                }
            }
        }while(!game);











    }
}