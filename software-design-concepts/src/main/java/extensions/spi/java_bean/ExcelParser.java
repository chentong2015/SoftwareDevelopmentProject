package extensions.spi.java_bean;

public class ExcelParser implements IDocumentParser {

    @Override
    public void parse() {
        System.out.println("Parse excel");
    }
}
