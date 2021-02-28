package com.k7.runnable;

import com.k7.WriteToFile;
import com.k7.tasks.Phones;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneRunnable implements Runnable{
    private Phones phones;
    private WriteToFile writeToFile;
    @Override
    public void run() {
        writeToFile.write(phones.getPhoneString());
    }
}
