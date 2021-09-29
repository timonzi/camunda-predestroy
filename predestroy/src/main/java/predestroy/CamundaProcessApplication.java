package predestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInterface;
import org.camunda.bpm.application.impl.EjbProcessApplication;
import org.camunda.bpm.engine.cdi.impl.event.CdiEventListener;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ProcessApplication
@Local(ProcessApplicationInterface.class)
public class CamundaProcessApplication extends EjbProcessApplication {

	protected CdiEventListener cdiEventListener = new CdiEventListener();


    @PostConstruct
    public void start() {
    	System.out.println("POSTCONSTRUCT: CamundaProcessApplication");
        deploy();
    }


    @PreDestroy
    public void stop() {
    	System.out.println("PREDESTROY: CamundaProcessApplication");
        undeploy();
    }


    @Override
    public ExecutionListener getExecutionListener() {
        return this.cdiEventListener;
    }


    @Override
    public TaskListener getTaskListener() {
        return this.cdiEventListener;
    }


}
