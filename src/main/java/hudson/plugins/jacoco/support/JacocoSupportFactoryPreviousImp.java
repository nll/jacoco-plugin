package hudson.plugins.jacoco.support;

import hudson.plugins.jacoco.analyzer.Analyzer;
import hudson.plugins.jacoco.analyzer.AnalyzerPreviousImp;
import hudson.plugins.jacoco.data.ExecutionDataReader;
import hudson.plugins.jacoco.data.ExecutionDataReaderPreviousImp;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;

import java.io.InputStream;

public class JacocoSupportFactoryPreviousImp implements JacocoSupportFactory {

    @Override
    public ExecutionDataReader createExecutionDataReader(InputStream input) {
        return new ExecutionDataReaderPreviousImp(input);
    }

    @Override
    public Analyzer createAnalyzer(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder) {
        return new AnalyzerPreviousImp(executionDataStore, coverageBuilder);
    }
}
