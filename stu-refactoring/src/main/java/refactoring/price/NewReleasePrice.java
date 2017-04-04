package refactoring.price;

import nativecode.Movie;

/**
 * Created by bob on 2017/4/4.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoint(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
