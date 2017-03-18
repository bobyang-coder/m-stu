package com.bob.stu.Strategy.withdraw;

/**
 * 抽象策略角色-提现失败后操作
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/17
 */
public interface WithdrawFail {

    //提现退款
    void refund();
}
