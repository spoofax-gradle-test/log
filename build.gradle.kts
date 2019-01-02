plugins {
  id("org.metaborg.gitonium") version "0.3.0"
}

subprojects {
  group = "org.metaborg"
  
  repositories {
    maven(url = "http://home.gohla.nl:8091/artifactory/all/")
  }
  
  apply(plugin = "java-library")
  configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  apply(plugin = "maven-publish")
  configure<PublishingExtension> {
    repositories {
      maven {
        name = "Artifactory"
        url = uri("http://192.168.1.3:8091/artifactory/all/")
        credentials {
          username = project.findProperty("publish.repository.Artifactory.username")?.toString()
          password = project.findProperty("publish.repository.Artifactory.password")?.toString()
        }
      }
    }
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
