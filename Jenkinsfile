pipeline {
	agent : any
	stages {
		stage("Build"){
			steps{
				sh "mvn compile"
			}
		}
		stage("Test") {
			steps {
				wrap([$class : 'Xvfb']) {
					sh "mvn test"
				}
			}
		}
		stage("Publish") {
			steps {
				testNG()
			}
		}
	}
}