package com.jason.thread.deadthread;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿  解决循环等待问题
 * @create: 2020-05-24 14:37
 **/
public class TransAccount2 implements Runnable {
    private Account fromAccount;
    private Account toAccount;
    private long amount;
    private TransLocal locks;

    public TransAccount2(Account fromAccount, Account toAccount, long amount, TransLocal locks) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.locks=locks;
    }

    @Override
    public void run() {
           Account left=null;
           Account right=null;
           while(true)
           {
                       if(fromAccount.hashCode()>toAccount.hashCode())
                       {
                           left=toAccount;
                           right=fromAccount;
                       }else
                       {
                           left=fromAccount;
                           right=toAccount;
                       }

                       synchronized (left)
                       {
                           synchronized (right)
                           {
                               if(fromAccount.getAmount()>=amount)
                               {
                                   fromAccount.withDraw(amount);
                                   toAccount.deposit(amount);
                               }
                           }
                       }
                       System.out.println(fromAccount.getAccountName()+"--balance=-->"+fromAccount.getAmount());
                       System.out.println(toAccount.getAccountName()+"--balance=-->"+toAccount.getAmount());

           }
    }

    public static void main(String[] args) {
        Account  fromAccount=new Account("jason",3000000);
        Account  toAccount=new Account("jerry",100000);
        TransLocal   locks=new TransLocal();
        Thread  thread1=new Thread(new TransAccount2(fromAccount,toAccount,30,locks));
        Thread thread2=new Thread(new TransAccount2(toAccount,fromAccount,10,locks));
        thread1.start();
        thread2.start();


    }
}
