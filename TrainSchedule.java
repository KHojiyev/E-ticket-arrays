package Module2_OOP.ExtraTasks.Lesson4.E_ticket;

public class TrainSchedule {
    private static int ticketCount;
    private Train train;
    private String fromStation;
    private String ToStation;

    public TrainSchedule(Train train, String fromStation, String toStation) {
        this.train = train;
        this.fromStation = fromStation;
        ToStation = toStation;
    }

    public static int getTicketCount() {
        return ticketCount;
    }

    public static void setTicketCount(int ticketCount) {
        TrainSchedule.ticketCount = ticketCount;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return ToStation;
    }

    public void setToStation(String toStation) {
        ToStation = toStation;
    }
}
