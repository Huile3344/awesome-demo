pipeline {
    agent any
    tools {
      maven 'maven-3.9.12'
      jdk 'jdk-17'
    }
    parameters {
      gitParameter branch: 'origin/dev', branchFilter: 'origin/dev*', defaultValue: 'origin/dev', name: 'branchName', quickFilterEnabled: false, selectedValue: 'DEFAULT', sortMode: 'ASCENDING_SMART', tagFilter: '*', type: 'GitParameterDefinition'
    }
    stages {
        stage('pull') {
            steps {
                checkout scmGit(branches: [[name: '$branchName']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Huile3344/awesome-demo.git']])
            }
        }
        stage('mvn') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
