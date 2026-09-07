package license;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

// 从文件路径下加载License信息并验证
public class LicenseLocatorTest {

    public static void main(String[] args) throws IOException {
        License license = loadLicenseFile();
        System.out.println(license.isValidLicense("DEMO", "1.1"));
    }

    private static License loadLicenseFile() throws IOException {
        Path path = Paths.get("software-license/license-validator/src/main/resources/AppLicense.lic");
        List<String> lines = Files.readAllLines(path);

        License license = new License();
        for (String line : lines) {
            String[] elements = line.split("=");
            String key = elements[0];
            String value = elements[1];
            switch (key) {
                case "APPLICATION" -> license.setApplication(value);
                case "USER" -> license.setLicenceUser(value);
                case "COUNTRY" -> license.setCountry(value);
                case "PROJECT NAME" -> license.setProjectName(value);
                case "PROJECT CODE" -> license.setProjectCode(value);
                case "MAX CON" -> license.setMaxCon(Integer.parseInt(value));
                case "MAX DB" -> license.setMaxDb(Integer.parseInt(value));
                case "LIMIT DATE" -> license.setLimitDate(value);
                case "LICENSE VALUE" -> license.setLicenseValue(value);
            }
        }
        return license;
    }

}
