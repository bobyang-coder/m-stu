package nativecode;

/**
 * 影片对象
 * <p>
 * 纯数据类
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/4
 */
public class Movie {
    public static final int REGULAR = 0;//普通片
    public static final int NEW_RELEASE = 1;//新片
    public static final int CHILDRENS = 2;//儿童片


    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
