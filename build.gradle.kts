plugins {
  id("org.metaborg.gitonium") version "0.3.0"
}

subprojects {
  group = "org.metaborg"
  repositories {
    mavenCentral()
  }
  apply(plugin = "java-library")
  configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}
tasks {
  register("buildAll") {
    dependsOn(subprojects.map { it.tasks["build"] })
  }
  register("cleanAll") {
    dependsOn(subprojects.map { it.tasks["clean"] })
  }
}
