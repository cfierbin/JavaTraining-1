package com.practicaljava.custom;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public abstract class MobilePhone {

	String operationSystem;
	String webBrowser;
	String applicationMarket;

	public MobilePhone(String operationSystem, String webBrowser,
			String applicationMarket) {
		this.operationSystem = operationSystem;
		this.webBrowser = webBrowser;
		this.applicationMarket = applicationMarket;
	}

	abstract void systemProcess();

	public void powerOn() {
		System.out.println("Run " + operationSystem);
		systemProcess();
	}

	public void runWebBrowser() {
		System.out.println("Run " + webBrowser);
	}

	public void openApplicationMarket() {
		System.out.println("Connect to " + applicationMarket);
	}

}
