package com.jason.thread.deadthread;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-24 14:37
 **/
public class TransAccount implements Runnable {
    private Account fromAccount;
    private Account toAccount;
    private long amount;
    private TransLocal locks;

    public TransAccount(Account fromAccount, Account toAccount, long amount,TransLocal locks) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.locks=locks;
    }

    @Override
    public void run() {
           while(true)
           {
               if(locks.applyLock(fromAccount,toAccount))
               {
                   try
                   {

                       synchronized (fromAccount)
                       {
                           synchronized (toAccount)
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


                   }finally {
                       locks.removeLock();
                   }
               }

           }
    }

    public static void main(String[] args) {
        Account  fromAccount=new Account("jason",3000000);
        Account  toAccount=new Account("jerry",100000);
        TransLocal   locks=new TransLocal();
        Thread  thread1=new Thread(new TransAccount(fromAccount,toAccount,30,locks));
        Thread thread2=new Thread(new TransAccount(toAccount,fromAccount,10,locks));
        thread1.start();
        thread2.start();


    }
}
