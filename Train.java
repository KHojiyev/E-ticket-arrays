package Module2_OOP.ExtraTasks.Lesson4.E_ticket;

public class Train {
    public int seatCount;
    private String numberId;

    public Train(String numberId, int seatCount) {
        this.numberId = numberId;
        this.seatCount = seatCount;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
