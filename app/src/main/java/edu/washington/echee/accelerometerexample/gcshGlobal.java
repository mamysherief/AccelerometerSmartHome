package edu.washington.echee.accelerometerexample;

/**
 * Created by Ägaren on 2016-04-07.
 */
//public class gcshGlobal {
//    //public static int ivar1,ivar2;
//    //public static int[] myarray1=new int[10];
//    public static String room,equipment;
//}

public class gcshGlobal {
    private static gcshGlobal instance;
    private static String room, equipment, ip;
    //To stop calling from other classes
    private gcshGlobal(){}

    public void setRoom(String r){
        gcshGlobal.room = r;
    }

    public String getRoom(){
        return gcshGlobal.room;
    }

    public void setEquipment(String e){
        gcshGlobal.equipment = e;
    }

    public String getEquipment(){
        return gcshGlobal.equipment;
    }

    public void setIP(String ip){
        gcshGlobal.ip = ip;
    }

    public String getIP(){
        return gcshGlobal.ip;
    }

    public static synchronized gcshGlobal getInstance(){
        if(instance==null){
            instance=new gcshGlobal();
        }
        return instance;
    }
}
