package hudson.plugins.jacoco.analyzer;

import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;
import org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AnalyzerImp implements Analyzer {

    private final org.jacoco.core.analysis.Analyzer analyzer;

    public AnalyzerImp(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder) {
        analyzer = new org.jacoco.core.analysis.Analyzer(executionDataStore, coverageBuilder);
    }

    @Override
    public void analyzeClass(ClassReader reader) {
        analyzer.analyzeClass(reader);
    }

    @Override
    public void analyzeClass(byte[] buffer, String location) throws IOException {
        analyzer.analyzeClass(buffer, location);
    }

    @Override
    public void analyzeClass(InputStream input, String location) throws IOException {
        analyzer.analyzeClass(input, location);
    }

    @Override
    public int analyzeAll(InputStream input, String location) throws IOException {
        return analyzer.analyzeAll(input, location);
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
