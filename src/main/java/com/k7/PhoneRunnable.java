package com.k7;

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
