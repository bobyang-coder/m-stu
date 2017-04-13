package account;/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2015
 */

import java.io.Serializable;
import java.util.List;


/**
 * @ClassName: account.ResAcc
 * @Description: 账务返回结果 
 * @author Eric wangdong@reapal.com
 * @date 2015年8月12日 下午4:06:55
 */
public class ResAcc implements Serializable{
	

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 5163459459276285704L;

	/**
	 * @Fields result : 结果
	 */
	private boolean result;
	
	/**
	 * @Fields transCode : 账务事物凭证号
	 */
	private String transCode;
	
	/**
	 * @Fields transIds : 账户指令id集合
	 */
	private List<String> transIds;
	
	/**
	 * @Fields errorCode : 当result为false，返回错误码。00代表成功，ff代表未知异常。
	 */
	private String errorCode;
	
	/**
	 * @Fields errorMsg : 当result为false，返回错误原因
	 */
	private String errorMsg;

    /**
     * 封装账户号
     */
    private String accountNo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<String> getTransIds() {
		return transIds;
	}

	public void setTransIds(List<String> transIds) {
		this.transIds = transIds;
	}

    @Override
    public String toString() {
        return "account.ResAcc{" +
                "result=" + result +
                ", transCode='" + transCode + '\'' +
                ", transIds=" + transIds +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
    

}
