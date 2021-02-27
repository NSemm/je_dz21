package com.k7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumbersRunnable implements Runnable{
    private Numbers numbers;
    private WriteToFile writeToFile;
    @Override
    public void run() {
        writeToFile.write(numbers.getSum(10));
    }
}
