package com.pauu.bankqueue;

import java.util.ArrayList;
import java.util.List;
/**
 * ���������
 * @author peng.xing
 *
 */
public class NumberManager {
	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	//���ɺ�����ͻ�
	public synchronized int generateNewNumber(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	//�ŶӴ���ȡ��
	public synchronized int fetchServiceNumber(){
		return queueNumber.remove(0);
	}
}
