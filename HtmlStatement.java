import java.util.Enumeration;

public class HtmlStatement extends Statement {
    
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = getRecord(aCustomer);
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += getFigures(each);
        }
        //add footer lines
        result +=  getFooter(aCustomer);
        return result;
    }

    public String getRecord(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    public String getFigures(Rental aRental) {
        return aRental.getMovie().getTitle() + ": " +
               String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    public String getFooter(Customer aCustomer) {
        return "<P>You owe <EM>" + 
               String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
               "On this rental you earned <EM>" +
               String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
               "</EM> frequent renter points<P>";
    }
}
