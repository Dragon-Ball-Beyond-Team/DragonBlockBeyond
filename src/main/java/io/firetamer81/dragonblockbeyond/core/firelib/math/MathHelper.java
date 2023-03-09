package io.firetamer81.dragonblockbeyond.core.firelib.math;

import java.util.List;

public class MathHelper {

    public static int sumIntList(List<Integer> numbersIn) {
        int sum = numbersIn.stream().mapToInt(Integer::valueOf).sum();

        return sum;
    }

    public static double sumDoubleList(List<Double> numbersIn) {
        double sum = numbersIn.stream().mapToDouble(Double::valueOf).sum();

        return sum;
    }
}
