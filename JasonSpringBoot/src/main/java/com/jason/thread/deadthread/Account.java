package com.jason.thread.deadthread;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 22:31
 **/
public class Account {
    public Account(String accountName, long amount) {
        this.accountName = accountName;
        this.amount = amount;
    }

    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private long  amount;

    public Account(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    //存钱
    public long deposit(long amount)
    {
        setAmount(getAmount()+amount);
        return getAmount();
    }

    public long withDraw(long amount)
    {
       setAmount((getAmount()-amount)<=0 ? 0:getAmount()-amount);
       return getAmount();
    }
}
