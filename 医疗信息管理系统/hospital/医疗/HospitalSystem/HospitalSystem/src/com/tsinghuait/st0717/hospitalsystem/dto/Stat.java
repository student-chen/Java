package com.tsinghuait.st0717.hospitalsystem.dto;

import java.util.Date;

public class Stat {
    private String items;//��Ŀ
    private Float pay;//���
    private String payee;//�տ���
    private String name;//������
    private Date pdate;//����
    private Byte isFinished;//�Ƿ�����
	public Byte getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Byte isFinished) {
		this.isFinished = isFinished;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPay() {
		return pay;
	}
	public void setPay(Float pay) {
		this.pay = pay;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
}
