package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/3/29.
 */

public class ServiceContent<T1,T2> {
	private ServiceBody<T1,T2>service;

	public ServiceContent(T1 t1,T2 t2) {
		this.service= (ServiceBody<T1, T2>) new ServiceBody<>(t1,t2);
	}

	public ServiceBody<T1, T2> getService() {
		return service;
	}

	public void setService(ServiceBody<T1, T2> service) {
		this.service = service;
	}
}
