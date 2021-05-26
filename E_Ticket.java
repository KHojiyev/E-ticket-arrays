package Module2_OOP.ExtraTasks.Lesson4.E_ticket;

import java.util.Objects;
import java.util.Scanner;

public class E_Ticket {
    // Composition

    public static Ticket[] tickets = new Ticket[54];
    public static int count = 0;
    public static Order[] orders = new Order[10];
    public static User[] users = new User[100];
    public static User activeUser = new User(null, null, null, null, null);
    public static TrainSchedule[] trainSchedule = new TrainSchedule[25];
    public static Train[] trains = new Train[10];

    public static void main(String[] args) {
        initBase();
        while (true) {
            login();
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String loginName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        boolean notLoginUser = true;
        for (User loginUser : users) {
            if (loginUser != null) {
                if (loginUser.getFirstName().equals(loginName) && loginUser.getPassword().equals(password)) {
                    notLoginUser = false;
                    System.out.println("\nWelcome to E-Ticket " + loginUser.getFirstName() + " " + loginUser.getSecondName());
                    activeUser = loginUser;
                    activeUserCommands();
                }
            }
        }
        if (notLoginUser) {
            System.out.println("Incorrect login (0-Exit)");
        }

    }

    private static void activeUserCommands() {
        while (true) {
            showMAinMenu();
            Scanner scanner = new Scanner(System.in);
            int choiceActiveUser = scanner.nextInt();
            switch (choiceActiveUser) {
                case 1:
                    System.out.println("--Order Ticket--");
                    orderTicket();
                    break;
                case 2:
                    System.out.println("--Show Train schedule--");
                    showTrainSchedules();
                    break;
                case 3:
                    System.out.println("--Ordered Tickets-- ");
                    showOrderedTickets();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
        }
    }

    private static void showOrderedTickets() {
        System.out.println("----------------------------------------");
        for (int i = 0; i < count; i++) {
            if (Objects.equals(activeUser, orders[i].getUser())) {
                System.out.println("TicketId: " + orders[i].getOrderId() + " | " +
                        "From: " + orders[i].getTicket().getTrainSchedule().getFromStation() + " | " +
                        "To: " + orders[i].getTicket().getTrainSchedule().getToStation() + " | " +
                        "Class: " + orders[i].getTicket().getClassCategory() + " | " +
                        "Price: " + orders[i].getTicket().getPrice());
            }
        }
        System.out.println("----------------------------------------\n");

    }

    private static void orderTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        String fromStation = scanner.nextLine();
        System.out.print("To: ");
        String toStation = scanner.nextLine();
        System.out.print("Category: ");
        int category = scanner.nextInt();
        boolean trainScheduleFound = false;
        for (Ticket orderTicket : tickets) {
            if (orderTicket != null && orderTicket.getTrainSchedule().getFromStation().equals(fromStation) &&
                    orderTicket.getTrainSchedule().getToStation().equals(toStation) &&
                    orderTicket.getClassCategory() == category) {
                trainScheduleFound = true;
                System.out.println(orderTicket.getTicketNumber() + " " + orderTicket.getTrainSchedule().getFromStation() + " "
                        + orderTicket.getTrainSchedule().getToStation() + " " + orderTicket.getClassCategory() + " " + orderTicket.getPrice());
                System.out.println("Do you order the ticket   Yes-1 or No-2");
                scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice == 1) {
                    orders[count] = new Order(count, activeUser, orderTicket);
                    count++;
                    System.out.println("You ordered succesfully!!\n");
                    break;
                }
            }

        }
        if (!trainScheduleFound) {
            System.out.println("\nSuch TrainSchedule is not exist!\n");
        }
    }

    private static void showTrainSchedules() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        String from = scanner.nextLine();
        System.out.println("----------------------------------------");
        for (TrainSchedule schedule : trainSchedule) {
            if (schedule != null) {
                if (schedule.getFromStation().contains(from)) {
                    System.out.println(schedule.getTrain().getNumberId() + " " + schedule.getFromStation() + " " + schedule.getToStation());
                }
            }
        }
        System.out.println("----------------------------------------\n");


    }

    private static void showMAinMenu() {
        System.out.println("Main menu: ");
        System.out.println("----------------------------------------");
        System.out.println("1.Order ticket\n" +
                "2.Show Train Schedules\n" +
                "3.Show my Ordered Tickets\n" +
                "0.Exit");
        System.out.println("----------------------------------------");
    }

    private static void initBase() {

        trains[0] = new Train("123@123", 500);
        trains[1] = new Train("123@124", 635);
        trains[2] = new Train("123@125", 540);
        trains[3] = new Train("123@126", 100);
        trains[4] = new Train("123@127", 50);
        trains[5] = new Train("123@128", 120);
        trains[6] = new Train("123@129", 400);

        trainSchedule[0] = new TrainSchedule(trains[0], "TashkentSouth", "Buxara");
        trainSchedule[1] = new TrainSchedule(trains[0], "TashkentNorth", "Buxara");
        trainSchedule[2] = new TrainSchedule(trains[1], "Tashkent", "Nukus");
        trainSchedule[3] = new TrainSchedule(trains[1], "Tashkent", "Andijan");
        trainSchedule[4] = new TrainSchedule(trains[2], "Tashkent", "Kokan");
        trainSchedule[5] = new TrainSchedule(trains[2], "Kokan", "Fergana");
        trainSchedule[6] = new TrainSchedule(trains[3], "Andijan", "Tashkent");
        trainSchedule[7] = new TrainSchedule(trains[3], "Nukus", "Tashkent");
        trainSchedule[8] = new TrainSchedule(trains[4], "Fergana", "TashkentSouth");
        trainSchedule[9] = new TrainSchedule(trains[4], "Buxara", "TashkentSouth");
        trainSchedule[10] = new TrainSchedule(trains[5], "Buxara", "TashkentNorth");
        trainSchedule[11] = new TrainSchedule(trains[5], "Fergana", "TashkentNorth");
        trainSchedule[12] = new TrainSchedule(trains[6], "Fergana", "Kokan");
        trainSchedule[13] = new TrainSchedule(trains[6], "Fergana", "Andijan");
        trainSchedule[14] = new TrainSchedule(trains[4], "Fergana", "Namangan");
        trainSchedule[15] = new TrainSchedule(trains[4], "Namangan", "Kokan");
        trainSchedule[16] = new TrainSchedule(trains[5], "Kokan", "Pap");
        trainSchedule[17] = new TrainSchedule(trains[5], "Samarkand", "Nukus");

        users[0] = new User("Lochinbek", "Xojiyev", "Khojiyev@gmail.com", "asd123", null);
        users[1] = new User("Shohruh", "Sindarov", "Sindarov@gmail.com", "asd123", null);
        users[2] = new User("Sodiq", "Bo'riyev", "Boriyev@gmail.com", "asd123", null);
        users[3] = new User("Mamur", "Karimov", "Karimov@gmail.com", "asd123", null);
        users[4] = new User("Shokir", "Ahtamov", "Ahtamov@gmail.com", "asd123", null);

        tickets[0] = new Ticket("000", trainSchedule[0], 1, 250000);
        tickets[1] = new Ticket("010", trainSchedule[0], 2, 200000);
        tickets[2] = new Ticket("100", trainSchedule[0], 3, 150000);
        tickets[3] = new Ticket("000", trainSchedule[1], 1, 250000);
        tickets[4] = new Ticket("010", trainSchedule[1], 2, 200000);
        tickets[5] = new Ticket("100", trainSchedule[1], 3, 150000);
        tickets[6] = new Ticket("000", trainSchedule[2], 1, 250000);
        tickets[7] = new Ticket("001", trainSchedule[2], 2, 200000);
        tickets[8] = new Ticket("100", trainSchedule[2], 3, 150000);
        tickets[9] = new Ticket("000", trainSchedule[3], 1, 250000);
        tickets[10] = new Ticket("010", trainSchedule[3], 2, 200000);
        tickets[11] = new Ticket("100", trainSchedule[3], 3, 150000);
        tickets[12] = new Ticket("000", trainSchedule[4], 1, 250000);
        tickets[13] = new Ticket("010", trainSchedule[4], 2, 200000);
        tickets[14] = new Ticket("100", trainSchedule[4], 3, 150000);
        tickets[15] = new Ticket("000", trainSchedule[5], 1, 250000);
        tickets[16] = new Ticket("001", trainSchedule[5], 2, 200000);
        tickets[17] = new Ticket("100", trainSchedule[5], 3, 150000);
        tickets[18] = new Ticket("000", trainSchedule[6], 1, 250000);
        tickets[19] = new Ticket("001", trainSchedule[6], 2, 200000);
        tickets[20] = new Ticket("100", trainSchedule[6], 3, 150000);
        tickets[21] = new Ticket("000", trainSchedule[7], 1, 250000);
        tickets[22] = new Ticket("001", trainSchedule[7], 2, 200000);
        tickets[23] = new Ticket("100", trainSchedule[7], 3, 150000);
        tickets[24] = new Ticket("000", trainSchedule[8], 1, 250000);
        tickets[25] = new Ticket("001", trainSchedule[8], 2, 200000);
        tickets[26] = new Ticket("100", trainSchedule[8], 3, 150000);
        tickets[27] = new Ticket("000", trainSchedule[9], 1, 250000);
        tickets[28] = new Ticket("001", trainSchedule[9], 2, 200000);
        tickets[29] = new Ticket("100", trainSchedule[9], 3, 150000);
        tickets[30] = new Ticket("000", trainSchedule[10], 1, 250000);
        tickets[31] = new Ticket("001", trainSchedule[10], 2, 200000);
        tickets[32] = new Ticket("100", trainSchedule[10], 3, 150000);
        tickets[33] = new Ticket("000", trainSchedule[11], 1, 250000);
        tickets[34] = new Ticket("001", trainSchedule[11], 2, 200000);
        tickets[35] = new Ticket("100", trainSchedule[11], 3, 150000);
        tickets[36] = new Ticket("000", trainSchedule[12], 1, 250000);
        tickets[37] = new Ticket("001", trainSchedule[12], 2, 200000);
        tickets[38] = new Ticket("100", trainSchedule[12], 3, 150000);
        tickets[39] = new Ticket("000", trainSchedule[13], 1, 250000);
        tickets[40] = new Ticket("001", trainSchedule[13], 2, 200000);
        tickets[41] = new Ticket("100", trainSchedule[13], 3, 150000);
        tickets[42] = new Ticket("000", trainSchedule[14], 1, 250000);
        tickets[43] = new Ticket("001", trainSchedule[14], 2, 200000);
        tickets[44] = new Ticket("100", trainSchedule[14], 3, 150000);
        tickets[45] = new Ticket("000", trainSchedule[15], 1, 250000);
        tickets[46] = new Ticket("001", trainSchedule[15], 2, 200000);
        tickets[47] = new Ticket("100", trainSchedule[15], 3, 150000);
        tickets[48] = new Ticket("000", trainSchedule[16], 1, 250000);
        tickets[49] = new Ticket("001", trainSchedule[16], 2, 200000);
        tickets[50] = new Ticket("100", trainSchedule[16], 3, 150000);
        tickets[51] = new Ticket("000", trainSchedule[17], 1, 250000);
        tickets[52] = new Ticket("001", trainSchedule[17], 2, 200000);
        tickets[53] = new Ticket("100", trainSchedule[17], 3, 150000);

    }
}
