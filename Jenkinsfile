pipeline {
  agent any

  environment {
    JENKINS_NODE_COOKIE = 'dontKillMe' // Necessary for the Gradle daemon to be kept alive.
  }

  stages {
    stage('Build') {
      steps {
        sh 'gradle build'
      }
    }
  }
}
