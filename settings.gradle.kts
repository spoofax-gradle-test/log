rootProject.name = "log"

pluginManagement {
  repositories {
    maven(url = "http://home.gohla.nl:8091/artifactory/all/")
  }
}

include("log.api")
include("log.slf4j")

project(":log.api").projectDir = file("api")
project(":log.slf4j").projectDir = file("slf4j")
