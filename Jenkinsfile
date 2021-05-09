pipeline {
  agent {
    docker {
      image 'docker pull maven:3.8.1-openjdk-11'
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
      parallel {
        stage('COmplete') {
          steps {
            echo 'Completed'
          }
        }

        stage('docker') {
          steps {
            build(job: 'ASXM-Parent', wait: true)
          }
        }

      }
    }

  }
}