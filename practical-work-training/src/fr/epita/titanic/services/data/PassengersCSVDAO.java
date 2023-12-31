package fr.epita.titanic.services.data;

import fr.epita.titanic.datamodel.Passenger;
import fr.epita.titanic.datamodel.PassengerClass;
import fr.epita.titanic.datamodel.PassengerSex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PassengersCSVDAO {

    public static List<Passenger> readAll(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(new File(filePath).toPath());
        List<Passenger> passengers = new ArrayList<>();
        lines.remove(0);
        for(String line : lines) {
            String[] passengersPart = line.split(";");
            String name = passengersPart[0].trim();
            PassengerClass passengerClass = PassengerClass.resolve(passengersPart[1].trim());
            Double age = 0.0;
            if (!passengersPart[2].trim().isEmpty()) {
                age = Double.parseDouble(passengersPart[2].trim());
            }
            PassengerSex passengerSex = PassengerSex.resolve(passengersPart[3].trim());
            Boolean survived = "1".equals(passengersPart[4].trim());
            Passenger passenger = new Passenger(name, passengerClass, age, passengerSex, survived);
            passengers.add(passenger);
        }
        return passengers;
    }
}
