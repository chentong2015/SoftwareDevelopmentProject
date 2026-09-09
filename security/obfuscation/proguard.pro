-dontoptimize
-dontpreverify
-dontwarn

-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod

-keep public class org.example.** {
    public static void main(java.lang.String[]);
}

# 只对org.example进行混淆, 输出混淆映射
-printmapping target/proguard-mapping.txt