package TrainTimetable;

import java.util.ArrayList;

public class Timetable {
    private ArrayList<Trains> trainTimetable = new ArrayList<>();

    public Timetable (ArrayList<Trains> trainTimetable){
        this.trainTimetable = new ArrayList<>(trainTimetable);
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

    public Trains findTrain(Station endStation, Time time){
        int lastTime = 1441;
        Trains lastTrain = null;
        for (Trains train: trainTimetable) {
            int trainTime = train.getTime().toMinutes();
            if (train.getEndStation() == endStation && trainTime > time.toMinutes() && trainTime < lastTime){
                lastTime = trainTime;
                lastTrain = train;
            }
            else {
                for (Station station: train.getIntermediateStations()) {
                    if (station == endStation && trainTime > time.toMinutes() && trainTime < lastTime){
                        lastTime = trainTime;
                        lastTrain = train;
                    }
                }
            }
        }
        return (lastTrain);
    }
}
