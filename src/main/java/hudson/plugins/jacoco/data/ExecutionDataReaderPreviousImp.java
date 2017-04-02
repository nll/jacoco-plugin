package hudson.plugins.jacoco.data;

import org.jacoco.core.data.IExecutionDataVisitor;
import org.jacoco.core.data.ISessionInfoVisitor;
import org.jacoco.core.data.IncompatibleExecDataVersionException;
import org.jacoco.previous.core.data.ExecutionDataWriter;

import java.io.IOException;
import java.io.InputStream;

public class ExecutionDataReaderPreviousImp implements ExecutionDataReader {

    private final org.jacoco.previous.core.data.ExecutionDataReader executionDataReader;

    public ExecutionDataReaderPreviousImp(InputStream input) {
        executionDataReader = new org.jacoco.previous.core.data.ExecutionDataReader(input);
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
