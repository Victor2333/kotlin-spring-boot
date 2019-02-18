pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh './gradlew check'
      }
    }
	stage('Build') {
      steps {
        sh './gradlew bootjar'
      }
    }
  }
}
