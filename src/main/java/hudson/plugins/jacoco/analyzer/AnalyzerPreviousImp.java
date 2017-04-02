package hudson.plugins.jacoco.analyzer;


import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;
import org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AnalyzerPreviousImp implements Analyzer {

    private final org.jacoco.previous.core.analysis.Analyzer analyzer;

    public AnalyzerPreviousImp(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder) {
        analyzer = new org.jacoco.previous.core.analysis.Analyzer(executionDataStore, coverageBuilder);
    }

    @Override
    public void analyzeClass(ClassReader reader) {
        analyzer.analyzeClass(reader);
    }

    @Override
    public void analyzeClass(byte[] buffer, String name) throws IOException {
        analyzer.analyzeClass(buffer, name);
    }

    @Override
    public void analyzeClass(InputStream input, String name) throws IOException {
        analyzer.analyzeClass(input, name);
    }

    @Override
    public int analyzeAll(InputStream input, String name) throws IOException {
        return analyzer.analyzeAll(input, name);
    }

    @Override
    public int analyzeAll(File file) throws IOException {
        return analyzer.analyzeAll(file);
    }

    @Override
    public int analyzeAll(String path, File basedir) throws IOException {
        return analyzer.analyzeAll(path, basedir);
    }
}
