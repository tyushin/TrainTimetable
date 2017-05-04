package Tests;

import TrainTimetable.Timetable;
import TrainTimetable.Trains;
import TrainTimetable.Station;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Tests {
    private Station station1 = new Station("Muzh");
    private Station station2 = new Station("Pol");
    private Station station3 = new Station("Acad");
    private Station station4 = new Station("Lesn");
    private Station station5 = new Station("Dev");
    private Trains train1 = new Trains("Tr1", "10:10", station1);
    private Trains train2 = new Trains("Tr2", "13:15", station2);
    private ArrayList<Station> intermediateStations3 = new ArrayList<>(Arrays.asList(station4, station5));
    private Trains train3 = new Trains("Tr3", "16:47", station3, intermediateStations3);
    private ArrayList<Trains> trainList = new ArrayList<>(Arrays.asList(train1, train2, train3));
    private Timetable trainTimetable = new Timetable(trainList);

    @Test
    public void findTrain() {
        Trains trainFind = trainTimetable.findTrain(station2, "9:37");
        assertEquals(train2, trainFind);
    }

    @Test
    public void addTrain() {
        Trains newTrain = new Trains("Tr4", "15:16", station1);
        trainTimetable.addTrain(newTrain);
        assertEquals(trainTimetable.getTrainTimetable().get(trainTimetable.getTrainTimetable().size() - 1), newTrain);
    }

    @Test
    public void removeTrain() {
        trainTimetable.removeTrain(train1);
        assertEquals(trainTimetable.getTrainTimetable().get(0), train2);
    }

    @Test
    public void addIntermediateStation() {
        trainTimetable.getTrainTimetable().get(0).addIntermediateStation(station4);
        assertEquals(trainTimetable.getTrainTimetable().get(0).getIntermediateStations().get(trainTimetable.getTrainTimetable().get(0).getIntermediateStations().size() - 1), station4);
    }

    @Test
    public void removeIntermediateStation() {
        trainTimetable.getTrainTimetable().get(2).removeIntermediateStation(station4);
        assertEquals(trainTimetable.getTrainTimetable().get(2).getIntermediateStations().get(0), station5);
    }
}
