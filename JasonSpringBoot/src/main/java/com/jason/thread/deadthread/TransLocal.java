package com.jason.thread.deadthread;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-24 16:17
 **/
public class TransLocal {
    public  List<Account> accountList=new ArrayList<Account>();

    synchronized  boolean  applyLock(Account account,Account account1)
    {
        if(accountList.contains(account)||accountList.contains(account1))
        {
            return false;
        }
        accountList.add(account);
        accountList.add(account1);
        return true;
    }

    synchronized   void   removeLock()
    {
        accountList.clear();
    }
}
