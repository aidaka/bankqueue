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
	public synchronized Integer generateNewNumber(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	//�ŶӴ���ȡ��
	public synchronized Integer fetchServiceNumber(){
		Integer number = null;
		if(queueNumber.size()>0){
			number = queueNumber.remove(0);
		}
		return number;
	}
}
