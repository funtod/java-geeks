package train;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        String fal = "There is no such trains";
        Sample sample = new Sample();
        Scanner scanner = new Scanner(System.in);


//        System.out.println("Input train destination");
//        String destination = scanner.next();
//        ArrayList<Train> trainsByDestination = sample.getTrainsByDestination(destination);
//
//        if (trainsByDestination.isEmpty()) {
//            System.out.println(fal);
//        } else {
//            System.out.println(trainsByDestination.toString());
//        }


        System.out.println("Input time in format YYYY/MM/DD HH:MM");
        Date time = java.sql.Date.valueOf(scanner.next());
        System.out.println("Input destination");
        String destination = scanner.next();

        ArrayList<Train> trainByDateByDestination = sample.getTrainsByTimeByDestination(time, destination);
        if (trainByDateByDestination.isEmpty()) {
            System.out.println(fal);
        } else {
            System.out.println(trainByDateByDestination.toString());
        }

//        System.out.println("Input train destination");
//        String destinationSeats= scanner.next();
//        System.out.println("Input numbers of seats");
//        int number = scanner.nextInt();
//        ArrayList<Train> trainsByDestinationSeats = sample.getTrainsByDestinationBySeats(destinationSeats, number);
//        if (trainsByDestinationSeats.isEmpty()) {
//            System.out.println(fal);
//        }
//        else {
//            System.out.println(trainsByDestinationSeats.toString());
//        }
        scanner.close();
    }
}
