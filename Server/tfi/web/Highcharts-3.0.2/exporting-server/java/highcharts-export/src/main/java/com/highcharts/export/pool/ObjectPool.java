/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Highcharts-3.0.2.exporting-server.java.highcharts-export.src.main.java.com.highcharts.export.pool;

/**
 *
 * @author gert
 */
public interface ObjectPool<T> {

	public void createObject();
	public void destroyObject(T object);
	public T borrowObject() throws InterruptedException, PoolException;
	public void returnObject(T object, boolean validate) throws InterruptedException;
	public void poolCleaner() throws PoolException, InterruptedException;
}
