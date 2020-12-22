package co.il.androidapp.model;

import java.util.LinkedList;
import java.util.List;

public class ModelDemo {

    public final static ModelDemo instance = new ModelDemo();

    private ModelDemo(){
        for(int i=0;i<10;i++) {
            Event event = new Event();
            event.EventName = "Event " + i;
            //event.name = "DemoFragment " + i;
            data.add(event);
        }
    }
    List<Event> data = new LinkedList<Event>();

    public List<Event> getAllEvents() {
        return data;
    }

}










