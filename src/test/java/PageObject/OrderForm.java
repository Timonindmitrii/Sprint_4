package PageObject;

    public class OrderForm {
        private final String name;
        private final String surname;
        private final String address;
        private final String metroStation;
        private final String phoneNumber;
        private final String orderDate ;
        private final String rentalPeriod;
        private final String scooterColour;
        private final String orderComment;
        //Конструктор
        public OrderForm(String name, String surname, String address, String metroStation, String phoneNumber, String orderDate,
                         String rentalPeriod, String scooterColour, String orderComment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.metroStation = metroStation;
            this.phoneNumber = phoneNumber;
            this.orderDate = orderDate;
            this.rentalPeriod = rentalPeriod;
            this.scooterColour = scooterColour;
            this.orderComment = orderComment;
        }
        //Геттеры на све параметры
        public  String getName() {
            return name;
        }
        public  String getSurname() {
            return surname;
        }
        public String getAddress() {
            return address;
        }
        public  String getMetroStation() {
            return metroStation;
        }
        public  String getPhoneNumber() {
            return phoneNumber;
        }
        public  String getOrderDate() {
            return orderDate;
        }
        public  String getRentalPeriod() {
            return rentalPeriod;
        }
        public  String getScooterColour() {
            return scooterColour;
        }
        public  String getOrderComment() {
            return orderComment;
        }
    }

