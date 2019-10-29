/**
	@Description	: Jenkinsfile
	@author			  : Sanjeev Saxena

*/

pipeline{

  agent any

  environment{
  		gradle = './gradlew'
  }	 	 	    

  stages{
    stage('Prepare'){
      steps {
         echo pwd()
         sh 'chmod 777 gradlew'
        }
      }
    stage('Build'){
      steps {
      	 sh '$gradle clean build'		
      }
    }
    stage('Verify'){
      steps {
         parallel unitTest: {junit 'build/test-results/test/*xml'}, integrationTest: {sleep 10}, securityScan: {sleep 8}, sonarChecks: {sleep 10}, failFast: true    
        }
      }
    stage('Package'){
      steps {
         step { sh 'sleep 4' }
         step { echo "upload to registry"}
       }
      }
    stage('Deploy2Dev'){
      steps {
         sh 'sleep 4'
       }
      }    
  }
}
