package org.mschaeffner.sparkjavags.context;

import java.util.Properties;

import org.mschaeffner.sparkjavags.web.ControllerRegistry;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
		
//		Properties props = new Properties();
//		props.setProperty("prop123", System.getProperty("prop123"));
//		Names.bindProperties(binder(), props);

		bind(ControllerRegistry.class).asEagerSingleton();

	}

}
