package refactoring.price;

/**
 * 费用接口
 * <p>
 * (运用状态state模式)
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public abstract class Price {

    /**
     * 获取价格码
     *
     * @return
     */
    public abstract int getPriceCode();

    /**
     * 计算费用
     * 运用重构方法：Extract Method、Remove Method、
     *
     * @return
     */
    public abstract double getCharge(int daysRented);

    /**
     * 计算常客积分
     *
     * @return
     */
    public int getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
