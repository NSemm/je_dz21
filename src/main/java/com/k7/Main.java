package com.k7;


import com.k7.runnable.FiboRunnable;
import com.k7.runnable.NumbersRunnable;
import com.k7.runnable.PhoneRunnable;
import com.k7.tasks.Fibo;
import com.k7.tasks.Numbers;
import com.k7.tasks.Phones;

public class Main {

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        Phones phones = new Phones("test.txt");
        Numbers numbers = new Numbers("numbers.txt");

        WriteToFile writeToFile = new WriteToFile();
        Thread th1 = new Thread(new FiboRunnable(fibo, writeToFile));
        Thread th2 = new Thread(new PhoneRunnable(phones, writeToFile));
        Thread th3 = new Thread(new NumbersRunnable(numbers, writeToFile));
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        //System.out.println("numbers: "+numbers.getSum(100));

        //System.out.println(phones.getPhoneString());
    }
}
