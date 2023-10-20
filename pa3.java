import java.time.*;

class Flight {
    /* Fields from PA 2*/
    String flightNo;
    String departureAirport;
    String arrivalAirport;
    String aircraftType;
    double cost;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    int capacity;
    int numBooked;

    /* TODO: Add new fields for PA 3 */


    Flight(String flightNo, String departureAirport,
            String arrivalAirport, String aircraftType,
            double cost, LocalDateTime departureTime,
            LocalDateTime arrivalTime, int capacity) {
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.aircraftType = aircraftType;
        this.cost = cost;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
    }

    boolean departsBefore(Flight other){
        return this.departureTime.isBefore(other.departureTime);
    }

    boolean arrivesBefore(Flight other){
        return this.arrivalTime.isBefore(other.arrivalTime);
    }

    double costInSkyPoints(){
        return cost * 100;
    }
    /* TODO: Write PA 3 methods */
}

class Ticket {
    /* TODO: Implement the Ticket class. */
    Flight flight;
    Passenger pax;
    LocalDateTime purchaseTime = LocalDateTime.now();
    LocalDateTime cancelDeadline = purchaseTime.plusDays(1);
    boolean purchasedWithSkyPoints;
    boolean cancelled = false;

    Ticket(Passenger pax, Flight flight, boolean purchasedWithSkyPoints){
        this.pax = pax;
        this.flight = flight;
        this.purchasedWithSkyPoints = purchasedWithSkyPoints;
        this.flight.numBooked++;
    }

    boolean cancel() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(cancelDeadline)) {
            return false; 
        }
        if (purchasedWithSkyPoints) {
            pax.skyPoints += flight.costInSkyPoints();
        } 
        else {
            double refundAmount = flight.cost * 0.95;
            pax.cashBalance += refundAmount;
        }
        flight.numBooked--;
        cancelled = true;
        return true; 
    }
}

class Passenger {
    /* 
     * All fields have been created for you, including the new
     * cashBalance field. 
     */
    int skyId;
    String firstName;
    String lastName;
    int skyPoints;
    double cashBalance;

    Passenger(int skyId, String firstName, String lastName,
            int skyPoints, double cashBalance) {
        /* TODO: Write the constructor */
        this.skyId = skyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skyPoints = skyPoints;
        this.cashBalance = cashBalance;
    }

    /*
     * TODO: Write the book() method.
     */
     Ticket book(Flight flight) {
        if (flight.capacity > flight.numBooked) {
            if (skyPoints >= flight.costInSkyPoints()) {
                skyPoints -= flight.costInSkyPoints();
                return new Ticket(this, flight, true);
            }
            else if (cashBalance >= flight.cost) {
                cashBalance -= flight.cost;
                return new Ticket(this, flight, false);
            }
        }
        return null;
     }
}


class FlightTest {
    /*
     * The following are some examples for how you can use
     * the LocalDateTime class.
     */

    // LocalDateTime object for October 23, 2023 04:00 PM
    LocalDateTime dt1 = LocalDateTime.of(2023, 10, 23, 16, 0);
    // LocalDateTime object for October 23, 2023 05:30 PM
    LocalDateTime dt2 = LocalDateTime.of(2023, 10, 23, 17, 30);
    // LocalDateTime object for the current time.
    LocalDateTime current = LocalDateTime.now();

    /* Create your own tests here */
    
}
