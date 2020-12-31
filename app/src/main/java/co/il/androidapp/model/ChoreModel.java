package co.il.androidapp.model;

import java.util.LinkedList;
import java.util.List;

public class ChoreModel {

    public final static ChoreModel instance = new ChoreModel();

    public ChoreModel() {
            for(int i=0;i<10;i++) {
                Chore chore = new Chore();
                chore.choreId = 1+ i;
                chore.choreName = "Chore " + i;
                chore.choreDetails="babab";
                chore.position=i;
                data.add(chore);
            }
        }
        List<Chore> data = new LinkedList<>();

        public List<Chore> getAllChoreList() {
            return data;
        }

        public void addChore(Chore chore)
        {
            if (data!=null){
                data.add(chore);
            }
        }

}
