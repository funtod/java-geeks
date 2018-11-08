package train;

import java.util.Date;

class Train {
    private String trainDestination;
    private Date trainTime;
    private int trainNumber;
    private int trainNumberOfSeats;

    public Train(String trainDestination, Date trainTime, int trainNumber, int trainNumberOfSeats) {

        this.trainDestination = trainDestination;
        this.trainTime = trainTime;
        this.trainNumber = trainNumber;
        this.trainNumberOfSeats = trainNumberOfSeats;
    }

    public String getTrainDestination() {
        return this.trainDestination;
    }
    public Date getTrainTime() {
        return this.trainTime;
    }
    public int getTrainNumber() {
        return this.trainNumber;
    }
    public int getTrainNumberOfSeats() {
        return this.trainNumberOfSeats;
    }

}