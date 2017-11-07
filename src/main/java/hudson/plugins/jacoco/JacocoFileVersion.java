package hudson.plugins.jacoco;

import hudson.plugins.jacoco.analyzer.Analyzer;
import hudson.plugins.jacoco.data.ExecutionDataReader;
import hudson.plugins.jacoco.support.JacocoSupportFactory;
import hudson.plugins.jacoco.support.JacocoSupportFactoryImp;
import hudson.plugins.jacoco.support.JacocoSupportFactoryPreviousImp;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.ExecutionDataWriter;

import java.io.*;

public enum JacocoFileVersion implements JacocoSupportFactory {

    PREVIOUS(org.jacoco.previous.core.data.ExecutionDataWriter.FORMAT_VERSION, new JacocoSupportFactoryPreviousImp()),
    CURRENT(org.jacoco.core.data.ExecutionDataWriter.FORMAT_VERSION, new JacocoSupportFactoryImp());

    private final char version;
    private final JacocoSupportFactory factory;

    JacocoFileVersion(char formatVersion,
                      JacocoSupportFactory factory) {
        this.version = formatVersion;
        this.factory = factory;
    }

    @Override
    public ExecutionDataReader createExecutionDataReader(InputStream input) {
        return factory.createExecutionDataReader(input);
    }

    @Override
    public Analyzer createAnalyzer(ExecutionDataStore executionDataStore, CoverageBuilder coverageBuilder) {
        return factory.createAnalyzer(executionDataStore, coverageBuilder);
    }

    public static JacocoFileVersion readFromFile(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        DataInputStream in = new DataInputStream(input);
        in.mark(5); // 1 byte - header mark; 2 bytes - magic number; 2 bytes - version number
        if (in.read() != ExecutionDataWriter.BLOCK_HEADER) {
            throw new IOException("Invalid execution data file.");
        }
        if (in.readChar() != ExecutionDataWriter.MAGIC_NUMBER) {
            throw new IOException("Invalid execution data file.");
        }
        final char fileVersion = in.readChar();

        for (JacocoFileVersion version : JacocoFileVersion.values()) {
            if (version.version == fileVersion) {
                return version;
            }
        }

        throw new RuntimeException("Execution data version not supported");
    }
}
