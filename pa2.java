class Flight {
    String flightNo;
    String departureAirport;
    String arrivalAirport;
    String aircraftType;
    double cost;

    Flight(String flightNo, String departureAirport, String arrivalAirport,
    String aircraftType, double cost){
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.aircraftType = aircraftType;
        this.cost = cost;
    };

    boolean isSameFlightAs(Flight other){
        return this.flightNo.equals(other.flightNo);
    }         

    boolean hasSameRouteAs(Flight other){
        return this.departureAirport.equals(other.departureAirport) && 
        this.arrivalAirport.equals(other.arrivalAirport);
    }

    boolean costsMoreThan(Flight other){
        return this.cost > other.cost;
    }

    String getFlightPlanString(){
        return this.flightNo + ": " + this.departureAirport + "/" + 
        this.arrivalAirport + " " + this.aircraftType;
    }
}

class Passenger {
    int skyId;
    String firstName;
    String lastName;
    int skyPoints;
    Flight upcomingFlight;

    Passenger(int skyId, String firstName, String lastName, int skyPoints, Flight upcomingFlight){
        this.skyId = skyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skyPoints = skyPoints;
        this.upcomingFlight = upcomingFlight;
    }

    String getPassengerInfoString(){
        return this.firstName + " " + this.lastName + " " + 
        "[" + this.skyId + "]" + " " + 
        "(" + this.skyPoints + " points" + ")" + " " + 
        "Upcoming: " + this.upcomingFlight.flightNo;
    }
}

class FlightTest {
   Flight united1 = new Flight("UAL 2247", "KSAN", "KSFO", "B738", 243.0);
   Flight skywest1 = new Flight("SKW 3410", "KSAN", "KSFO", "E75L", 198.59);
   Flight united2 = new Flight("UAL 2461", "KSAN", "KEWR", "B752", 487.0);

   boolean isSameFlightAsTest1 = united1.isSameFlightAs(skywest1);
   boolean isSameFlightAsTest2 = united1.isSameFlightAs(united1);
   boolean hasSameRouteAsTest1 = united1.hasSameRouteAs(skywest1);
   boolean hasSameRouteAsTest2 = united1.hasSameRouteAs(united2);
   boolean costsMoreThanTest1 = united1.costsMoreThan(skywest1);
   boolean costsMoreThanTest2 = united2.costsMoreThan(skywest1);
   String flightPlan1 = united1.getFlightPlanString();
   String flightPlan2 = skywest1.getFlightPlanString();
   String flightPlan3 = united2.getFlightPlanString();
   Passenger pax1 = new Passenger(1337, "Gerald", "Soosairaj", 2500, united2);
   String pax2 = pax1.getPassengerInfoString();
}