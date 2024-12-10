import java.util.HashMap;

public class SnakesAndLadder implements SnakesAndLadders {
    HashMap<Integer,Integer> snakes=new HashMap<>();
    HashMap<Integer,Integer> ladder=new HashMap<>();
    public SnakesAndLadder() {
        snakes.put(97, 78);
        snakes.put(95, 56);
        snakes.put(88, 24);
        snakes.put(62, 18);
        snakes.put(48, 26);
        snakes.put(36, 6);
        snakes.put(32, 10);

        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(8, 30);
        ladder.put(21, 42);
        ladder.put(28, 76);
        ladder.put(50, 67);
        ladder.put(71, 92);
        ladder.put(80, 99);
    }




    public int jump(int n){
        if(isWhat(n)=="snake"){
            return snakes.get(n);
        }else if(isWhat(n)=="ladder"){
            return ladder.get(n);
        }else{
            return 0;
        }
    }

    public String isWhat(int n){
        if(snakes.containsKey(n)){
            return "snake";
        }else if(ladder.containsKey(n)){
            return "ladder";
        }else{
            return "plain";
        }

    }
}
