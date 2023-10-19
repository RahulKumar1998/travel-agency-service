package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *  This is the destination class
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

@Getter
@Setter
public class Destination {

    private String destinationName;
    private List<Activity> activities;


    public Destination(String destinationName){
        this.destinationName = destinationName;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity){
        activity.setDestinationName(destinationName);
        activities.add(activity);
    }


}
