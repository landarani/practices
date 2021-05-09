pipeline {
  agent {
    docker {
      image 'maven:3.8.1-openjdk-11'
    }

  }
  stages {
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            sh 'mvn --version'
          }
        }

        stage('publish') {
          steps {
            echo 'Running Maven'
          }
        }

        stage('Step 2') {
          steps {
            sh 'mvn --version'
          }
        }

      }
    }

    stage('COmplete') {
      steps {
        echo 'Completed'
      }
    }

  }
}