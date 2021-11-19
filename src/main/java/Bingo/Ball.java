package main.java.Bingo;
public class Ball {
    private  int value;
    public Ball(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return String.valueOf(this.value);
    }
}