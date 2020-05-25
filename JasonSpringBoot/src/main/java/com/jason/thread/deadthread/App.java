package com.jason.thread.deadthread;
/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 22:38
 **/

import static java.lang.Thread.sleep;

public class App implements  Runnable{
    ThreadLocal  local=new ThreadLocal();
    private Account subfromAccount;
    private Account accountTo;
    private long amount;

    public App(Account subfromAccount, Account accountTo,long amout) {
        this.subfromAccount = subfromAccount;
        this.accountTo = accountTo;
        this.amount=amout;
        local.set(amout);
    }

    public static void main(String[] args) {
          Account  subfromAccount  = new Account(400000);
          Account  accountTo  = new Account(100000);
          Thread depositThread=new Thread(new App(subfromAccount,accountTo,10));
          Thread withDrawThread=new Thread(new App(accountTo,subfromAccount,-30));
          depositThread.start();
          withDrawThread.start();
    }

    @Override
    public void run() {
             synchronized (subfromAccount)
             {
                    synchronized (accountTo)
                    {
                        while(true)
                        {
                            if(local.get()==null)
                            {
                                local.set(amount);
                            }
                            System.out.println(Thread.currentThread().getName()+"-->"+"local=="+local);
                            System.out.println(local.get());
                            long amounts= (long)local.get();
                            long subfromAmounts=subfromAccount.withDraw(amounts);
                            long accountTos=accountTo.deposit(amounts);
                            System.out.println("subfromAmounts------>"+subfromAmounts);
                            System.out.println("accountTos---------->"+accountTos);
                        }

                    }
             }

    }
}
