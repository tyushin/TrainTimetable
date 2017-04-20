package TrainTimetable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[]args){
        Station station1 = new Station("Muzh");
        Station station2 = new Station("Pol");
        Station station3 = new Station("Acad");
        Trains train1 = new Trains("Tr1", "10:10", station1);
        Trains train2 = new Trains("Tr2", "13:15", station2);
        Trains train3 = new Trains("Tr3", "16:47", station3);
        ArrayList<Trains> trainList = new ArrayList<Trains>(Arrays.asList(train1, train2, train3));
        Timetable trainTimetable = new Timetable(trainList);
        Trains trainFind = trainTimetable.findTrain(station2, "9:37");
        System.out.println(trainFind.getName());
    }

}
