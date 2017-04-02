package hudson.plugins.jacoco.analyzer;


import org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface Analyzer {

    void analyzeClass(final ClassReader reader);

    void analyzeClass(final byte[] buffer, final String location) throws IOException;

    void analyzeClass(final InputStream input, final String location) throws IOException;

    int analyzeAll(final InputStream input, final String location) throws IOException;

    int analyzeAll(final File file) throws IOException;

    int analyzeAll(final String path, final File basedir) throws IOException;
}
