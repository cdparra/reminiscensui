package utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import play.api.Play;

public class PlayDozerMapper implements Mapper {

	private static PlayDozerMapper instance;
	private ClassLoader resourceClassLoader;
	private DozerBeanMapper targetMapper;

	@SuppressWarnings("unused")
	private PlayDozerMapper() {
	}

	public static PlayDozerMapper getInstance() {
//		if (instance == null) {
			List<String> myMappingFiles = new ArrayList<String>();
			myMappingFiles.add("dozerBeanMapping.xml");
			instance = new PlayDozerMapper(
					Play.classloader(Play.current()), myMappingFiles);
//		}
		return instance;
	}

	public PlayDozerMapper(ClassLoader classLoader,
			List<String> mappingFiles) {
		this.resourceClassLoader = classLoader;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(resourceClassLoader);
		try {
			targetMapper = new DozerBeanMapper(mappingFiles);
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

	@Override
	public void map(Object source, Object destination, String mapId)
			throws MappingException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(resourceClassLoader);
		try {
			targetMapper.map(source, destination, mapId);
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

	@Override
	public <T> T map(Object source, Class<T> destinationClass, String mapId)
			throws MappingException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(resourceClassLoader);
		try {
			return targetMapper.map(source, destinationClass, mapId);
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

	@Override
	public <T> T map(Object source, Class<T> destinationClass)
			throws MappingException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(resourceClassLoader);
		try {
			return targetMapper.map(source, destinationClass);
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

	@Override
	public void map(Object source, Object destination) throws MappingException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(resourceClassLoader);
		try {
			targetMapper.map(source, destination);
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

}
