# Using the Maven Wrapper on Windows

1. Ensure JDK is installed and `JAVA_HOME` is set to the JDK root.
2. From PowerShell in the `ourProject` folder run:

```
.\mvnw.cmd -U clean test
```

The first run will download the maven-wrapper.jar automatically. If download fails, ensure you have internet access and PowerShell's execution policies allow running the script.
