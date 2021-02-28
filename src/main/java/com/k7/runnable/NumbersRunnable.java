package com.k7.runnable;

import com.k7.WriteToFile;
import com.k7.tasks.Numbers;
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
