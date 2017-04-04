package refactoring;


import java.util.Enumeration;
import java.util.Vector;

/**
 * customer类重构
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class CustomerRefactor {

    private String name;
    private Vector _rentals = new Vector();

    public CustomerRefactor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 租贷
     *
     * @param arg
     */
    public void addRental(RentalRefactor arg) {
        _rentals.add(arg);
    }


    /**
     * 生成详单
     *
     * @return
     */
    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = getName() + "的租贷记录\n";
        while (rentals.hasMoreElements()) {
            RentalRefactor rental = (RentalRefactor) rentals.nextElement();
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        result += "你的欠款为" + String.valueOf(this.getTotalCharge()) + "\n";
        result += "你赚了" + String.valueOf(this.getTotalChargeFrequentRenterPoint()) + "租贷积分";
        return result;
    }


    /**
     * 获取总欠款
     *
     * @return
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            RentalRefactor rental = (RentalRefactor) rentals.nextElement();
            double thisAmount = rental.getCharge();
            result += thisAmount;
        }
        return result;
    }

    /**
     * 获取总常客积分点
     *
     * @return
     */
    private int getTotalChargeFrequentRenterPoint() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            RentalRefactor rental = (RentalRefactor) rentals.nextElement();
            result += rental.getFrequentRenterPoint();
        }
        return result;
    }

}
