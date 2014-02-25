package com.practicaljava.custom;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class AppleIPhone extends MobilePhone implements IVoiceInput {

	public AppleIPhone() {
		super("iOS", "Safari", "AppStore");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.custom.MobilePhone#systemProcess()
	 */
	@Override
	void systemProcess() {
		System.out.println("Run TouchID Scanner.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.custom.IVoiceInput#runVoiceListener()
	 */
	@Override
	public void runVoiceListener() {
		System.out.println("Run Siri.");

	}

}
