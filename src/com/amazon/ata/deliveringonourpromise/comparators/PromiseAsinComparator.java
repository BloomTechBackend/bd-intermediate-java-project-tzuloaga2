package com.amazon.ata.deliveringonourpromise.comparators;

import com.amazon.ata.deliveringonourpromise.types.Promise;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class PromiseAsinComparator implements Comparator<Promise>{
    @Override
    public int compare(Promise o1, Promise o2) {

        return o1.getAsin().compareTo(o2.getAsin());
    }


}
