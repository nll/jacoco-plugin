package hudson.plugins.jacoco.support;

import hudson.plugins.jacoco.analyzer.Analyzer;
import hudson.plugins.jacoco.data.ExecutionDataReader;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;

import java.io.InputStream;

public interface JacocoSupportFactory {
    ExecutionDataReader createExecutionDataReader(InputStream input);
    Analyzer createAnalyzer(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder);
}
