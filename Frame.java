public class Frame{
    private int nantoume;
    private int[] scores = new int[3];
    public  Frame next;

    public Frame(){
        nantoume = 0;
    }
    public void update(int pins){
        scores[nantoume++] = pins;
    }
    public int getScore(int index){
        return scores[index];
    }

    public int sumOfPins(){
        int ret = 0;
        for(int i = 0; i < 3; i++){
            ret+=scores[i];
        }
        return ret;
    }

    public int sumOfScore(int frameIdx){
        if((frameIdx == 9) || (sumOfPins() < 10)){  //10フレーム目or残ピンあり
            return sumOfPins();
        }else if(scores[0] == 10){   //ストライク
            if((frameIdx == 8) || (next.scores[0] < 10)){  //9フレーム目or次はストライクでない
                return 10 + next.scores[0] + next.scores[1];
            } else {    //次もストライク
                return 20 + next.next.scores[0];
            }
        } else {  //スペア
            return 10+next.scores[0];
        }
    }

    public boolean isEnd(int frameIdx){
        if(frameIdx == 9){
            return (nantoume == 3) || ((nantoume == 2) && sumOfPins() < 10);
        } else{
            return (sumOfPins() == 10) || (nantoume == 2);
        }        
    }

    //各投球結果を返す
    public String toStringScores(int frameIdx){
        StringBuilder sb = new StringBuilder();
        int scoreNum = ((frameIdx == 9) ? 3 : 2);
        for(int i = 0; i < scoreNum; i++){
            if(nantoume > i){
                sb.append(String.format("%2d",scores[i]));
            }else{
                sb.append(String.format("%2s",""));
            }

            if(i != scoreNum-1){
                sb.append("|");
            }
        }
        return sb.toString();
    }

    //フレームの合計スコアを返す
    public String toStringSumOfScores(int frameIdx){
        return String.format(((frameIdx==9) ? "%8d":"%5d"),sumOfScore(frameIdx));
    }
}