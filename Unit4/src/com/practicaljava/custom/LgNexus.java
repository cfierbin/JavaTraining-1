package com.practicaljava.custom;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class LgNexus extends MobilePhone implements IVoiceInput {

	public LgNexus() {
		super("Android", "Google Chrome", "Google Play");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.custom.MobilePhone#systemProcess()
	 */
	@Override
	void systemProcess() {
		System.out.println("Try to connect to Google Glass.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.custom.IVoiceInput#runVoiceListener()
	 */
	@Override
	public void runVoiceListener() {
		System.out
				.println("Turn on microphone and connect to google voice recognize server.");

	}
}
