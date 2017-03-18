package com.bob.stu.Strategy.withdraw;

/**
 * 具体策略角色-商户会员提现失败-退款
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public class CustMemWithdrawFail implements WithdrawFail {
    public void refund() {
        System.out.println("商户会员提现失败-退款");
    }
}
