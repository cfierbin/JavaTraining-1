package com.practicaljava.lesson16;
import java.io.File;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Config {

	public static final String APPLICATION_PATH = new File(Config.class
			.getProtectionDomain().getCodeSource().getLocation().getPath())
			.toString()+"//";
}
