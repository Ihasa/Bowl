public class Player{
    private String name;
    private Frame[] score;
    private int frameIdx;
    public Player(String iniName){
        name = iniName;
        frameIdx = 0;
        score = new Frame[10];
        for(int i = 0; i < score.length; i++){
            score[i] = new Frame();
        }
    }

    public void update(int pins){
        if(isEnd()){
            frameIdx++;
        }
        score[frameIdx].update(pins);
    }

    public int getTotal(){
        // wrong logic
        int sum = 0;
        for(Frame f : score){
            sum+=f.sumScore();
        }
        return sum;
    }
	public String getName(){
		return name;
	}

    public boolean isEnd(){
        return score[frameIdx].isEnd(frameIdx);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(name).append("\t|");
        for(int i = 0; i < 10; i++){
            sb.append(score[i].toString());
        }
        sb.append(getTotal()).append("|");
        return sb.toString();
    }
}