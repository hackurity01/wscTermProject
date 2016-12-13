package koreatech.cse.domain;

import java.util.ArrayList;

/**
 * Created by 성준이 on 2016-12-08.
 */
public class Clss {
    private ArrayList<Assi> AList = new ArrayList<Assi>();
    private String name;

    public Clss(){
        name = "";
    }

    public ArrayList<Assi> getAList() {
        return AList;
    }

    public void setAList(ArrayList<Assi> AList) {
        this.AList = AList;
    }
    public void addAss(Assi a){
        AList.add(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
