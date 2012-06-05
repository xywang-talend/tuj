package org.talend.mdm;

import static org.monte.media.AudioFormatKeys.SampleRateKey;
import static org.monte.media.AudioFormatKeys.SampleSizeInBitsKey;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;

public class TestCaseRecorder {

	private TestCaseScreenRecorder screenRecorder;
	
	public TestCaseScreenRecorder getScreenRecorder(String name) throws IOException, AWTException{
		GraphicsConfiguration gc = GraphicsEnvironment//
		 .getLocalGraphicsEnvironment()//
		 .getDefaultScreenDevice()//
		 .getDefaultConfiguration();
		
		screenRecorder = new TestCaseScreenRecorder(gc,
               // the file format:
               new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, "video/avi"),
               //
               // the output format for screen capture:
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "tscc",
               CompressorNameKey, "tscc",
               DepthKey, 8, FrameRateKey, Rational.valueOf(15.0),
               QualityKey, 1.0f,
               KeyFrameIntervalKey, (int) (15.0 * 60) // one keyframe per minute is enough
               ),
               //
               // the output format for mouse capture:
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
               FrameRateKey, Rational.valueOf(30.0)),
               //
               // the output format for audio capture:
               new Format(MediaTypeKey, MediaType.AUDIO,
               //EncodingKey, audioFormatName,
               SampleRateKey, Rational.valueOf(8000),
               SampleSizeInBitsKey, 16), name);
		
		return screenRecorder;
	}
	
	
}
