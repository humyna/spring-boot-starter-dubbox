package info.zoio.spring.dubbox.rpc.joinpoint;

import java.util.Map;

import com.alibaba.dubbo.common.Node;
import com.alibaba.dubbo.rpc.Result;

/**
 * Dubbox过滤器链的连接点接口.
 * 
 * @author Finn
 *
 * @param <T>
 */
public interface JoinPoint<T> extends Node {
	/**
	 * 调用下一个过滤器，如果当前是最后一个，就调用具体业务方法
	 * 
	 * @return
	 */
	 Result proceed();

	/**
	 * 接口信息
	 */
	Class<T> getInterface();

	/**
	 * 方法名
	 * 
	 * @return
	 */
	String getMethodName();

	/**
	 * 参数类型
	 * 
	 * @return
	 */
	Class<?>[] getParameterTypes();

	/**
	 * 参数名
	 * 
	 * @return
	 */
	Object[] getArguments();

	/**
	 * 隐式传参
	 * 
	 * @return
	 */
	Map<String, String> getAttachments();

	/**
	 * 获取隐式参数
	 * 
	 * @param key
	 *            参数名
	 * @return
	 */
	String getAttachment(String key);

	/**
	 * 获取隐式参数
	 * 
	 * @param key
	 *            参数名
	 * @param defaultValue
	 *            参数默认值
	 * @return
	 */
	String getAttachment(String key, String defaultValue);

	/**
	 * 获取参数
	 * 
	 * @param key
	 * @return
	 */
	Object getAttribute(String key);

	/**
	 * 设置参数
	 * 
	 * @param key
	 * @param value
	 */
	void setAttribute(String key, Object value);
}
