package Tests;

import TrainTimetable.Time;
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
    private Time time1 = new Time(10, 10);
    private Time time2 = new Time(13, 15);
    private Time time3 = new Time(16, 47);
    private Trains train1 = new Trains("Tr1", time1, station1);
    private Trains train2 = new Trains("Tr2", time2, station2);
    private ArrayList<Station> intermediateStations3 = new ArrayList<>(Arrays.asList(station4, station5));
    private Trains train3 = new Trains("Tr3", time3, station3, intermediateStations3);
    private ArrayList<Trains> trainList = new ArrayList<>(Arrays.asList(train1, train2, train3));
    private Timetable trainTimetable = new Timetable(trainList);

    @Test
    public void findTrain1() {
        Time time4 = new Time(9, 37);
        Trains trainFind = trainTimetable.findTrain(station2, time4);
        assertEquals(train2, trainFind);
    }

    @Test
    public void findTrain2() {
        Time time4 = new Time(9, 37);
        Time newTime = new Time(9, 40);
        Trains newTrain = new Trains("Tr5", newTime, station2);
        trainTimetable.addTrain(newTrain);
        Trains trainFind = trainTimetable.findTrain(station2, time4);
        assertEquals(newTrain, trainFind);
    }

    @Test
    public void addTrain() {
        Time time5 = new Time(15, 16);
        Trains newTrain = new Trains("Tr4", time5, station1);
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

    @Test
    public void haveStation() {
        assertTrue(trainTimetable.getTrainTimetable().get(1).haveStation(station2));
    }
}
