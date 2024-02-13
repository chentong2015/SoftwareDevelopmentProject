package extensions.core_spi;

import extensions.core_spi.model.IDocumentParser;

import java.util.ServiceLoader;

public class JavaSpiDemo {

    // TODO: ServiceLoader加载指定接口的实现类型，通过反射创建类型对象
    public static void main(String[] args) {
        ServiceLoader<IDocumentParser> iParseDocs = ServiceLoader.load(IDocumentParser.class);
        for (IDocumentParser iParseDoc : iParseDocs) {
            iParseDoc.parse();
        }
    }
}
