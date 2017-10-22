//
// Main.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task01.main;

import akashivskyy.tpo.task01.io.Reader;
import akashivskyy.tpo.task01.io.Writer;
import java.io.RandomAccessFile;

/**
 * Main class of the program.
 */
public final class Main {

	/**
	 * Main function of the program.
	 * @param args Arguments of the program.
	 */
	public static void main(String[] args) throws Exception {

		RunningMode mode = RunningMode.fromArgs(args);

		if (mode == null) {
			throw new Exception("Application must be run with either `--mode reader` or `--mode writer`.");
		}

		RandomAccessFile file = new RandomAccessFile("tmp.txt", "rw");

		switch (mode) {
			case READER: {
				Reader reader = new Reader(file);
				reader.run();
				break;
			}
			case WRITER: {
				Writer writer = new Writer(file);
				writer.run(10);
				break;
			}
		}

	}

	/**
	 * A running mode of the program.
	 */
	private enum RunningMode {

		/**
		 * Reader mode.
		 */
		READER,

		/**
		 * Writer mode.
		 */
		WRITER;

		/**
		 * Initialize a value from string.
		 * @param string A string.
		 * @return A `RunningMode` or `null`.
		 */
		private static RunningMode fromString(String string) {
			switch (string) {
				case "reader": return READER;
				case "writer": return WRITER;
				default: return null;
			}
		}

		/**
		 * Initialize a value from args.
		 * @param args Program arguments.
		 * @return A `RunningMode` or `null`.
		 */
		private static RunningMode fromArgs(String[] args) {
			if (!(args.length == 2 && args[0].equals("--mode"))) { return null; }
			return RunningMode.fromString(args[1]);
		}

	}

}
