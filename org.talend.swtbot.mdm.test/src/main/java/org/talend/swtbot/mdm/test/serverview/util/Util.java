package org.talend.swtbot.mdm.test.serverview.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class Util {

	private static String SAMPLE_FOLDER_PATH = "/sample/";//$NON-NLS-1$
 
	/**
	 * Copy a file with the FileChannel that will accelerate the process.
	 * 
	 * @param inputFile
	 * @param outFile
	 * @return
	 * @throws Exception
	 */
	public static long copyFile(File inputFile, File outFile) throws Exception {
		long time = new Date().getTime();
		int length = 2097152;
		FileInputStream in = new FileInputStream(inputFile);
		FileOutputStream out = new FileOutputStream(outFile);
		FileChannel inC = in.getChannel();
		FileChannel outC = out.getChannel();
		ByteBuffer b = null;
		while (true) {
			if (inC.position() == inC.size()) {
				inC.close();
				outC.close();
				return new Date().getTime() - time;
			}
			if ((inC.size() - inC.position()) < length) {
				length = (int) (inC.size() - inC.position());
			} else
				length = 2097152;
			b = ByteBuffer.allocateDirect(length);
			inC.read(b);
			b.flip();
			outC.write(b);
			outC.force(false);
		}
	}

	/**
	 * Return a File instance pointing to the file or folder located below this
	 * plugin sample folder
	 * 
	 * @param subSamplePath
	 *            , path located below /sample/, so subpath should never start
	 *            with a /, example : test.xsl
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File getFileFromCurrentPluginSampleFolder(String subSamplePath)
			throws IOException, URISyntaxException {
		URL url = Util.class.getResource(SAMPLE_FOLDER_PATH + subSamplePath);
		URI escapedURI = getFileUrl(url);
		return URIUtil.toFile(escapedURI);
	}

	/**
	 * Convert any URL to a file URL
	 * 
	 * @param url
	 *            ,maybe an eclipse URL
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private static URI getFileUrl(URL url) throws IOException,
			URISyntaxException {
		URL unescapedURL = FileLocator.toFileURL(url);
		URI escapedURI = new URI(unescapedURL.getProtocol(),
				unescapedURL.getPath(), unescapedURL.getQuery());
		return escapedURI;
	}

	/**
	 * look for all the widget of type TalendTabbedPropertyList and select the
	 * tab at index for all of them
	 * 
	 * @param index
	 *            index of the tab to select in aTalendTabbedPropertyList
	 *            TalendTabbedPropertyList(values start from 0)
	 */
	public static void selecteTalendTabbedPropertyListAtIndex(SWTBot bot,
			final int index) {
		// look for all the widgets of type TabbedPropertyList
		final List<TabbedPropertyList> controls = bot.getFinder().findControls(
				new BaseMatcher<TabbedPropertyList>() {

					// @Override
					public boolean matches(Object item) {
						if (item instanceof TabbedPropertyList) {
							return true;
						} else {
							return false;
						}
					}

					// @Override
					public void describeTo(Description description) {
						description
								.appendText("looking for widget of type TabbedPropertyList");
					}
				});

		// select the desired tab in the UI thread
		UIThreadRunnable.syncExec(new VoidResult() {

			// @Override
			public void run() {
				for (TabbedPropertyList ttpl : controls) {
					Method select;
					try {
						select = ttpl.getClass().getDeclaredMethod("select",
								int.class);
						select.setAccessible(true);
						select.invoke(ttpl, index);
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} finally {
					}
				}
			}
		});
	}

}
