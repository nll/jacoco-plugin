package hudson.plugins.jacoco.support;

import hudson.plugins.jacoco.analyzer.Analyzer;
import hudson.plugins.jacoco.analyzer.AnalyzerImp;
import hudson.plugins.jacoco.data.ExecutionDataReader;
import hudson.plugins.jacoco.data.ExecutionDataReaderImp;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;

import java.io.InputStream;

public class JacocoSupportFactoryImp implements JacocoSupportFactory {

    @Override
    public ExecutionDataReader createExecutionDataReader(InputStream input) {
        return new ExecutionDataReaderImp(input);
    }

    @Override
    public Analyzer createAnalyzer(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder) {
        return new AnalyzerImp(executionDataStore, coverageBuilder);
    }

}
