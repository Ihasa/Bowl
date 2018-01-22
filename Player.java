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
        for(int i = 0; i < score.length-1; i++){
            score[i].next = score[i+1];
        }
    }

    public void update(int pins){
        if(isEnd()){
            frameIdx++;
        }
        score[frameIdx].update(pins);
    }

    public int getTotal(){
        int sum = 0;
        int frameIdx = 0;
        for(Frame f : score){
            sum+=f.sumOfScore(frameIdx++);
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
        sb.append(String.format("|%8s|",name));
        for(int i = 0; i < 10; i++){
            sb.append(score[i].toStringScores(i)).append("|");
        }

        sb.append("\n");

        sb.append(String.format("|%8s|",""));
        for(int i = 0; i < 10; i++){
            sb.append(score[i].toStringSumOfScores(i)).append("|");
        }

        sb.append(String.format("%5d", getTotal())).append("|");

        return sb.toString();
    }
}