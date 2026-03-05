pipeline {
    agent any
    tools {
      maven 'maven-3.9.12'
      jdk 'jdk-17'
    }
    parameters {
        gitParameter branch: 'origin/dev', branchFilter: 'origin/dev*', defaultValue: 'origin/dev', name: 'branchName', quickFilterEnabled: false, selectedValue: 'DEFAULT', sortMode: 'DESCENDING_SMART', tagFilter: '*', type: 'GitParameterDefinition', useRepository: 'https://github.com/Huile3344/awesome-demo.git'
    }
    stages {
        stage('pull') {
            steps {
                checkout scmGit(branches: [[name: '$branchName']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Huile3344/awesome-demo.git']])
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'SonarQube-full-token') {
                  // 将 sonar-scanner 配置到 PATH 中
                  sh "sonar-scanner"
                }
            }
        }
    }
}