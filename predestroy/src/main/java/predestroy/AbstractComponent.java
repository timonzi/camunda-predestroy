package predestroy;

import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;

public abstract class AbstractComponent {

	public void initialize(@Observes final ApplicationControl control) throws RuntimeException {

		throw new RuntimeException("component exception");

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy of component");
	}

}
