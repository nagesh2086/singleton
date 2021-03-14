package demo1;

import java.io.Serializable;

public final class Singleton implements Serializable, Cloneable {

	private static final long serialVersionUID = -4905573383556355986L;
	private static volatile Singleton instance = null;

	private Singleton() {
		// Check if we already have an instance
		if (instance != null) {
			throw new IllegalStateException("Singleton" + " instance already created.");
		}
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}