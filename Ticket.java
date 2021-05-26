package Module2_OOP.ExtraTasks.Lesson4.E_ticket;

public class Ticket {
    private String ticketNumber;
    private TrainSchedule trainSchedule;
    private int classCategory;
    private double price;

    public Ticket(String ticketNumber, TrainSchedule trainSchedule, int classCategory, double price) {
        this.ticketNumber = ticketNumber;
        this.trainSchedule = trainSchedule;
        this.classCategory = classCategory;
        this.price = price;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public TrainSchedule getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(TrainSchedule trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public int getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(int classCategory) {
        this.classCategory = classCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
