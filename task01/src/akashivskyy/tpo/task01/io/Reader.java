//
// Reader.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task01.io;

import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Reads data from shared file.
 */
public final class Reader {

	// Constructors

	/**
	 * Construct an instance.
	 * @param file A file to read from.
	 */
	public Reader(RandomAccessFile file) {
		this.file = file;
	}

	// Fields

	/**
	 * A file to read from.
	 */
	private RandomAccessFile file;

	// Reading

	public void run() throws Exception {

		FileChannel channel = file.getChannel();

		MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
		IntBuffer intBuffer = mappedBuffer.asIntBuffer();

		while (intBuffer.hasRemaining()) {
			int x = intBuffer.get();
			int y = intBuffer.get();
			System.out.println(String.format("Read: %d + %d = %d", x, y, x + y));
		}

		channel.close();

	}

}
