import java.util.ArrayList;
import java.util.List;


public class Game{
    private List<Player> players;
    private Player currentPlayer;
    public Game(String... playerNames){
        players = new ArrayList<Player>();
        for(String s : playerNames){
            players.add(new Player(s));
        }
        currentPlayer = players.get(0);
    }

    public void update(int pins){
        currentPlayer.update(pins);
        if(currentPlayer.isEnd()){
            currentPlayer = nextPlayer();
        }
    }

    private Player nextPlayer(){
        int playerIdx = players.indexOf(currentPlayer);
        if(playerIdx < players.size() - 1){
            return players.get(playerIdx+1);
        }else{
            return players.get(0);
        }
    }

    public void show(){
		System.out.println(currentPlayer.getName() + "‚Ì”Ô");
        System.out.println("|\t|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   |");
        for(Player p : players){
            System.out.println(p.toString());
        }
    }
}
