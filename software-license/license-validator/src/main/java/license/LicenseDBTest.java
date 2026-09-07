package license;

// 从DB数据库加载License信息并验证
public class LicenseDBTest {

    public static void main(String[] args) {
        License license = new License(); // Load object from database
        System.out.println(license.isValidLicense("DEMO", "1.1"));
    }
}
