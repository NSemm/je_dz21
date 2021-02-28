package com.k7.tasks;

import lombok.AllArgsConstructor;

public class Fibo {
    public String FiboString(int n) {
        return "Фибонначи: " + getFiboNumber(n).toString();
    }

    private Integer getFiboNumber(int n) {
        if (n == 0 || n == 1) return 1;
        return getFiboNumber(n - 1) + getFiboNumber(n - 2);
    }

}
