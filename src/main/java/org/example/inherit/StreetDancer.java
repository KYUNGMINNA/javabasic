package org.example.inherit;

import org.example.basic.Dancer;
import org.example.basic.Rapper;

public class StreetDancer extends Dancer
        implements Rapper {

    public StreetDancer(String crewName, String myName) {
        super(crewName, myName);
    }

//    @Override
    public void dance() {
        System.out.println("비보잉을 합니다.");
    }


    @Override
    public void rap() {

    }
}
