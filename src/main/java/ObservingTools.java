import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ObservingTools {

//    private int[] theWorld;

    public ObservingTools() {
    }

    //Returns the first object found
    static ArrayList<Integer> findObject(int[] theWorld) {
        ArrayList<Integer> object = new ArrayList<>();
        boolean objectIsFound = false;
        for (int obj : theWorld) {
            if (!(obj == 0)) {
                object.add(obj);
                objectIsFound = true;
            }
            if (objectIsFound && obj == 0) {
                break;
            }
        }
        return object;
    }

    public static int getLeftSideLength(int[] theWorld) {
        int leftZeros = 0;
        for (int elem : theWorld) {
//            System.out.println("leftZeros: " + leftZeros);
            if (elem == 0) {
                leftZeros++;
            } else {
                break;
            }
        }
        return leftZeros;
    }

    private static int getRightSideLength(int[] theWorld) {
        int rightZeros = 0;
        int[] clonedWorld = theWorld.clone();
        List<Integer> list = Arrays.stream(clonedWorld)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(list);
        for (int elem : theWorld) {
            if (elem == 0) {
                rightZeros++;
            } else {
                break;
            }
        }
        return rightZeros;
    }

    static int getObjectLength(int[] theWorld) {
        return findObject(TheWorld.getTheWorld()).size();
    }
}
