
public class TheWorld {
    private static TheWorld instance;
    private int[] theWorld = {0, 0, 1, 1, 1, 0, 0};

    TheWorld() {
    }

    public static TheWorld getInstance(){
        if(instance == null){
            instance = new TheWorld();
        }
        return instance;
    }

    public int[] getTheWorld() {
        return theWorld;
    }
}
