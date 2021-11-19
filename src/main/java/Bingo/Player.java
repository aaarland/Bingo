package main.java.Bingo;

public class Player {
    private Ticket ticket;
    private String name;

    public Player(String name, Ticket ticket){
        this.ticket = ticket;
        this.name = name;
    }
    public boolean markNumber(Ball ball){
        return ticket.markNumber(ball.getValue());
    }

    public boolean gameOver(){
        return ticket.result();
    }

    public String getName(){
        return name;
    }
    public String toString(){
        return name + "\n" + ticket;
    }

}
