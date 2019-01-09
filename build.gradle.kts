plugins {
  id("org.metaborg.gradle.config.multi-project-root") version "develop-SNAPSHOT"
  id("org.metaborg.gradle.config.sub-project") version "develop-SNAPSHOT" apply false
  id("org.metaborg.gitonium") version "0.3.0"
}

subprojects {
  apply(plugin = "org.metaborg.gradle.config.sub-project")
  apply(plugin = "java-library")
  apply(plugin = "maven-publish")
}
