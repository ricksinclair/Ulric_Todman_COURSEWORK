package com.company;

public class TeamLead extends Developer{

    public TeamLead(String name) {
        super(name);
        System.out.println("Team lead constructor");
    }

    public void planSprint(){
        //do something;
    }

    public void assignWork(Developer dev){
        // do something

    }

    @Override
    public void estimateStoryPoints() {


        System.out.println("Estimating my story points.(Team Lead)");
    }
}
