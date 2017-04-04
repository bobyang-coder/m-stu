package refactoring;

import refactoring.price.ChildrensPrice;
import refactoring.price.NewReleasePrice;
import refactoring.price.Price;
import refactoring.price.RegularPrice;

/**
 * 影片对象
 * <p>
 * 纯数据类
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class MovieRefactor {
    public static final int REGULAR = 0;//普通片
    public static final int NEW_RELEASE = 1;//新片
    public static final int CHILDRENS = 2;//儿童片


    private String title;
    private Price price;

    public MovieRefactor(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    /**
     * 计算费用
     * 运用重构方法：Extract Method、Remove Method、
     *
     * @return
     */
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    /**
     * 计算常客积分
     *
     * @return
     */
    public int getFrequentRenterPoint(int daysRented) {
        return price.getFrequentRenterPoint(daysRented);
    }
}
