package Highcharts-3.0.2.exporting-server.java.highcharts-export.src.main.java.com.highcharts.export.pool;

public interface ObjectFactory<T>{
	public T create();
	public boolean validate(T object);
	public void destroy(T object);
	public void activate(T object);
	public void passivate(T Object);
}
