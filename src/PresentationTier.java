public class PresentationTier {

    ApplicationTier ap = new ApplicationTier();

    void presentationTier() throws Exception {

        while (true) {

            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Ambulance");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Check for any patient info sent from hospital.");
            System.out.println("3. Enter and send callout details to the hospital.");
            System.out.println("4. Exit program.");

            ap.applicationTier();
        }


    }


    void enterNameMsg() {

        System.out.println("Enter patient's name:");
    }

    void enterSurnameMsg() {

        System.out.println("Enter patient's surname:");
    }

    void enterNhsNoMsg() {

        System.out.println("Enter patient's NHS registration number:");
    }

    void enterAccDescMsg() {

        System.out.println("Enter patient's accident description:");
    }

    void enterLocationMsg() {

        System.out.println("Enter accident's location:");
    }

    void enterActionTakenDesc() {

        System.out.println("Enter description of action taken:");
    }


    void enterCallTimeMsg() {

        System.out.println("Enter call time:");
    }

    void patientDetailsMsg(String name, String surname, int nhsNo, String address, String medicalCond) {

        System.out.println(
                "Name:'" + name + '\'' +
                        ", Surname:'" + surname + '\'' +
                        ", NHS Registration Number:" + nhsNo +
                        ", Address:'" + address + '\'' +
                        ", Medical Condition:'" + medicalCond);
    }

    void IOMsg() {

        System.err.println("Error in I/O");
    }

    void noDataMsg() {

        System.err.println("No available data show.");
    }

    void errorOcMsg() {

        System.err.println("Error Occurred");
    }


}
