# momas-blog

博客项目,Spring Boot框架实现

http://localhost:8080 是博客首页

http://localhost:8080/admin 是博客管理后台

## 打包

打包可运行 jar
```shell
mvn package 
```

打包 docker 镜像
```shell
PS C:\>mvn package docker:build
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< cc.momas:momas-blog >-------------------------
[INFO] Building momas-blog 1.1
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The artifact com.atlassian.commonmark:commonmark:jar:0.17.0 has been relocated to org.commonmark:commonmark:jar:0.17.0
[WARNING] The artifact com.atlassian.commonmark:commonmark-ext-heading-anchor:jar:0.17.0 has been relocated to org.commonmark:commonmark-ext-heading-anchor:jar:0.17.0
[WARNING] The artifact com.atlassian.commonmark:commonmark-ext-gfm-tables:jar:0.17.0 has been relocated to org.commonmark:commonmark-ext-gfm-tables:jar:0.17.0
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ momas-blog ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 267 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ momas-blog ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 54 source files to C:\Users\sod\Downloads\git-dir\momas-project\momas-blog\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ momas-blog ---
[INFO] Not copying test resources
[INFO]
[INFO] Not compiling test sources
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ momas-blog ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ momas-blog ---
[INFO] Building jar: C:\Users\sod\Downloads\git-dir\momas-project\momas-blog\target\momas-blog-1.1.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.3.12.RELEASE:repackage (repackage) @ momas-blog ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.306 s
[INFO] Finished at: 2021-12-02T23:43:03+08:00
[INFO] ------------------------------------------------------------------------
PS C:\Users\sod\Downloads\git-dir\momas-project\momas-blog> mvn package docker:build
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< cc.momas:momas-blog >-------------------------
[INFO] Building momas-blog 1.1
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The artifact com.atlassian.commonmark:commonmark:jar:0.17.0 has been relocated to org.commonmark:commonmark:jar:0.17.0
[WARNING] The artifact com.atlassian.commonmark:commonmark-ext-heading-anchor:jar:0.17.0 has been relocated to org.commonmark:commonmark-ext-heading-anchor:jar:0.17.0
[WARNING] The artifact com.atlassian.commonmark:commonmark-ext-gfm-tables:jar:0.17.0 has been relocated to org.commonmark:commonmark-ext-gfm-tables:jar:0.17.0
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ momas-blog ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 267 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ momas-blog ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ momas-blog ---
[INFO] Not copying test resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ momas-blog ---
[INFO] Not compiling test sources
[INFO]

 ---> 30c45fae1495
Step 3/3 : ENTRYPOINT ["java", "-jar", "momas-blog-1.1.jar"]

 ---> Running in 3b850fa70cd2
Removing intermediate container 3b850fa70cd2
 ---> 27809a64e56d
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built 27809a64e56d
Successfully tagged cc.momas/momas-blog:1.1
[INFO] Built cc.momas/momas-blog:1.1
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.359 s
[INFO] Finished at: 2021-12-02T23:43:19+08:00
[INFO] ------------------------------------------------------------------------

```