//
// Writer.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task01.io;

import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * Writes data to shared file.
 */
public final class Writer {

	// Constructors

	/**
	 * Construct an instance.
	 * @param file A file to write to.
	 */
	public Writer(RandomAccessFile file) {
		this.file = file;
		this.random = new Random();
	}

	// Fields

	/**
	 * A file to write to.
	 */
	private RandomAccessFile file;

	/**
	 * A random number generator.
	 */
	private Random random;

	// Writing

	public void run(int iterations) throws Exception {

		FileChannel channel = file.getChannel();
		MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, iterations * 2 * Integer.BYTES);
		IntBuffer intBuffer = mappedBuffer.asIntBuffer();

		for (int i = 0; i < iterations; i++) {
			int x = random.nextInt(100);
			int y = random.nextInt(100);
			intBuffer.put(x).put(y);
			System.out.println(String.format("Write: %d, %d", x, y));
		}

		channel.close();

	}

}
