pipeline {
  agent {
    node {
      label 'el6'
    }

  }
  stages {
    stage('test') {
      agent {
        node {
          label 'el7'
        }

      }
      steps {
        waitUntil(initialRecurrencePeriod: 100) {
          node(label: 'java8') {
            sh 'mvn --version'
          }

        }

        echo 'Completed'
      }
    }

  }
}