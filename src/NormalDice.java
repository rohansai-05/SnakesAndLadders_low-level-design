import java.util.Random;

public class NormalDice implements Dice{
    private int roll;

    public int randomValue(){
        Random r=new Random();
        return r.nextInt(6)+1;
    }
    public int getRoll(){
        return roll;
    }
    public int rollDice(){
        int a=randomValue();
        if(a==6){
            a+=randomValue();
            if(a==12){
                a+=randomValue();
                if(a==18){
                    a=0;
                }
            }
        }
        return a;
    }
    public void setValue(){
        this.roll+=rollDice();
    }




}
