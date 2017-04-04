package refactoring;

/**
 * 租贷
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class RentalRefactor {

    private MovieRefactor movie;
    private int daysRented;//租贷天数

    public RentalRefactor(MovieRefactor movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public MovieRefactor getMovie() {
        return movie;
    }

    public void setMovie(MovieRefactor movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    /**
     * 计算欠款
     * 运用重构方法：Extract Method、Remove Method、
     *
     * @return
     */
    public double getCharge() {
        return movie.getCharge(this.getDaysRented());
    }

    /**
     * 计算常客积分
     *
     * @return
     */
    public int getFrequentRenterPoint() {
        return movie.getFrequentRenterPoint(this.getDaysRented());
    }
}
