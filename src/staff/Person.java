package staff;

public interface Person {
    public String getName();
    default int getAge(){
        return 0;
    }
    default int getSize(){
        return 38;
    }
    default String getFavFood(){
        return "Lasagne";
    }
    default String getHairColor(){
        return "Brown";
    }
}
