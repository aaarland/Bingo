package main.java.Bingo;

public class TestDriver {

    public static void main(String args[]){
        try {
            BingoMaster bm = new BingoMaster();
            Player p1 = new Player("Adrian", bm.generateTicket());
            Player p2 = new Player("Lasse", bm.generateTicket());
            while(!bm.gameOver() && !p1.gameOver() && !p2.gameOver()){
                Ball ball = bm.getNextBall();
                p1.markNumber(ball);
                p2.markNumber(ball);
            }

            if(p1.gameOver()) {
                System.out.println("Winnwer is " + p1.getName());
            }else if(p2.gameOver()){
                System.out.println("Winnwer is " + p2.getName());
            }
                System.out.println(p1);
                System.out.println(p2);
        }catch (Exception e){
            System.err.println(e);
        }


    }
}
