package TrainTimetable;

import java.util.ArrayList;

public class Trains {
    private String name;
    private Time time;
    private Station endStation;
    private ArrayList<Station> intermediateStations = new ArrayList<>();

    public Trains (String name, Time time, Station endStation){
        this.name = name;
        this.time = time;
        this.endStation = endStation;
    }

    public Trains (String name, Time time, Station endStation, ArrayList<Station> intermediateStations){
        this.name = name;
        this.time = time;
        this.endStation = endStation;
        this.intermediateStations = new ArrayList<>(intermediateStations);
    }

    public String getName(){
        return name; 
    }

    public Time getTime(){
        return time;
    }

    public Station getEndStation(){
        return endStation;
    }

    public ArrayList<Station> getIntermediateStations() {
        return intermediateStations;
    }
    public void addIntermediateStation(Station intermediateStation){
        intermediateStations.add(intermediateStation);
    }
    public void removeIntermediateStation(Station intermediateStation){
        intermediateStations.remove(intermediateStation);
    }
}
