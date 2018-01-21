import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Game game = new Game("Tarou", "Hanako", "Saeko");
        try{
            Scanner s = new Scanner(System.in);
            game.show();            
            while(!game.isEnd()){
                int pins = Integer.parseInt(s.nextLine());
                if(pins == -1)
                    break;
                else 
                    game.update(pins);
                    game.show();                    
            }
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}