#!/bin/sh
#!/bin/sh
BASE_DIR=$(cd "$(dirname "$0")" && pwd)
# Minimal maven wrapper script copied from Apache Maven distribution
if [ -z "$JAVA_HOME" ]; then
  echo "Error: JAVA_HOME is not set"
  exit 1
fi
exec "$JAVA_HOME/bin/java" -jar "$BASE_DIR/.mvn/wrapper/maven-wrapper.jar" "$@"
