package com.k7.runnable;

import com.k7.WriteToFile;
import com.k7.tasks.Fibo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FiboRunnable implements Runnable{
    private Fibo fibo;
    private WriteToFile writeToFile;
    @Override
    public void run() {
        writeToFile.write(fibo.FiboString(15));
    }
}
