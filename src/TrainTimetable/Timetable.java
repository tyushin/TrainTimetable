package TrainTimetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    private static final Comparator<Trains> COMPARE_BY_TIME = new Comparator<Trains>() {
        @Override
        public int compare(Trains train1, Trains train2) {
            return train1.getTime().toMinutes() - train2.getTime().toMinutes();
        }
    };

    public Trains findTrain(Station endStation, Time time){
        Collections.sort(trainTimetable, Timetable.COMPARE_BY_TIME);
        Trains lastTrain = null;
        for (Trains train: trainTimetable) {
            int trainTime = train.getTime().toMinutes();
            if (train.getEndStation() == endStation && trainTime > time.toMinutes()){
                lastTrain = train;
                break;
            }
            else {
                for (Station station: train.getIntermediateStations()) {
                    if (station == endStation && trainTime > time.toMinutes()){
                        lastTrain = train;
                        break;
                    }
                }
            }
        }
        return (lastTrain);
    }
}
