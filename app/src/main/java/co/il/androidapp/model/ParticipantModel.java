package co.il.androidapp.model;

import java.util.LinkedList;
import java.util.List;

public class ParticipantModel {

    public final static ParticipantModel instance = new ParticipantModel();

    List<Participant> participantList = new LinkedList<>();

    public ParticipantModel(){
        for (int i =0;i<10;i++){
            Participant participant = new Participant();
            participant.participantId=+ i;
            participantList.add(participant);
        }

    }

    public List<Participant>getAllParticipantList() {
        return participantList;
    }

    public void addParticipant(Participant p){
        if (participantList!=null){
            participantList.add(p);
        }
    }
}
