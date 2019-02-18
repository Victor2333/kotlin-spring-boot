properties([pipelineTriggers([githubPush()])])
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
  post {
    always {
      junit 'build/test-results/**/*.xml'
    }
  }
}
