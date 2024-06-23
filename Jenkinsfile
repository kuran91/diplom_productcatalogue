pipeline {
    agent any
    tools{
        maven 'maven_3_9_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github_cred', url: 'https://github.com/kuran91/diplom_productcatalogue']])
                sh 'mvn clean install'
            }
        }
                stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t kuran91/productcatalogue .'
                }
            }
        }
                stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'docker_hub_pass', variable: 'docker_hub_pass')]) {
                   sh 'docker login -u kuran91 -p ${docker_hub_pass}'
}
                   sh 'docker push kuran91/productcatalogue'
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}