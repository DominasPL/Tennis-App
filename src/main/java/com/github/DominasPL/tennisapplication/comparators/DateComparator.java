package com.github.DominasPL.tennisapplication.comparators;

import com.github.DominasPL.tennisapplication.dtos.MatchDTO;

import java.util.Comparator;

public class DateComparator implements Comparator<MatchDTO> {

    @Override
    public int compare(MatchDTO o1, MatchDTO o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
