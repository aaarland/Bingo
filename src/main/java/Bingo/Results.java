package main.java.Bingo;

public class Results {

    private Ticket ticket;

    public Results(Ticket ticket){
        this.ticket = ticket;
    }

    private boolean checkRows(){
        for(int i = 0; i < ticket.getRows(); i++){
            int count = 0;
            for(int j = 0; j < ticket.getCols() && ticket.getNumber(i, j) == 0; j++){
                count++;
            }
            if(count == ticket.getRows()) return true;
        }
        return false;
    }

    private boolean checkCols(){
        for(int i = 0; i < ticket.getCols(); i++){
            int count = 0;
            for(int j = 0; j < ticket.getRows() && ticket.getNumber(j, i) == 0; j++){
                count++;
            }
            if(count == ticket.getCols()) return true;
        }
        return false;
    }

    private boolean checkCross(){
        int i = 0, j = 0;
        int count = 0;
        while(i < ticket.getRows() && j < ticket.getRows() && ticket.getNumber(i, j) == 0){
            i++;
            j++;
            count++;
            if(count == ticket.getRows()) return true;
        }
        i = ticket.getCols() - 1;
        j = 0;
        count = 0;
        while(i >= 0 && j < ticket.getRows() && ticket.getNumber(i, j) == 0){
            i--;
            j++;
            count++;
            if(count == ticket.getCols());
        }
        return false;
    }

    public static boolean isWinner(Ticket ticket){
        Results res = new Results(ticket);
        return res.checkRows() || res.checkCols() || res.checkCross();
    }
}
