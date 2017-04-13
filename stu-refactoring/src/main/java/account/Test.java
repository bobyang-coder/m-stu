package account;

import java.util.List;

/**
 * Created by bob on 2017/4/14.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/14
 */
public class Test {
    public static void main(String[] args) {
        AccTransferReq req = new AccTransferReq();
        req.setNetFromObjectNo("100000");
        req.setNetToObjectNo("200000");
        req.setNet(100L);
        req.setTradeNo("bob110");
        req.setMatchTradeNo("bob120");
        req.setCustomerFlagNo("bob");
        req.setNetTradingNote("转账交易净额");
        req.setFeeOfPayer("1");
        req.setFeeType("1");
        req.setReapalFee(2L);
        req.setCategoryId("140010");
        req.setProductId("120010");
        req.setReapalFeeTradingNote("融宝收商户手续费");
        req.setFeeType("1");
        req.setCustomerNo("10000");
        req.setMemberNo("20000");

        List<ReqAcc> reqAccList = req.getReqAccList();
        System.out.println(reqAccList.toString());

    }
}
