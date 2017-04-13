package account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 账户转账请求
 * 前提：
 * 1.同一业务产品的转账码一致
 * <p>
 * 好处
 * 1.无需手动拼接转账码
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/13
 */
public class AccTransferReq {
    private String STR_1 = "1";
    private String STR_2 = "2";
    private String STR_3 = "3";
    private String STR_CURRENCY = "CNY";
    private String reapalFeeAccount = "300000000000";

    private String customerNo;
    private String memberNo;

    private String netFromObjectNo;
    private String netToObjectNo;
    private Long net;//交易净额
    private String netTradingNote;//交易净额的记账备注

    private String feeOfPayer;//手续费收取对象(商户1、会员2)
    private String feeType;//手续费类型(即扣1、预收2、月结3)
    private long reapalFee;//融宝须收手续费金额
    private String reapalFeeTradingNote;//融宝须收手续费金额的记账备注

    private String custFee;//商户收会员手续费

    private String productId;//产品码
    private String categoryId;//业务码
    private String tradeNo;//交易号
    private String matchTradeNo;//清算交易号
    private String customerFlagNo;//外部订单号

    public List<ReqAcc> getReqAccList() {
        ArrayList<ReqAcc> list = new ArrayList<ReqAcc>();
        list.add(this.getNetReqAcc());
        list.add(this.getReapalFeeReqAcc());
        return list;
    }

    /**
     * net的转账指令
     * 需要确保reqAcc必要参数都有
     *
     * @return
     */
    private ReqAcc getNetReqAcc() {
        return this.getReqAcc(netFromObjectNo, netToObjectNo, net, this.getNetTradingCode(), "net", netTradingNote);
    }

    /**
     * 融宝收取手续费的转账指令
     *
     * @return
     */
    public ReqAcc getReapalFeeReqAcc() {
        return this.getReqAcc(this.getReapalFeeFromObjectNo(), reapalFeeAccount, reapalFee, this.getReapalFeeTradingCode(), "fee", reapalFeeTradingNote);
    }

    private ReqAcc getReqAcc(String fromObjectNo, String toObjectNo, long amount, String tradingCode, String transferType, String tradingNote) {
        if (amount == 0) {
            return null;
        }
        ReqAcc reqAcc = new ReqAcc();
        //不同处
        reqAcc.setFromCustomerNo(fromObjectNo);
        reqAcc.setToCustomerNo(toObjectNo);
        reqAcc.setAmount(amount);
        reqAcc.setTradingCode(this.getNetTradingCode());
        reqAcc.setTransferType(transferType);
        reqAcc.setTradingNote(tradingNote);
        //相同处
        reqAcc.setCurrency(STR_CURRENCY);
        reqAcc.setTradeDate(new Date());
        reqAcc.setTradeNo(tradeNo);
        reqAcc.setMatchTradeNo(matchTradeNo);
        reqAcc.setBusinessNumber(categoryId);
        reqAcc.setProductNumber(productId);
        reqAcc.setCustomerFlagNo(customerFlagNo);
        return reqAcc;
    }

    /**
     * 交易净额转账码
     *
     * @return
     */
    private String getNetTradingCode() {
        String from = netFromObjectNo.substring(0, 2);
        String to = netToObjectNo.substring(0, 2);
        String netTradingCode = "";
        switch (categoryId + "-" + productId) {
            case "140010-120010":
                netTradingCode = from + "11" + to + "12";
                break;
            default:
                break;
        }
        return netTradingCode;
    }

    /**
     * 融宝手续费转账码
     *
     * @return
     */
    private String getReapalFeeTradingCode() {
        String from = this.getReapalFeeFromObjectNo().substring(0, 2);
        String to = this.getReapalFeeToObjectNo().substring(0, 2);
        String netTradingCode = "";
        switch (categoryId + "-" + productId) {
            case "140010-120010":
                netTradingCode = from + "11" + to + "12";
                break;
            default:
                break;
        }
        return netTradingCode;
    }


    /**
     * 获取融宝手续费收取对象号
     *
     * @return
     */
    private String getReapalFeeFromObjectNo() {
        String reapalFeeFromObjectNo = "";
        if (STR_1.equals(feeOfPayer)) {//向商户收
            reapalFeeFromObjectNo = customerNo;
        } else if (STR_2.equals(feeOfPayer)) {//向会员收
            reapalFeeFromObjectNo = memberNo;
        }
        return reapalFeeFromObjectNo;
    }

    /**
     * 获取融宝手续费收取对象号
     *
     * @return
     */
    private String getReapalFeeToObjectNo() {
        String reapalFeeFromObjectNo = "";
        switch (categoryId + "-" + productId) {
            case "140010-120010":
            case "140010-120011":
                reapalFeeFromObjectNo = customerNo;
                break;
            default:
                break;
        }
        return reapalFeeFromObjectNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public void setNetFromObjectNo(String netFromObjectNo) {
        this.netFromObjectNo = netFromObjectNo;
    }

    public void setNetToObjectNo(String netToObjectNo) {
        this.netToObjectNo = netToObjectNo;
    }

    public void setNet(Long net) {
        this.net = net;
    }

    public void setNetTradingNote(String netTradingNote) {
        this.netTradingNote = netTradingNote;
    }

    public void setFeeOfPayer(String feeOfPayer) {
        this.feeOfPayer = feeOfPayer;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public void setReapalFee(long reapalFee) {
        this.reapalFee = reapalFee;
    }

    public void setReapalFeeTradingNote(String reapalFeeTradingNote) {
        this.reapalFeeTradingNote = reapalFeeTradingNote;
    }

    public void setCustFee(String custFee) {
        this.custFee = custFee;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public void setMatchTradeNo(String matchTradeNo) {
        this.matchTradeNo = matchTradeNo;
    }

    public void setCustomerFlagNo(String customerFlagNo) {
        this.customerFlagNo = customerFlagNo;
    }
}
