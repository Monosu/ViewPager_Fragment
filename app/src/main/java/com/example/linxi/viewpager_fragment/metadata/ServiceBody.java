package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/3/29.
 * 泛型
 */
public class ServiceBody<T1, T2> {
	private T1 head;
	private T2 body;

	public ServiceBody(T2 body, T1 head) {
		this.body = body;
		this.head = head;
	}

	public T2 getBody() {
		return body;
	}

	public void setBody(T2 body) {
		this.body = body;
	}

	public T1 getHead() {
		return head;
	}

	public void setHead(T1 head) {
		this.head = head;
	}
}
