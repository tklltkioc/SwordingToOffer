package 剑指;

public class Singleton {
	 /**
     * 单例模式，饿汉式，线程安全
     */
    public static class Singleton1{
		private final static Singleton1 instance=new Singleton1();
		private Singleton1() {
			
		}
		public static Singleton1 getInstance() {
			return instance;
		}
    	
    }
	 /**
     * 单例模式，懒汉式，线程不安全
     */
    public static class Singleton2{
    	private static Singleton2 instance=null;
    	private Singleton2(){
    		
    	}
    	public static  Singleton2 getInstance() {
			if(instance==null) {
				instance=new Singleton2();
			}
	    	return instance;
		}
    }
	 /**
     * 单例模式，懒汉式，线程安全，多线程效率不高
     */
    public static class Singleton3{
    	private static Singleton3 instance=null;
    	private Singleton3(){
    		
    	}
    	public static synchronized Singleton3 getInstance() {
			if(instance==null) {
				instance=new Singleton3();
			}
	    	return instance;
		}
    }	 
    /**
     * 单例模式，懒汉式，双重校验锁,volatile关键字（推荐）
     */
    public static class Singleton4{
    	private volatile static Singleton4 instance=null;
    	private Singleton4(){
    		
    	}
    	public static Singleton4 getInstance() {
			if(instance==null) 
				synchronized (Singleton4.class){
					if(instance==null)
				instance=new Singleton4();
			}
	    	return instance;
		}
    }
	 /**
     * 单例模式，懒汉式，静态代码块，线程安全
     */
    public static class Singleton5{
    	private static Singleton5 instance=null;
    	static {
    		instance=new Singleton5();
    	}
    	private Singleton5(){
    		
    	}
    	public static  Singleton5 getInstance() {
	    	return instance;
		}
    }	
    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     */
    public enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {

        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Singleton1.getInstance()==Singleton1.getInstance());
		System.out.println(Singleton6.INSTANCE==Singleton6.INSTANCE);

	}

}
