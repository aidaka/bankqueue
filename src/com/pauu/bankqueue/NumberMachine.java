package com.pauu.bankqueue;
/**
 * �����������ͨ�����١���Ա��
 * @author peng.xing
 *
 */
public class NumberMachine {
	private NumberManager commonManager = new NumberManager();//������ͨ����Ĺ�����
	private NumberManager expressManager = new NumberManager();//���ɿ��ٺ���Ĺ�����
	private NumberManager vipManager = new NumberManager();//���ɻ�Ա����Ĺ�����
	public NumberManager getCommonManager() {
		return commonManager;
	}
	public NumberManager getExpressManager() {
		return expressManager;
	}
	public NumberManager getVipManager() {
		return vipManager;
	}
	//ȷ������
	private NumberMachine(){}
	private static NumberMachine instance = new NumberMachine();
	public static NumberMachine getInstance(){
		return instance;
	}
}
