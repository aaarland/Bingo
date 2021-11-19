
package main.java.Bingo;

import java.util.*;

public class BingoMaster {

    private List<Ball> ballCollection;
    private Random rand;
    private Set<Ticket> tickets;
    private int seed;
    public BingoMaster(){
        ballCollection = new ArrayList<>(76);
        rand = new Random();
        tickets = new HashSet<>();
        fillBallCollection();
        seed = rand.nextInt();
    }

    private void fillBallCollection(){
        for(int i = 1; i < 76; i++){
            ballCollection.add(new Ball(i));
        }
    }

    public boolean gameOver(){
        return ballCollection.size() == 0;
    }

    public Ticket generateTicket() throws Exception {
        Ticket ticket;
        do{
            ticket = new Ticket(seed++);
        }while(tickets.contains(ticket));
        tickets.add(ticket);
        return ticket;
    }

    public Ball getNextBall(){
        Ball next;
        int r_idx;
        if(gameOver()) return null;
        do{
            r_idx = rand.nextInt(ballCollection.size());
            next = ballCollection.get(r_idx);
        }while(next == null);
        ballCollection.remove(next);
        return next;
    }
}
