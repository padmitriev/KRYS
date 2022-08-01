class ManipulatingTools {

    int[] theWorld = TheWorld.getTheWorld();
/*
    TheWorld theWorld = new TheWorld(theNewWorld);
    private int[] theWorld000 = theWorld.getTheWorld();
*/

    void changeElement(int i) {
        if (theWorld[i] == 0) {
            theWorld[i] = 1;
        } else {
            theWorld[i] = 0;
        }
//        TheWorld.setTheWorld(fdhg);
    }

    void moveLeft() {
        for (int dgdfg : theWorld) {
            System.out.print(dgdfg);
        }
        System.out.println();

        int objectLength = ObservingTools.getObjectLength(theWorld);
        int leftSideLength = ObservingTools.getLeftSideLength(theWorld);
        System.out.println("objectLength: " + objectLength);
        System.out.println("leftSideLength: " + leftSideLength);

//!!        предусмотреть случай leftSideLength = 0
        changeElement(leftSideLength - 1);
        changeElement(leftSideLength + objectLength - 1);

        for (int dgdfg : theWorld) {
            System.out.print(dgdfg);
        }
    }




}
