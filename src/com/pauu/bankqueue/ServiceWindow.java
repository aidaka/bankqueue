package com.pauu.bankqueue;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {
	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;
	
	public void setType(CustomerType type) {
		this.type = type;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public void start(){
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					switch(type){
						case COMMON:
						commonService();
							break;
						case EXPRESS:
							expressService();
							break;
						case VIP:
							vipService();
							break;
					}
				}
			}
		});
	}

	private void commonService() {
		String windowName = "��"+windowId+"��"+type+"����";
		System.out.println("���ڻ�ȡ����");
		Integer number = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
		if(number!=null){
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME;
			int serviceTime = Constants.MIN_SERVICE_TIME+new Random().nextInt(maxRandom)+1;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(windowName+"Ϊ��"+number+"��"+type+"�ͻ���ɷ��񣬺�ʱ"+(endTime-beginTime));
		}else{
			System.out.println("û��ȡ������,����Ϣһ����!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void expressService() {
		String windowName = "��"+windowId+"��"+type+"����";
		System.out.println("���ڻ�ȡ����");
		Integer number = NumberMachine.getInstance().getExpressManager().fetchServiceNumber();
		if(number!=null){
			long beginTime = System.currentTimeMillis();
			int serviceTime = Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(windowName+"Ϊ��"+number+"��"+type+"�ͻ���ɷ��񣬺�ʱ"+(endTime-beginTime));
		}else{
			System.out.println(windowName+"û��ȡ������!");
			commonService();
		}
	}
	
	private void vipService() {
		String windowName = "��"+windowId+"��"+type+"����";
		System.out.println("���ڻ�ȡ����");
		Integer number = NumberMachine.getInstance().getVipManager().fetchServiceNumber();
		if(number!=null){
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME;
			int serviceTime = Constants.MIN_SERVICE_TIME+new Random().nextInt(maxRandom)+1;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(windowName+"Ϊ��"+number+"��"+type+"�ͻ���ɷ��񣬺�ʱ"+(endTime-beginTime));
		}else{
			System.out.println(windowName+"û��ȡ������!");
			commonService();
		}
	}
}
