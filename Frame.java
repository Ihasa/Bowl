public class Frame{
    private int nantoume;
    private int[] scores = new int[3];

    public Frame(){
        nantoume = 0;
    }
    public void update(int pins){
        scores[nantoume++] = pins;
    }
    public int getScore(int index){
        return scores[index];
    }

    public int sumScore(){
        int ret = 0;
        for(int i = 0; i < 3; i++){
            ret+=scores[i];
        }
        return ret;
    }

    public boolean isEnd(int frameIdx){
        if(sumScore() == 10){
            return true;
        } else {
            return ((frameIdx == 9)&&(nantoume == 3)) || 
                   ((frameIdx != 9)&&(nantoume==2)); 
        }    
        
    }

    public String toString(){
        // wrong logic
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            if(nantoume > i){
                sb.append(scores[i]);
            }else{
                sb.append(" ");
            }
            sb.append("|");
        }
        return sb.toString();
    }
}