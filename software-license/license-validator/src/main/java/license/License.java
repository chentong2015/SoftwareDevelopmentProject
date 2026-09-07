package license;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class License {

    private static final String LICENSE_DATE_FORMAT = "yyyy/MM/dd-HH:mm:ss";
    private static final String NEVER_AS_LIMIT_DATE = "NEVER";

    private String application;
    private String licenceUser;
    private String country;
    private String projectName;
    private String projectCode;
    private int maxCon;
    private int maxDb;
    private String limitDate;

    private String licenseValue;

    // TODO. 验证license文件/数据是否有效: 验证信息值和加密后的结果
    public boolean isValidLicense(String application, String version) {
        if (!application.equals(this.application)) {
            return false;
        }
        if (!version.startsWith(projectCode)) {
            return false;
        }
        if (!NEVER_AS_LIMIT_DATE.equals(limitDate)) {
            String currentTimeStamp = new SimpleDateFormat(LICENSE_DATE_FORMAT).format(Calendar.getInstance().getTime());
            if (currentTimeStamp.compareTo(limitDate) > 0) {
                return false;
            }
        }
        String licenseBuilder = application + projectCode + licenceUser +
                country + projectName + maxCon + maxDb + limitDate;
        // String license = CipherUtils.encryptLicense(licenseBuilder);
        return licenseBuilder.equals(licenseValue);
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getLicenceUser() {
        return licenceUser;
    }

    public void setLicenceUser(String licenceUser) {
        this.licenceUser = licenceUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getMaxCon() {
        return maxCon;
    }

    public void setMaxCon(int maxCon) {
        this.maxCon = maxCon;
    }

    public int getMaxDb() {
        return maxDb;
    }

    public void setMaxDb(int maxDb) {
        this.maxDb = maxDb;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }

    public String getLicenseValue() {
        return licenseValue;
    }

    public void setLicenseValue(String licenseValue) {
        this.licenseValue = licenseValue;
    }
}
