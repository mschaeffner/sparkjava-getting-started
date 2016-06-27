package org.mschaeffner.sparkjavags.context;

import static spark.Spark.after;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import com.google.inject.Guice;

public class Main {

	public static void main(String[] args) {
		setPort();
		setStaticFiles();
		setCacheHeader();
		Guice.createInjector(new MainModule());
	}

	private static void setPort() {
		int port = Integer.valueOf(System.getProperty("port")).intValue();
		if (port < 1024) {
			System.err.println("Port must be 1024 or more.");
			return;
		}
		port(port);
	}

	private static void setStaticFiles() {
		staticFileLocation("/public");
	}

	private static void setCacheHeader() {
		after((req, res) -> {
			String url = req.url();
			if (url == null || url.endsWith("/") || url.endsWith("html")) {
				res.header("Cache-Control", "max-age=0, no-cache");
			} else {
				res.header("Cache-Control", "max-age=2592000");
			}
		});
	}

}
