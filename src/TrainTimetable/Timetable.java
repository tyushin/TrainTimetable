package TrainTimetable;

import java.util.ArrayList;

public class Timetable {
    private ArrayList<Trains> trainTimetable = new ArrayList<Trains>();

    public Timetable (ArrayList<Trains> trainTimetable){
        this.trainTimetable = trainTimetable;
    }

    public ArrayList<Trains> getTrainTimetable() {
        return trainTimetable;
    }
    public void addTrain(Trains train){
        trainTimetable.add(train);
    }
    public void removeTrain(Trains train) {
        trainTimetable.remove(train);
    }

    private int timeToMinutes(String time){
        String[] partTime;
        partTime = time.split(":");
        return (Integer.parseInt(partTime[0])*60 + Integer.parseInt(partTime[1]));
    }

    public Trains findTrain(Station endStation, String time){
        int lastTime = 1441;
        int lastTime2 = -1;
        Trains lastTrain = trainTimetable.get(0);
        Trains lastTrain2 = trainTimetable.get(0);
        for (int x = 0; x < trainTimetable.size(); x++){
            int trainTime = timeToMinutes(trainTimetable.get(x).getTime());
            if (trainTimetable.get(x).getEndStation() == endStation){
                if (trainTime > timeToMinutes(time) && trainTime < lastTime){
                    lastTrain = trainTimetable.get(x);
                    lastTime = trainTime;
                }
                if (trainTime < timeToMinutes(time) && trainTime > lastTime2){
                    lastTrain2 = trainTimetable.get(x);
                    lastTime2 = trainTime;
                }
            }
            for (int y = 0; y < trainTimetable.get(x).getIntermediateStations().size(); y++){
                if (trainTimetable.get(x).getIntermediateStations().get(y) == endStation) {
                    if (trainTime > timeToMinutes(time) && trainTime < lastTime) {
                        lastTrain = trainTimetable.get(x);
                        lastTime = trainTime;
                    }
                    if (trainTime < timeToMinutes(time) && trainTime > lastTime2){
                        lastTrain2 = trainTimetable.get(x);
                        lastTime2 = trainTime;
                    }
                }
            }
        }
        if (lastTime == 1441){
            if (lastTime2 == -1){
                return null;
            }
            else {
                return (lastTrain2);
            }
        }
        else {
            return (lastTrain);
        }
    }
}
