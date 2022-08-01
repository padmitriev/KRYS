public class TheWorld {

    private static TheWorld instance;
    private static int[] theWorld = {0, 0, 1, 1, 1, 0, 0};

    private TheWorld() {
    }

    public static TheWorld getInstance(){
        if(instance == null){		//если объект еще не создан
            instance = new TheWorld();	//создать новый объект
        }
        return instance;

    }

    public static int[] getTheWorld() {
        return theWorld;
    }

    public static void setTheWorld(int[] theWorld) {
        TheWorld.theWorld = theWorld;
    }



//    private static LazyInitializedSingleton instance; //#1
//
//    private LazyInitializedSingleton() {
//    }
//
//    public static LazyInitializedSingleton getInstance(){ // #3
//        if(instance == null){		//если объект еще не создан
//            instance = new LazyInitializedSingleton();	//создать новый объект
//        }
//        return instance;		// вернуть ранее созданный объект
//    }



}
