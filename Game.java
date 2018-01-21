import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;


public class Game{
    private List<Player> players;
    private Player currentPlayer;
    private int frameIdx = 0;
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
            frameIdx++;
            return players.get(0);
        }
    }

    public void show(){
        String msg = (frameIdx == 10) ? "Winner:"+leaders() : (currentPlayer.getName()+"の番");
		System.out.println(msg);
        System.out.println("|\t|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   |");
        for(Player p : players){
            System.out.println(p.toString());
        }
    }

    private String leaders(){
        Stream<Player> stream = players.stream();
        int max = stream.flatMapToInt((p)->{
            return IntStream.builder().add(p.getTotal()).build();
        }).max().getAsInt();
        String leaderNames = "";
        stream = players.stream();
        leaderNames = stream.filter((x)->x.getTotal() == max).flatMap((p)->{
            Stream.Builder<String> sb = Stream.builder();
            return sb.add(p.getName()).build();
        }).reduce("",(x,y)->{return new String(x+" "+y);});
        return leaderNames;
    }

    public boolean isEnd(){
        return (frameIdx == 10);
    }
}
