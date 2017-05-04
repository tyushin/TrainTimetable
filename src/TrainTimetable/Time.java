package TrainTimetable;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes ) {
        if (hours < 0 || hours > 23 || minutes < 0 ||  minutes > 59){
            throw new IllegalArgumentException();
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int toMinutes(){
        return getMinutes() + getHours() * 60;
    }

    @Override
    public String toString(){
        return hours + ":" + minutes;
    }
}
