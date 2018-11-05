package Train;

import java.util.ArrayList;
import java.util.Date;

public class Sample {

    ArrayList<Train> trains = new ArrayList<Train>();

    {
        trains.add(new Train("Kyiv", new Date(2018, 10, 12, 12,11), 5200, 50));
        trains.add(new Train("Lviv", new Date(2018, 10, 12, 22, 13) , 2333, 23));
        trains.add(new Train("Luhansk", new Date(2018, 10, 12, 15, 10), 1200, 36));
        trains.add(new Train("Odesa", new Date(2018, 10, 12, 11, 11), 1836, 20));
        trains.add(new Train("Mykolaiv", new Date(2018, 10, 12, 23, 45), 8888, 23));
        trains.add(new Train("Zhytomyr", new Date(2018, 10, 12, 17, 11), 3688, 45));
        trains.add(new Train("Kyiv", new Date(2018, 10, 12, 19, 17), 8911,55));
        trains.add(new Train("Lviv", new Date(2018, 10, 12, 8, 7), 4777, 23));
        trains.add(new Train("Luhansk", new Date(2018, 10, 12, 6, 10), 9900, 86));
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public ArrayList<Train> getTrainsByDestination(String destination) {
        ArrayList<Train> sortedTrains = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.getTrainDestination().equals(destination)) {
                sortedTrains.add(train);
            }
        }
        return sortedTrains;
    }
    public ArrayList<Train> getTrainsByDestinationByTime (Date time, String destination) {
        ArrayList<Train> sortedTrains = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.getTrainTime().equals(time) && train.getTrainDestination().equals(destination)){
                sortedTrains.add(train);
            }
        }
        return sortedTrains;
    }
    public ArrayList<Train> getTrainsByDestinationBySeats (Date time, int number) {
        ArrayList<Train> sortedTrains = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.getTrainTime().equals(time) && train.getTrainNumber() == (number)){
                sortedTrains.add(train);
            }
        }
        return sortedTrains;
    }
}
