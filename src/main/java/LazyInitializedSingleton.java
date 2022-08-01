public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance; //#1

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance(){ // #3
        if(instance == null){		//если объект еще не создан
            instance = new LazyInitializedSingleton();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }
}