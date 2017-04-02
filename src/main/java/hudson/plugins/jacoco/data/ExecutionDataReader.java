package hudson.plugins.jacoco.data;

import org.jacoco.core.data.IExecutionDataVisitor;
import org.jacoco.core.data.ISessionInfoVisitor;

import java.io.IOException;

public interface ExecutionDataReader {

    void setSessionInfoVisitor(ISessionInfoVisitor sessionInfoStore);

    void setExecutionDataVisitor(IExecutionDataVisitor executionDataStore);

    boolean read() throws IOException;
}
