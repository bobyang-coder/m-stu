import nativecode.Customer;
import nativecode.Movie;
import nativecode.Rental;
import refactoring.CustomerRefactor;
import refactoring.MovieRefactor;
import refactoring.RentalRefactor;

/**
 * Created by bob on 2017/4/4.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class Test {
    public static void main(String[] args) {
        nativeCode();
        System.out.println("============重构后============");
        refactoring();
    }


    public static void nativeCode() {
        Customer customer = new Customer("bob");
        customer.addRental(new Rental(new Movie("三国演义", 0), 2));
        customer.addRental(new Rental(new Movie("水浒传", 1), 2));
        customer.addRental(new Rental(new Movie("西游记", 2), 8));
        System.out.println(customer.statement());
    }

    public static void refactoring() {
        CustomerRefactor customer = new CustomerRefactor("bob");
        customer.addRental(new RentalRefactor(new MovieRefactor("三国演义", 0), 2));
        customer.addRental(new RentalRefactor(new MovieRefactor("水浒传", 1), 2));
        customer.addRental(new RentalRefactor(new MovieRefactor("西游记", 2), 8));
        System.out.println(customer.statement());
    }
}
