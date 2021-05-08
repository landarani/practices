pipeline {
  agent {
    node {
      label 'el6'
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