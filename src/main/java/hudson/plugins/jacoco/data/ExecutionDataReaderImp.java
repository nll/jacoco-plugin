package hudson.plugins.jacoco.data;

import org.jacoco.core.data.*;

import java.io.IOException;
import java.io.InputStream;

public class ExecutionDataReaderImp implements ExecutionDataReader {

    private final org.jacoco.core.data.ExecutionDataReader executionDataReader;

    public ExecutionDataReaderImp(InputStream input) {
        executionDataReader = new org.jacoco.core.data.ExecutionDataReader(input);
    }

    @Override
    public void setSessionInfoVisitor(ISessionInfoVisitor visitor) {
        executionDataReader.setSessionInfoVisitor(visitor);
    }

    @Override
    public void setExecutionDataVisitor(IExecutionDataVisitor visitor) {
        executionDataReader.setExecutionDataVisitor(visitor);
    }

    @Override
    public boolean read() throws IOException, IncompatibleExecDataVersionException {
        return executionDataReader.read();
    }
}
