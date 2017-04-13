package account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 2017/4/13.
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/13
 */
public class AccountTransfer {

    private String[] transfer;

    /**
     * 格式：
     * @param arr
     * @return
     */
    public List<ReqAcc> getReqAccList(String[] arr) {
        ArrayList<ReqAcc> list = new ArrayList<ReqAcc>();
        for (int i = 0; i < arr.length; i++) {
            String[] transferReq = arr[i].split("-");
            for (int j = 0; j < transferReq.length; j++) {
                ReqAcc reqAcc = new ReqAcc();
                reqAcc.setFromCustomerNo(transferReq[0]);
                reqAcc.setToCustomerNo(transferReq[1]);
                reqAcc.setAmount(Long.valueOf(transferReq[2]));

            }

        }

        return list;
    }
}
