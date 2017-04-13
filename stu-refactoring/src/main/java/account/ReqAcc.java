package account;/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2015
 */

import java.io.Serializable;
import java.util.Date;


/**
 * @author Eric wangdong@reapal.com
 * @ClassName: account.ReqAcc
 * @Description: 账务请求
 * @date 2015年8月12日 下午4:07:07
 */
public class ReqAcc implements Serializable {
    private static final long serialVersionUID = -5498173250094200328L;
    //交易码 (格式：10111012)
    private String tradingCode;
    //转账类型 只包括 净额和手续费 net 和 fee
    private String transferType;
    //金额
    private Long amount;
    //币种
    private String currency;
    //记账备注
    private String tradingNote;
    //交易发生日期，必传字段
    private Date tradeDate;
    //转出方对象码
    private String fromCustomerNo;
    //转入方对象码
    private String toCustomerNo;
    //产品码
    private String productNumber;
    //业务码
    private String businessNumber;
    //交易号
    private String tradeNo;
    //清算交易号
    private String matchTradeNo;

    public String getCustomerFlagNo() {
        return customerFlagNo;
    }

    public void setCustomerFlagNo(String customerFlagNo) {
        this.customerFlagNo = customerFlagNo;
    }

    /**
     * 商户标识号，用于记录上的订单号，退款单号，代付批次号等
     */
    private String customerFlagNo;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getMatchTradeNo() {

        return matchTradeNo;
    }

    public void setMatchTradeNo(String matchTradeNo) {
        this.matchTradeNo = matchTradeNo;
    }

    public String getFromCustomerNo() {
        return fromCustomerNo;
    }

    public void setFromCustomerNo(String fromCustomerNo) {
        this.fromCustomerNo = fromCustomerNo;
    }

    public String getToCustomerNo() {
        return toCustomerNo;
    }

    public void setToCustomerNo(String toCustomerNo) {
        this.toCustomerNo = toCustomerNo;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTradingCode() {
        return tradingCode;
    }

    public void setTradingCode(String tradingCode) {
        this.tradingCode = tradingCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTradingNote() {
        return tradingNote;
    }

    public void setTradingNote(String tradingNote) {
        this.tradingNote = tradingNote;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public String toString() {
        return "ReqAcc{" +
                "tradingCode='" + tradingCode + '\'' +
                ", transferType='" + transferType + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", tradingNote='" + tradingNote + '\'' +
                ", tradeDate=" + tradeDate +
                ", fromCustomerNo='" + fromCustomerNo + '\'' +
                ", toCustomerNo='" + toCustomerNo + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", matchTradeNo='" + matchTradeNo + '\'' +
                ", customerFlagNo='" + customerFlagNo + '\'' +
                '}';
    }
}
