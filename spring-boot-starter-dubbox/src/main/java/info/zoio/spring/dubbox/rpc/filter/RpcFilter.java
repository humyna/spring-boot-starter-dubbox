package info.zoio.spring.dubbox.rpc.filter;

import com.alibaba.dubbo.rpc.Result;

import info.zoio.spring.dubbox.rpc.joinpoint.JoinPoint;

/**
 * Dubbox的通用过滤器接口.
 * 
 * @author Finn
 */
public interface RpcFilter {
	Result invoke(JoinPoint<?> point);
}
