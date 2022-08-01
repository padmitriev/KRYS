import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println(getRandomName());
//        checkIfTheWorldIsNotEmpty();

//        int[] theWorld0 = TheWorld.getTheWorld();
//        ObservingTools gfjgf = new ObservingTools();
//        ArrayList<Integer> vhf = gfjgf.findObject(theWorld0);
//        System.out.println("----------------------");
//        for (int gdfg : vhf) {
//            System.out.println(gdfg);
//        }

        ManipulatingTools wfjhfg = new ManipulatingTools();
        wfjhfg.moveLeft();





    }

    private static void checkIfTheWorldIsNotEmpty() {
        int zero = 0;
        ArrayList<Integer> object = new ArrayList<>();
        for (int worldElement: getTheWorld()) {
            if (worldElement != zero) {
                object.add(worldElement);
            }
        }

        int[] newObject = new int[object.size()];

        for (int i = 0; i < object.size(); i++) {
            newObject[i] = object.get(i);
        }
        System.out.println(newObject.length);
    }

    public static String getRandomName() {
        char nextChar;
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for(int i = 0; i < 3; i++) {
            nextChar = (char) (rnd.nextInt(26) + 97);
            sb.append(nextChar);
        }

        return sb.toString();
    }

    private static int[] getTheWorld() {
        int[] theWorld = {0, 0, 1, 1, 1, 0, 0};
        return theWorld;
    }




}
