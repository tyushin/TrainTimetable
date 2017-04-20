package TrainTimetable;

import java.util.ArrayList;

public class Trains {
    private String name;
    private String time;
    private Station endStation;
    private ArrayList<Station> intermediateStations = new ArrayList<Station>();

    public Trains (String name, String time, Station endStation){
        this.name = name;
        this.time = time;
        this.endStation = endStation;
    }

    public Trains (String name, String time, Station endStation, ArrayList<Station> intermediateStations){
        this.name = name;
        this.time = time;
        this.endStation = endStation;
        this.intermediateStations = intermediateStations;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }

    public Station getEndStation(){
        return endStation;
    }
    public void setEndStation(Station endStation){
        this.endStation = endStation;
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
