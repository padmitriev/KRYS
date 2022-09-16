
public class ManipulatingTools {
    TheWorld theWorldInstance = new TheWorld();
    int[] theWorld = theWorldInstance.getTheWorld();

    //"Direction = true" to move left, "direction = false" to move right
    static int[] moveObject(int[] theWorld, boolean direction){

        int leftLimit = ObservingTools.getLeftSideLength(theWorld);
        int rightLimit = ObservingTools.getRightSideLength(theWorld);

        if (direction) {
            if (leftLimit > 0) {
                theWorld = change0To1orViceVersa(theWorld, leftLimit - 1);
                theWorld = change0To1orViceVersa(theWorld, theWorld.length - rightLimit - 1);
            } else {
                somethingIsWrongWithTheLimits();
            }
        } else {
            if (rightLimit > 0) {
                theWorld = change0To1orViceVersa(theWorld, theWorld.length - rightLimit);
                theWorld = change0To1orViceVersa(theWorld, leftLimit);
            } else {
                somethingIsWrongWithTheLimits();
            }
        }

        return theWorld;
    }

    static int[] change0To1orViceVersa(int[] theWorld, int index){

        if (theWorld[index] == 0) {
            theWorld[index] = 1;
        } else {
            theWorld[index] = 0;
        }

        return theWorld;
    }

    static void somethingIsWrongWithTheLimits() {
        System.out.println("something's wrong with the limits");
    }
}
