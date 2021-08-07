import java.util.Enumeration;

public abstract class Statement {
    
    public abstract String getRecord(Customer aCustomer);
    public abstract String getFigures(Rental aRental);
    public abstract String getFooter(Customer aCustomer);

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
}
