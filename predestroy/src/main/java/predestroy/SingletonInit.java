package predestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import predestroy.ApplicationControl.Phase;

@Singleton
@Startup
public class SingletonInit {

	@Inject
	private Event<ApplicationControl> startupEvent;

	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void onStartup() {
		System.out.println("application startup ...");

		startupEvent.fire(new ApplicationControl(Phase.SHUTDOWN_APPLICATION));
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("application shutdown ...");
	}

}
